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
	public boolean workRegist(WorkVO vo) {
		return workMapper.workRegist(vo);
	}

	@Override
	public WorkVO workDetail(int w_no) {
		return workMapper.workDetail(w_no);
	}

	@Override
	public boolean workUpdate(WorkVO vo) {
		return workMapper.workUpdate(vo);
	}

	@Override
	public boolean workDelete(int w_no) {
		return workMapper.workDelete(w_no);
	}

}