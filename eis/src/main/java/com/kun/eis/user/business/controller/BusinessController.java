package com.kun.eis.user.business.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kun.eis.common.util.BoardUtil;
import com.kun.eis.user.business.service.BusinessService;
import com.kun.eis.user.business.vo.BusinessVO;
import com.kun.eis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/business")
public class BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

	@Autowired
	private BusinessService businessService;

	@RequestMapping(value = "/listBusiness")
	public String listBusiness(@ModelAttribute("searchVO") BusinessVO vo, Model model, HttpSession session) {

		// 게시판 UTIL
		BoardUtil boardUtil = new BoardUtil();
		List<BusinessVO> listBusiness = null;

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
			listBusiness = businessService.selectBusinessList(vo);

			// 검색된 결과가 있는지 체크
			if (listBusiness.size() > 0) { // businessList의 데이터가 존재할 때
				// 전체 검색 결과 게시물 건 수
				totalRecordCount = listBusiness.get(0).getTotalRecordCount();
			}

			// pager기능 모든 계산식 결과 정보 map에 담기
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount,
					recordCountPerPage, pageSize);
			/**
			 * 게시판 END
			 */

			// model 세팅
			model.addAttribute("listBusiness", listBusiness); // 검색한 list정보
			model.addAttribute("pagerMap", pagerMap); // 게시판 계산식 map

		} catch (Exception e) {

			logger.info(e.getMessage());
			e.printStackTrace();
		}

		return "/user/business/listBusiness.tiles";
	}

	/**
	 * ajax test (ajax 테스트 하려고 임시로 만든거 나중에 지움 )
	 * 
	 * @return
	 * @throws Exception
	 */

	/**
	 * java 객체로 변환 한 client로부터 요청받은 데이터를 응답본문의 객체로 변환 후 client로 전송
	 * Controller단에 @ResponseBody 명시되었다면 반환타입은 jsp가 아닌 데이터
	 */
	@RequestMapping("/ajax_testAjax.json")
	@ResponseBody
	public Object ajax_testAjax(@ModelAttribute("vo") BusinessVO vo, Model model, HttpSession session)
			throws Exception {

		// key value
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 결과 성공 여부
		boolean result = false; // DB 통신 성공 결과 여부
		BusinessVO VO = null;

		try {

			// VO는 DB로부터 조회한 bTitle 값이 들어가 있음
			VO = businessService.selectTitleYn(vo);

			result = true;

		} catch (Exception e) {

			result = false;
			e.printStackTrace();
			logger.debug(e.getMessage());

		} finally {

			resultMap.put("result", result);
			resultMap.put("VO", VO);

		}

		return resultMap;
	}

	// 글쓰기 페이지 이동
	@RequestMapping("/registBusiness")
	public String registBusiness(@ModelAttribute("vo") BusinessVO vo, Model model, HttpSession session) {
/*
		String url = "";

		MemberVO userInfoVo = (MemberVO) session.getAttribute("userInfo");

		if (userInfoVo == null) {
			// 로그인 정보가 없을경우
			url = "/user/common/goLogin.tiles";

		} else {
			// 로그인 정보가 있을경우
			url = "/user/business/registBusiness.tiles";
		}
*/
		return "/user/business/registBusiness.tiles";
	}

	// 글 상세 페이지 이동
	@RequestMapping("/detailBusiness")
	public String detailBusiness(@ModelAttribute("vo") BusinessVO vo, Model model, HttpSession session) {
		
		String url = "";
		BusinessVO rsltVO = null;
		
		rsltVO = businessService.selectBusinessDetail(vo);
		
		model.addAttribute("rsltVO", rsltVO);
		
		url = "/user/business/detailBusiness.tiles";

		return url;
	}

	/**
	 * 등록관련 CUD
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/procManageBusiness.json")
	@ResponseBody
	public Object procManagePrdct(@ModelAttribute("vo") BusinessVO vo, Model model, HttpSession session)
			throws Exception {

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		boolean rstFlag = false;
		int resultCnt = 0;

		// ADD:insert MOD:update DEL: delete
		String procFlag = vo.getProcFlag();
		MemberVO rsltUserInfoVO = (MemberVO) session.getAttribute("userInfo");

		/* 세션 정보 세팅 */
		vo.setm_email(rsltUserInfoVO.getM_email());

		try {

			switch (procFlag) {

			case "ADD":
				resultCnt = businessService.insertBusiness(vo);
				break;

			case "MOD":
				resultCnt = businessService.updateBusiness(vo);
				break;

			case "DEL":
				// 추후에 작업예정
				break;

			default:
				break;
			}

			if (resultCnt > 0) {

				rstFlag = true;
			}

		} catch (Exception e) {

			logger.debug(e.getMessage());
			e.printStackTrace();

		} finally {

			resultMap.put("rstFlag", rstFlag);
		}

		return resultMap;
	}

	// 글 수정 페이지 이동
	@RequestMapping("/modifyBusiness")
	public String modifyBusiness(@ModelAttribute("vo") BusinessVO vo, Model model, HttpSession session) {

		// 디버깅 하기 위한 임의코드 작성
		System.out.println("@@@@");

		BusinessVO rsltVO = null;

		rsltVO = businessService.selectBusinessDetail(vo);
		model.addAttribute("rsltVO", rsltVO);

		return "/user/business/modifyBusiness.tiles";
	}
}