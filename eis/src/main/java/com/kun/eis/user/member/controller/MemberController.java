package com.kun.eis.member.controller;


import com.kun.eis.business.controller.BusinessController;
import com.kun.eis.member.vo.MemberVO;
import com.kun.eis.common.util.BoardUtil;
import com.kun.eis.member.service.MemberService;
import com.kun.eis.member.vo.MemberVO;
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
     * memberLogin, memberInsert,forget_pw memberRegist, memberList, memberDetail, memberUpdate, memberDelete 추가
     */

    /**
     * 23.04.28
     * @Autowired
     * private MemberService memberService;
     */

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping("/memberLogin")
    public String memberLogin(@ModelAttribute("MemberVO") MemberVO vo, Model model,
                            HttpSession session, HttpServletRequest request) {
        String email = request.getParameter("m_email");
        String password = request.getParameter("m_pw");

        /**
         *  1. Memberloginfind(이메일, 비밀번호 일치 확인 ), Memberpermiss(회원 가입 승인 확인) 생성
         *  2. Memberpermiss, memberloginfind가 false 라면 로그인 거부
         *    1) return "/member/login";
         *  3. Memberpermiss, memberloginfind가 true 라면 로그인 승인
         *  */

        // 로그인 성공시 홈페이지로 리다이렉트
        return "/member/home";
    }

   @RequestMapping("/singUp")
    public String membersingUp() {

       return "/member/memberRegist";
   }

    @RequestMapping("/forget_pw")
    public String pwFind(){

        return "forget_pw";
    }

   @RequestMapping("/memberRegist")
    public String memberRegist(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session){

        return "/member/memberRegist";
    }


    @RequestMapping(value="/memberForm", method=RequestMethod.POST)
    public String memberForm(MemberVO vo) {

        boolean a = memberService.memberRegist(vo);
        return "/member/memberLogin";
    }


    /* memberList ver1
    @RequestMapping("/memberList")
    public String memberList(@ModelAttribute("MemberVO") MemberVO vo, Model model, HttpSession session) {
        return "memberList";
    }
    */


    @RequestMapping("/memberDetail")
    public String memberDetail(@ModelAttribute("MemberVO") MemberVO vo, Model model,
                               HttpSession session, @RequestParam("m_email") String m_email){
        vo = memberService.memberDetail(m_email);
        model.addAttribute("MemberVO", vo);

        return "memberDetail";
    }


    @Transactional
    @RequestMapping("/memberUpdate")                                // MemberVO에 m_photo 추가 후 수정 - 완료
    public String MemberUpdate(@ModelAttribute ("MemberVO") MemberVO vo,Model model, HttpSession session_a,
                               @RequestParam("m_photo1") MultipartFile m_photo,RedirectAttributes ra, HttpServletRequest request) {

        session_a.invalidate();
        HttpSession session = request.getSession();
        boolean a = memberService.memberUpdate(vo, m_photo);
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
    @RequestMapping("/memberDelete")
    public String memberDelete(@RequestParam("m_email") String m_email, RedirectAttributes ra, HttpSession session){

        /**
         * 23.04.28
         * MemberVO 완성 후 memberDelete 추가
         * 23.04.28 임시 MemberVO 생성 후 추가 완료
         */
        boolean b = memberService.memberDelete(m_email);
        if(b) {
            ra.addFlashAttribute("msg", "탈퇴가 완료되었습니다.");
        } else {
            ra.addFlashAttribute(("msg"), "오류로 인하여 탈퇴가 실패하였습니다.");
        }
        session.invalidate();
        return "redirect:/login";
    }

}
