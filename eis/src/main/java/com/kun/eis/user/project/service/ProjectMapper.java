package com.kun.eis.user.project.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.project.vo.ProjectVO;

@Mapper
public interface ProjectMapper {

	public List<ProjectVO> selectProjectList(ProjectVO vo);
	
}