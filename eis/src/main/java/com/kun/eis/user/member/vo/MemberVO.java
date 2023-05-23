package com.kun.eis.user.member.vo;


import com.kun.eis.common.vo.DefaultVO;


import java.time.LocalDateTime;

/**
 * 23.04.28
 * MemberVO 생성
 * 23.05.04
 * MemberVO 수정 ( m_permiss, m_created_ate .. )
 */


public class MemberVO extends DefaultVO {


	private String mEmail;	//이메일

    private String mName; //성별

    private String mPw;  //패스워드코드

    private String mPhone;
    
    private char mPermiss;

    private char mType;

    private String mCreatedate;

    private String mUpdatedate;
    
    private String mDeletedate;

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

	public String getmCreatedate() {
		return mCreatedate;
	}

	public void setmCreatedate(String mCreatedate) {
		this.mCreatedate = mCreatedate;
	}

	public String getmUpdatedate() {
		return mUpdatedate;
	}

	public void setmUpdatedate(String mUpdatedate) {
		this.mUpdatedate = mUpdatedate;
	}

	public String getmDeletedate() {
		return mDeletedate;
	}

	public void setmDeletedate(String mDeletedate) {
		this.mDeletedate = mDeletedate;
	}



   
}