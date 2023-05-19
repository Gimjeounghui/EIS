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


	private String m_email;	//이메일

    private String m_name; //성별

    private String m_pw;  //패스워드코드

    private String m_phone;
    
    private char m_type;

    private char m_permiss;

    private LocalDateTime m_created_ate;

    private LocalDateTime m_updated_ate;
    
    private LocalDateTime m_deleted_ate;

    public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public char getM_type() {
		return m_type;
	}

	public void setM_type(char m_type) {
		this.m_type = m_type;
	}

	public char getM_permiss() {
		return m_permiss;
	}

	public void setM_permiss(char m_permiss) {
		this.m_permiss = m_permiss;
	}

	public LocalDateTime getM_created_ate() {
		return m_created_ate;
	}

	public void setM_created_ate(LocalDateTime m_created_ate) {
		this.m_created_ate = m_created_ate;
	}

	public LocalDateTime getM_updated_ate() {
		return m_updated_ate;
	}

	public void setM_updated_ate(LocalDateTime m_updated_ate) {
		this.m_updated_ate = m_updated_ate;
	}

	public LocalDateTime getM_deleted_ate() {
		return m_deleted_ate;
	}

	public void setM_deleted_ate(LocalDateTime m_deleted_ate) {
		this.m_deleted_ate = m_deleted_ate;
	}


}