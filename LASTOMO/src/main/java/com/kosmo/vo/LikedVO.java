package com.kosmo.vo;

public class LikedVO {
	
	private int lseq;
	private int lcnt;
	private int gseq;
	private int oseq;
	private int sseq;
	private int mseq;
	
	//추가된 부분
	private GongmoVO gvo;
	private OfferVO ovo;
	private SeekVO svo;
	
	public int getLseq() {
		return lseq;
	}
	public void setLseq(int lseq) {
		this.lseq = lseq;
	}
	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
	}
	public int getGseq() {
		return gseq;
	}
	public void setGseq(int gseq) {
		this.gseq = gseq;
	}
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public GongmoVO getGvo() {
		return gvo;
	}
	public void setGvo(GongmoVO gvo) {
		this.gvo = gvo;
	}
	public OfferVO getOvo() {
		return ovo;
	}
	public void setOvo(OfferVO ovo) {
		this.ovo = ovo;
	}
	public SeekVO getSvo() {
		return svo;
	}
	public void setSvo(SeekVO svo) {
		this.svo = svo;
	}
	
	
	
}
