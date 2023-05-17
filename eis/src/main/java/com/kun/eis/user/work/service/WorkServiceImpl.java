package com.kun.eis.user.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kun.eis.user.work.vo.WorkVO;
	
@Service("workService")
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkMapper workMapper;

	@Override
	public List<WorkVO> selectWorkList(WorkVO vo) {
		return workMapper.selectWorkList(vo);
	}
}