package com.kosmo.omo;

import java.awt.PageAttributes.MediaType;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.common.PagingUtil;
import com.kosmo.vo.OpenVO;
import com.kosmo.vo.PayVO;
import com.kosmo.vo.PointVO;
 
// 카카오 결제변경시
//1. kakao4.do 검색
//2.  prm.put("approval_url","http://192.168.0.36:81/approval.do");
//	prm.put("cancel_url","http://192.168.0.36:81/my_body_pointpay.do");
//	prm.put("fail_url","http://192.168.0.36:81/my_body_pointpay.do");
//	3개 //192.168.0.36:81 부분 본인 카카오 디벨로퍼 웹 도메인,서버 일치 시키기 
//  80번일경우는 ->> ex.) http://192.168.0.36:81 -->> http://192.168.0.36 으로만 80안써도됨
	
/**
 * Handles requests for the application home page.
 */
@Controller
//@SessionAttribute("SESS_UNAME")
public class PointPayController {
	private static final Logger logger = LoggerFactory.getLogger(PointPayController.class);
	
	@Autowired PayService service;
	
	@RequestMapping(value = "/tiles.do", method = RequestMethod.GET)
	public String tiles() {
		
		return "index_body_main_page";
	}
	
	@RequestMapping(value = "/my_body_pointpay.do", method = RequestMethod.GET)
	public ModelAndView myBodyPointPay(HttpSession session) {
		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		String mid = (String)session.getAttribute("SESS_MEMBERID");
		
		int pointSum = service.pointSum(mseq);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_pointSum", pointSum);
		mav.addObject("mid", mid);
		
		mav.setViewName("my_body_pointpay");
		
		return mav;
	}
/*	@RequestMapping(value = "/my_body_pointpaycom.do", method = RequestMethod.GET)
	public ModelAndView myBodyPointPayCom() {
		int paseq=3;
		PayVO payCom = service.payCom(paseq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("LVL_PAYCOM", payCom);
		
		mav.setViewName("my_body_pointpaycom");
		
		return mav;
	}*/
	
