package com.kun.eis.user.project.vo;

import com.kun.eis.common.vo.DefaultVO;

public class ProjectVO extends DefaultVO {
	
	private int pNo; 			// 프로젝트 번호
	
	private String m_email; 	// 회원 이메일
	
	private String pTitle; 		// 프로젝트 제목
	
	private String pContent; 	// 프로젝트 내용
	
	private String pCreatedAte; // 프로젝트 생성일
	
	private String pUpdatedAte; // 프로젝트 수정일
	
	private String pDeletedAte; // 프로젝트 삭제일

	
	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getm_email() {
		return m_email;
	}

	public void setm_email(String m_email) {
		this.m_email = m_email;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCreatedAte() {
		return pCreatedAte;
	}

	public void setpCreatedAte(String pCreatedAte) {
		this.pCreatedAte = pCreatedAte;
	}

	public String getpUpdatedAte() {
		return pUpdatedAte;
	}

	public void setpUpdatedAte(String pUpdatedAte) {
		this.pUpdatedAte = pUpdatedAte;
	}

	public String getpDeletedAte() {
		return pDeletedAte;
	}

	public void setpDeletedAte(String pDeletedAte) {
		this.pDeletedAte = pDeletedAte;
	}	
}