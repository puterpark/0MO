package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.AdminVO;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.RreportVO;

@Repository("dao")
public interface GongmoMapper {
	
public int breportCount();
	
	public int rreportCount();
	
	public int memberCount();

	public int gongmoCount();
	
	public int gongmoFieldCount(int fseq);
	
	public int gongmoSearchCount(String searchStr);
	
	public ArrayList<GongmoVO> gongmoListFive();
	
	public ArrayList<GongmoVO> gongmoList(@Param("sseq") int sseq, 
											@Param("eseq") int eseq);
	
	public ArrayList<GongmoVO> gongmoListField(@Param("fseq") int fseq, @Param("sseq") int sseq, 
													@Param("eseq") int eseq);
	
	public ArrayList<FieldVO> gongmoField(int gseq);
	
	public ArrayList<GongmoVO> gongmoListSearch(@Param("sseq") int sseq, 
											@Param("eseq") int eseq, 
											@Param("searchStr") String searchStr);
	
	public ArrayList<GongmoVO> gongmoCal();
	
	
	public GongmoVO gongmoDetail(int gseq);
	
	public int gongmoInsert(GongmoVO gvo);
	
	public int adminGongmoInsert(GongmoVO gvo);
	
	public int gongmoFieldInsert(int fseq);
	
	public int gongmoFieldUpdate(@Param("gseq") int gseq, @Param("fseq") int fseq);
	
	public int gongmoUpdate(GongmoVO gvo);
	
	public int gongmoUpdateForPoster(GongmoVO gvo);
	
	public int gongmoFieldDelete(int gseq);
	
	public int gongmoDelete(int gseq);
	
	public int gongmoViewUp(int gseq);
	
	public int gongmoLike(@Param("gseq") int gseq, @Param("mseq") int mseq, @Param("lcnt") int lcnt);
	
	public int adminGongmoCount();
	
	public int userGongmoCount();
	
	public int adminGongmoSearchCount(String searchStr);
	
	public int userGongmoSearchCount(String searchStr);
	
	public ArrayList<GongmoVO> adminGongmoListFive();
	
	public ArrayList<GongmoVO> userGongmoListFive();
	
	public ArrayList<GongmoVO> adminGongmoList(@Param("sseq") int sseq, 
												@Param("eseq") int eseq);
	
	public ArrayList<GongmoVO> userGongmoList(@Param("sseq") int sseq, 
												@Param("eseq") int eseq);
	
	public ArrayList<GongmoVO> adminGongmoListSearch(@Param("sseq") int sseq, 
												@Param("eseq") int eseq, 
												@Param("searchStr") String searchStr);	
	
	public ArrayList<GongmoVO> userGongmoListSearch(@Param("sseq") int sseq, 
												@Param("eseq") int eseq, 
												@Param("searchStr") String searchStr);
	
	public ArrayList<FieldVO> fieldList();
	
	public ArrayList<GongmoVO> fieldListCheck(int gseq);
	
	public int fieldInsert(FieldVO fvo);
	
	public int fieldUpdate(FieldVO fvo);
	
	public int gongmoReport(BreportVO brvo);
	
	public int breportListCount();
	
	public ArrayList<BreportVO> breportList(@Param("startSeq") int startSeq, 
											@Param("endSeq") int endSeq);
	
	public int breportSearchListCount(String searchStr);
	
	public ArrayList<BreportVO> breportSearchList(@Param("startSeq") int startSeq, 
													@Param("endSeq") int endSeq,
													@Param("searchStr") String searchStr);
	
	public int rreportListCount();
	
	public ArrayList<RreportVO> rreportList(@Param("startSeq") int startSeq, 
												@Param("endSeq") int endSeq);
	
	public int rreportSearchListCount(String searchStr);
	
	public ArrayList<RreportVO> rreportSearchList(@Param("startSeq") int startSeq, 
													@Param("endSeq") int endSeq,
													@Param("searchStr") String searchStr);
	
	public int memberDelete(int mseq);
	
	
	public int memberSearchCount(String searchStr);

	public ArrayList<MemberVO> memberList(@Param("startSeq") int startSeq, 
											@Param("endSeq") int endSeq);

	public ArrayList<MemberVO> memberSearchList(@Param("startSeq") int startSeq, 
													@Param("endSeq") int endSeq,
													@Param("searchStr") String searchStr);

	
	
	
	
	
	public int adminListCount();
	
	public ArrayList<AdminVO> adminList(@Param("startSeq") int startSeq, 
										@Param("endSeq") int endSeq);
	
	public int adminSearchListCount(String searchStr);
	
	public ArrayList<AdminVO> adminSearchList(@Param("startSeq") int startSeq, 
												@Param("endSeq") int endSeq,
												@Param("searchStr") String searchStr);
	
	
	public AdminVO adminDetail(int aseq);
	
	public int adminGradeUp(int aseq);
	
	public int adminGradeDown(int aseq);
	
	public int adminAckOn(int aseq);
	
	public int adminAckOff(int aseq);
	
	public int adminJoin(AdminVO avo);
	
	public AdminVO adminLogin(@Param("aid") String aid, @Param("apw") String apw);	
		
	public int adminLeave(int aseq);
	
	//하트부분
	public int likeInfo(@Param("mseq")int mseq, @Param("column") String column, @Param("value") int value);
}
