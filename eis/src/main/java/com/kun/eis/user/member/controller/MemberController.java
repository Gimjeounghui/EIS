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
     * 23.04.28
     * loginMember, memberInsert,forget_pw registMember, listMember, detailMember, updateMember, deleteMember 추가
     */

    /**
     * 23.04.28
     * @Autowired
     * private MemberService memberService;
     * 
     * 23.05.17
     * listMember 추가
     * 
     * 23.05.18
     * goLogin, login 추가
     */

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/listMember")
    public String listMember(@ModelAttribute("searchVO") MemberVO vo, Model model, HttpSession session) {

        // 게시판 UTIL
        BoardUtil boardUtil = new BoardUtil();
        List<MemberVO> listMember = null;

        try {

           
            int totalRecordCount = 0; 								// 총 게시물 건수
            int currentPageNo = vo.getCurrentPageNo(); 				// 현재 클릭한 page번호
            int pageSize = vo.getPageSize(); 						// 페이지 리스트에 게시되는 페이지 건수
            int recordCountPerPage = vo.getRecordCountPerPage();	// 한 페이지당 게시되는 게시물 건 수

            // 게시물 조회 범위 연산
            HashMap<String, Integer> rangeMap = boardUtil.calcDataRange(currentPageNo, recordCountPerPage);
            vo.setStart(rangeMap.get("firstRecordIndex"));
            vo.setEnd(rangeMap.get("lastRecordIndex"));

            // 전체 검색 결과
             listMember = memberService.selectListMember(vo);   //listMember 생성
             System.out.println("listMember 데이터: " + listMember);
             System.out.println("listMember 데이터:");
             for (MemberVO member : listMember) {
                 System.out.println(": " + member.getM_name());
             }
            // 검색된 결과가 있는지 체크
            if(listMember.size() > 0) { // listMember의 데이터가 존재 할 때
                // 전체 검색 결과 게시물 건 수
                totalRecordCount = listMember.get(0).getTotalRecordCount(); //get쌧미
            }

            // pager기능 모든 계산식 결과 정보 map에 담기
            HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, 
            		totalRecordCount, recordCountPerPage, pageSize);

            // model 세팅
            model.addAttribute("listMember", listMember);
            model.addAttribute("pagerMap", pagerMap);

        } catch (Exception e) {

            logger.info(e.getMessage());
            e.printStackTrace();
        }

        return "/user/member/listMember.tiles";
    }
    
    
    @RequestMapping("/loginMember")
    public String loginMember(@ModelAttribute("MemberVO") MemberVO vo, Model model,
                            HttpSession session, HttpServletRequest request) {
    	// session = request.getSession();
        String email = request.getParameter("m_email");
        String password = request.getParameter("m_pw");
       
        int isLogin = memberService.isLogin(vo);
		MemberVO member  = memberService.login(vo);
		
		if(isLogin == 0) {
			model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			model.addAttribute("msg2", "입력하신 내용을 다시 확인해주세요.");
			return "/common/index";
		}
		else {
			session.setAttribute("vo", member);
		}

        // 로그인 성공시 홈페이지로 리다이렉트
        return "/common/main";
    }

   @RequestMapping("/signUp")
    public String signUpMember() {

       return "/common/signUp";
   }
   
  

    @RequestMapping("/forget_pw")
    public String pwFind(){

        return "/member/forget_pw";
    }

   @RequestMapping("/registMember")
    public String registMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session){

        return "/member/registMember";
    }


    @RequestMapping(value="/formMember", method=RequestMethod.POST)
    public String formMember(MemberVO vo) {

        boolean a = memberService.registMember(vo);
        return "/member/loginMember";
    }


    /* listMember ver1
    @RequestMapping("/listMember")
    public String listMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session) {
        return "listMember";
    }
    */


    @RequestMapping("/datailMember")
    public String detailMember(@ModelAttribute("MemberVO") MemberVO vo, Model model,
                               HttpSession session, @RequestParam("m_email") String m_email){
       // vo = memberService.detailMember(m_email);
        model.addAttribute("MemberVO", vo);

        return "/member/detailMember";
    }


    @Transactional
    @RequestMapping("/updateMember")                                // MemberVO에 m_photo 추가 후 수정 - 완료
    public String updateMember(@ModelAttribute ("MemberVO") MemberVO vo,Model model, HttpSession session_a,
                               @RequestParam("m_photo1") MultipartFile m_photo,RedirectAttributes ra, HttpServletRequest request) {

        session_a.invalidate();
        HttpSession session = request.getSession();
        boolean a = memberService.updateMember(vo, m_photo);
        MemberVO member = vo;
        session.setAttribute("member",member);
        ra.addAttribute("m_email", vo.getM_email());

        /**
         * 23.04.28
         * info = 멤버정보(M_info) / 마이페이지(M_page)
         * 네이밍은 차후 변경 가능
         */

        return "redirect:/info";
    }

    @Transactional
    @RequestMapping("/deleteMember")
    public String deleteMember(@RequestParam("m_email") String m_email, RedirectAttributes ra, HttpSession session){

        /**
         * 23.04.28
         * MemberVO 완성 후 deleteMember 추가
         * 23.04.28 임시 MemberVO 생성 후 추가 완료
         */
        boolean b = memberService.deleteMember(m_email);
        if(b) {
            ra.addFlashAttribute("msg", "탈퇴가 완료되었습니다.");
        } else {
            ra.addFlashAttribute(("msg"), "오류로 인하여 탈퇴가 실패하였습니다.");
        }
        session.invalidate();
        return "redirect:/goLogin";
    }
    

	// 글 수정 페이지 이동
	@RequestMapping("/modifyMember")
	public String modifyMember(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session) {

		// 디버깅 하기 위한 임의코드 작성
		System.out.println("@@@@");

		MemberVO vo1 = null;

		vo1 = memberService.detailMember(vo);
		model.addAttribute("vo1", vo1);

		return "/user/member/modifyMember.tiles";
	}
	
}


