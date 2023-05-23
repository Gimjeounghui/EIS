package com.kun.eis.user.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.work.vo.WorkVO;

@Mapper
public interface WorkMapper {

	public List<WorkVO> selectWorkList(WorkVO vo);
	
	public boolean registWork(WorkVO vo); //등록

	public WorkVO detailWork(int wNo); //상세조회
	
	public boolean updateWork(WorkVO vo); //수정

	public boolean deleteWork(int wNo); //삭제

}