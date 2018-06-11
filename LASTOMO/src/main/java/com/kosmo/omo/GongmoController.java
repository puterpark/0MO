package com.kosmo.omo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.common.GongmoCrawler;
import com.kosmo.common.PagingUtil;
import com.kosmo.vo.AdminVO;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.LikedVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.PayVO;
import com.kosmo.vo.RreportVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GongmoController {
	private static final Logger logger = LoggerFactory.getLogger(GongmoController.class);
	
	@Autowired
	private GongmoService service;
	@Autowired
	private PayService paysvc;
	
	
	@RequestMapping(value = "/rtest.do", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView rtest() throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("shift/index");
		return mav;
	}
	
	
//	@RequestMapping(value = "/ajaxlist.do", method = RequestMethod.POST)
//	@ResponseBody
//	public ArrayList<GongmoVO> ajaxGongmoList(@RequestBody GongmoVO gvo) throws Exception {
//		
//		System.out.println("수신된 데이터 : {\"sseq\":" + gvo.getSseq() + ", \"eseq\":" + gvo.getEseq() + "}");
//		
//		
//		
//		ArrayList<GongmoVO> list = service.gongmoList(gvo.getSseq(), gvo.getEseq());
//		
//		for(int i = 0; i < 10; i++) {
//			System.out.println(i+ "번째 Gtitle : " + list.get(i).getGtitle());
//			System.out.println(i+ "번째 Gspon : " + list.get(i).getGspon());
//		}
//		
//		
//		return list;
//	}
//	
//	@RequestMapping(value = "/ajaxdetail.do", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<GongmoVO> ajaxGongmoDetail(@RequestBody GongmoVO gvo) throws Exception {
//		
//		gvo = service.gongmoDetail(gvo.getGseq());
//		
//		return new ResponseEntity<GongmoVO>(gvo, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/ajaxinsert.do", method = RequestMethod.POST)
//	@ResponseBody
//	public int ajaxGongmoInsert(@RequestBody GongmoVO gvo) throws Exception {
//
//		int res = 0;
//		
//		res = service.adminGongmoInsert(gvo);
//		
//		return res;
//	}
//	
//	@RequestMapping(value = "/ajaxdelete.do", method = RequestMethod.POST)
//	@ResponseBody
//	public int ajaxGongmoDelete(@RequestBody GongmoVO gvo) throws Exception {
//
//		int res = 0;
//		
//		res = service.gongmoDelete(gvo.getGseq());
//		
//		return res;
//	}
//	
//	@RequestMapping(value = "/ajaxupdate.do", method = RequestMethod.POST)
//	@ResponseBody
//	public int ajaxGongmoupdate(@RequestBody GongmoVO gvo) throws Exception {
//
//		int res = 0;
//		
//		res = service.gongmoUpdate(gvo);
//		
//		return res;
//	}
	
	
	@RequestMapping(value = "/listForAndroid.do", method = RequestMethod.GET)
	@ResponseBody
//	public String listForAndroid() throws Exception {
	public ArrayList<FieldVO> listForAndroid() throws Exception {
		ArrayList<FieldVO> flist = service.fieldList();
		
//		return "testtest";
		return flist;
	}
	
	
	@RequestMapping(value = "/gongmo_side_bar.do", method = RequestMethod.GET)
	public ModelAndView gongmoSideBar(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<FieldVO> flist = service.fieldList();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("flist", flist);
		mav.setViewName("tiles/tiles_gongmo_side_bar");
		return mav;
	}


	@RequestMapping(value = "/gongmo.do", method = RequestMethod.GET)
	public ModelAndView gongmo(HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.gongmoCount();
		
		PagingUtil pu = new PagingUtil("/gongmo.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.gongmoList(pu.getStartSeq(), pu.getEndSeq());
		
	/*	for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = service.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}*/
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("gongmo_body_main_list");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_field.do", method = RequestMethod.GET)
	public ModelAndView gongmoListField(HttpServletRequest request, HttpServletResponse response) {
		String fseq = request.getParameter("fseq");
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.gongmoFieldCount(Integer.parseInt(fseq));
		
		PagingUtil pu = new PagingUtil("/gongmo_field.do?fseq="+fseq
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.gongmoListField(Integer.parseInt(fseq), pu.getStartSeq(), pu.getEndSeq());
		
	/*	for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = service.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}*/
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("fseq", fseq);
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("gongmo_body_main_list");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_search.do", method = RequestMethod.GET)
	public ModelAndView gongmoListSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.gongmoSearchCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/gongmo_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.gongmoListSearch(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("gongmo_body_main_search_list");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_cal.do", method = RequestMethod.GET)
	public ModelAndView gongmoCal(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<GongmoVO> list = service.gongmoCal();

		ModelAndView mav = new ModelAndView();

		mav.addObject("LVL_CAL", list);
		//mav.setViewName("omo/gongmo_body_main_calendar");
		mav.setViewName("gongmo_body_main_calendar");  
		return mav;   
	}
	
	@RequestMapping(value = "/gongmo_detail.do", method = RequestMethod.GET)
	public ModelAndView gongmoDetail(@RequestParam("gseq") int gseq, HttpSession session) {
		
		GongmoVO gvo = service.gongmoDetail(gseq);
		int likeInfo = 0;
		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("SESS_MSEQ") != null) {
			int mseq = Integer.parseInt(session.getAttribute("SESS_MSEQ").toString());
			likeInfo = service.likeInfo(mseq, "l.gseq", gseq);
		}

		mav.addObject("likeInfo", likeInfo);
		mav.addObject("gvo", gvo);
		mav.setViewName("gongmo_body_detail");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_write_page.do", method = RequestMethod.GET)
	public ModelAndView gongmoWritePage(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<FieldVO> flist = service.fieldList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("flist", flist);
		mav.setViewName("index_body_gongmo_insert");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_insert.do", method = RequestMethod.POST)
	public String gongmoInsert(GongmoVO gvo, HttpSession session) throws IOException {
		
		int resGongmoField = 0;
		MultipartFile ufile = gvo.getUfile();
		
//		String dir = "C:\\Users\\Puter\\Desktop\\dddd\\lastOMO\\OMO\\src\\main\\webapp\\uploads\\gposter";
		String dir = "C:\\git_repository\\0MO\\LASTOMO\\src\\main\\webapp\\uploads\\gposter";
		
		//신규첨부파일
		if(!ufile.isEmpty()) {
			String path = dir + "\\" + ufile.getOriginalFilename();
			File newFile = new File(path); //파일생성
			ufile.transferTo(newFile);
			gvo.setGposter("/uploads/gposter/" + ufile.getOriginalFilename());
		}

		int mseq = (Integer) session.getAttribute("SESS_MSEQ");
		gvo.setMseq(mseq);
		
		int resGongmo = service.gongmoInsert(gvo);
		System.out.println("[LOG] 공모전 " + resGongmo + "건 입력");
		
/*		String checkbox = request.getParameter("farr");
		System.out.println("checkbox="+checkbox);*/
		String[] unit = gvo.getCheckbox().split(",");
		
		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i]);
			gvo.setFarr(Integer.parseInt(unit[i]));
			System.out.println("gvo.getfarr(): " + gvo.getFarr());
			resGongmoField += service.gongmoFieldInsert(Integer.parseInt(unit[i]));
		}
		
		// 세션 mseq 받아서 공모전 등록시 포인트 테이블에 추가부분
		int gUploadPoint = paysvc.gUploadPoint(mseq);
		
		System.out.println("공모전 등록 포인트 들어갔니?" + gUploadPoint);
		System.out.println("[LOG] 공모전의 분야 "+ resGongmoField + "건 입력");
		
		return "redirect:/gongmo.do";
	}
	
	@RequestMapping(value = "/gongmo_edit_page.do", method = RequestMethod.GET)
	public ModelAndView gongmoEditPage(@RequestParam("gseq") int gseq) {
		GongmoVO gvo = service.gongmoDetail(gseq);
		System.out.println("Gseq : " + gseq);
		
		System.out.println(gvo.getGsday());
		System.out.println(gvo.getGeday());
		
		ArrayList<FieldVO> flist = service.fieldList();
		ArrayList<GongmoVO> clist = service.fieldListCheck(gseq);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("gvo", gvo);
		mav.addObject("flist", flist);
		mav.addObject("clist", clist);
		mav.setViewName("index_body_gongmo_update");
		return mav;
	}
	
	@RequestMapping(value = "/gongmo_update.do", method = RequestMethod.POST)
	public String gongmoUpdate(GongmoVO gvo, @RequestParam("gseq") int gseq) throws IOException {
		
		int res = 0;
		System.out.println("For update Gseq : " + gseq);
		int resGongmoField = 0;
		
		int resDelField = service.gongmoFieldDelete(gseq);
		System.out.println("[LOG] " + resDelField + "건 분야 삭제");
		
		MultipartFile ufile = gvo.getUfile();
		String dir = "C:\\git_repository\\0MO\\LASTOMO\\src\\main\\webapp\\uploads\\gposter";
		
		String gposter = gvo.getGposter();
		System.out.println("[LOG] 현재 파일 : " + gposter);
		
		
		if(ufile.isEmpty()) { //기존 첨부파일 유지
			res = service.gongmoUpdate(gvo);
			System.out.println("[LOG] " + res + "건 수정(파일 미포함) 완료");
			
			String[] unit = gvo.getCheckbox().split(",");
			
			for(int i=0; i<unit.length; i++) {
				System.out.println("[LOG] 분야 번호 : " + unit[i]);
				gvo.setFarr(Integer.parseInt(unit[i]));
				System.out.println("gvo.getfarr(): " + gvo.getFarr());
				resGongmoField += service.gongmoFieldUpdate(gseq, Integer.parseInt(unit[i]));
			}
			System.out.println("[LOG] 공모전의 분야 "+ resGongmoField + "건 수정");
		} else { //신규 포스터 등록
			
			if(gposter.equals("")) {
				
				String path = dir + "\\" + ufile.getOriginalFilename();
				File newFile = new File(path);
				ufile.transferTo(newFile);
				gvo.setGposter("/uploads/gposter/" + ufile.getOriginalFilename());
			}
			else {
				String fileNm = gposter.split("/")[3];
				System.out.println("[LOG] 스플릿한 파일 이름 : " + fileNm);
				File oldFile = new File(dir + "\\" + fileNm);
				if(oldFile.exists())
					oldFile.delete();
				
				String path = dir + "\\" + ufile.getOriginalFilename();
				File newFile = new File(path);
				ufile.transferTo(newFile);
				gvo.setGposter("/uploads/gposter/" + ufile.getOriginalFilename());
			}
			
			
			res = service.gongmoUpdateForPoster(gvo);
			System.out.println("[LOG] " + res + "건 수정("+ufile.getOriginalFilename()+") 완료");
			
			String[] unit = gvo.getCheckbox().split(",");
			
			for(int i=0; i<unit.length; i++) {
				System.out.println(unit[i]);
				gvo.setFarr(Integer.parseInt(unit[i]));
				System.out.println("gvo.getfarr(): " + gvo.getFarr());
				resGongmoField += service.gongmoFieldUpdate(gseq, Integer.parseInt(unit[i]));
			}
			System.out.println("[LOG] 공모전의 분야 "+ resGongmoField + "건 수정");
		}
		
		return "redirect:/gongmo_detail.do?gseq="+gseq;
	}
	
	@RequestMapping(value = "/gongmo_delete.do", method = RequestMethod.POST)
	public String gongmoDelete(@RequestParam("gseq") int gseq, @RequestParam("mseq") int mseq, HttpSession session) {
		int res = service.gongmoDelete(gseq);
		
		// 세션 받아서 공모전 삭제시 포인트 차감 부분
		int gDeletePoint = paysvc.gDeletePoint(mseq);
		
		System.out.println("공모전 삭제시 포인트 차감 테스트 : " + gDeletePoint);
		System.out.println("[LOG] " + res + "건 삭제 완료");
		return "redirect:/gongmo.do";
	}
	
	@RequestMapping(value = "/gongmo_like.do", method = RequestMethod.POST)
	@ResponseBody
	public String gongmoLike(@RequestBody LikedVO lvo) {
		service.gongmoLike(lvo.getGseq(), lvo.getMseq(), lvo.getLcnt());
		
		GongmoVO gvo = service.gongmoDetail(lvo.getGseq());
		String lcnt = gvo.getLvo().getLcnt()+"";
		
		/*int likeInfo = service.likeInfo(lvo.getMseq(), "l.gseq", lvo.getGseq());
		
		Map<String,Object> map = new Map<String, Object>();
		map.put("lcnt", lcnt);
		map.put("likeInfo", likeInfo);*/
		
		return lcnt;
	}
	
	@RequestMapping(value = "/gongmo_report.do", method = RequestMethod.POST)
	public String gongmoReport(@RequestParam("brwhy") String brwhy, @RequestParam("gseq") int gseq) {
		BreportVO brvo = new BreportVO();
		brvo.setBrwhy(brwhy);
		brvo.setGseq(gseq);
		
		service.gongmoReport(brvo);
		
		return "redirect:/gongmo_detail.do?gseq="+gseq;
	}
	
	/***********************************/
	/***********어드민페이지************/
	/***********************************/
	@RequestMapping(value = "/admin_index.do", method = RequestMethod.GET)
	public ModelAndView adminIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("admin_body_login");
		return mav;
	}
	
	@RequestMapping(value = "/admin_join.do", method = RequestMethod.POST)
	public String adminJoin(AdminVO avo) {
		ModelAndView mav = new ModelAndView();
			int i = service.adminJoin(avo);
			if(i>0){
				mav.setViewName("admin_body_login");
				System.out.println("네, 가입되어씀니다. 뿌잉뜌잉");
				return "redirect:/admin_index.do";
			}else{
				System.out.println("실패");
				mav.setViewName("admin_body_login");
				return "redirect:/admin_join.do";
			}
		
	}
	
	@RequestMapping(value = "/admin_login.do", method = RequestMethod.POST)
	public ModelAndView adminLogin(HttpSession session,
			@RequestParam(value="aid", required=false) String aid,
			@RequestParam(value="apw", required=false) String apw) {
		System.out.println("Admin Login");
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = service.indexPage();
		ArrayList<BreportVO> brlist = service.breportList(1, 3);
		ArrayList<RreportVO> rrlist = service.rreportList(1, 3);
		ArrayList<MemberVO> mlist = service.memberList(1, 3);
		ArrayList<PayVO> indexPayList = paysvc.indexPayList();
		
		int pcount = paysvc.payTodayCount();
		int gcount = service.gongmoCount();
		int mcount = service.memberCount();
		int rcount = service.breportCount() + service.rreportCount();
		int payCnt = paysvc.payTodayCount();
		
		AdminVO avo = service.adminLogin(aid, apw);
			
		if(avo != null) {
			if(avo.getAgrade().equals("A") || avo.getAgrade().equals("Super")) {
				session.setAttribute("SESS_ASEQ", avo.getAseq());
				session.setAttribute("SESS_AID", avo.getAid());
				session.setAttribute("SESS_AGRADE", avo.getAgrade());
				
				
				mav.addObject("SESS_ASEQ",session.getAttribute("SESS_ASEQ"));
				mav.addObject("SESS_AID",session.getAttribute("SESS_AID"));
				mav.addObject("SESS_AGRADE",session.getAttribute("SESS_AGRADE"));
				mav.addObject("iplist", indexPayList);
				mav.addObject("paycnt", payCnt);
				
				mav.addObject("glist", map.get("glist"));
				mav.addObject("list", map.get("list"));
				mav.addObject("mlist", mlist);
				mav.addObject("brlist", brlist);
				mav.addObject("rrlist", rrlist);
				mav.addObject("pcount", pcount);
				mav.addObject("gcount", gcount);
				mav.addObject("mcount", mcount);
				mav.addObject("rcount", rcount);
				mav.setViewName("admin_body_index");
			} else {
				mav.setViewName("admin_body_login");
			}
		} else {
			mav.setViewName("admin_body_login");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.indexPage();
		ArrayList<BreportVO> brlist = service.breportList(1, 3);
		ArrayList<RreportVO> rrlist = service.rreportList(1, 3);
		ArrayList<MemberVO> mlist = service.memberList(1, 3);
		ArrayList<PayVO> indexPayList = paysvc.indexPayList();
		
		
		int pcount = paysvc.payTodayCount();
		int gcount = service.gongmoCount();
		int mcount = service.memberCount();
		int rcount = service.breportCount() + service.rreportCount();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("glist", map.get("glist"));
		mav.addObject("list", map.get("list"));
		mav.addObject("mlist", mlist);
		mav.addObject("brlist", brlist);
		mav.addObject("rrlist", rrlist);
		mav.addObject("iplist", indexPayList);
		mav.addObject("pcount", pcount);
		mav.addObject("gcount", gcount);
		mav.addObject("mcount", mcount);
		mav.addObject("rcount", rcount);
		mav.setViewName("admin_body_index");
		return mav;
	}
	
	
	@RequestMapping(value = "/admin_gongmo.do", method = RequestMethod.GET)
	public ModelAndView adminGongmo(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<GongmoVO> alist = service.adminGongmoListFive();
		ArrayList<GongmoVO> ulist = service.userGongmoListFive();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("alist", alist);
		mav.addObject("ulist", ulist);
		
		mav.setViewName("admin_body_gongmo_main");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_admin_list.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoList(HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.adminGongmoCount();
		
		PagingUtil pu = new PagingUtil("/admin_gongmo_admin_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.adminGongmoList(pu.getStartSeq(), pu.getEndSeq());
		
		int mseq = list.get(0).getMvo().getMseq();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		mav.addObject("mseq", mseq);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_gongmo_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_user_list.do", method = RequestMethod.GET)
	public ModelAndView userGongmoList(HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.userGongmoCount();
		
		PagingUtil pu = new PagingUtil("/admin_gongmo_user_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.userGongmoList(pu.getStartSeq(), pu.getEndSeq());
	/*	for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = service.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}*/
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_gongmo_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_detail.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoDetail(@RequestParam("gseq") int gseq) {
		
		GongmoVO gvo = service.gongmoDetail(gseq);

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("gvo", gvo);
		mav.setViewName("admin_body_gongmo_detail");
		return mav;
	}
	
	
	@RequestMapping(value = "/admin_gongmo_edit_page.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoEditPage(@RequestParam("gseq") int gseq) {
		GongmoVO gvo = service.gongmoDetail(gseq);
		System.out.println("Gseq : " + gseq);
		
		System.out.println(gvo.getGsday());
		System.out.println(gvo.getGeday());
		
		ArrayList<FieldVO> flist = service.fieldList();
		ArrayList<GongmoVO> clist = service.fieldListCheck(gseq);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("gvo", gvo);
		mav.addObject("flist", flist);
		mav.addObject("clist", clist);
		mav.setViewName("admin_body_gongmo_update");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_update.do", method = RequestMethod.POST)
	public String adminGongmoUpdate(GongmoVO gvo, @RequestParam("gseq") int gseq) throws IOException {
		
		int res = 0;
		System.out.println("For update Gseq : " + gseq);
		int resGongmoField = 0;
		
		int resDelField = service.gongmoFieldDelete(gseq);
		System.out.println("[LOG] " + resDelField + "건 분야 삭제");
		
		MultipartFile ufile = gvo.getUfile();
		String dir = "C:\\git_repository\\0MO\\LASTOMO\\src\\main\\webapp\\uploads\\gposter";
		String gposter = gvo.getGposter();
		System.out.println("[LOG] 현재 파일 : " + gposter);
		
		
		if(ufile.isEmpty()) { //기존 첨부파일 유지
			res = service.gongmoUpdate(gvo);
			System.out.println("[LOG] " + res + "건 수정(파일 미포함) 완료");
			
			String[] unit = gvo.getCheckbox().split(",");
			
			for(int i=0; i<unit.length; i++) {
				System.out.println("[LOG] 분야 번호 : " + unit[i]);
				gvo.setFarr(Integer.parseInt(unit[i]));
				System.out.println("gvo.getfarr(): " + gvo.getFarr());
				resGongmoField += service.gongmoFieldUpdate(gseq, Integer.parseInt(unit[i]));
			}
			System.out.println("[LOG] 공모전의 분야 "+ resGongmoField + "건 수정");
		} else { //신규 포스터 등록
			
			if(gposter.equals("")) {
				
				String path = dir + "\\" + ufile.getOriginalFilename();
				File newFile = new File(path);
				ufile.transferTo(newFile);
				gvo.setGposter("/uploads/gposter/" + ufile.getOriginalFilename());
			}
			else {
				String fileNm = gposter.split("/")[2];
				System.out.println("[LOG] 스플릿한 파일 이름 : " + fileNm);
				File oldFile = new File(dir + "\\" + fileNm);
				if(oldFile.exists())
					oldFile.delete();
				
				String path = dir + "\\" + ufile.getOriginalFilename();
				File newFile = new File(path);
				ufile.transferTo(newFile);
				gvo.setGposter("/uploads/gposter/" + ufile.getOriginalFilename());
			}
			
			
			res = service.gongmoUpdateForPoster(gvo);
			System.out.println("[LOG] " + res + "건 수정("+ufile.getOriginalFilename()+") 완료");
			
			String[] unit = gvo.getCheckbox().split(",");
			
			for(int i=0; i<unit.length; i++) {
				System.out.println(unit[i]);
				gvo.setFarr(Integer.parseInt(unit[i]));
				System.out.println("gvo.getfarr(): " + gvo.getFarr());
				resGongmoField += service.gongmoFieldUpdate(gseq, Integer.parseInt(unit[i]));
			}
			System.out.println("[LOG] 공모전의 분야 "+ resGongmoField + "건 수정");
		}
		
		return "redirect:/admin_gongmo_detail.do?gseq="+gseq;
	}
	
	@RequestMapping(value = "/admin_gongmo_delete.do", method = RequestMethod.POST)
	public String adminGongmoDelete(@RequestParam("gseq") int gseq) {
		int res = service.gongmoDelete(gseq);
		
		System.out.println("[LOG] " + res + "건 삭제 완료");
		return "redirect:/admin_gongmo.do";
	}
	
	@RequestMapping(value = "/admin_gongmo_admin_search.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoAdminSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.adminGongmoSearchCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_gongmo_admin_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.adminGongmoListSearch(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_gongmo_search_admin_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_user_search.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoUserSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.userGongmoSearchCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_gongmo_user_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<GongmoVO> list = service.userGongmoListSearch(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("list", list);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_gongmo_search_user_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_gongmo_field.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoField(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<FieldVO> flist = service.fieldList();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("flist", flist);
		mav.setViewName("admin_body_gongmo_field");
		return mav;
	}
	
//	@RequestMapping(value = "/gongmo_like.do", method = RequestMethod.POST)
//	@ResponseBody
//	public String gongmoLike(@RequestBody LikedVO lvo) {
//		service.gongmoLike(lvo.getGseq(), lvo.getMseq(), lvo.getLcnt());
//		
//		GongmoVO gvo = service.gongmoDetail(lvo.getGseq());
//		String lcnt = gvo.getLvo().getLcnt()+"";
//		
//		return lcnt;
//	}
	
	@RequestMapping(value = "/admin_gongmo_field_update.do", method = RequestMethod.POST)
	@ResponseBody
	public int adminGongmoFieldUpdate(@RequestBody FieldVO fvo) {
		
		int res = service.fieldUpdate(fvo);
		
		return res;
	}
	
	@RequestMapping(value = "/admin_gongmo_field_insert.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<FieldVO> adminGongmoFieldInsert(@RequestBody FieldVO fvo) {
		
		service.fieldInsert(fvo);
		
		ArrayList<FieldVO> flist = service.fieldList();
		
		return flist;
	}
	
	@RequestMapping(value = "/admin_gongmo_crawl.do", method = RequestMethod.GET)
	public ModelAndView adminGongmoCrawl() {
		
		GongmoCrawler gc = new GongmoCrawler();
		
		String html = gc.getGongmoCrawler();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("html", html);
		mav.setViewName("admin_body_gongmo_crawl");
		return mav;
		
	}
	
	@RequestMapping(value = "/admin_gongmo_insert.do", method = RequestMethod.POST)
	@ResponseBody
	public int adminGongmoInsert(@RequestBody GongmoVO gvo) {
		System.out.println(gvo.getGtitle());
		int resGongmo = 0;
		if(gvo.getGbody().length() < 2000){
			resGongmo = service.adminGongmoInsert(gvo);
		} else {
			System.out.println("[LOG] gbody 한계치 이상 - SKIP");
		}
		
		
		return resGongmo;
	}
	
	
	//========================================================================================
	
	@RequestMapping(value = "/admin_breport_list.do", method = RequestMethod.GET)
	public ModelAndView adminBreportList(HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.breportListCount();
		
		PagingUtil pu = new PagingUtil("/admin_breport_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<BreportVO> brlist = service.breportList(pu.getStartSeq(), pu.getEndSeq());
	/*	for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = service.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}*/
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("brlist", brlist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_breport_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_breport_search.do", method = RequestMethod.GET)
	public ModelAndView adminBreportSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.breportSearchListCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_breport_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<BreportVO> brlist = service.breportSearchList(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("brlist", brlist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_breport_search");
		return mav;
	}
	
	@RequestMapping(value = "/admin_rreport_list.do", method = RequestMethod.GET)
	public ModelAndView adminRreportList(HttpServletRequest request, HttpServletResponse response) {		
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.rreportListCount();
		
		PagingUtil pu = new PagingUtil("/admin_rreport_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<RreportVO> rrlist = service.rreportList(pu.getStartSeq(), pu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("rrlist", rrlist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_rreport_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_rreport_search.do", method = RequestMethod.GET)
	public ModelAndView adminRreportSearch(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.rreportSearchListCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_rreport_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<RreportVO> rrlist = service.rreportSearchList(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("rrlist", rrlist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_rreport_search");
		return mav;
	}
	
	@RequestMapping(value = "/member_delete.do", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("mseq") int mseq) {
		int res = service.memberDelete(mseq);
		
		System.out.println("[LOG] " + res + "건 삭제 완료");
		
		return "redirect:/admin_rreport_list.do";
	}
	
	@RequestMapping(value = "/member_delete_toList.do", method = RequestMethod.POST)
	public String memberDeleteToList(@RequestParam("mseq") int mseq) {
		int res = service.memberDelete(mseq);
		
		System.out.println("[LOG] " + res + "건 삭제 완료");
		
		return "redirect:/admin_member_list.do";
	}
	
	
	@RequestMapping(value = "/admin_member_list.do", method = RequestMethod.GET)
	public ModelAndView adminMemberList(HttpServletRequest request, HttpServletResponse response) {		
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.memberCount();
		
		PagingUtil pu = new PagingUtil("/admin_member_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<MemberVO> mlist = service.memberList(pu.getStartSeq(), pu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mlist", mlist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_member_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_member_search.do", method = RequestMethod.GET)
	public ModelAndView adminMemberSearchList(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {		
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.memberSearchCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_member_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<MemberVO> mlist = service.memberSearchList(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("mlist", mlist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_member_list");
		return mav;
	}
	
	
	@RequestMapping(value = "/admin_admin_list.do", method = RequestMethod.GET)
	public ModelAndView adminAdminList(HttpServletRequest request, HttpServletResponse response) {		
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.adminListCount();
		
		PagingUtil pu = new PagingUtil("/admin_admin_list.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<AdminVO> alist = service.adminList(pu.getStartSeq(), pu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("alist", alist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_admin_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_admin_search.do", method = RequestMethod.GET)
	public ModelAndView adminAdminSearchList(@RequestParam("searchStr") String searchStr, HttpServletRequest request, HttpServletResponse response) {		
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.adminSearchListCount(searchStr);
		
		PagingUtil pu = new PagingUtil("/admin_admin_search.do?searchStr="+searchStr
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<AdminVO> alist = service.adminSearchList(pu.getStartSeq(), pu.getEndSeq(), searchStr);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchStr", searchStr);
		mav.addObject("alist", alist);
		//mav.addObject("gflist", gflist);
		mav.addObject("paging", html);

		mav.setViewName("admin_body_admin_list");
		return mav;
	}
	
	@RequestMapping(value = "/admin_grade_up.do", method = RequestMethod.POST)
	@ResponseBody
	public String adminGradeUp(@RequestBody AdminVO avo) {
		service.adminGradeUp(avo.getAseq());
		
		return service.adminDetail(avo.getAseq()).getAgrade();
	}
	
	@RequestMapping(value = "/admin_grade_down.do", method = RequestMethod.POST)
	@ResponseBody
	public String adminGradeDown(@RequestBody AdminVO avo) {
		service.adminGradeDown(avo.getAseq());
		
		return service.adminDetail(avo.getAseq()).getAgrade();
	}
	
	
}
