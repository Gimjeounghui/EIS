package com.kun.eis.user.member.controller;

import com.kun.eis.user.member.vo.MemberVO;
import com.kun.eis.common.util.BoardUtil;
import com.kun.eis.user.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {


	/**
	 * @Autowired private MemberService memberService;
	 *
	 *            23.04.28 Member, insertMember, forget_pw, registMember, listMember
	 *            		   detailMember, updateMember, deleteMember 추가
	 *            
	 *            23.05.17 listMember 추가
	 * 
	 *            23.05.18 goLogin, login 추가
	 *            
	 *            23.05.22 listMember 수정 완료
	 *            
	 *            23.05.23 detailMember, updateMember, modifyMember 추가
	 */
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	
	/**
	 * 23.05.22
	 * listMember 수정 완료 
	 */	
	@RequestMapping(value = "/listMember")
	public String listMember(@ModelAttribute("searchVO") MemberVO vo, Model model, HttpSession session) {

		// 게시판 UTIL
		BoardUtil boardUtil = new BoardUtil();
		List<MemberVO> listMember = null;

		try {

			/**
			 * 게시판 기능
			 */
			int totalRecordCount = 0; // 총 게시물 건수
			int currentPageNo = vo.getCurrentPageNo(); // 현재 클릭한 page번호
			int pageSize = vo.getPageSize(); // 페이지 리스트에 게시되는 페이지 건수
			int recordCountPerPage = vo.getRecordCountPerPage(); // 한 페이지당 게시되는 게시물 건 수

			// 게시물 조회 범위 연산
			HashMap<String, Integer> rangeMap = boardUtil.calcDataRange(currentPageNo, recordCountPerPage);
			vo.setStart(rangeMap.get("firstRecordIndex"));
			vo.setEnd(rangeMap.get("lastRecordIndex"));

			// 전체 검색 결과
			listMember = memberService.selectListMember(vo);
				
			// 검색된 결과가 있는지 체크
			if (listMember.size() > 0) { // listMember의 데이터가 존재할 때
				// 전체 검색 결과 게시물 건 수
				totalRecordCount = listMember.get(0).getTotalRecordCount();
			}

			// pager기능 모든 계산식 결과 정보 map에 담기
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount,
					recordCountPerPage, pageSize);
			/**
			 * 게시판 END
			 */

			// model 세팅
			model.addAttribute("listMember", listMember); // 검색한 list정보
			model.addAttribute("pagerMap", pagerMap); // 게시판 계산식 map

		} catch (Exception e) {

			logger.info(e.getMessage());
			e.printStackTrace();
		}

		return "/user/member/listMember.tiles";
	}
	
	
	@RequestMapping("/loginMember")
	public String loginMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session,
			HttpServletRequest request) {

		// session = request.getSession();
		String email = request.getParameter("mEmail");
		String password = request.getParameter("mPw");

		int isLogin = memberService.isLogin(vo);
		MemberVO member = memberService.login(vo);
		
		if (isLogin == 0) { // 로그인에 실패 했을 경우
			model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			model.addAttribute("msg2", "입력하신 내용을 다시 확인해주세요.");
			return "/common/index";
		} else {  			// 로그인에 성공 했을 경우 
			session.setAttribute("vo", member);
			session.setMaxInactiveInterval(-1);
	
		}

		// 로그인 성공시 홈페이지로 리다이렉트
		return "/common/main";
	}

	
	@RequestMapping("/signUp")
	public String signUpMember() {

		return "/common/signUp";
	}

	@RequestMapping("/forget_pw")
	public String pwFind() {

		return "/member/forget_pw";
	}

	@RequestMapping("/registMember")
	public String registMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session) {

		return "/member/registMember";
	}

	@RequestMapping(value = "/formMember", method = RequestMethod.POST)
	public String formMember(MemberVO vo) {

		boolean a = memberService.registMember(vo);

		return "/common/index";
	}

	/**
	 * listMember ver1
	 * 
	 * @RequestMapping("/listMember") public String
	 * listMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession
	 * session) { return "listMember"; }
	 */

	
	/**
	 * 23.05.23
	 * detailMember // 수정 완료
	 */
	@RequestMapping("/detailMember")
	public String detailMember(@ModelAttribute("vo") MemberVO vo, Model model, HttpSession session) {
		
		MemberVO mVO = null;
		
		mVO = memberService.detailMember(vo);
		
		model.addAttribute("mVO", mVO);	
	
		return "/user/member/detailMember.tiles";
	}

	
	
	/**
	 * 23.05.23
	 * updateMember 시작
	 */
	@Transactional
	@RequestMapping("/updateMember") // MemberVO에 mPhoto 추가 후 수정 - 완료
	public String updateMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session_a,
			 RedirectAttributes ra, HttpServletRequest request) {

		session_a.invalidate();
		HttpSession session = request.getSession();
		boolean a = memberService.updateMember(vo);
		MemberVO member = vo;
		session.setAttribute("mVO", member);
		ra.addAttribute("mEmail", vo.getmEmail());

		/**
		 * 23.04.28 info = 멤버정보(M_info) / 마이페이지(M_page) 네이밍은 차후 변경 가능
		 */

		return "/user/member/listMember.tiles";
	}
	
	/**
	 * detailMember 제작 예정
	 */

	@Transactional
	@RequestMapping("/deleteMember")
	public String deleteMember(@RequestParam("mEmail") String mEmail, RedirectAttributes ra, HttpSession session) {

		/**
		 * 23.04.28 MemberVO 완성 후 deleteMember 추가 23.04.28 임시 MemberVO 생성 후 추가 완료
		 */
		boolean b = memberService.deleteMember(mEmail);
		if (b) {
			ra.addFlashAttribute("msg", "탈퇴가 완료되었습니다.");
		} else {
			ra.addFlashAttribute(("msg"), "오류로 인하여 탈퇴가 실패하였습니다.");
		}
		session.invalidate();
		return "redirect:/goLogin";
	}

	
	
	/**
	 * 23.05.23
	 * modifyMember // 수정 완료
	 */
	// 글 수정 페이지 이동
	@RequestMapping("/modifyMember")
	public String modifyMember(@ModelAttribute("vo") MemberVO vo, Model model, HttpSession session) {

		// 디버깅 하기 위한 임의코드 작성
		System.out.println("@@@@");

		MemberVO mVO = null;

		mVO = memberService.detailMember(vo);
		model.addAttribute("mVO", mVO);

		return "/user/member/modifyMember.tiles";
	}

}
