package com.kun.eis.user.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.work.vo.WorkVO;

@Mapper
public interface WorkMapper {

	public List<WorkVO> selectWorkList(WorkVO vo);

}