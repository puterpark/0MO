package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PayVO;
import com.kosmo.vo.PointPayVO;
import com.kosmo.vo.PointVO;
import com.kosmo.vo.SeekPointVO;

@Repository("ppdao")
public interface PointPayMapper {
	
	public ArrayList<PointVO> adminPointList(@Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PayVO> adminPayList(@Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PointVO> adminPointsearchList11(@Param("mid")String mid, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PointVO> adminPointsearchList(@Param("mid")String mid, @Param("sdate")String sdate, 
													@Param("edate")String edate,
													@Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PayVO> adminPayIdSearchList(@Param("mid")String mid, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PayVO> adminPaySearchList(@Param("mid")String mid, @Param("sdate")String sdate, @Param("edate")String edate
												, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public int pointCount();
	
	public int pointSearchCount(@Param("mid")String mid, @Param("sdate")String sdate, @Param("edate")String edate);

	public int pointIdSearchCount(@Param("mid")String mid);
	
	public int payCount();
	
	public int paySearchCount(@Param("mid")String mid, @Param("sdate")String sdate, @Param("edate")String edate);
	
	public int paySerchIdCount(@Param("mid")String mid);
	
	public int pointSum(int mseq);
	
	public PayVO payCom(int mseq);
	
	public ArrayList<PointVO> userPointList(@Param("mseq") int mseq
											, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public ArrayList<PointVO> userSearchPointList(@Param("mseq")int mseq
												, @Param("sdate")String sdate, @Param("edate")String edate
												, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public int userPointCount(int mseq);
	
	public int userSearhPointCount(@Param("mseq")int mseq, @Param("sdate")String sdate, @Param("edate")String edate);
	
	public ArrayList<PayVO> userPayList(@Param("mseq")int mseq
			, @Param("sseq") int sseq, @Param("eseq") int eseq);

	public ArrayList<PayVO> userSearchPayList(@Param("mseq")int mseq
					, @Param("sdate")String sdate, @Param("edate")String edate
					, @Param("sseq") int sseq, @Param("eseq") int eseq);
	
	public int userPayCount(int mseq);
	
	public int userSearhPayCount(@Param("mseq")int mseq, @Param("sdate")String sdate, @Param("edate")String edate);
	
	public int insertPayPoint(@Param("mseq") int mseq, @Param("pamoney")  int pamoney);
	
	public int insertPay(PayVO pavo);
	
	public int insertPointPayTable();
	
	// =============== �쉶�썝媛��엯, 怨듬え�쟾 �궘�젣, �룷�뤃 �긽�꽭蹂닿린, 怨듬え�쟾 �벑濡�, �씤�뜳�뒪 寃곗젣 由ъ뒪�듃 ============

	public int insertMember();

	public int insertJoinPoint();
	
	public int gDeletePoint(int mseq);
	
	public int poViewPoint(int mseq);
	
	public int insertSeekPoint(@Param("mseq") int mseq, @Param("sseq") int sseq);
	
	public int gUploadPoint(int mseq);
	
	public ArrayList<PayVO> indexPayList(); // 3媛쒕쭔 異쒕젰
	
	public int payCnt();

	public int searchSpoint(@Param("mseq") int mseq, @Param("sseq") int sseq);
	
	public int payTodayCount();
	
}



