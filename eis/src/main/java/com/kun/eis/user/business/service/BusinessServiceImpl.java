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
	public BusinessVO selectTitleYn(BusinessVO vo) {

		return businessMapper.selectTitleYn(vo);
	}

	@Override
	public int insertBusiness(BusinessVO vo) {

		return businessMapper.insertBusiness(vo);
	}

	@Override
	public int updateBusiness(BusinessVO vo) {

		return businessMapper.updateBusiness(vo);
	}

	@Override
	public BusinessVO selectBusinessDetail(BusinessVO vo) {

		return businessMapper.selectBusinessDetail(vo);
	}
}