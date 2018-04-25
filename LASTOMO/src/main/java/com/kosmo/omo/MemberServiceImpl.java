package com.kosmo.omo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.common.PagingUtil;
import com.kosmo.mapper.MemberMapper;
import com.kosmo.vo.DutyVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.LikedVO;
import com.kosmo.vo.MemberAddrVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.OfferVO;
import com.kosmo.vo.SeekVO;
import com.kosmo.vo.ValidationVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	public MemberMapper memberMapper;

	@Override
	public int memberCount() {
		return memberMapper.memberCount();
	}

	@Override
	public int memberReg(MemberVO mvo) {
		return memberMapper.memberReg(mvo);
	}

	//유효성 검사
	@Override
	public int memberValidation(ValidationVO vvo) {
		return memberMapper.memberValidation(vvo.getColumn(), vvo.getValue());
	}


	@Override
	public int memberUpdate(MemberVO mvo) {
		System.out.println("[LOG] Enter MemServicerImpl / memberUpdate()");
		return memberMapper.memberUpdate(mvo);
	}

	@Override
	public int memberAddrUpdate(MemberAddrVO mavo) {
		return memberMapper.memberAddrUpdate(mavo);
	}
	
   @Override
   public MemberVO memberLogin(String mid, String mpw) {
	   System.out.println("[LOG] Enter. MemberServiceImpl / memberLogin(mid, mpw) " );
	  MemberVO mvo = new MemberVO();
      mvo = memberMapper.memberLogin(mid, mpw);
      if(mvo == null){
    	  return null;
      }
      return mvo;
   }

	@Override
	public ArrayList<GongmoVO> memberGongmoList(GongmoVO gvo) {
		return memberMapper.memberGongmoList(gvo);
	}

	@Override
	public ArrayList<OfferVO> memberOfferList(OfferVO ovo) {
		return memberMapper.memberOfferList(ovo);
	}

	@Override
	public ArrayList<SeekVO> memberSeekList(SeekVO svo) {
		return memberMapper.memberSeekList(svo);
	}

	@Override
	public ArrayList<GongmoVO> memberGongmoLike(GongmoVO gvo) {
		return memberMapper.memberGongmoLike(gvo);
	}

	@Override
	public ArrayList<OfferVO> memberOfferLike(OfferVO ovo) {
		return memberMapper.memberOfferLike(ovo);
	}

	@Override
	public ArrayList<SeekVO> memberSeekLike(SeekVO svo) {
		return memberMapper.memberSeekLike(svo);
	}

	@Override
	public int memberLeave(int mseq) {
		return memberMapper.memberLeave(mseq);
	}

	@Override
	public MemberVO memberInfo(int mseq) {
		return memberMapper.memberInfo(mseq);
	}
	
	@Override
	public ArrayList<MemberVO> dutyListCheck(int mseq) {
		System.out.println("[LOG] Enter MemberService / dutyListCheck(int mseq) ");
		ArrayList<MemberVO> list =memberMapper.dutyListCheck(mseq);
		System.out.println("[LOG] Callback dutyListCheck(int mseq) ");
		return list;
	}
	

	@Override
	public int memberAddrInsert(MemberVO mvo) {
		return memberMapper.memberAddrInsert(mvo);
	}

	@Override
	public int memberDutyInsert(int dseq) {
		return memberMapper.memberDutyInsert(dseq);
	}

	@Override
	public ArrayList<DutyVO> dutyList() {
		return memberMapper.dutyList();
	}

	@Override
	public int memberDutyDel(int mseq) {
		return memberMapper.memberDutyDel(mseq);
		
	}

	@Override
	public int memberDutyUpdate(int mseq, int dseq) {
		return memberMapper.memberDutyUpdate(mseq, dseq);
		
	}

	@Override
	public Map<String, Object> memberBoardList(HttpServletRequest request) {
		int mseq = Integer.parseInt(request.getSession().getAttribute("SESS_MSEQ").toString());
		
		int startSeq = 1;
		int endSeq = 5;
		
		ArrayList<GongmoVO> memberGomoList = memberMapper.memberGomoList(startSeq, endSeq, mseq);
		ArrayList<SeekVO> memberSeekList = memberMapper.memberSeekList(startSeq, endSeq, mseq);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("glist", memberGomoList);
		map.put("slist", memberSeekList);
		
		return map;
	}

	@Override
	public Map<String, Object> memberBoardDetail(HttpServletRequest request) {
		
		int mseq = Integer.parseInt(request.getSession().getAttribute("SESS_MSEQ").toString());
		String gubun = request.getParameter("gubun");
		Map<String,Object> map = new HashMap<String,Object>();
		int currentPage = 1;
		
		if(gubun.equals("GONGMO")){
			List<GongmoVO> list = new ArrayList<GongmoVO>();
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}		
			int totRecord = memberMapper.memberGomoAllListCount(mseq);
			PagingUtil pu = new PagingUtil("/userDetail.do?gubun=GONGMO", currentPage, totRecord, 10, 5);
			list = memberMapper.memberGomoList(pu.getStartSeq(), pu.getEndSeq(), mseq);
			String html = pu.getPagingHtml();
			
			System.out.println("공모리스트사이즈: "  + list.size());
			System.out.println("제목: "  + list.get(0).getGtitle());
			map.put("allList", list);
			map.put("html", html);
			map.put("gubun", "GONGMO");
			
			
		} else if(gubun.equals("SEEK")) {
			List<SeekVO> list = new ArrayList<SeekVO>();
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}	
			
			int totRecord = memberMapper.memberSeekAllListCount(mseq);
			PagingUtil pu = new PagingUtil("/userDetail.do?gubun=SEEK", currentPage, totRecord, 10, 5);
			list = memberMapper.memberSeekList(pu.getStartSeq(), pu.getEndSeq(), mseq);
			String html = pu.getPagingHtml();
			
			System.out.println("구직리스트사이즈: "  + list.size());
			System.out.println("제목: "  + list.get(0).getStitle());
			
			map.put("allList", list);
			map.put("html", html);
			map.put("gubun", "SEEK");
			
		} else {
			System.out.println("offer는 아직 구현 안되있음");
		}
		return map;
	}

	@Override
	public int memberSearchCount(String searchStr) {
		return memberMapper.memberSearchCount(searchStr);
	}

	@Override
	public ArrayList<MemberVO> memberList(int startSeq, int endSeq,int mseq) {
		return memberMapper.memberList(startSeq, endSeq, mseq);
	}
	@Override
	public int memberListCount(int mseq){
		return memberMapper.memberListCount(mseq);
				
	}

	@Override
	public ArrayList<MemberVO> memberSearchList(int startSeq, int endSeq, String searchStr) {
		return memberMapper.memberSearchList(startSeq, endSeq, searchStr);
	}

	//좋아요한 글
	@Override
	public Map<String,Object> myLikeList(HttpServletRequest request) {
		int currentPage = 1;
		int mseq = Integer.parseInt(request.getSession().getAttribute("SESS_MSEQ").toString());
		Map<String,Object> map = new HashMap<String,Object>();
		List<LikedVO> list = new ArrayList<LikedVO>();		
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}	
		int totRecord = memberMapper.myLikeListCount(mseq);
		PagingUtil pu = new PagingUtil("/like_list.do?", currentPage, totRecord, 10, 5);
		list = memberMapper.myLikeList(pu.getStartSeq(), pu.getEndSeq(), mseq);
		String html = pu.getPagingHtml();
		System.out.println("++++++++++++"+list.get(0).getGvo().getGtitle());
		
		map.put("likeList", list);
		map.put("html", html);
		
		return map;
	}
	
	
}
