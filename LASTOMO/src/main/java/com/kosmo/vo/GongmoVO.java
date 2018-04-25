package com.kosmo.vo;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class GongmoVO {
	
	private int gseq;
	private String gtitle;
	private String gspon;
	private String gsday;
	private String geday;
	private String glink;
	private String gbody;
	private String gposter;
	private String gregdate;
	private int gview;
	private String gdel;
	private String gerday;
	private String gsrday;
	
	private int mseq;
	
	private int totalCount;
	private String searchStr;
	private int sseq;
	private int eseq;
	
	private ArrayList<FieldVO> flist;
	
	private MultipartFile ufile;
	
	private MemberVO mvo;
	private FieldVO fvo;
	private LikedVO lvo;
	
	private String fname;
	private int fseq;
	
	private int flength;
	private int farr; 
	
	private String checkbox;
	
	
	public ArrayList<FieldVO> getFlist() {
		return flist;
	}
	public void setFlist(ArrayList<FieldVO> flist) {
		this.flist = flist;
	}
	public int getGseq() {
		return gseq;
	}
	public void setGseq(int gseq) {
		this.gseq = gseq;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public String getGspon() {
		return gspon;
	}
	public void setGspon(String gspon) {
		this.gspon = gspon;
	}
	public String getGsday() {
		return gsday;
	}
	public void setGsday(String gsday) {
		this.gsday = gsday;
	}
	public String getGeday() {
		return geday;
	}
	public void setGeday(String geday) {
		this.geday = geday;
	}
	public String getGlink() {
		return glink;
	}
	public void setGlink(String glink) {
		this.glink = glink;
	}
	public String getGbody() {
		return gbody;
	}
	public void setGbody(String gbody) {
		this.gbody = gbody;
	}
	public String getGposter() {
		return gposter;
	}
	public void setGposter(String gposter) {
		this.gposter = gposter;
	}
	public String getGregdate() {
		return gregdate;
	}
	public void setGregdate(String gregdate) {
		this.gregdate = gregdate;
	}
	public int getGview() {
		return gview;
	}
	public void setGview(int gview) {
		this.gview = gview;
	}
	public String getGdel() {
		return gdel;
	}
	public void setGdel(String gdel) {
		this.gdel = gdel;
	}
	public String getGerday() {
		return gerday;
	}
	public void setGerday(String gerday) {
		this.gerday = gerday;
	}
	
	public String getGsrday() {
		return gsrday;
	}
	public void setGsrday(String gsrday) {
		this.gsrday = gsrday;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
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
	public MemberVO getMvo() {
		return mvo;
	}
	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}
	public FieldVO getFvo() {
		return fvo;
	}
	public void setFvo(FieldVO fvo) {
		this.fvo = fvo;
	}
	public LikedVO getLvo() {
		return lvo;
	}
	public void setLvo(LikedVO lvo) {
		this.lvo = lvo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFseq() {
		return fseq;
	}
	public void setFseq(int fseq) {
		this.fseq = fseq;
	}
	public MultipartFile getUfile() {
		return ufile;
	}
	public void setUfile(MultipartFile ufile) {
		this.ufile = ufile;
	}
	public int getFlength() {
		return flength;
	}
	public void setFlength(int flength) {
		this.flength = flength;
	}
	public int getFarr() {
		return farr;
	}
	public void setFarr(int farr) {
		this.farr = farr;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	
	
	
}
