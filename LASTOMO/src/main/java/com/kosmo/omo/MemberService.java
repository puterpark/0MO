package com.kosmo.omo;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.MemberAddrVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.OfferVO;
import com.kosmo.vo.SeekVO;
import com.kosmo.vo.ValidationVO;

public interface MemberService{

	
	/**
	 * 사용유무
	 * @return int
	 */
	public int memberLeave(int mseq);
	
	public int memberValidation(ValidationVO vvo);

	
	/**
	 * 회원가입
	 */
	public int memberReg(MemberVO mvo);
	public int memberAddrInsert(MemberVO mvo);
	
	/**
	 * 개인정보 수정
	 */
	public int memberUpdate(MemberVO mvo);
	public ArrayList<MemberVO> dutyListCheck(int mseq);
	public int memberDutyDel(int mseq);
	public int memberDutyUpdate(int mseq, int dseq);
	
	
	/**
	 * 주소 추가
	 */
	public int memberAddrUpdate(MemberAddrVO mavo);
	
	/**
	 * 로그인
	 */
	public MemberVO memberLogin(String mid, String mpw);



	/**
	 * 내가 쓴 글 보기
	 * 공모전
	 */
	public ArrayList<GongmoVO> memberGongmoList(GongmoVO gvo);
	
	/**
	 * 내가 쓴 글 보기
	 * 구인
	 */
	public ArrayList<OfferVO> memberOfferList(OfferVO ovo);
	
	/**
	 * 내가 쓴 글 보기
	 * 구직
	 */
	public ArrayList<SeekVO> memberSeekList(SeekVO svo);
	
	/**
	 * 내가 좋아요 한 글 보기
	 * 공모전
	 */
	public ArrayList<GongmoVO> memberGongmoLike(GongmoVO gvo);
	
	/**
	 * 내가 좋아요 한 글 보기
	 * 구인
	 */
	public ArrayList<OfferVO> memberOfferLike(OfferVO ovo);
	
	/**
	 * 내가 좋아요 한 글 보기
	 * 구직
	 */
	public ArrayList<SeekVO> memberSeekLike(SeekVO svo);

	
	/**
	 * 개인정보보기
	 */
	public MemberVO memberInfo(int mseq);
	

	public int memberDutyInsert(int dseq);
	
	
	ArrayList<DutyVO> dutyList();
	
	public Map<String,Object> memberBoardList(HttpServletRequest request);	
	public Map<String,Object> memberBoardDetail(HttpServletRequest request);
	
	
	
	public int memberCount();

	public int memberSearchCount(String searchStr);

	public ArrayList<MemberVO> memberList(int startSeq, int endSeq, int mseq);
	
	public int memberListCount(int mseq);

	public ArrayList<MemberVO> memberSearchList(int startSeq, int endSeq, String searchStr);
	
	//내가 좋아요 한 글
	public Map<String,Object> myLikeList(HttpServletRequest request);
	
}
