package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PofolVO;
import com.kosmo.vo.SeekAllVO;

@Repository("seekdao")
public interface SeekAllMapper {
	public ArrayList<SeekAllVO> seekIndexList();
	public ArrayList<SeekAllVO> seekAllList(@Param("startseq") int startseq, 
			@Param("endseq") int endseq);
	public ArrayList<SeekAllVO> seekAllListDuty(@Param("dseq") int dseq, @Param("startseq") int startseq, 
			@Param("endseq") int endseq);
	public ArrayList<DutyVO> seekDuty(int sseq);
	public int seekCount();
	public int seekDutyCount(int dseq);
	public SeekAllVO seekDetail(SeekAllVO vo);
	public ArrayList<SeekAllVO> seekDetailDuty(SeekAllVO vo);
	public ArrayList<SeekAllVO> seekReply(SeekAllVO vo);
	public int seekReplyinsert(SeekAllVO vo);
	public ArrayList<PofolVO> mypofollist(PofolVO vo);
	public int pofolInsert(PofolVO vo);
	public int seekReplyupdate(SeekAllVO vo);
	public int seekReplydelete(int rseq);
	public SeekAllVO seekRcnt(SeekAllVO vo);
	public int seekViewUp(int sseq);
	public int seekDelete(int sseq);
	public ArrayList<DutyVO> dutyList();
	public int gujikInsert(SeekAllVO vo);
	
	public int seekSearchCount(String searchStr);
	public ArrayList<SeekAllVO> seekListSearch(@Param("startseq") int startseq, 
			@Param("endseq") int endseq, 
			@Param("searchStr") String searchStr);
	public int userseekSearchCount(String searchStr);
	public ArrayList<SeekAllVO> userseekListSearch(@Param("startseq") int startseq, 
			@Param("endseq") int endseq, 
			@Param("searchStr") String searchStr);
}
