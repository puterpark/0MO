package com.kosmo.omo;

import java.util.ArrayList;

import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

public interface OfferAllService {
	
	public OfferAllVO memberOfferDetail(int oseq);
	
	public int memberOfferCount();
	
	public ArrayList<OfferAllVO> memberOfferLists(int startseq, int endseq);
	
	public int memberOfferDutyDelete(int oseq);
	
	public int memberOfferDutyUpdate(int dseq, int oseq);
	
	public int memberOfferUpdate(OfferAllVO ovo);
	
	public ArrayList<OfferAllVO> memberGongList();
	
	public ArrayList<OfferAllVO> memberDutyList(int oseq);
	
	
	//���� �Խ��� �۾��� 
	public int memberOfferInsert(OfferAllVO ovo);
	
	public int memberDutyOfferInsert(int dseq);
	
	//����
	
	public int memberofferDelete(int oseq);
	
	//�ֽŸ���Ʈ ���
	public ArrayList<OfferAllVO> offerNewList();
	
	
	public int offerSearchCount(String searchStr);
	
	public ArrayList<OfferAllVO> offerListSearch(int startseq, int endseq, String searchStr);
	

}