	@RequestMapping(value = "/my_body_pointlook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView myBodyPointLook(HttpSession session
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
			) {
		
		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		
		System.out.println("mseq***********" + mseq);
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.userPointCount(mseq);
		System.out.println("total" + totalCount);
		
		PagingUtil pu = new PagingUtil("/my_body_pointlook.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String html = pu.getPagingHtml();
		
		
//		int pointSum = service.pointSum(vo.getMid());
		
//		ArrayList<PointVO> userPointList = service.userPointList();
		
		HashMap<String, Object> map = service.pointLookPage(mseq, sdate, edate, 
				pu.getStartSeq(), pu.getEndSeq());
		
		System.out.println("sseq************" + pu.getStartSeq());
		System.out.println("eseq************" + pu.getStartSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTSUM", map.get("pointSum"));
		
		mav.addObject("LVL_USERPOINTLIST", map.get("userPointList"));
		mav.addObject("LVL_PAGING", html);
		mav.setViewName("my_body_pointlook");
		
		
		return mav;
	}
	
	@RequestMapping(value = "/my_body_pointsearchlook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView myBodyPointSearchLook(HttpSession session
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
			) {
		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("********여기까지**********");
		System.out.println("sdate***********" + sdate);
		System.out.println("edate***********" + edate);
		
		
		int searchTotalCount = service.userSearhPointCount(mseq, sdate, edate);
		
		System.out.println("searchTotalCount*********" + searchTotalCount);
		
		PagingUtil searchpu = new PagingUtil("/my_body_pointsearchlook.do?sdate="+sdate+"&edate="+edate
										, currentPage
										, searchTotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String searchHtml = searchpu.getPagingHtml();
		
//		int pointSum = service.pointSum(vo.getMid());
		
//		ArrayList<PointVO> userPointList = service.userPointList();
		
		HashMap<String, Object> map = service.pointLookPage(mseq, sdate, edate, 
				searchpu.getStartSeq(), searchpu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTSUM", map.get("pointSum"));

		System.out.println("날짜있는거");
		mav.addObject("LVL_USERPOINTLIST", map.get("userSearchPointList"));
		mav.addObject("LVL_PAGING", searchHtml);
		mav.setViewName("my_body_pointlook");

		return mav;
	}
	
	@RequestMapping(value = "/my_body_paylook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView myBodyPayLook(HttpSession session
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
			) {
		
		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int totalCount = service.userPayCount(mseq);

		PagingUtil pu = new PagingUtil("/my_body_paylook.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String html = pu.getPagingHtml();
		
		HashMap<String, Object> map = service.payLookPage(mseq, sdate, edate, pu.getStartSeq(), 
				pu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTSUM", map.get("pointSum"));
		
		System.out.println("날짜없는거");
		mav.addObject("LVL_USERPAYLIST", map.get("userPayList"));
		mav.setViewName("my_body_paylook");
		mav.addObject("LVL_PAGING", html);
		
		return mav;
	}
	
	@RequestMapping(value = "/my_body_paysearchlook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView myBodyPaySearchLook(HttpSession session
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
			) {
		
		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int searchTotalCount = service.userSearhPayCount(mseq, sdate, edate);
		
		PagingUtil searchpu = new PagingUtil("/my_body_paysearchlook.do?sdate="+sdate+"&edate="+edate
										, currentPage
										, searchTotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		String searchHtml = searchpu.getPagingHtml();
		
		HashMap<String, Object> map = service.payLookPage(mseq, sdate, edate, searchpu.getStartSeq(), searchpu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTSUM", map.get("pointSum"));

		System.out.println("날짜잇는거");
		mav.addObject("LVL_USERPAYLIST", map.get("userSearchPayList"));
		mav.setViewName("my_body_paylook");
		mav.addObject("LVL_PAGING", searchHtml);
		
		return mav;
	}
	

	@RequestMapping(value = "/admin_point.do", method = RequestMethod.GET)
	public ModelAndView admin_point(HttpServletRequest request, HttpServletResponse response) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.pointCount();
		
		PagingUtil pu = new PagingUtil("/admin_point.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
//		Map<String, Object> map = service.adminPage();
		ArrayList<PointVO> adminPointList = service.adminPointList(pu.getStartSeq(), pu.getEndSeq());

		ModelAndView mav = new ModelAndView();
		
//		mav.addObject("LVL_APOINTLIST", map.get("adminPointList"));
//		mav.addObject("LVL_APAYLIST", map.get("adminPayList"));
		mav.addObject("LVL_APOINTLIST", adminPointList);
		mav.addObject("LVL_PAGING", html);
		
		mav.setViewName("admin_body_point");
		return mav;
	}
	
	@RequestMapping(value = "/admin_pay.do", method = RequestMethod.GET)
	public ModelAndView admin_pay(HttpServletRequest request, HttpServletResponse response) {
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int totalCount = service.payCount();
		
		PagingUtil pu = new PagingUtil("/admin_pay.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
//		Map<String, Object> map = service.adminPage();
		ArrayList<PayVO> adminPayList = service.adminPayList(pu.getStartSeq(), pu.getEndSeq());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_APAYLIST", adminPayList);
		mav.addObject("LVL_PAGING", html);
		
		mav.setViewName("admin_body_pay");
		return mav;
	}
	//<a href=/admin5.do/17/주전자>click</a>
	//@RequestMapping(value = "/admin5.do/{mid}/{goods}", method = {RequestMethod.GET}")
//			@PathVariable String mid
//			,@PathVariable String goods
	
	//<a href=/admin5.do?sid=17 &goodname=주전자>click</a>
	@RequestMapping(value = "/admin_point_search.do", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView admin_point_search(//HttpServletRequest request, HttpServletResponse response
			@RequestParam(value="mid", required=false) String mid
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
//			, @RequestParam(value="sdate", required=false) String mid
//			,@RequestParam(value="sid", required=false, defaultValue="10") int mid
//			,HttpServletRequest request (구버전)   --> , HttpSession session(스프링)
//			Model model
			) {
		//String mid = request.getParameter("sid");
		
		//구버전 세션넣기
//		HttpServletSession session = request.getSession();
//		session.setAttribute("dd", val);
		
//		스프링 세션넣기
//		model.addAttribute("SESS_UNAME", vo.getUname());
//		session.setAttribute("SESS_UNAME", val);
//		session.getAttribute("SESS_UNAME");
		
		System.out.println("mid:**************" +  mid);
		System.out.println("sdate : **********" + sdate);
		System.out.println("edate : **********" + edate);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		int totalCount = service.pointCount();
		int searchIdtotalCount = service.pointIdSearchCount(mid);
		int searchtotalCount = service.pointSearchCount(mid, sdate, edate);
		
		PagingUtil pu = new PagingUtil("/admin_point_search.do?sdate="+sdate+"&edate="+edate+"&mid="+mid
										, currentPage
										, searchtotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		PagingUtil pui = new PagingUtil("/admin_point_search.do?mid="+mid
										, currentPage
										, searchIdtotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String ihtml = pui.getPagingHtml();
		String html = pu.getPagingHtml();
		
		ArrayList<PointVO> adminPointsearchList11 = new ArrayList<PointVO>();
		ArrayList<PointVO> adminPointsearchList = new ArrayList<PointVO>();
		ModelAndView mav = new ModelAndView();
		
		if((sdate=="" && edate=="") || (sdate==null&& edate==null) || (sdate.equals("")&& edate.equals(""))) {
			System.out.println("날짜없는거");
			adminPointsearchList11 = service.adminPointsearchList11(mid, pui.getStartSeq(), pui.getEndSeq());
			mav.addObject("LVL_APOINTLIST", adminPointsearchList11);
			mav.addObject("LVL_PAGING", ihtml);
			mav.setViewName("admin_body_point");
			
		} else {
			System.out.println("날짜잇는거");
			adminPointsearchList = service.adminPointsearchList(mid, sdate, edate, pu.getStartSeq(), pu.getEndSeq());
			mav.addObject("LVL_APOINTLIST", adminPointsearchList);
			mav.addObject("LVL_PAGING", html);
			mav.setViewName("admin_body_point");
		}
		return mav;
	}
	
	@RequestMapping(value = "/admin_pay_search.do", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView admin_pay_search(
			@RequestParam(value="mid", required=false) String mid
			, @RequestParam(value="sdate", required=false) String sdate
			, @RequestParam(value="edate", required=false) String edate
			, HttpServletRequest request
			) {
		
		System.out.println("mid:**************" +  mid);
		System.out.println("sdate : **********" + sdate);
		System.out.println("edate : **********" + edate);
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int searchtotalCount = service.paySearchCount(mid, sdate, edate);
		int searchIdtotalCount = service.paySerchIdCount(mid);
		
		PagingUtil pu = new PagingUtil("/admin_pay_search.do?sdate="+sdate+"&edate="+edate+"&mid="+mid
										, currentPage
										, searchtotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		
		PagingUtil pui = new PagingUtil("/admin_pay_search.do?mid="+mid
										, currentPage
										, searchIdtotalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		String htmli = pui.getPagingHtml();
		
		ArrayList<PayVO> adminPaysearchList11 = new ArrayList<PayVO>();
		ArrayList<PayVO> adminPaysearchList = new ArrayList<PayVO>();
		ModelAndView mav = new ModelAndView();
		
		if(sdate=="" && edate=="" || (sdate==null&& edate==null) || (sdate.equals("")&& edate.equals(""))) {
			adminPaysearchList11 = service.adminPayIdSearchList(mid, pui.getStartSeq(), pui.getEndSeq());
			mav.addObject("LVL_APAYLIST", adminPaysearchList11);
			mav.addObject("LVL_PAGING", htmli);
			mav.setViewName("admin_body_pay");
		} else {
			adminPaysearchList = service.adminPaySearchList(mid, sdate, edate, pu.getStartSeq(), pu.getEndSeq());
			mav.addObject("LVL_APAYLIST", adminPaysearchList);
			mav.addObject("LVL_PAGING", html);
			mav.setViewName("admin_body_pay");
		}
		return mav;
	}
	
	@RequestMapping(value = "/approval.do")
	public ModelAndView approval(HttpSession session) {

		/*HashMap<String, Object> map = new HashMap<String, Object>();
		map.get("insertPayPoint");
		map.get("insertPay");*/
		PayVO pavo = (PayVO)session.getAttribute("pavo");
		PayVO payCom = service.insetPage(pavo);
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("pavo");
		mav.addObject("LVL_PAYCOM", payCom);
		
		mav.setViewName("my_body_pointpaycom");
		
		return mav;
	}  
	
	@RequestMapping(value = "/kakao4.do")
	@ResponseBody
	public String kakao4(@RequestBody OpenVO ovo, HttpSession session) {
		
		HashMap<String, Object> prm = new HashMap<String, Object>();
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		PayVO pavo = new PayVO();

		int mseq = (Integer)session.getAttribute("SESS_MSEQ");
		
		pavo.setMseq(mseq);
		pavo.setPamoney(ovo.getPamoney());
//		pavo.setPtseq(1);
		session.setAttribute("pavo", pavo);
		
		prm.put("cid","TC0ONETIME");
		prm.put("partner_order_id","20180410LV5057489s7");
		prm.put("partner_user_id","COMEALONE");
		prm.put("item_name",ovo.getPamoney()+"p");
		prm.put("quantity",1);
		prm.put("total_amount",ovo.getPamoney());
		prm.put("tax_free_amount",1);
		prm.put("vat_amount",+0);
		prm.put("approval_url","http://192.168.0.5/approval.do");
		prm.put("cancel_url","http://192.168.0.5/my_body_pointpay.do");
		prm.put("fail_url","http://192.168.0.5/my_body_pointpay.do");

		ovo.setUrl("https://kapi.kakao.com/v1/payment/ready");
		ovo.setRequestMethod("POST");
		ovo.setHost("https://kapi.kakao.com");
//		ovo.setAuth("Bearer {aLzkwoXVVzjlunBCaRe2bRDedh8hk6nKWM1iGAo8BdgAAAFirxCXKA}");  //ACCESS_TOKEN
		ovo.setAuth("Bearer {"+ovo.getAccess_token()+"}");  //ACCESS_TOKEN
//		ovo.setAuth("KakaoAK {d17be967963b0f416b148fdb8b4069f9}");
		ovo.setMap(prm);
		
		KakaoTest4 kkt = new KakaoTest4();

		resMap = kkt.openAPI(ovo);
		System.out.println(resMap.get("code") + "----" + resMap.get("message"));
		
		return (String) resMap.get("message");
	}
	
	
	//=============== 회원가입, 공모전 삭제, 포폴 상세보기, 공모전 등록, 인덱스 결제 리스트 ============
	
	@RequestMapping(value = "/my_body_joinmember.do", method = RequestMethod.GET)
	public ModelAndView myBodyJoinMember(HttpSession session) {
		ArrayList<PayVO> indexPayList = service.indexPayList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_INDEXPAYLIST", indexPayList);
		mav.setViewName("my_body_joinmember");
		
		return mav;
	}
	
	@RequestMapping(value = "/my_body_joinpointmember.do", method = RequestMethod.GET)
	public String myBodyJoinPointMember(HttpSession session) {
		
		int insertJoinPoint = service.insertJoinPoint();
		
		return "redirect:/index.do";
	}  
	
	@RequestMapping(value = "/gDeletePoint.do", method = RequestMethod.GET)
	public String gdeletepoint(HttpSession session) {
		int mseq = 3;
		
		int gdeletepoint = service.gDeletePoint(mseq);
		
		return "redirect:/index.do";
	} 
	
	@RequestMapping(value = "/poViewPoint.do", method = RequestMethod.GET)
	public String poViewPoint(HttpSession session) {
		int mseq = 3;
		
		int poViewPoint = service.poViewPoint(mseq);
		
		return "redirect:/index.do";
	}
	
	@RequestMapping(value = "/gUploadPoint.do", method = RequestMethod.GET)
	public String gUploadPoint(HttpSession session) {
		int mseq = 3;
		
		int gUploadPoint = service.gUploadPoint(mseq);
		
		return "redirect:/index.do";
	}
	
	//============================어드민 메인, point ,pay리스트============================
	
	@RequestMapping(value = "/admin_body_pointpay_main.do", method = RequestMethod.GET)
	public ModelAndView adminBodyPointPayMain(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = service.adminMainPage();
		
		mav.addObject("LVL_POINTLIST", map.get("adminPointList"));
		mav.addObject("LVL_PAYLSIT" , map.get("adminPayList"));
		
		mav.setViewName("admin_body_pointpay_main");
		
		return mav;
	}
	
	@RequestMapping(value = "/admin_body_pointpay_palist.do", method = RequestMethod.GET)
	public ModelAndView adminBodyPointPayPalist(HttpSession session, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		int totalCount = service.pointCount();
		int totalCount = service.payCount();
		
		PagingUtil pu = new PagingUtil("/admin_body_pointpay_palist.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<PayVO> adminPayList = service.adminPayList(pu.getStartSeq(), pu.getEndSeq());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_PAYLSIT", adminPayList);
		mav.addObject("LVL_PAGING", html);
		
		
		mav.setViewName("admin_body_pointpay_palist");
		
		return mav;
	}
	
	@RequestMapping(value = "/admin_body_pointpay_pasearchlist.do")
	public ModelAndView adminBodyPointPayPaSearchList(HttpSession session, 
													HttpServletRequest request,
													@RequestParam(value="mid", required=false) String mid
			) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		int totalCount = service.pointCount();
		int totalCount = service.paySerchIdCount(mid);
		
		PagingUtil pu = new PagingUtil("/admin_body_pointpay_pasearchlist.do?mid="+mid
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<PayVO> adminPayIdSearchList = service.adminPayIdSearchList(mid, pu.getStartSeq(), pu.getEndSeq());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_PAYLSIT", adminPayIdSearchList);
		mav.addObject("LVL_PAGING", html);
		
		
		mav.setViewName("admin_body_pointpay_palist");
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/admin_body_pointpay_polist.do", method = RequestMethod.GET)
	public ModelAndView adminBodyPointPayPolist(HttpSession session, HttpServletRequest request) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		int totalCount = service.pointCount();
		int totalCount = service.pointCount();
		
		PagingUtil pu = new PagingUtil("/admin_body_pointpay_polist.do?"
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<PointVO> adminPointList = service.adminPointList(pu.getStartSeq(), pu.getEndSeq());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTLSIT", adminPointList);
		mav.addObject("LVL_PAGING", html);
		
		mav.setViewName("admin_body_pointpay_polist");
		
		return mav;
	}
	
	@RequestMapping(value = "/admin_body_pointpay_posearchlist.do")
	public ModelAndView adminBodyPointPayPoSearchList(HttpSession session, 
													HttpServletRequest request,
													@RequestParam(value="mid", required=false) String mid
													) {
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
//		int totalCount = service.pointCount();
		int totalCount = service.pointIdSearchCount(mid);
		
		PagingUtil pu = new PagingUtil("/admin_body_pointpay_posearchlist.do?mid="+mid
										, currentPage
										, totalCount  //------------
										, 10	//선택한 2번 블럭에 나타날 게시물 갯수
										, 5 // 1 2 [다음]
										);
		String html = pu.getPagingHtml();
		
		ArrayList<PointVO> adminPointIdSearchList = service.adminPointsearchList11(mid, pu.getStartSeq(), pu.getEndSeq());
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("LVL_POINTLSIT", adminPointIdSearchList);
		mav.addObject("LVL_PAGING", html);
		
		mav.setViewName("admin_body_pointpay_polist");
		
		return mav;
	}
}
