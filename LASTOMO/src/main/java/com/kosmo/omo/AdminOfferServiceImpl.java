package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.AdminOfferMapper;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.OfferAllVO;

@Service
public class AdminOfferServiceImpl implements AdminOfferService{

	@Autowired
	private AdminOfferMapper adminOffer;

	@Override
	public int AdminOfferCount() {
		System.out.println("[LOG : Enter AdminOfferService, adminOfferCount() ]");
		int i = adminOffer.AdminOfferCount();
		return i;
	}

	@Override
	public ArrayList<OfferAllVO> adminOfferList(int startseq, int endseq) {
		System.out.println("[LOG : Enter AdminOfferService, adminOfferList() ");
		ArrayList<OfferAllVO> list  = adminOffer.AdminOfferList(startseq, endseq);

		for(int i=0; i < list.size(); i++){
			ArrayList<DutyVO> tempList = adminOffer.offerDuty(list.get(i).getOseq());
			list.get(i).setDlist(tempList);
		}

		return list;
	}

	@Override
	public OfferAllVO adminOfferDetail(int oseq) {
		System.out.println("[LOG] : Enter AdminOfferService, adminOfferDetail() ");
		OfferAllVO ovo = adminOffer.adminOfferDetail(oseq); //1
		ArrayList<DutyVO> tempList = adminOffer.offerDuty(oseq); //3
		ovo.setDlist(tempList);

		return ovo;
	}

	@Override
	public int AdminOfferDutyDelete(int oseq) {
		return adminOffer.AdminOfferDutyDelete(oseq);
	}

	@Override
	public int OfferUpdate(OfferAllVO ovo) {
		return adminOffer.OfferUpdate(ovo);
	}

	@Override
	public int OfferDutyUpdate(int oseq, int dseq) {
		return adminOffer.OfferDutyUpdate(oseq, dseq);
	}

	@Override
	public ArrayList<OfferAllVO> GongList() {
		return adminOffer.GongList();
	}

	@Override
	public ArrayList<OfferAllVO> DutyList(int oseq) {
		return adminOffer.DutyList(oseq);
	}




}
