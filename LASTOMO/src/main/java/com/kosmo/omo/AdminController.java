package com.kosmo.omo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.common.PagingUtil;
import com.kosmo.vo.AdminVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminSeekService service;
	@Autowired
	private AdminOfferService oservice;
	@Autowired
	private SeekAllService ssvc;
	@Autowired
	private MemberService memberService;




	/*********************************************************[Admin Seek Page]*************************************************************/


	@RequestMapping(value = "/admin_seek.do", method = RequestMethod.GET)
	public ModelAndView admin_gujik(HttpServletRequest request, HttpServletResponse response) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		System.out.println("[LOG] : Enter Controller , /admin_seek.do " );
		int totalCount = service.AdminSeekCount();


		PagingUtil pu = new PagingUtil("/admin_seek.do?"
				, currentPage
				, totalCount  //------------
				, 10	//선택한 2번 블럭에 나타날 게시물 갯수
				, 5 // 1 2 [다음]
				);

		String html = pu.getPagingHtml();
		ArrayList<SeekAllVO> list = service.adminSeekList(pu.getStartSeq(), pu.getEndSeq());

		ModelAndView mav = new ModelAndView();

		mav.addObject("list", list);
		mav.addObject("seekpaging", html);

		mav.setViewName("admin_body_seek_list");

		return mav;
	}




	@RequestMapping(value = "/admin_seek_detail.do", method = RequestMethod.GET)
	public ModelAndView admin_seek_detail(HttpServletRequest request, @RequestParam("sseq")int sseq) {
		ModelAndView mav = new ModelAndView();


		SeekAllVO svo = service.adminSeekDetail(sseq);
		ArrayList<SeekAllVO> seekDetailDuty = ssvc.seekDetailDuty(svo);
		mav.addObject("svo",svo);

		System.out.println("[LOG] CallBack Controller - AdminController / admin_seek_detail() ");

		mav.addObject("seekDetailDuty", seekDetailDuty);
		mav.setViewName("admin_body_seek_detail");
		return mav;
	}


	@RequestMapping(value = "/admin_seek_delete.do", method = RequestMethod.POST)
	public String seekDelete(@RequestParam("sseq") int sseq) {
		System.out.println(sseq);
		int res = ssvc.seekDelete(sseq);

		System.out.println("[LOG] " + res + "건 삭제 완료");
		return "redirect:/admin_seek.do";
	}


	@RequestMapping(value = "/admin_edit_seek.do", method = RequestMethod.GET)
	public ModelAndView admin_seek_edit(HttpServletRequest request, @RequestParam("sseq")int sseq) {
		SeekAllVO svo = service.adminSeekDetail(sseq);
		System.out.println("[LOG] : Enter AdminCotroller / admin_seek_edit() " +sseq);


		ModelAndView mav = new ModelAndView();
		mav.addObject("svo",svo);

		System.out.println("[LOG] CallBack Controller - AdminController / admin_seek_edit()");

		mav.setViewName("admin_body_seek_edit");
		return mav;
	}


	@RequestMapping(value = "/admin_seek_update.do", method = RequestMethod.POST)
	public String admin_seek_update(SeekAllVO svo, @RequestParam("sseq")int sseq) {
		System.out.println("[LOG] : Enter AdminCotroller / admin_seek_update() " +sseq);
		int res = 0;
		res = service.adminSeekUpdate(svo);
		System.out.println("[LOG] : adminSeekUpdate Result : "+res);


		if(res>0){
			System.out.println("[LOG] : 수정되었습니다 - ");
			return "redirect:/admin_seek_detail.do?sseq="+sseq;
		}
		else
			System.out.println("[LOG] : 실패하였습니다 -");
		return "";	

	}


	/***********************************************************[Admin Offer Page]***************************************************************/

	@RequestMapping(value = "/admin_offer.do", method = RequestMethod.GET)
	public ModelAndView admin_offer(HttpServletRequest request, HttpServletResponse response) {

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		System.out.println("[LOG] : Enter Controller , /admin_offer.do " );
		int totalCount = oservice.AdminOfferCount();
		System.out.println("[LOG] : Total Count " + totalCount);

		PagingUtil pu = new PagingUtil("/admin_offer.do?"
				, currentPage
				, totalCount  //------------
				, 10	//선택한 2번 블럭에 나타날 게시물 갯수
				, 5 // 1 2 [다음]
				);

		String html = pu.getPagingHtml();

		ArrayList<OfferAllVO> offerList = oservice.adminOfferList(pu.getStartSeq(), pu.getEndSeq());

		ModelAndView mav = new ModelAndView();

		mav.addObject("list", offerList);		
		mav.addObject("paging", html);

		mav.setViewName("admin_body_offer_list");		
		return mav;
	}

	@RequestMapping(value = "/admin_offer_detail.do", method = RequestMethod.GET)
	public ModelAndView admin_offer_detail(@RequestParam("oseq") int oseq) {

		ModelAndView mav = new ModelAndView();
		OfferAllVO ovo = oservice.adminOfferDetail(oseq);

		System.out.println("[LOG] CallBack Controller - AdminController / admin_offer_detail() ");

		mav.addObject("ovo", ovo);

		mav.setViewName("admin_body_offer_detail");
		return mav;
	}


	@RequestMapping(value = "/admin_offer_update.do", method = RequestMethod.POST)
	public String admin_offer_Update(OfferAllVO ovo, @RequestParam("oseq") int oseq){

		int resDelField = oservice.AdminOfferDutyDelete(oseq); //분야삭제
		System.out.println("[LOG] :  분야 삭제 몇건?" +resDelField);
		int res = 0;
		int resOfferDuty = 0;
		res = oservice.OfferUpdate(ovo);

		String[] unit = ovo.getCheckbox().split(",");

		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i]);
			ovo.setFarr(Integer.parseInt(unit[i]));
			System.out.println("ovo.getfarr(): " + ovo.getFarr());
			resOfferDuty += oservice.OfferDutyUpdate(oseq, Integer.parseInt(unit[i]));
		}

		System.out.println("[LOG] Offer Duty "+ resOfferDuty + "건 수정");
		return "redirect:/admin_offer_detail.do?oseq="+oseq;
	}

	@RequestMapping(value = "/admin_edit_offer.do", method = RequestMethod.GET)
	public ModelAndView admin_offer_edit(HttpServletRequest request, @RequestParam("oseq")int oseq) {
		OfferAllVO ovo = oservice.adminOfferDetail(oseq);

		System.out.println(oseq+4);

		System.out.println("[LOG] : Enter AdminCotroller / admin_offer_edit() " +oseq);
		ArrayList<OfferAllVO> glist = oservice.GongList();
		ArrayList<OfferAllVO> dlist =oservice.DutyList(oseq);
		ModelAndView mav = new ModelAndView();

		mav.addObject("gvo",glist);
		mav.addObject("ovo",ovo);
		mav.addObject("dlist",dlist);

		for(int i =0; i < dlist.size(); i++){
			System.out.println("[CHECK] : dseq "+dlist.get(i).getDseq()+"\t dname "+dlist.get(i).getOseq());
		}

		mav.setViewName("admin_body_offer_edit");
		return mav;
	}

	/***********************************************************[Admin Offer/Seek Main Page]***************************************************************/

	@RequestMapping(value = "/admin_Seekoffer.do", method = RequestMethod.GET)
	public ModelAndView admin_Seekoffer(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		
		mav.setViewName("admin_body_seekoffer_main");
		return mav;
	}




	/*****************************************************[ Admin member ]*********************************************************************/
	/*@RequestMapping(value = "/admin.do", method = RequestMethod.POST)
	public ModelAndView admin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();


		if(session != null){
			mav.setViewName("admin_body_index");
			return mav;
		}else{
			mav.setViewName("admin_body_login");
			return mav;
		}
	}*/
	
	
	
	
