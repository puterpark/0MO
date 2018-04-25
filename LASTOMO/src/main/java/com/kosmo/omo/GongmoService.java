package com.kosmo.omo;

import java.util.ArrayList;
import java.util.Map;

import com.kosmo.vo.AdminVO;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.RreportVO;

public interface GongmoService {
	
	public int breportCount();
	
	public int rreportCount();
	
	public int memberCount();
	
	public int gongmoCount();
	
	public int gongmoFieldCount(int fseq);
	
	public int gongmoSearchCount(String searchStr);
	
	public ArrayList<GongmoVO> gongmoListFive();
	
	public ArrayList<GongmoVO> gongmoList(int sseq, int eseq);
	
	public ArrayList<GongmoVO> gongmoListField(int fseq, int sseq, int eseq);
	
	public Map<String, Object> indexPage();
	
	public ArrayList<FieldVO> gongmoField(int gseq);
	
	public ArrayList<GongmoVO> gongmoListSearch(int sseq, int eseq, String searchStr);
	
	public ArrayList<GongmoVO> gongmoCal();

	public GongmoVO gongmoDetail(int gseq);
	
	public int gongmoInsert(GongmoVO gvo);
	
	public int gongmoFieldInsert(int fseq);
	
	public int gongmoFieldUpdate(int gseq, int fseq);
	
	public int gongmoUpdate(GongmoVO gvo);
	
	public int gongmoUpdateForPoster(GongmoVO gvo);
	
	public int gongmoFieldDelete(int gseq);
	
	public int gongmoDelete(int gseq);
	
	public int gongmoViewUp(int gseq);
	
	public int gongmoLike(int gseq, int mseq, int lcnt);
	
	public ArrayList<GongmoVO> adminGongmoListFive();
	
	public ArrayList<GongmoVO> userGongmoListFive();
	
	public int adminGongmoCount();
	
	public int userGongmoCount();
	
	public int adminGongmoSearchCount(String searchStr);
	
	public int userGongmoSearchCount(String searchStr);
	
	public ArrayList<GongmoVO> adminGongmoList(int sseq, int eseq);
	
	public ArrayList<GongmoVO> userGongmoList(int sseq, int eseq);
	
	public ArrayList<GongmoVO> adminGongmoListSearch(int sseq, int eseq, String searchStr);
	
	public ArrayList<GongmoVO> userGongmoListSearch(int sseq, int eseq, String searchStr);
	
	public ArrayList<FieldVO> fieldList();
	
	public ArrayList<GongmoVO> fieldListCheck(int gseq);
	
	public int fieldInsert(FieldVO fvo);
	
	public int fieldUpdate(FieldVO fvo);
	
	public int gongmoReport(BreportVO brvo);
	
public int breportListCount();
	
	public ArrayList<BreportVO> breportList(int startSeq, int endSeq);
	
	public int breportSearchListCount(String searchStr);
	
	public ArrayList<BreportVO> breportSearchList(int startSeq, int endSeq, String searchStr);
	
	public int rreportListCount();
	
	public ArrayList<RreportVO> rreportList(int startSeq, int endSeq);
	
	public int rreportSearchListCount(String searchStr);
	
	public ArrayList<RreportVO> rreportSearchList(int startSeq, int endSeq, String searchStr);
	
	public int memberDelete(int mseq);
	
	
	
	public int memberSearchCount(String searchStr);

	public ArrayList<MemberVO> memberList(int startSeq, int endSeq);

	public ArrayList<MemberVO> memberSearchList(int startSeq, int endSeq, String searchStr);
	
	
	
	
	public int adminListCount();
	
	public ArrayList<AdminVO> adminList(int startSeq, int endSeq);
	
	public int adminSearchListCount(String searchStr);
	
	public ArrayList<AdminVO> adminSearchList(int startSeq, int endSeq, String searchStr);
	
	
	public AdminVO adminDetail(int aseq);
	
	public int adminGradeUp(int aseq);
	
	public int adminGradeDown(int aseq);
	
	public int adminAckOn(int aseq);
	
	public int adminAckOff(int aseq);
	
	
	public int adminJoin(AdminVO avo);
	
	public AdminVO adminLogin(String aid, String apw);
	
	public int adminLeave(int aseq);

	//하트표시
	public int likeInfo(int mseq, String column, int value);
	
	
	
}
