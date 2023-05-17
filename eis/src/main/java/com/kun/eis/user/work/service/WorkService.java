package com.kun.eis.user.work.service;

import java.util.List;

import com.kun.eis.user.work.vo.WorkVO;

public interface WorkService {
	
	/**
	 * 테스트 항목 리스트
	 * @param vo
	 * @return List
	 * @throws Exception
	 */
	public List<WorkVO> selectWorkList(WorkVO vo);

}