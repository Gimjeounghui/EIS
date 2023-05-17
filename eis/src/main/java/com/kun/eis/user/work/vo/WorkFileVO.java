package com.kun.eis.user.work.vo;


import java.time.LocalDateTime;


public class WorkFileVO {

    private int w_file_no;
    private int w_no;
    private String w_file;
    private String w_file_path;
    private LocalDateTime w_file_created_ate;
    private LocalDateTime w_file_updated_ate;
    private LocalDateTime w_file_deleted_ate;
	
    public int getW_file_no() {
		return w_file_no;
	}
	public void setW_file_no(int w_file_no) {
		this.w_file_no = w_file_no;
	}
	public int getW_no() {
		return w_no;
	}
	public void setW_no(int w_no) {
		this.w_no = w_no;
	}
	public String getW_file() {
		return w_file;
	}
	public void setW_file(String w_file) {
		this.w_file = w_file;
	}
	public String getW_file_path() {
		return w_file_path;
	}
	public void setW_file_path(String w_file_path) {
		this.w_file_path = w_file_path;
	}
	public LocalDateTime getW_file_created_ate() {
		return w_file_created_ate;
	}
	public void setW_file_created_ate(LocalDateTime w_file_created_ate) {
		this.w_file_created_ate = w_file_created_ate;
	}
	public LocalDateTime getW_file_updated_ate() {
		return w_file_updated_ate;
	}
	public void setW_file_updated_ate(LocalDateTime w_file_updated_ate) {
		this.w_file_updated_ate = w_file_updated_ate;
	}
	public LocalDateTime getW_file_deleted_ate() {
		return w_file_deleted_ate;
	}
	public void setW_file_deleted_ate(LocalDateTime w_file_deleted_ate) {
		this.w_file_deleted_ate = w_file_deleted_ate;
	}
    
}
