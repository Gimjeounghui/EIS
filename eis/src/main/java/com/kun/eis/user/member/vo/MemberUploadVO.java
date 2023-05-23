package com.kun.eis.user.member.vo;



/**
 * 23.05.04
 * MemberUploadVO 생성
 */
public class MemberUploadVO {

	private int mUpload_no;
    private String mEmail;
    private String mPhoto;
    private String mPhoto_path;

    public int getmUpload_no() {
		return mUpload_no;
	}
	public void setmUpload_no(int mUpload_no) {
		this.mUpload_no = mUpload_no;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPhoto() {
		return mPhoto;
	}
	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}
	public String getmPhoto_path() {
		return mPhoto_path;
	}
	public void setmPhoto_path(String mPhoto_path) {
		this.mPhoto_path = mPhoto_path;
	}
	
}
