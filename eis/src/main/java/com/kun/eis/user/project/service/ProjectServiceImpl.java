package com.kun.eis.user.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kun.eis.user.project.vo.ProjectVO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public List<ProjectVO> selectProjectList(ProjectVO vo) {
		return projectMapper.selectProjectList(vo);
	}
}