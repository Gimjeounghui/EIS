package com.kun.eis.user.project.service;

import java.util.List;

import com.kun.eis.user.project.vo.ProjectVO;

public interface ProjectService {
	
	/**
	 * 테스트 항목 리스트
	 * @param vo
	 * @return List
	 * @throws Exception
	 */
	public List<ProjectVO> selectProjectList(ProjectVO vo);

}