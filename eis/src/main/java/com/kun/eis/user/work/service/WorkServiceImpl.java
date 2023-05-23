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
	
	@Override
	public boolean registWork(WorkVO vo) {
		return workMapper.registWork(vo);
	}

	@Override
	public WorkVO detailWork(int wNo) {
		return workMapper.detailWork(wNo);
	}

	@Override
	public boolean updateWork(WorkVO vo) {
		return workMapper.updateWork(vo);
	}

	@Override
	public boolean deleteWork(int wNo) {
		return workMapper.deleteWork(wNo);
	}

}