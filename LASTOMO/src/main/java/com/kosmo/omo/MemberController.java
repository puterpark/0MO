package com.kosmo.omo;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.MemberAddrVO;
import com.kosmo.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	@Autowired
	private PayService paysvc;


	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(
			@RequestParam(value="mid", required=false) String mid,
			@RequestParam(value="mpw", required=false) String mpw,
			HttpSession session,
			HttpServletRequest request) {

		MemberVO mvo = new MemberVO();
		System.out.println(mid);
		System.out.println("[LOG] : MemberController / login()");
		mvo = memberService.memberLogin(mid, mpw);

		if(mvo!=null){
			session.setAttribute("SESS_MSEQ", mvo.getMseq());
			session.setAttribute("SESS_MEMBERID", mvo.getMid());
			System.out.println(mvo.getMseq());
			System.out.println(mvo.getMid());
		} else {
			System.out.println("로그인이 되지 않았습니다. ");
		}
		String referer = request.getHeader("Referer");
	
		return "redirect:"+referer;
//		return "redirect:/index.do";
	}
	

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {

		session.invalidate();

//		String referer = request.getHeader("Referer");

//		return "redirect:"+referer;
		return "redirect:/index.do";
	}  


	//회원가입 가기전에 들려서 duty 뽑아줌  
	@RequestMapping(value = "/reg_page.do", method = RequestMethod.GET)
	public ModelAndView regPage() {

		ArrayList<DutyVO> dlist = memberService.dutyList();

		ModelAndView mav = new ModelAndView();

		for(int i=0; i<dlist.size(); i++){
			System.out.println(dlist.get(i).getDname());
			System.out.println(dlist.get(i).getDseq());

		}
		mav.addObject("dlist", dlist);
		mav.setViewName("index_body_main_reg");
		return mav;
	}




	//회원가입
	@RequestMapping(value = "/memberjoin.do", method = RequestMethod.POST)
	public String admin(MemberVO mvo) {
		System.out.println("join.do에 들어왔씁니다.");
		memberService.memberReg(mvo);
		memberService.memberAddrInsert(mvo);

		String[] unit = mvo.getCheckbox().split(",");

		for(int i=0; i < unit.length; i++){
			mvo.setDarr(Integer.parseInt(unit[i]));
			memberService.memberDutyInsert(Integer.parseInt(unit[i]));
		}
		int insertJoinPoint = paysvc.insertJoinPoint();
		return "redirect:/index.do";

	}

	//회원정보 보기&수정
	@RequestMapping(value = "/myinfo.do", method = RequestMethod.GET)
	public ModelAndView myinfo(HttpSession session) {
		System.out.println("[LOG] Enter MemberController - ");
		System.out.println(session.getAttribute("SESS_MSEQ"));

		int mseq = Integer.parseInt(session.getAttribute("SESS_MSEQ").toString());
		System.out.println(mseq);

		MemberVO mvo = memberService.memberInfo(mseq);
		ArrayList<DutyVO> dlist = memberService.dutyList();
		ArrayList<MemberVO> clist = memberService.dutyListCheck(mseq);



		ModelAndView mav = new ModelAndView();
		mav.addObject("mvo", mvo);
		mav.addObject("dlist", dlist);
		mav.addObject("clist",clist);
		mav.setViewName("my_body_member_info");
		return mav;
	}


	@RequestMapping(value = "/mupdate.do", method=RequestMethod.POST)
	public String mupdate(MemberVO mvo, HttpSession session) {
		System.out.println("[LOG} : MemverController / mupdate();");
		System.out.println("For Update Mseq : "+session.getAttribute("SESS_MSEQ"));

		int resDuty = 0;

		int delDu = memberService.memberDutyDel(Integer.parseInt(session.getAttribute("SESS_MSEQ").toString()));
		System.out.println("Delete existing Duty information : "+delDu);

		String[] unit = mvo.getCheckbox().split(",");
		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i]);
			mvo.setDarr(Integer.parseInt(unit[i]));
			resDuty =+ memberService.memberDutyUpdate(Integer.parseInt(session.getAttribute("SESS_MSEQ").toString()), Integer.parseInt(unit[i]));
		}

		int res = memberService.memberUpdate(mvo);
		System.out.println("[LOG] : 수정된 정보 수 "+res);
		System.out.println("[LOG] : 추가 된 직무 수 : "+resDuty);

		return "redirect:/myinfo.do";
	}



	@RequestMapping(value = "/mleave.do")
	public String mleave(@RequestParam("mseq") int mseq, HttpSession session) {
		memberService.memberLeave(mseq);
		
		session.invalidate();

		return "redirect:/index.do";
	}

	@RequestMapping(value = "/userList.do", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {

		Map<String, Object> map = memberService.memberBoardList(request);
		ModelAndView mav = new ModelAndView();

		mav.addObject("glist", map.get("glist"));
		mav.addObject("slist", map.get("slist"));
		mav.addObject("olist", map.get("olist"));
		mav.setViewName("my_body_list");

		return mav;
	}

	@RequestMapping(value = "/userDetail.do", method = RequestMethod.GET)
	public ModelAndView allList(HttpServletRequest request) {

		Map<String, Object> map = memberService.memberBoardDetail(request);
		ModelAndView mav = new ModelAndView();

		mav.addObject("allList", map.get("allList"));
		mav.addObject("html", map.get("html"));
		mav.addObject("gubun", map.get("gubun"));
		mav.setViewName("my_body_gm_list");

		return mav;
	}

	@RequestMapping(value = "/myactive.do", method = RequestMethod.GET)
	public ModelAndView mActiveAddr() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("my_body_member_addr2");
		return mav;
	}




	@RequestMapping(value = "/member_addr.do", method = RequestMethod.POST)
	public ModelAndView memberActiveAddr(HttpSession session, MemberAddrVO mavo) {

		mavo.setMseq(Integer.parseInt(session.getAttribute("SESS_MSEQ").toString()));
		
		System.out.println(mavo.getMdetail2());
		memberService.memberAddrUpdate(mavo);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("my_body_member_info");
		return mav;
	}
	
	@RequestMapping(value="/like_list.do")
	public ModelAndView myLikeList(HttpServletRequest request) {
		Map<String,Object> map = memberService.myLikeList(request);
		ModelAndView mav = new ModelAndView();
		System.out.println("라이크한글 뜨고있나여");
		mav.addObject("likeList", map.get("likeList"));
		mav.addObject("html", map.get("html"));
		mav.setViewName("my_body_like");
		return mav;
	}
}
