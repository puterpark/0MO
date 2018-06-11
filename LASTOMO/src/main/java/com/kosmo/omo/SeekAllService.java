package com.kosmo.omo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.kosmo.vo.BreportVO;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PofolVO;
import com.kosmo.vo.SeekAllVO;

public interface SeekAllService {
	
	public ArrayList<SeekAllVO> seekIndexList();
	
	public int seekReport(BreportVO brvo);
	
	public ArrayList<SeekAllVO> seekAllList(int startseq, int endseq);
	
	public ArrayList<SeekAllVO> seekAllListDuty(int dseq, int startseq, int endseq);
	
	public ArrayList<DutyVO> seekDuty(int sseq);
	
	public SeekAllVO seekDetail(SeekAllVO vo);

	public SeekAllVO mSeekDetail(int sseq);
	
	public int seekCount();
	
	public int seekDutyCount(int dseq);
	
	public ArrayList<SeekAllVO> seekDetailDuty(SeekAllVO vo);
	
	public ArrayList<SeekAllVO> seekReply(SeekAllVO vo);
	
	public int seekReplyinsert(SeekAllVO vo);
	
	public ArrayList<PofolVO> mypofollist(PofolVO vo);
	
	public int pofolInsert(PofolVO vo);
	
	public int seekReplyupdate(SeekAllVO vo);
	
	public int seekReplydelete(int rseq);
	
	public SeekAllVO seekRcnt(SeekAllVO vo);
	
	public int seekDelete(int sseq);
	
	public int seekViewUp(int sseq);
	
	public ArrayList<DutyVO> dutyList();
	
	public int gujikInsert(SeekAllVO vo);
	
	public int seekSearchCount(String searchStr);
	
	public ArrayList<SeekAllVO> seekListSearch(int startseq, int endseq, String searchStr);
	
	public int userseekSearchCount(String searchStr);
	
	public ArrayList<SeekAllVO> userseekListSearch(int startseq, int endseq, String searchStr);
}
