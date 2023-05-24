package com.kun.eis.user.member.service;

import com.kun.eis.user.member.vo.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
	/**
	 * 23.04.28
	 * MemberService 추가
	 * memberRegist, memberDetail .. 추가
	 * 
	 * 23.05.18
	 * login, isLogin 추가
	 */

public interface MemberService {

	public List<MemberVO> selectListMember(MemberVO vo);

	public MemberVO selectPwCode(MemberVO vo) throws Exception;

	public boolean registMember(MemberVO vo);

	public MemberVO detailMember(MemberVO vo);

	public boolean updateMember(MemberVO vo);

	public boolean deleteMember(String mEmail);

	public MemberVO login(MemberVO vo); 
	
	public int isLogin(MemberVO vo);

    }