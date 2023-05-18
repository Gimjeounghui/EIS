package com.kun.eis.user.business.service;

import java.util.List;

import com.kun.eis.user.business.vo.BusinessVO;

public interface BusinessService {
	
	/**
	 * 테스트 항목 리스트
	 * @param vo
	 * @return List
	 * @throws Exception
	 */
	public List<BusinessVO> selectBusinessList(BusinessVO vo);

	public BusinessVO selectTitleYn(BusinessVO vo);

	public int insertBusiness(BusinessVO vo);
	
	public int updateBusiness(BusinessVO vo);
	
	/* 삭제 메서드 생성 */
	
	public BusinessVO selectBusinessDetail(BusinessVO vo);
	
}