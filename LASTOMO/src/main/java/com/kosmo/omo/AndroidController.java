package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

@Controller
public class AndroidController {

	@Autowired
	private GongmoService gsvc;
	@Autowired
	private OfferAllService osvc;
	@Autowired
	private SeekAllService ssvc;
	
	@RequestMapping(value = "/mGongmoList.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<GongmoVO> mGongmoList(@RequestBody GongmoVO gvo) throws Exception {
		
		ArrayList<GongmoVO> list = gsvc.gongmoList(gvo.getSseq(), gvo.getEseq());
		
		return list;
	}
	
	@RequestMapping(value = "/mGongmoDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GongmoVO> mGongmoDetail(@RequestBody GongmoVO gvo) throws Exception {
		
		gvo = gsvc.gongmoDetail(gvo.getGseq());
		
		return new ResponseEntity<GongmoVO>(gvo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mGuinList.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<OfferAllVO> mGuinList(@RequestBody OfferAllVO ovo) throws Exception {
		
		ArrayList<OfferAllVO> list = osvc.memberOfferLists(ovo.getStartseq(), ovo.getEndseq());
		
		return list;
	}
	
	@RequestMapping(value = "/mGuinDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<OfferAllVO> mGuinDetail(@RequestBody OfferAllVO ovo) throws Exception {
		
		ovo = osvc.memberOfferDetail(ovo.getOseq());
		
		return new ResponseEntity<OfferAllVO>(ovo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mGuinInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public int mGuinInsert(@RequestBody OfferAllVO ovo) throws Exception {

		int res = 0;
		
		res = osvc.memberOfferInsert(ovo);
		
		return res;
	}
	
	@RequestMapping(value = "/mGuinDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public int mGuinDelete(@RequestBody OfferAllVO ovo) throws Exception {

		int res = 0;
		
		res = osvc.memberofferDelete(ovo.getOseq());
		
		return res;
	}
	
	@RequestMapping(value = "/mGuinUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public int mGuinUpdate(@RequestBody OfferAllVO ovo) throws Exception {

		int res = 0;
		
		res = osvc.memberOfferUpdate(ovo);
		
		return res;
	}
	
	@RequestMapping(value = "/mGujikList.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<SeekAllVO> mGujikList(@RequestBody SeekAllVO svo) throws Exception {

		ArrayList<SeekAllVO> list = ssvc.seekAllList(svo.getStartseq(), svo.getEndseq());
		
		return list;
	}
	
	@RequestMapping(value = "/mGujikDetail.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SeekAllVO> mGujikDetail(@RequestBody SeekAllVO svo) throws Exception {
		
		svo = ssvc.mSeekDetail(svo.getSseq());
		
		return new ResponseEntity<SeekAllVO>(svo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/mGujikInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public int mGujikInsert(@RequestBody SeekAllVO svo) throws Exception {

		int res = 0;
		
		res = ssvc.gujikInsert(svo);
		
		return res;
	}
	
	@RequestMapping(value = "/mGujikDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public int mGujikDelete(@RequestBody SeekAllVO svo) throws Exception {

		int res = 0;
		
		res = ssvc.seekDelete(svo.getSseq());
		
		return res;
	}
	
}
