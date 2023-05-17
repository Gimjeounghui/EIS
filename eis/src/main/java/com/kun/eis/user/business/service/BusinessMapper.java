package com.kun.eis.user.business.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.business.vo.BusinessVO;

@Mapper
public interface BusinessMapper {

	public List<BusinessVO> selectBusinessList(BusinessVO vo);

	public BusinessVO selectPwCode(BusinessVO vo);
	
}