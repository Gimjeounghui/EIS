package com.kun.eis.user.member.service;

import java.util.List;

import com.kun.eis.user.member.vo.MemberVO;

public interface MemberService {
	
	/**
	 * 테스트 항목 리스트
	 * @param vo
	 * @return List
	 * @throws Exception
	 */
	public List<MemberVO> selectMemberList(MemberVO vo);

}