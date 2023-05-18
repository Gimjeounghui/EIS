package com.kun.eis.user.business.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.business.vo.BusinessVO;

@Mapper
public interface BusinessMapper {

	public List<BusinessVO> selectBusinessList(BusinessVO vo);

	public BusinessVO selectTitleYn(BusinessVO vo);

	public int insertBusiness(BusinessVO vo);
	
	public int updateBusiness(BusinessVO vo);
	
	/* 삭제 메서드 생성 */
	
	public BusinessVO selectBusinessDetail(BusinessVO vo);
		
}