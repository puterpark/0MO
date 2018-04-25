package com.kosmo.omo;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.PointPayMapper;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PayVO;
import com.kosmo.vo.PointVO;
import com.kosmo.vo.SeekPointVO;

@Service
public class PayServiceImpl implements PayService {
	
	@Autowired
	private PointPayMapper ppdao;

	@Override
	public ArrayList<PointVO> adminPointList(int sseq, int eseq) {
		return ppdao.adminPointList(sseq, eseq);
	}

	@Override
	public ArrayList<PayVO> adminPayList(int sseq, int eseq) {
		return ppdao.adminPayList(sseq, eseq);
	}

	@Override
	public HashMap<String, Object> adminPage() {
		int sseq=0;
		int eseq=0;
		
		ArrayList<PointVO> adminPointList = ppdao.adminPointList(sseq, eseq);
		ArrayList<PayVO> adminPayList = ppdao.adminPayList(sseq, eseq);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adminPointList", adminPointList);
		map.put("adminPayList", adminPayList);
		
		return map;
	}

	@Override
	public ArrayList<PointVO> adminPointsearchList(String mid, String sdate, String edate, int sseq, int eseq) {
		return ppdao.adminPointsearchList(mid, sdate, edate, sseq, eseq);
	}

	@Override
	public ArrayList<PointVO> adminPointsearchList11(String mid, int sseq, int eseq) {
		return ppdao.adminPointsearchList11(mid, sseq, eseq);
	}

	@Override
	public ArrayList<PayVO> adminPayIdSearchList(String mid, int sseq, int eseq) {
		return ppdao.adminPayIdSearchList(mid, sseq, eseq);
	}

	@Override
	public ArrayList<PayVO> adminPaySearchList(String mid, String sdate, String edate, int sseq, int eseq) {
		return ppdao.adminPaySearchList(mid, sdate, edate, sseq, eseq);
	}

	@Override
	public int pointCount() {
		return ppdao.pointCount();
	}
	
	@Override
	public int pointSearchCount(String mid, String sdate, String edate) {
		return ppdao.pointSearchCount(mid, sdate, edate);
	}

	@Override
	public int pointIdSearchCount(String mid) {
		return ppdao.pointIdSearchCount(mid);
	}

	@Override
	public int payCount() {
		return ppdao.payCount();
	}
	
	@Override
	public int paySearchCount(String mid, String sdate, String edate) {
		return ppdao.paySearchCount(mid, sdate, edate);
	}

	@Override
	public int paySerchIdCount(String mid) {
		return ppdao.paySerchIdCount(mid);
	}

	@Override
	public int pointSum(int mseq) {
		return ppdao.pointSum(mseq);
	}

	@Override
	public PayVO payCom(int mseq) {
		return ppdao.payCom(mseq);
	}

	@Override
	public HashMap<String, Object> pointLookPage(int mseq, String sdate, String edate, int sseq, int eseq) {
//		MemberVO mvo = new MemberVO();
//        mvo.getMseq();
        ArrayList<PointVO> userPointList = ppdao.userPointList(mseq, sseq, eseq);
		int pointSum = ppdao.pointSum(mseq);
		ArrayList<PointVO> userSearchPointList = ppdao.userSearchPointList(mseq, sdate, edate, sseq, eseq);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userPointList", userPointList);
		map.put("pointSum", pointSum);
		map.put("userSearchPointList", userSearchPointList);
		
		return map;
	}

	@Override
	public ArrayList<PointVO> userPointList(int mseq, int sseq, int eseq) {
		return ppdao.userPointList(mseq, sseq, eseq);
	}

	@Override
	public ArrayList<PointVO> userSearchPointList(int mseq, String sdate, String edate, int sseq, int eseq) {
		return ppdao.userSearchPointList(mseq, sdate, edate, sseq, eseq);
	}

	@Override
	public int userPointCount(int mseq) {
		return ppdao.userPointCount(mseq);
	}

