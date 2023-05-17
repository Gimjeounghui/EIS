package com.kun.eis.user.work.vo;

import com.kun.eis.common.vo.DefaultVO;

public class WorkVO extends DefaultVO {
	
	private int wNo; 			// 업무번호
	
	private String mEmail; 		// 회원 이메일
	
	private String wTitle; 		// 업무제목
	
	private String wContent; 	// 업무내용

	private String wFile;		// 업무파일
	
	private String wFilePath; 	// 업무파일 경로
	
	private String wCreatedAte; // 업무 등록일
	
	private String wUpdatedAte; // 업무 수정일
	
	private String wDeletedAte; // 업무 삭제일

	
	public int getwNo() {
		return wNo;
	}

	public void setwNo(int wNo) {
		this.wNo = wNo;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getwTitle() {
		return wTitle;
	}

	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}

	public String getwContent() {
		return wContent;
	}

	public void setwContent(String wContent) {
		this.wContent = wContent;
	}

	public String getwFile() {
		return wFile;
	}

	public void setwFile(String wFile) {
		this.wFile = wFile;
	}

	public String getwFilePath() {
		return wFilePath;
	}

	public void setwFilePath(String wFilePath) {
		this.wFilePath = wFilePath;
	}

	public String getwCreatedAte() {
		return wCreatedAte;
	}

	public void setwCreatedAte(String wCreatedAte) {
		this.wCreatedAte = wCreatedAte;
	}

	public String getwUpdatedAte() {
		return wUpdatedAte;
	}

	public void setwUpdatedAte(String wUpdatedAte) {
		this.wUpdatedAte = wUpdatedAte;
	}

	public String getwDeletedAte() {
		return wDeletedAte;
	}

	public void setwDeletedAte(String wDeletedAte) {
		this.wDeletedAte = wDeletedAte;
	}
}