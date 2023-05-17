package com.kun.eis.user.business.vo;

import com.kun.eis.common.vo.DefaultVO;

public class BusinessVO extends DefaultVO {
	
	private int bNo; 			// 영업번호

	private String mEmail; 		// 회원 이메일
	
	private String bTarget; 	// 영업대상
	
	private String bContent; 	// 영업내용
	
	private String bCreatedAte; // 영업 등록일

	private String bUpdatedAte; // 영업 수정일
	
	private String bDeletedAte; // 영업 삭제일

	
	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getbTarget() {
		return bTarget;
	}

	public void setbTarget(String bTarget) {
		this.bTarget = bTarget;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbCreatedAte() {
		return bCreatedAte;
	}

	public void setbCreatedAte(String bCreatedAte) {
		this.bCreatedAte = bCreatedAte;
	}

	public String getbUpdatedAte() {
		return bUpdatedAte;
	}

	public void setbUpdatedAte(String bUpdatedAte) {
		this.bUpdatedAte = bUpdatedAte;
	}

	public String getbDeletedAte() {
		return bDeletedAte;
	}

	public void setbDeletedAte(String bDeletedAte) {
		this.bDeletedAte = bDeletedAte;
	}
}