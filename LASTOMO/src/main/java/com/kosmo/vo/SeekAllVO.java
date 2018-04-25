package com.kosmo.vo;

import java.util.ArrayList;

public class SeekAllVO {
	
	private int sseq;
	private int mseq;
	private String stitle;
	private String sbody;
	private String sregdate;
	private int sview;
	private int lcnt;
	private String dname;
	private int dseq;
	private String sdel;
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String mphone;
	private String mmail;
	private String mgender;
	private String mregdate;
	private String mdel;
	private String mpost1;
	private String msi1;
	private String msgg1;
	private String memd1;
	private String mdetail1;
	private String mpost2;
	private String msi2;
	private String msgg2;
	private String memd2;
	private String mdetail2;
	private String rcnt;
	private int rseq;
	private int rmseq;
	private String rmid;
	private String rbody;
	private String rregdate;
	private String pffile;
	private int pfseq;
	
	
	
	private ArrayList<DutyVO> dlist;
	
	private String searchStr;
	private int startseq;
	private int endseq;
	private int rnum;
	
	
	public String getSearchStr() {
		return searchStr;
	}
	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}
	public ArrayList<DutyVO> getDlist() {
		return dlist;
	}
	public void setDlist(ArrayList<DutyVO> dlist) {
		this.dlist = dlist;
	}
	public int getPfseq() {
		return pfseq;
	}
	public void setPfseq(int pfseq) {
		this.pfseq = pfseq;
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
	public int getSview() {
		return sview;
	}
	public void setSview(int sview) {
		this.sview = sview;
	}
	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
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
	public String getSdel() {
		return sdel;
	}
	public void setSdel(String sdel) {
		this.sdel = sdel;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
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
	public String getMpost1() {
		return mpost1;
	}
	public void setMpost1(String mpost1) {
		this.mpost1 = mpost1;
	}
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
	public String getMpost2() {
		return mpost2;
	}
	public void setMpost2(String mpost2) {
		this.mpost2 = mpost2;
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
	public String getRcnt() {
		return rcnt;
	}
	public void setRcnt(String rcnt) {
		this.rcnt = rcnt;
	}
	public int getRmseq() {
		return rmseq;
	}
	public void setRmseq(int rmseq) {
		this.rmseq = rmseq;
	}

	public String getRmid() {
		return rmid;
	}
	public void setRmid(String rmid) {
		this.rmid = rmid;
	}
	public String getRbody() {
		return rbody;
	}
	public void setRbody(String rbody) {
		this.rbody = rbody;
	}
	public String getRregdate() {
		return rregdate;
	}
	public void setRregdate(String rregdate) {
		this.rregdate = rregdate;
	}
	public int getStartseq() {
		return startseq;
	}
	public void setStartseq(int startseq) {
		this.startseq = startseq;
	}
	public int getEndseq() {
		return endseq;
	}
	public void setEndseq(int endseq) {
		this.endseq = endseq;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getPffile() {
		return pffile;
	}
	public void setPffile(String pffile) {
		this.pffile = pffile;
	}
	
	
	
}
