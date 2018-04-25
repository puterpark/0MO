package com.kosmo.omo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kosmo.mapper.AdminSeekMapper;
import com.kosmo.vo.SeekAllVO;

@Service
public class AdminSeekServiceImpl implements AdminSeekService {

	@Autowired
	private AdminSeekMapper adminSeek;

	@Override
	public int AdminSeekCount() {
		
		int i = adminSeek.AdminSeekCount();
		System.out.println("[LOG : Enter AdminSeekService, adminSeekCount() ]"+i);
		return i;
	}

	@Override
	public ArrayList<SeekAllVO> adminSeekList(int startseq, int endseq) {
		ArrayList<SeekAllVO> list = adminSeek.AdminSeekList(startseq, endseq);
		return list;
	}

	@Override
	public SeekAllVO adminSeekDetail(int sseq) {
		System.out.println("[LOG] Enter AdminSeekSerciveImpl / adminSeekDetail() "+sseq);
		SeekAllVO svo= adminSeek.adminSeekDetail(sseq);
		System.out.println("[LOG] Mapper.java - Mapper.xml - return list : ");
		
		return svo;
	}
	

	@Override
	public int adminSeekUpdate(SeekAllVO svo) {
		System.out.println("[LOG] Enter AdminSeekServiceImpl / adminSeekUpdate()"+svo.getSseq());
		int i = adminSeek.adminSeekUpdate(svo);
		return i;
	}

	
	
	

}
