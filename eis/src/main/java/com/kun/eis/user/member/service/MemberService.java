package com.kun.eis.user.member.service;

import com.kun.eis.user.business.vo.BusinessVO;
import com.kun.eis.user.member.vo.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
	/**
	 * 23.04.28
	 * MemberService 추가
	 * memberRegist, memberDetail .. 추가
	 */

public interface MemberService {

	public List<MemberVO> MemberList(MemberVO vo);

	public MemberVO selectPwCode(MemberVO vo) throws Exception;

	public boolean memberRegist(MemberVO vo);

	public MemberVO memberDetail(String m_email);

	public boolean memberUpdate(MemberVO vo, MultipartFile m_photo);

	public boolean memberDelete(String m_email);


    }