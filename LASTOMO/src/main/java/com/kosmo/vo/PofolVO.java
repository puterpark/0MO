package com.kosmo.vo;

import org.springframework.web.multipart.MultipartFile;

public class PofolVO {
	private int pfseq;
	private int mseq;
	private String pfregdate;
	private String pftitle;
	private String pfdel;
	private String pffile;
	private MultipartFile ufile;
	
	public MultipartFile getUfile() {
		return ufile;
	}
	public void setUfile(MultipartFile ufile) {
		this.ufile = ufile;
	}
	public int getPfseq() {
		return pfseq;
	}
	public void setPfseq(int pfseq) {
		this.pfseq = pfseq;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getPfregdate() {
		return pfregdate;
	}
	public void setPfregdate(String pfregdate) {
		this.pfregdate = pfregdate;
	}
	public String getPftitle() {
		return pftitle;
	}
	public void setPftitle(String pftitle) {
		this.pftitle = pftitle;
	}
	public String getPfdel() {
		return pfdel;
	}
	public void setPfdel(String pfdel) {
		this.pfdel = pfdel;
	}
	public String getPffile() {
		return pffile;
	}
	public void setPffile(String pffile) {
		this.pffile = pffile;
	}
	
	

}
