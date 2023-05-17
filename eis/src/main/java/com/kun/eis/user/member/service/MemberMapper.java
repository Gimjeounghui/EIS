package com.kun.eis.user.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.member.vo.MemberVO;

@Mapper
public interface MemberMapper {

	public List<MemberVO> selectMemberList(MemberVO vo);

}