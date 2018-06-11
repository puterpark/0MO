package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.BreportVO;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

@Repository("offerdao")
public interface OfferAllMapper {
//	public ArrayList<OfferAllVO> offerAllList(int startseq, int endseq);
	
	public OfferAllVO memberOfferDetail(@Param("oseq")int oseq);
	
	public int offerViewUp(int oseq);

	public int offerReport(BreportVO brvo);

	
	public int memberOfferCount();
	
	public int offerDutyCount(int dseq);
	
	public ArrayList<OfferAllVO> memberOfferLists(@Param("startseq")int startseq, @Param("endseq")int endseq);
	
	public ArrayList<OfferAllVO> offerAllListDuty(@Param("dseq") int dseq, @Param("startseq") int startseq, 
			@Param("endseq") int endseq);
	
	public int memberOfferDutyDelete(int oseq);
	
	public int memberOfferDutyUpdate(@Param("dseq")int dseq, @Param("oseq")int oseq);
	
	public int memberOfferUpdate(OfferAllVO ovo);
	
	public ArrayList<OfferAllVO> memberGongList();
	
	public ArrayList<OfferAllVO> memberDutyList(int oseq);
		
	public ArrayList<DutyVO> memberOfferDuty(int oseq);
	
	//���� �Խ��� �۾��� 
	public int memberOfferInsert(OfferAllVO ovo);
	
	public int memberDutyOfferInsert(int dseq);
	
	public int memberofferDelete(int oseq);

	public ArrayList<OfferAllVO> offerNewList();
	
	
	public int offerSearchCount(String searchStr);
	
/*	public ArrayList<OfferAllVO> offerListSearch(@Param("startseq") int startseq, 
			@Param("endseq") int endseq, 
			@Param("searchStr") String searchStr);*/
	public ArrayList<OfferAllVO> offerListSearch(OfferAllVO oavo);
}
