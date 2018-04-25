package com.kosmo.omo;

import java.util.ArrayList;


import com.kosmo.vo.OfferAllVO;

public interface AdminOfferService {

	
	public int AdminOfferCount();
	
	public ArrayList<OfferAllVO> adminOfferList(int sseq, int eseq);
	
	public OfferAllVO adminOfferDetail(int oseq);
	
	public int AdminOfferDutyDelete(int oseq);
	
	public int OfferUpdate(OfferAllVO ovo);
	
	public int OfferDutyUpdate(int oseq, int dseq);
	
	public ArrayList<OfferAllVO> GongList();
	
	public ArrayList<OfferAllVO> DutyList(int oseq);
	
	
}
