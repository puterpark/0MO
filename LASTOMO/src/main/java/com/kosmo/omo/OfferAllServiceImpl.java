package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.OfferAllMapper;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

@Service
public class OfferAllServiceImpl implements OfferAllService{
	
	@Autowired
	private OfferAllMapper OfferAllMapper;
	
	@Override
	public int memberOfferCount() {
		System.out.println("[LOG : Enter AdminOfferService, adminOfferCount() ]");
		int i = OfferAllMapper.memberOfferCount();
		return i;
	}
	
	@Override
	public int offerDutyCount(int dseq) {
		return OfferAllMapper.offerDutyCount(dseq);
	}
	
	@Override
	public int offerReport(BreportVO brvo) {
		return OfferAllMapper.offerReport(brvo);
	}

	@Override
	public ArrayList<OfferAllVO> memberOfferLists(int startseq, int endseq) {
		System.out.println("[LOG : Enter AdminOfferService, adminOfferList() ");
		ArrayList<OfferAllVO> list  = OfferAllMapper.memberOfferLists(startseq, endseq);

		for(int i=0; i < list.size(); i++){
			ArrayList<DutyVO> tempList = OfferAllMapper.memberOfferDuty(list.get(i).getOseq());
			list.get(i).setDlist(tempList);
		}

		return list;
	}
		
	@Override
	public ArrayList<DutyVO> memberOfferDuty(int oseq) {
		return OfferAllMapper.memberOfferDuty(oseq);
	}
	
	@Override
	public ArrayList<OfferAllVO> offerAllListDuty(int dseq, int startseq, int endseq) {
		ArrayList<OfferAllVO> offerAllListDuty = OfferAllMapper.offerAllListDuty(dseq, startseq, endseq);
		
		for(int i = 0; i < offerAllListDuty.size(); i++) {
			ArrayList<DutyVO> tempList = OfferAllMapper.memberOfferDuty(offerAllListDuty.get(i).getOseq());
			offerAllListDuty.get(i).setDlist(tempList);
		}
		
		return offerAllListDuty;
	}

	@Override
	public OfferAllVO memberOfferDetail(int oseq) {
		System.out.println("[LOG] : Enter OfferAllService, memberOfferDetail() ");
		OfferAllVO ovo = OfferAllMapper.memberOfferDetail(oseq); //1
		System.out.println("service: "+ovo.getOtitle()+" "+ovo.getMname());
		ArrayList<DutyVO> tempList = OfferAllMapper.memberOfferDuty(oseq); //3
		ovo.setDlist(tempList);
		OfferAllMapper.offerViewUp(oseq);


		return ovo;
	}
	
	@Override
	public int offerViewUp(int oseq){
		return OfferAllMapper.offerViewUp(oseq);
	}
	

	@Override
	public int memberOfferDutyDelete(int oseq) {
		return OfferAllMapper.memberOfferDutyDelete(oseq);
	}

	@Override
	public int memberOfferUpdate(OfferAllVO ovo) {
		System.out.println("serviceimpl : "+ovo.getOtitle());
		int i = OfferAllMapper.memberOfferUpdate(ovo);
		System.out.println(i);
		return i;
	}

	@Override
	public int memberOfferDutyUpdate(int dseq, int oseq) {
		System.out.println("dseq   : " +dseq);
		System.out.println("oseq   : " +oseq);
		
		return OfferAllMapper.memberOfferDutyUpdate(dseq, oseq);
	}

	@Override
	public ArrayList<OfferAllVO> memberGongList() {
		return OfferAllMapper.memberGongList();
	}

	@Override
	public ArrayList<OfferAllVO> memberDutyList(int oseq) {
		return OfferAllMapper.memberDutyList(oseq);
	}

	@Override
	public int memberOfferInsert(OfferAllVO ovo) {
		return OfferAllMapper.memberOfferInsert(ovo);
	}

	@Override
	public int memberDutyOfferInsert(int dseq) {
		return OfferAllMapper.memberDutyOfferInsert(dseq);
	}

	@Override
	public int memberofferDelete(int oseq) {
		return OfferAllMapper.memberofferDelete(oseq);
	}

	@Override
	public ArrayList<OfferAllVO> offerNewList() {
		return OfferAllMapper.offerNewList();
	}


	@Override
	public int offerSearchCount(String searchStr) {
		return OfferAllMapper.offerSearchCount(searchStr);
	}
	
	@Override
	public ArrayList<OfferAllVO> offerListSearch(int startseq, int endseq, String searchStr) {
		OfferAllVO oavo = new OfferAllVO();
		oavo.setStartseq(startseq);
		oavo.setEndseq(endseq);
		oavo.setSearchStr(searchStr);
		System.out.println("이거 되는거임?");
		System.out.println(startseq);
		System.out.println(endseq);
		System.out.println(searchStr);
		ArrayList<OfferAllVO> list = OfferAllMapper.offerListSearch(oavo);
		for(int i = 0; i < list.size(); i++) {
			ArrayList<DutyVO> tempList = OfferAllMapper.memberOfferDuty(list.get(i).getOseq());
			list.get(i).setDlist(tempList);
		}
		return list;
	}





}
