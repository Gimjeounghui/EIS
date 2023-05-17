package com.kun.eis.user.member.vo;



/**
 * 23.05.04
 * MemberUploadVO 생성
 */
public class MemberUploadVO {

    private int m_upload_no;
    private String m_email;
    private String m_photo;
    private String m_photo_path;
	public int getM_upload_no() {
		return m_upload_no;
	}
	public void setM_upload_no(int m_upload_no) {
		this.m_upload_no = m_upload_no;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_photo() {
		return m_photo;
	}
	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
	public String getM_photo_path() {
		return m_photo_path;
	}
	public void setM_photo_path(String m_photo_path) {
		this.m_photo_path = m_photo_path;
	}

}
