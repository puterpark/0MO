package com.kosmo.vo;

public class PayVO {
	private int paseq;
	private int mseq;
	private int ptseq;
	private int pamoney;
	private String mid;
	private String paregdate;

	private int totalCount;
	private int sseq;
	private int eseq;

	private int popoint;
	private String ptname;

	private int pcnt;

	public int getPopoint() {
		return popoint;
	}
	public void setPopoint(int popoint) {
		this.popoint = popoint;
	}
	public String getPtname() {
		return ptname;
	}
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getEseq() {
		return eseq;
	}
	public void setEseq(int eseq) {
		this.eseq = eseq;
	}

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getPaseq() {
		return paseq;
	}
	public void setPaseq(int paseq) {
		this.paseq = paseq;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public int getPtseq() {
		return ptseq;
	}
	public void setPtseq(int ptseq) {
		this.ptseq = ptseq;
	}
	public int getPamoney() {
		return pamoney;
	}
	public void setPamoney(int pamoney) {
		this.pamoney = pamoney;
	}
	public String getParegdate() {
		return paregdate;
	}
	public void setParegdate(String paregdate) {
		this.paregdate = paregdate;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}

}