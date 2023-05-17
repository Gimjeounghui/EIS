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

	public BusinessVO selectPwCode(BusinessVO vo) throws Exception;
	
}