/*		@RequestMapping(value = "/admin_alist.do", method = RequestMethod.POST)
		public ModelAndView admin_alist(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			ModelAndView mav = new ModelAndView();
			
			AdminVO avo = adminService.adminAList();
			mav.addObject("avo",avo);
			mav.setViewName(viewName);
			
			return mav;

		}*/

		@RequestMapping(value = "/admin_update.do", method = RequestMethod.GET)
		public String aupdate() {
			return "admin_body_admin_update";
		}

		@RequestMapping(value = "/admin_list.do", method = RequestMethod.GET)
		public String alist() {
			return "admin_body_admin_list";
		}

		@RequestMapping(value = "/admin_mlist.do", method = RequestMethod.GET)
		public String mlist() {
			return "admin_body_admin_mlist";
		}

		@RequestMapping(value = "/admin_leave.do", method = RequestMethod.GET)
		public String aleave() {
			return "admin_body_admin_leave";
		}



		@RequestMapping(value = "/admin_logout.do", method = RequestMethod.GET)
		public String logout(HttpSession session) {
			session.invalidate();

			return "redirect:/admin_index.do";
		}
		
		@RequestMapping(value = "/adminValidation.do", method = RequestMethod.POST)
		@ResponseBody
		public int adminValidation(@RequestBody AdminVO vo) {
			String aid= vo.getAid();

			int res = adminService.adminValidation(aid);
		
			return res;

		}
		
		
	}



