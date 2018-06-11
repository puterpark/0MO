package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.*;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PofolVO;
import com.kosmo.vo.SeekAllVO;

@Service
public class SeekAllServiceImpl implements SeekAllService{
	
	@Autowired
	private SeekAllMapper SeekAllMapper;
	
	
	@Override
	public ArrayList<SeekAllVO> seekIndexList(){
		return SeekAllMapper.seekIndexList();
	}
	
	@Override
	public int seekReport(BreportVO brvo){
		return SeekAllMapper.seekReport(brvo);
	}
	
	@Override
	public ArrayList<SeekAllVO> seekAllList(int startseq, int endseq) {
		ArrayList<SeekAllVO> list = SeekAllMapper.seekAllList(startseq, endseq);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<DutyVO> tempList = SeekAllMapper.seekDuty(list.get(i).getSseq());
			list.get(i).setDlist(tempList);
		}
		
		return list;
	}
	
	@Override
	public int seekCount() {
		return SeekAllMapper.seekCount();
	}
	
	@Override
	public int seekDutyCount(int dseq) {
		return SeekAllMapper.seekDutyCount(dseq);
	}
	
	@Override
	public ArrayList<SeekAllVO> seekAllListDuty(int dseq, int startseq, int endseq) {
		ArrayList<SeekAllVO> seekAllListDuty = SeekAllMapper.seekAllListDuty(dseq, startseq, endseq);
		
		for(int i = 0; i < seekAllListDuty.size(); i++) {
			ArrayList<DutyVO> tempList = SeekAllMapper.seekDuty(seekAllListDuty.get(i).getSseq());
			seekAllListDuty.get(i).setDlist(tempList);
		}
		
		return seekAllListDuty;
	}

	@Override
	public ArrayList<DutyVO> seekDuty(int sseq) {
		// TODO Auto-generated method stub
		return SeekAllMapper.seekDuty(sseq);
	}

	
	@Override
	public SeekAllVO seekDetail(SeekAllVO vo){
		SeekAllVO svo = new SeekAllVO();
		
		svo = SeekAllMapper.seekDetail(vo);
		ArrayList<DutyVO> tempList = SeekAllMapper.seekDuty(vo.getSseq());
		svo.setDlist(tempList);
		System.out.println(" --- ---- " + svo.getMsgg1());
		System.out.println("--- ---- "+svo.getMseq());
		SeekAllMapper.seekViewUp(vo.getSseq());
		
		return svo;
	}

	@Override
public SeekAllVO mSeekDetail(int sseq) {
	SeekAllVO svo = SeekAllMapper.mSeekDetail(sseq);
	
	return svo;
}
	
	@Override
	public int seekViewUp(int sseq){
		return SeekAllMapper.seekViewUp(sseq);
	}
	

	
	@Override
	public ArrayList<SeekAllVO> seekDetailDuty(SeekAllVO vo){
		return SeekAllMapper.seekDetailDuty(vo);
	}
	
	@Override
	public ArrayList<SeekAllVO> seekReply(SeekAllVO vo){
		return SeekAllMapper.seekReply(vo);
	}
	
	@Override
	public ArrayList<PofolVO> mypofollist(PofolVO vo){
		return SeekAllMapper.mypofollist(vo);
	}
	
	@Override
	public int seekReplyinsert(SeekAllVO vo){
		return SeekAllMapper.seekReplyinsert(vo);
	}
	
	@Override
	public int pofolInsert(PofolVO vo){
		return SeekAllMapper.pofolInsert(vo);
	}
	
	@Override
	public int seekReplyupdate(SeekAllVO vo){
		return SeekAllMapper.seekReplyupdate(vo);
	}
	
	@Override
	public int seekReplydelete(int rseq){
		return SeekAllMapper.seekReplydelete(rseq);
	}
	
	@Override
	public SeekAllVO seekRcnt(SeekAllVO vo){
		return SeekAllMapper.seekRcnt(vo);
	}
	
	@Override
	public int seekDelete(int sseq) {
		return SeekAllMapper.seekDelete(sseq);
	}
	

	
	@Override
	public ArrayList<DutyVO> dutyList(){
		return SeekAllMapper.dutyList();
	}

	@Override
	public int gujikInsert(SeekAllVO vo) {
		return SeekAllMapper.gujikInsert(vo);
	}


	
	
	
	@Override
	public int seekSearchCount(String searchStr) {
		return SeekAllMapper.seekSearchCount(searchStr);
	}
	
	@Override
	public ArrayList<SeekAllVO> seekListSearch(int startseq, int endseq, String searchStr) {
		ArrayList<SeekAllVO> list = SeekAllMapper.seekListSearch(startseq, endseq, searchStr);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<DutyVO> tempList = SeekAllMapper.seekDuty(list.get(i).getSseq());
			list.get(i).setDlist(tempList);
		}
		
		return list;
	}

	@Override
	public int userseekSearchCount(String searchStr) {
		return SeekAllMapper.userseekSearchCount(searchStr);
	}
	
	@Override
	public ArrayList<SeekAllVO> userseekListSearch(int startseq, int endseq, String searchStr) {
		return SeekAllMapper.userseekListSearch(startseq, endseq, searchStr);
	}


}
