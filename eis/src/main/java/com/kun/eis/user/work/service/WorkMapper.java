package com.kun.eis.user.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kun.eis.user.work.vo.WorkVO;

@Mapper
public interface WorkMapper {

	public List<WorkVO> selectWorkList(WorkVO vo);
	
	public boolean workRegist(WorkVO vo); //등록

	public WorkVO workDetail(int w_no); //상세조회
	
	public boolean workUpdate(WorkVO vo); //수정

	public boolean workDelete(int w_no); //삭제

}