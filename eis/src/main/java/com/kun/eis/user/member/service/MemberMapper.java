package com.kun.eis.user.member.service;

import com.kun.eis.user.member.vo.MemberUploadVO;
import com.kun.eis.user.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * 23.04.28
 * MemberMapper 추가
 * ( memberUpdate, memberDelete ..)
 * 23.05.04
 * MemberImageInsert 추가
 */

@Mapper
public interface MemberMapper {

	public List<MemberVO> MemberList(MemberVO vo);

	public MemberVO selectPwCode(MemberVO vo);

	public boolean memberUpdate(MemberVO vo);

	public boolean memberDelete(String m_email);

	public boolean memberRegist(MemberVO vo);

	public MemberVO memberDetail(String m_email);

	public boolean memberImageInsert(MemberUploadVO vo); //회원 이미지 업로드



}
