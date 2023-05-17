package com.kun.eis.user.work.vo;


import java.time.LocalDateTime;

public class WorkVO {
 
	private int w_no;
    private String m_email;
    private String w_title;
    private String w_contents;
    private LocalDateTime w_created_ate;
    private LocalDateTime w_updated_ate;
    private LocalDateTime w_deleted_ate;
    
    public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getW_title() {
		return w_title;
	}
	public void setW_title(String w_title) {
		this.w_title = w_title;
	}
	public String getW_contents() {
		return w_contents;
	}
	public void setW_contents(String w_contents) {
		this.w_contents = w_contents;
	}
	public LocalDateTime getW_created_ate() {
		return w_created_ate;
	}
	public void setW_created_ate(LocalDateTime w_created_ate) {
		this.w_created_ate = w_created_ate;
	}
	public LocalDateTime getW_updated_ate() {
		return w_updated_ate;
	}
	public void setW_updated_ate(LocalDateTime w_updated_ate) {
		this.w_updated_ate = w_updated_ate;
	}
	public LocalDateTime getW_deleted_ate() {
		return w_deleted_ate;
	}
	public void setW_deleted_ate(LocalDateTime w_deleted_ate) {
		this.w_deleted_ate = w_deleted_ate;
	}

}
