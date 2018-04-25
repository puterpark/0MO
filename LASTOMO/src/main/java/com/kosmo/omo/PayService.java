package com.kosmo.omo;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.kosmo.vo.PayVO;
import com.kosmo.vo.PointVO;
import com.kosmo.vo.SeekPointVO;

public interface PayService {
	
	public HashMap<String, Object> adminPage();
	
	public ArrayList<PointVO> adminPointList(int sseq, int eseq); 
	
	public ArrayList<PayVO> adminPayList(int sseq, int eseq);

	public ArrayList<PointVO> adminPointsearchList11(String mid, int sseq, int eseq);
	
	public ArrayList<PointVO> adminPointsearchList(String mid, String sdate, String edate, int sseq, int eseq);
	
	public ArrayList<PayVO> adminPayIdSearchList(String mid, int sseq, int eseq);
	
	public ArrayList<PayVO> adminPaySearchList(String mid, String sdate, String edate, int sseq, int eseq);
	
	public int pointCount();
	
	public int pointSearchCount(String mid, String sdate, String edate);

	public int pointIdSearchCount(String mid);
	
	public int payCount(); 
	
	public int paySearchCount(String mid, String sdate, String edate);
	
	public int paySerchIdCount(String mid);
	
	public int pointSum(int mseq);
	
	public PayVO payCom(int mseq);
	
	public HashMap<String, Object> pointLookPage(int mseq, String sdate, String edate, int sseq, int eseq);
	
	public ArrayList<PointVO> userPointList(int mseq, int sseq, int eseq);
	
	public ArrayList<PointVO> userSearchPointList(int mseq, String sdate, String edate, int sseq, int eseq);
	
	public int userPointCount(int mseq);
	
	public int userSearhPointCount(int mseq, String sdate, String edate);
	
	public HashMap<String, Object> payLookPage(int mseq, String sdate, String edate, int sseq, int eseq);
	
	public ArrayList<PayVO> userPayList(int mseq, int sseq, int eseq);
	
	public ArrayList<PayVO> userSearchPayList(int mseq, String sdate, String edate, int sseq, int eseq);
	
	public int userPayCount(int mseq);
	
	public int userSearhPayCount(int mseq, String sdate, String edate);
	
	public PayVO insetPage(PayVO pavo);
	
	public int insertPayPoint(int mseq, int pamoney);
	
	public int insertPay(PayVO pavo);
	
	public int insertPointPayTable();
	
//	=============== �쉶�썝媛��엯, 怨듬え�쟾 �궘�젣, �룷�뤃 �긽�꽭蹂닿린, 怨듬え�쟾 �벑濡�, �씤�뜳�뒪 寃곗젣 由ъ뒪�듃 ============
	
	public int insertMember();

	public int insertJoinPoint();
	
	public int gDeletePoint(int mseq);
	
	public int poViewPoint(int mseq);
	
	public int insertSeekPoint(@Param("mseq") int mseq, @Param("sseq") int sseq);
	
	public int gUploadPoint(int mseq);
	
	public ArrayList<PayVO> indexPayList(); // 3媛쒕쭔 異쒕젰
	
	public int payCnt();
	
	public HashMap<String, Object> adminMainPage();
	
	public int searchSpoint(int mseq, int sseq);
	
	public int payTodayCount();
	
}
