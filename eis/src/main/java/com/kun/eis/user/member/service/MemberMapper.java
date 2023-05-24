package com.kun.eis.user.member.service;

import com.kun.eis.user.member.vo.MemberUploadVO;
import com.kun.eis.user.member.vo.MemberVO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 23.04.28 
 * MemberMapper 추가 ( memberUpdate, memberDelete ..) 
 * 23.05.04
 * MemberImageInsert 추가 
 * 23.05.18 
 * login, isLogin 추가
 */

@Mapper
public interface MemberMapper {
	
	public List<MemberVO> selectListMember(MemberVO vo);

	public MemberVO selectPwCode(MemberVO vo);

	public boolean updateMember(MemberVO vo);

	public boolean deleteMember(String mEmail);

	public boolean registMember(MemberVO vo);

	public MemberVO detailMember(MemberVO vo);

	public boolean imageInsertMember(MemberUploadVO vo);

	public MemberVO login(MemberVO vo);

	public int isLogin(MemberVO vo);

}
