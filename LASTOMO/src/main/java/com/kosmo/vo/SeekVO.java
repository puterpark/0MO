package com.kosmo.vo;

public class SeekVO {

	
	private int sseq;
	private String stitle;
	private String sbody;
	private String sregdate;
	private String sview;
	private String sdel;
	private int lcnt;
	private MemberVO mvo;
	
	public MemberVO getMvo() {
		return mvo;
	}
	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}
	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSbody() {
		return sbody;
	}
	public void setSbody(String sbody) {
		this.sbody = sbody;
	}
	public String getSregdate() {
		return sregdate;
	}
	public void setSregdate(String sregdate) {
		this.sregdate = sregdate;
	}
	public String getSview() {
		return sview;
	}
	public void setSview(String sview) {
		this.sview = sview;
	}
	public String getSdel() {
		return sdel;
	}
	public void setSdel(String sdel) {
		this.sdel = sdel;
	}
}
