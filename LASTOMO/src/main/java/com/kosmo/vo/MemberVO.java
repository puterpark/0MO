package com.kosmo.vo;

import java.util.ArrayList;

public class MemberVO {

	private int mseq;
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String mphone;
	private String mmail;
	private String mgender;
	private String mregdate;
	private String mdel;

	private int mcnt;
	

	private String msi1;
	private String msgg1;
	private String memd1;
	private String mdetail1;
	
	private String msi2;
	private String msgg2;
	private String memd2;
	private String mdetail2;
	
	private ArrayList<DutyVO> dlist;
	
	private String dname;
	private int dseq;
	private int dlength;
	private int darr;
	
	private String checkbox;
	
	private int startSeq;
	private int endSeq;
	
	private String searchStr;
	
	public String getMsi1() {
		return msi1;
	}
	public void setMsi1(String msi1) {
		this.msi1 = msi1;
	}
	public String getMsgg1() {
		return msgg1;
	}
	public void setMsgg1(String msgg1) {
		this.msgg1 = msgg1;
	}
	public String getMemd1() {
		return memd1;
	}
	public void setMemd1(String memd1) {
		this.memd1 = memd1;
	}
	public String getMdetail1() {
		return mdetail1;
	}
	public void setMdetail1(String mdetail1) {
		this.mdetail1 = mdetail1;
	}

	public String getMsi2() {
		return msi2;
	}
	public void setMsi2(String msi2) {
		this.msi2 = msi2;
	}
	public String getMsgg2() {
		return msgg2;
	}
	public void setMsgg2(String msgg2) {
		this.msgg2 = msgg2;
	}
	public String getMemd2() {
		return memd2;
	}
	public void setMemd2(String memd2) {
		this.memd2 = memd2;
	}
	public String getMdetail2() {
		return mdetail2;
	}
	public void setMdetail2(String mdetail2) {
		this.mdetail2 = mdetail2;
	}

	

	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMmail() {
		return mmail;
	}
	public void setMmail(String mmail) {
		this.mmail = mmail;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMregdate() {
		return mregdate;
	}
	public void setMregdate(String mregdate) {
		this.mregdate = mregdate;
	}
	public String getMdel() {
		return mdel;
	}
	public void setMdel(String mdel) {
		this.mdel = mdel;
	}
	public int getMcnt() {
		return mcnt;
	}
	public void setMcnt(int mcnt) {
		this.mcnt = mcnt;
	}
	public ArrayList<DutyVO> getDlist() {
		return dlist;
	}
	public void setDlist(ArrayList<DutyVO> dlist) {
		this.dlist = dlist;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public int getDlength() {
		return dlength;
	}
	public void setDlength(int dlength) {
		this.dlength = dlength;
	}
	public int getDarr() {
		return darr;
	}
	public void setDarr(int darr) {
		this.darr = darr;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public int getStartSeq() {
		return startSeq;
	}
	public void setStartSeq(int startSeq) {
		this.startSeq = startSeq;
	}
	public int getEndSeq() {
		return endSeq;
	}
	public void setEndSeq(int endSeq) {
		this.endSeq = endSeq;
	}
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

}