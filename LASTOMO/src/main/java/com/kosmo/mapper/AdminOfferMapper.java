package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.OfferAllVO;


@Repository("adminOffer")
public interface AdminOfferMapper {
	public int AdminOfferCount();

	public ArrayList<OfferAllVO> AdminOfferList(@Param("startseq")int startseq, @Param("endseq")int endseq);
	
	public OfferAllVO adminOfferDetail(@Param("oseq")int oseq);
	
	public ArrayList<DutyVO> offerDuty(@Param("oseq")int oseq);
	
	public int AdminOfferDutyDelete(@Param("oseq")int oseq);

	public int OfferUpdate(OfferAllVO ovo);
	
	public int OfferDutyUpdate(@Param("oseq")int oseq, @Param("dseq")int dseq);
	
	public ArrayList<DutyVO> DutyListCheck(int oseq);  
	
	public ArrayList<OfferAllVO> GongList();
	
	public ArrayList<OfferAllVO> DutyList(@Param("oseq")int oseq);
		
}
