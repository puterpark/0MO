package com.kosmo.omo;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	@Autowired
	private GongmoService gsvc;
	@Autowired
	private SeekAllService ssvc;
	@Autowired
	private OfferAllService osvc;
	@Autowired
	private DutyService dsvc;
	@Autowired
	private PayService paysvc;
	
	@RequestMapping(value = "/header.do", method = RequestMethod.GET)
	public ModelAndView header(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ArrayList<DutyVO> dutyList = dsvc.DutyList();
		ArrayList<FieldVO> flist = gsvc.fieldList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("flist", flist);
		mav.addObject("dutyList", dutyList);
		mav.setViewName("tiles/default_header");
		if(session.getAttribute("SESS_MSEQ")!=null){
			int mseq = (Integer)session.getAttribute("SESS_MSEQ");
			int pointSum = paysvc.pointSum(mseq);


			mav.addObject("LVL_PAYSUM", pointSum);
		}
		return mav;
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = gsvc.indexPage();
		ArrayList<SeekAllVO> seekAllList = ssvc.seekIndexList();
		ArrayList<OfferAllVO> offerAllList = osvc.offerNewList();
		ArrayList<DutyVO> dutyList = ssvc.dutyList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dutyList", dutyList);
		mav.addObject("seekAllList", seekAllList);
		mav.addObject("glist", map.get("glist"));
		mav.addObject("list", map.get("list"));
		mav.addObject("offerAllList", offerAllList);
		mav.setViewName("index_body_main");
		return mav;
	}
	
}
