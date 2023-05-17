package com.kun.eis.user.member.vo;

import com.kun.eis.common.vo.DefaultVO;

public class MemberVO extends DefaultVO {
	
	private String mEmail; 		// 회원 이메일
	
	private String mName; 		// 회원 이름
	
	private String mPw; 		// 회원 비밀번호
	
	private String mPhone; 		// 회원 전화번호
	
	private char mPermiss; 		// 회원승인 번호

	private char mType; 		// 회원구분(사용자, 관리자)
	
	private String mCreatedAte; // 회원 등록일
	
	private String mUpdatedAte; // 회원 수정일
	
	private String mDeletedAte; // 회원 삭제일

	
	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public char getmPermiss() {
		return mPermiss;
	}

	public void setmPermiss(char mPermiss) {
		this.mPermiss = mPermiss;
	}

	public char getmType() {
		return mType;
	}

	public void setmType(char mType) {
		this.mType = mType;
	}

	public String getmCreatedAte() {
		return mCreatedAte;
	}

	public void setmCreatedAte(String mCreatedAte) {
		this.mCreatedAte = mCreatedAte;
	}

	public String getmUpdatedAte() {
		return mUpdatedAte;
	}

	public void setmUpdatedAte(String mUpdatedAte) {
		this.mUpdatedAte = mUpdatedAte;
	}

	public String getmDeletedAte() {
		return mDeletedAte;
	}

	public void setmDeletedAte(String mDeletedAte) {
		this.mDeletedAte = mDeletedAte;
	}	
}