	@Override
	public int userSearhPointCount(int mseq, String sdate, String edate) {
		return ppdao.userSearhPointCount(mseq, sdate, edate);
	}

	@Override
	public HashMap<String, Object> payLookPage(int mseq, String sdate, String edate, int sseq, int eseq) {
		
		MemberVO mvo = new MemberVO();
        mvo.setMseq(mseq);
        ArrayList<PayVO> userPayList = ppdao.userPayList(mseq, sseq, eseq);
		int pointSum = ppdao.pointSum(mseq);
		ArrayList<PayVO> userSearchPayList = ppdao.userSearchPayList(mseq, sdate, edate, sseq, eseq);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userPayList", userPayList);
		map.put("pointSum", pointSum);
		map.put("userSearchPayList", userSearchPayList);
		
		return map;
	}

	@Override
	public ArrayList<PayVO> userPayList(int mseq, int sseq, int eseq) {
		return ppdao.userPayList(mseq, sseq, eseq);
	}

	@Override
	public ArrayList<PayVO> userSearchPayList(int mseq, String sdate, String edate, int sseq, int eseq) {
		return ppdao.userSearchPayList(mseq, sdate, edate, sseq, eseq);
	}

	@Override
	public int userPayCount(int mseq) {
		return ppdao.userPayCount(mseq);
	}

	@Override
	public int userSearhPayCount(int mseq, String sdate, String edate) {
		return ppdao.userSearhPayCount(mseq, sdate, edate);
	}

	@Override
	public int insertPayPoint(int mseq, int pamoney) {
		return ppdao.insertPayPoint(mseq, pamoney);
	}

	@Override
	public int insertPay(PayVO pavo) {
		return ppdao.insertPay(pavo);
	}

	@Override
	public PayVO insetPage(PayVO pavo) {
		PayVO payCom = new PayVO();
		
		System.out.println("mseq**************" + pavo.getMseq());
		System.out.println("pamoney**************" + pavo.getPamoney());
		
		int insertPay = ppdao.insertPay(pavo);
		if(insertPay >= 1) {
			int insertPayPoint = ppdao.insertPayPoint(pavo.getMseq(), pavo.getPamoney());
			if(insertPayPoint >= 1) {
				int insertPointPayTable = ppdao.insertPointPayTable();
				if(insertPointPayTable >=1) {
					payCom = ppdao.payCom(pavo.getMseq());
				}
			}
		}
		return payCom;
	}

	@Override
	public int insertPointPayTable() {
		return ppdao.insertPointPayTable();
	}

	@Override
	public int insertJoinPoint() {
		return ppdao.insertJoinPoint();
	}

	@Override
	public int insertMember() {
		return ppdao.insertMember();
	}

	@Override
	public int gDeletePoint(int mseq) {
		return ppdao.gDeletePoint(mseq);
	}

	@Override
	public int poViewPoint(int mseq) {
		return ppdao.poViewPoint(mseq);
	}

	@Override
	public int gUploadPoint(int mseq) {
		return ppdao.gUploadPoint(mseq);
	}

	@Override
	public ArrayList<PayVO> indexPayList() {
		return ppdao.indexPayList();
	}

	@Override
	public HashMap<String, Object> adminMainPage() {
		int sseq = 1;
		int eseq = 5;
		
		ArrayList<PointVO> adminPointList = ppdao.adminPointList(sseq, eseq);
		ArrayList<PayVO> adminPayList = ppdao.adminPayList(sseq, eseq);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adminPointList", adminPointList);
		map.put("adminPayList", adminPayList);
		
		return map;
	}

	@Override
	public int payCnt() {
		return ppdao.payCnt();
	}

	@Override
	public int insertSeekPoint(int mseq, int sseq) {
		return ppdao.insertSeekPoint(mseq, sseq);
	}

	@Override
	public int searchSpoint(int mseq, int sseq) {
		return ppdao.searchSpoint(mseq, sseq);
	}

	
	@Override
	public int payTodayCount() {
		return ppdao.payTodayCount();
	}

}
