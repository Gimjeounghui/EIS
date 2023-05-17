package com.kun.eis.user.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kun.eis.user.business.vo.BusinessVO;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessMapper businessMapper;

	@Override
	public List<BusinessVO> selectBusinessList(BusinessVO vo) {
		
		return businessMapper.selectBusinessList(vo);
	}

	@Override
	public BusinessVO selectPwCode(BusinessVO vo) throws Exception {

		return businessMapper.selectPwCode(vo);
	}
}