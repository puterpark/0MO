//package com.kosmo.omo;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.http.HttpRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.kosmo.common.PagingUtil;
//import com.kosmo.vo.DutyVO;
//import com.kosmo.vo.FieldVO;
//import com.kosmo.vo.GongmoVO;
//import com.kosmo.vo.MemberVO;
//import com.kosmo.vo.OfferAllVO;
//import com.kosmo.vo.PofolVO;
//import com.kosmo.vo.SeekAllVO;
//
///**
// * Handles requests for the application home page.
// */
//@Controller
//public class SeongHyunController_backup {
//	private static final Logger logger = LoggerFactory.getLogger(SeongHyunController_backup.class);
//	
//	@Autowired
//	private SeekAllService ssvc;
//	
//	@Autowired
//	private DutyService dsvc;
//	
//	@Autowired
//	private OfferAllService osvc;
//	
//	@Autowired
//	private PayService paysvc;
//	
//	
//	@RequestMapping(value = "/mypofol_list.do", method = RequestMethod.GET)
//	public ModelAndView mypofollist(PofolVO vo,
//									HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//		System.out.println("[LOG] mypofol_list.do ");
//		/*ArrayList<SeekAllVO> seekallList = ssvc.seekAllList();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		
//		mav.addObject("dutyList", dutyList);
//		
//		mav.addObject("seekallList", seekallList);
//		mav.setViewName("gujik_body_list");*/
//		int mseq = (Integer) session.getAttribute("SESS_MSEQ");
//		vo.setMseq(mseq);
//		ArrayList<PofolVO> mypofollist = ssvc.mypofollist(vo);
//		
//		mav.addObject("pofollist", mypofollist);
//		mav.setViewName("my_pofol_body_list");
//		return mav;
//	}
//	
//	
//	@RequestMapping(value = "/mypofol_insert_view.do")
//	public String pofolInsertView() {
//		
//		return "index_body_pofol_insert";
//	}
//	
//	@RequestMapping(value = "/mypofol_insert.do")
//	public String pofolInsert(PofolVO vo, HttpServletRequest req, HttpServletResponse rep) {
//
//		System.out.println("�꽦�쁽�떆諛�");
//
//		//�뙆�씪�씠 ���옣�맆 path �꽕�젙 
//		String path = "C:\\Users\\Puter\\Desktop\\dddd\\lastOMO\\OMO\\src\\main\\webapp\\uploads\\pdf"; 
//		Map returnObject = new HashMap(); 
//		try {
//
//			// MultipartHttpServletRequest �깮�꽦 
//			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req; 
//			Iterator iter = mhsr.getFileNames(); 
//
//			MultipartFile mfile = null; 
//			String fieldName = ""; 
//			List resultList = new ArrayList();
//			String want = "";
//			String wantext = "";
//
//			// �뵒�젅�넗由ш� �뾾�떎硫� �깮�꽦 
//			File dir = new File(path); 
//			if (!dir.isDirectory()) { dir.mkdirs(); } 
//
//
//			// 媛믪씠 �굹�삱�븣源뚯� 
//			while (iter.hasNext()) { 
//				fieldName = (String) iter.next(); // �궡�슜�쓣 媛��졇���꽌 
//				mfile = mhsr.getFile(fieldName); 
//				String origName; 
//
//				origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //�븳湲�爰좎쭚 諛⑹� 
//				// �뙆�씪紐낆씠 �뾾�떎硫�
//				if ("".equals(origName)) { 
//					continue; 
//				}
//				// �뙆�씪 紐� 蹂�寃�(uuid濡� �븫�샇�솕) 
//				String ext = origName.substring(origName.lastIndexOf('.')); // �솗�옣�옄 
//				String saveFileName = getUuid() + ext; 
//				// �꽕�젙�븳 path�뿉 �뙆�씪���옣
//				File serverFile = new File(path + File.separator + saveFileName); 
//				mfile.transferTo(serverFile); 
//
//				Map file = new HashMap(); 
//				file.put("origName", origName); 
//				file.put("sfile", serverFile); 
//				resultList.add(file); 
//				want = saveFileName;
//				wantext = ext;
//
//			} 
//
//			returnObject.put("files", resultList);
//			returnObject.put("params", mhsr.getParameterMap()); 
//
//			
//			System.out.println(want);
//		
//			vo.setPffile(want);
//			int res = ssvc.pofolInsert(vo);
//			System.out.println("[LOG] " + res + "嫄� �엯�젰 �셿猷�");
//
//			
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block e.printStackTrace(); 
//		}catch (IllegalStateException e) {
//			// TODO Auto-generated catch block e.printStackTrace(); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block 
//			e.printStackTrace(); 
//		} 
//		
//		return "redirect:/index.do";
//	}
//	
//	
////////////////////////////////////////////구직//////////////////////////////////////////////
//	
//	
//	@RequestMapping(value = "/gujik.do", method = RequestMethod.GET)
//	public ModelAndView gujik_list(HttpServletRequest request) {
//		
//	int currentPage = 1;
//		
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		
//		int totalCount = ssvc.seekCount();
//		
//		PagingUtil pu = new PagingUtil("/gujik.do?"
//										, currentPage
//										, totalCount  //------------
//										, 10	//보여줄갯수
//										, 5 // 1 2 [페이지갯수]
//										);
//		String html = pu.getPagingHtml();
//		
//		
//
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		ArrayList<SeekAllVO> seekAllList = ssvc.seekAllList(pu.getStartSeq(), pu.getEndSeq());
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.addObject("seekAllList", seekAllList);
//		mav.addObject("dutyList", dutyList);
//		mav.addObject("gujikpaging", html);
//
//		mav.setViewName("gujik_body_list");
//		return mav;
//	}
//	
//	
//	
//	@RequestMapping(value = "/gujik_duty.do", method = RequestMethod.GET)
//	public ModelAndView gongmoListField(HttpServletRequest request, HttpServletResponse response) {
//		String dseq = request.getParameter("dseq");
//		
//		int currentPage = 1;
//		
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		
//		int totalCount = ssvc.seekDutyCount(Integer.parseInt(dseq));
//		
//		PagingUtil pu = new PagingUtil("/gujik_duty.do?dseq="+dseq
//										, currentPage
//										, totalCount  //------------
//										, 10	//보여줄갯수
//										, 5 // 1 2 [페이지갯수]
//										);
//		String html = pu.getPagingHtml();
//		
//		ArrayList<SeekAllVO> list = ssvc.seekAllListDuty(Integer.parseInt(dseq), pu.getStartSeq(), pu.getEndSeq());
//		
//		for(int i = 0; i < list.size(); i++) {
//			ArrayList<DutyVO> tempList = ssvc.seekDuty(list.get(i).getDseq());
//			list.get(i).setDlist(tempList);
//		}
//		
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		
//		mav.addObject("dutyList", dutyList);
//		
//		mav.addObject("dseq", dseq);
//		mav.addObject("seekallList", list);
//		//mav.addObject("gflist", gflist);
//		mav.addObject("gujikpaging", html);
//
//		mav.setViewName("gujik_body_list");
//		return mav;
//	}
//	
//	
//
//	@RequestMapping(value = "/gujik_detail.do", method = RequestMethod.GET)
//	public ModelAndView gujik_detail(HttpServletRequest request, SeekAllVO vo, HttpSession session) {
//		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
//		int gubun = 0;
//		int pay = paysvc.searchSpoint(mseq, vo.getSseq());
//		ModelAndView mav = new ModelAndView();
//		String paykey = request.getParameter("paykey");
//
//		/*if(pay=="" || pay==null || pay==" " || )*/ 
//		if(pay == 0 ){
//			// 寃곗젣 �븞�븳 �궗�엺
//			SeekAllVO seekDetail  = ssvc.seekDetail(vo);
//			ArrayList<SeekAllVO> seekDetailDuty = ssvc.seekDetailDuty(vo);
//			SeekAllVO seekRcnt = ssvc.seekRcnt(vo);
//			ArrayList<SeekAllVO> seekReply = ssvc.seekReply(vo);
//			gubun=5;
//			System.out.println("paykey ************"+paykey);
//
//			if(paykey == null) {
//				System.out.println("�떎�꼸");
//				mav.addObject("seekDetail", seekDetail); // api
//				mav.addObject("seekDetailDuty", seekDetailDuty);
//				mav.addObject("seekReply", seekReply);
//				mav.addObject("seekRcnt", seekRcnt);
//				mav.addObject("gubun", gubun);
//				mav.addObject("mseq", mseq);
//				mav.setViewName("gujik_body_detail");
//			} else {
//				System.out.println("�럹�씠�궎媛��졇�삩�궗�엺");
//				mav.addObject("seekDetail", seekDetail); // api
//				mav.addObject("seekDetailDuty", seekDetailDuty);
//				mav.addObject("seekReply", seekReply);
//				mav.addObject("seekRcnt", seekRcnt);
//				mav.addObject("gubun", gubun);
//				mav.addObject("mseq", mseq);
//				paysvc.poViewPoint(mseq);
//				int res = paysvc.insertSeekPoint(mseq, vo.getSseq());
//				if(res >= 1) {
//					mav.addObject("gubun", 1);
//				}
//				mav.setViewName("gujik_body_detail");
//			}
//		} else {
//			// 寃곗젣 �븳 �궗�엺
//			SeekAllVO seekDetail  = ssvc.seekDetail(vo);
//			ArrayList<SeekAllVO> seekDetailDuty = ssvc.seekDetailDuty(vo);
//			SeekAllVO seekRcnt = ssvc.seekRcnt(vo);
//			ArrayList<SeekAllVO> seekReply = ssvc.seekReply(vo);
//			gubun=1;
//
//			mav.addObject("seekDetail", seekDetail); // api
//			mav.addObject("seekDetailDuty", seekDetailDuty);
//			mav.addObject("seekReply", seekReply);
//			mav.addObject("seekRcnt", seekRcnt);
//			mav.addObject("mseq", mseq);
//			mav.addObject("gubun", gubun);
//			mav.setViewName("gujik_body_detail");
//		}
//		
//		return mav;
//	}
//	
//	@RequestMapping(value = "/gujik_search.do", method = RequestMethod.GET)
//	public ModelAndView gujikListSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
//		
//		int currentPage = 1;
//		
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		
//		int totalCount = ssvc.seekSearchCount(searchStr);
//		
//		PagingUtil pu = new PagingUtil("/gujik_search.do?searchStr="+searchStr
//										, currentPage
//										, totalCount  //------------
//										, 10	//�꽑�깮�븳 2踰� 釉붾윮�뿉 �굹���궇 寃뚯떆臾� 媛��닔
//										, 5 // 1 2 [�떎�쓬]
//										);
//		String html = pu.getPagingHtml();
//		
//		ArrayList<SeekAllVO> seekAllList = ssvc.seekListSearch(pu.getStartSeq(), pu.getEndSeq(), searchStr);
//		
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		
//		mav.addObject("dutyList", dutyList);
//		
//		mav.addObject("searchStr", searchStr);
//		mav.addObject("seekAllList", seekAllList);
//		mav.addObject("gujikpaging", html);
//
//		
//		
//		mav.setViewName("gujik_body_main_search_list");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/gujik_reply_insert.do")
//	public String gujik_reply_insert(SeekAllVO vo) {
//		
//		
//		ModelAndView mav = new ModelAndView();
//		ssvc.seekReplyinsert(vo);
//		
//
//		return "redirect:/gujik_detail.do?sseq="+vo.getSseq();
//	}
//	
//	@RequestMapping(value = "/gujik_reply_update.do")
//	public String gujik_reply_update(SeekAllVO vo) {
//		
//		ModelAndView mav = new ModelAndView();
//		ssvc.seekReplyupdate(vo);
//		
//		
//		return "redirect:/gujik_detail.do?sseq="+vo.getSseq();
//	}
//	
//	@RequestMapping(value = "/gujik_reply_delete.do")
//	public String gujik_reply_delete(SeekAllVO vo) {
//		
//		ModelAndView mav = new ModelAndView();
//		ssvc.seekReplydelete(vo.getRseq());
//		
//		return "redirect:/gujik_detail.do?sseq="+vo.getSseq();
//	}
//	
//
//	@RequestMapping(value = "/gujik_insert.do", method = RequestMethod.GET)
//	public ModelAndView gujik_insert(HttpSession session, PofolVO vo) {
//		ModelAndView mav = new ModelAndView();
//		int mseq = (Integer) session.getAttribute("SESS_MSEQ");	
//		vo.setMseq(mseq);
//
//		ArrayList<PofolVO> mypofollist = ssvc.mypofollist(vo);
//		mav.addObject("pofollist", mypofollist);
//		mav.setViewName("index_body_gujik_insert");
//		
//		return mav;
//	}
//		
//		@RequestMapping(value = "/gujik_insert2.do")
//	public String gujik_insert_submit(HttpServletRequest request, HttpSession session) {
//			int mseq = (Integer) session.getAttribute("SESS_MSEQ");	
//			String stitle = request.getParameter("stitle"); String sbody = request.getParameter("sbody"); int pfseq = Integer.parseInt(request.getParameter("pfseq"));
//			SeekAllVO vo = new SeekAllVO(); vo.setStitle(stitle); vo.setSbody(sbody); vo.setPfseq(pfseq); vo.setMseq(mseq);
//			ssvc.gujikInsert(vo);
//			return "redirect:/gujik.do";
//	}
//		
//	
//	@RequestMapping(value = "/gujik_update.do", method = RequestMethod.POST)
//	public String gujik_update() {
//		return "gujik_body_update";
//	}
//
//	@RequestMapping(value = "/gujik_delete.do", method = RequestMethod.POST)
//	public String seekDelete(@RequestParam("sseq") int sseq) {
//		System.out.println(sseq);
//		int res = ssvc.seekDelete(sseq);
//		
//		System.out.println("[LOG] " + res + "嫄� �궘�젣 �셿猷�");
//		return "redirect:/gujik.do";
//	}
//	
//
//	
//
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value = "/gujik_report_detail.do", method = RequestMethod.GET)
//	public String gujik_report_detail() {
//		return "gujik_body_report_detail";
//	}
//	
//	@RequestMapping(value = "/admin_gujik_crawl.do", method = RequestMethod.GET)
//	public String admin_gujik_crawl() {
//		return "admin_body_gujik_crawl";
//	}
//	
//	@RequestMapping(value = "/guin_side_bar.do", method = RequestMethod.GET)
//	public ModelAndView guinSideBar(HttpServletRequest request, HttpServletResponse response) {
//		
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = dsvc.DutyList();
//		
//
//		mav.addObject("dutyList", dutyList);
//		mav.setViewName("tiles/tiles_guin_side_bar");
//		
//		return mav;
//	}
//	
//	@RequestMapping(value = "/gujik_side_bar.do", method = RequestMethod.GET)
//	public ModelAndView gujikSideBar(HttpServletRequest request, HttpServletResponse response) {
//		
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		
//
//		mav.addObject("dutyList", dutyList);
//		mav.setViewName("tiles/tiles_gujik_side_bar");
//		
//		return mav;
//	}
//	
//////////////////////////////////////援ъ씤///////////////////////////////////////////
//	
//	
//	@RequestMapping(value = "/guin.do", method = RequestMethod.GET)
//	public ModelAndView guin_list(HttpServletRequest request) {
//		int currentPage = 1;
//
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//
//		System.out.println("[LOG] : Enter Controller , /guin.do " );
//		int totalCount = osvc.memberOfferCount();
//		System.out.println("[LOG] : Total Count " + totalCount);
//
//		PagingUtil pu = new PagingUtil("/guin.do?"
//				, currentPage
//				, totalCount  //------------
//				, 10	//�꽑�깮�븳 2踰� 釉붾윮�뿉 �굹���궇 寃뚯떆臾� 媛��닔
//				, 5 // 1 2 [�떎�쓬]
//				);
//
//		String html = pu.getPagingHtml();
//		System.out.println(pu.getStartSeq()); //1
//		System.out.println(pu.getEndSeq()); //1
//
//		ArrayList<OfferAllVO> offerList = osvc.memberOfferLists(pu.getStartSeq(), pu.getEndSeq());
//
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("list", offerList);		
//		mav.addObject("guinpaging", html);
//
//		mav.setViewName("guin_body_list");		
//		return mav;
//	}
//	
//@RequestMapping(value = "/guin_search.do", method = RequestMethod.GET)
//	public ModelAndView guinListSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
//		int currentPage = 1;
//		
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		
//		int totalCount = osvc.offerSearchCount(searchStr);
//		
//		PagingUtil pu = new PagingUtil("/guin_search.do?searchStr="+searchStr
//										, currentPage
//										, totalCount  //------------
//										, 10	//�꽑�깮�븳 2踰� 釉붾윮�뿉 �굹���궇 寃뚯떆臾� 媛��닔
//										, 5 // 1 2 [�떎�쓬]
//										);
//		String html = pu.getPagingHtml();
//		
//		ArrayList<OfferAllVO> offerAllList = osvc.offerListSearch(pu.getStartSeq(), pu.getEndSeq(), searchStr);
//		
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		
//		mav.addObject("dutyList", dutyList);
//		
//		mav.addObject("searchStr", searchStr);
//		mav.addObject("list", offerAllList);
//		mav.addObject("guinpaging", html);
//		System.out.println(currentPage);
//		System.out.println(totalCount);
//		System.out.println(searchStr+"而⑦듃濡ㅻ윭遺�遺�------------------------");
//		
//		for(int i=0; i <offerAllList.size(); i++){
//			System.out.println(offerAllList.get(i));
//		}
//		mav.setViewName("guin_body_main_search_list");
//		return mav;
//	}
//
//	public static String getUuid() {
//		return UUID.randomUUID().toString().replaceAll("-", ""); 
//	}
//
//	@RequestMapping(value = "/guin_detail.do", method = RequestMethod.GET)
//	public ModelAndView guin_detail(@RequestParam("oseq") int oseq) {
//		ModelAndView mav = new ModelAndView();
//		OfferAllVO ovo = osvc.memberOfferDetail(oseq);
//		ArrayList<OfferAllVO> glist = ovo.getGlist();
//		
//		mav.addObject("glist",glist);
//		mav.addObject("ovo", ovo);
//		System.out.println(ovo.getGtitle());
//		System.out.println(glist.get(0).getGtitle());
//
//		
//		mav.setViewName("guin_body_detail");
//		return mav;
//	}
//		
//
//	@RequestMapping(value = "/guin_edit.do", method = RequestMethod.GET)
//	public ModelAndView offer_edit(HttpServletRequest request, @RequestParam("oseq")int oseq) {
//		OfferAllVO ovo = osvc.memberOfferDetail(oseq);
//
//		System.out.println(oseq+4);
//
//		System.out.println("[LOG] : Enter �꽦�쁽Cotroller / offer_edit() " +oseq);
//		ArrayList<OfferAllVO> glist = osvc.memberGongList();
//		ArrayList<OfferAllVO> dlist =osvc.memberDutyList(oseq);
//		ModelAndView mav = new ModelAndView();
//
//		mav.addObject("glist",glist);
//		mav.addObject("ovo",ovo);
//		mav.addObject("dlist",dlist);
//
//		for(int i =0; i < dlist.size(); i++){
//			System.out.println("[CHECK] : dseq "+dlist.get(i).getDseq()+"\t dname "+dlist.get(i).getOseq() );
//			if(ovo.getGseq()==glist.get(i).getGseq()){
//				System.out.println(ovo.getGtitle());
//			}
////			System.out.println();
//		}
//
//		mav.setViewName("guin_body_edit");
//		return mav;
//	}
//
//
//	//援ъ씤 �옉�꽦 �럹�씠吏� 媛��뒗 怨�
//	@RequestMapping(value = "/guin_insert.do", method = RequestMethod.GET)
//	public ModelAndView guin_insert(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView();
//		ArrayList<DutyVO> dutyList = ssvc.dutyList();
//		ArrayList<OfferAllVO> glist = osvc.memberGongList();
//		
//		mav.addObject("glist", glist);
//		mav.addObject("dlist",dutyList);
//		mav.setViewName("guin_body_insert");
//		return mav;
//	}
//	
//		//援ъ씤 �옉�꽦 �럹�씠吏��뿉�꽌 �뵒鍮꾨줈 �뿰寃고빐二쇰뒗 遺�遺�
//		@RequestMapping(value = "/guin_write.do", method = RequestMethod.POST)
//		public String guin_write(OfferAllVO ovo, HttpSession session) {
//			
//			System.out.println("[LOG] Enter board_offer Insert to DB");
//			System.out.println(ovo.getGseq());
//			int mseq = Integer.parseInt(session.getAttribute("SESS_MSEQ").toString());
//			ovo.setMseq(mseq);
//			osvc.memberOfferInsert(ovo);
//			
//			String[] unit = ovo.getCheckbox().split(",");
//			
//			for(int i=0; i < unit.length; i++){
//				ovo.setFarr(Integer.parseInt(unit[i]));
//				osvc.memberDutyOfferInsert(Integer.parseInt(unit[i]));
//			}
//			return "redirect:/guin.do";
//		}
//	
//		
//		@RequestMapping(value = "/guin_update.do", method = RequestMethod.POST)
//		public String guin_update(OfferAllVO ovo, @RequestParam("oseq")int oseq) {
//
//			osvc.memberOfferDutyDelete(oseq); //遺꾩빞�궘�젣
//			int res = 0;
//			int resOfferDuty = 0;
//			res = osvc.memberOfferUpdate(ovo);
//
//			String[] unit = ovo.getCheckbox().split(",");
//
//			for(int i=0; i<unit.length; i++) {
//				ovo.setFarr(Integer.parseInt(unit[i]));
//				System.out.println(Integer.parseInt(unit[i])+" : dd");
//				System.out.println(oseq+" �븘已�...吏꾩쭨 ");
//				resOfferDuty += osvc.memberOfferDutyUpdate(Integer.parseInt(unit[i]), oseq);
//			}
//
//			return "redirect:/guin_detail.do?oseq="+oseq;
//		}
//	
//		
//		@RequestMapping(value = "/delete_offer.do", method = RequestMethod.POST)
//		public String guin_delete(@RequestParam("oseq")int oseq) {
//			osvc.memberofferDelete(oseq);
//			return "redirect:/guin.do";
//		}
//	
//
//	
//	
//
//	
//	}
//
//
//
