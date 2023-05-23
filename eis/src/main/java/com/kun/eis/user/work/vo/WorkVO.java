package com.kun.eis.user.work.vo;



import com.kun.eis.common.vo.DefaultVO;

public class WorkVO extends DefaultVO {
 
	private int wNo;
    private String mEmail;
    private String wTitle;
    private String wContents;
    private String wFile ;
    private String wFilePath ;
    private String wCreatedate;
    private String wUpdatedate;
    private String wDeletedate;
	
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
	public String getwContents() {
		return wContents;
	}
	public void setwContents(String wContents) {
		this.wContents = wContents;
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
	public String getwCreatedate() {
		return wCreatedate;
	}
	public void setwCreatedate(String wCreatedate) {
		this.wCreatedate = wCreatedate;
	}
	public String getwUpdatedate() {
		return wUpdatedate;
	}
	public void setwUpdatedate(String wUpdatedate) {
		this.wUpdatedate = wUpdatedate;
	}
	public String getwDeletedate() {
		return wDeletedate;
	}
	public void setwDeletedate(String wDeletedate) {
		this.wDeletedate = wDeletedate;
	}
    
}