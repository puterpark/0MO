package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.LikedVO;
import com.kosmo.vo.MemberAddrVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.OfferVO;
import com.kosmo.vo.SeekVO;

@Repository("memberMapper")
public interface MemberMapper {
	public MemberVO memberSearchByID(String mid);
	public int memberDelete(int mid);
	public int memberInsert(MemberVO memberVO);
	public ArrayList<MemberVO> memberList();
	
	/**
	 * 사용유무
	 */
	public int memberLeave(int mseq);
	
	/**
	 *개인 정보 보기 
	 */
	public MemberVO memberInfo(int mseq);
	
	
	/**
	 * 조회수
	 * @return int
	 */
	public int memberCount();
	
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
	public int memberDutyUpdate(@Param("mseq")int mseq, @Param("dseq")int dseq);
	
	
	/**
	 * 주소 추가
	 */
	public int memberAddrUpdate(MemberAddrVO mavo);
	
	
	
	/**
	 * 로그인
	 */
	public MemberVO memberLogin(@Param("mid") String mid, @Param("mpw") String mpw); 
	

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
	
	
	

	public int memberSearchCount(String searchStr);

	public ArrayList<MemberVO> memberList(@Param("startSeq") int startSeq, @Param("endSeq") int endSeq ,@Param("mseq")int mseq);
	
	public int memberListCount(int mseq);
	

	public ArrayList<MemberVO> memberSearchList(int startSeq, int endSeq, String searchStr);
	
	public int memberDutyInsert(int dseq);
	
	public ArrayList<DutyVO> dutyList();

	public ArrayList<GongmoVO> memberGomoList(@Param("startSeq") int startSeq, @Param("endSeq") int endSeq ,@Param("mseq")int mseq);
	public ArrayList<SeekVO> memberSeekList(@Param("startSeq") int startSeq, @Param("endSeq") int endSeq ,@Param("mseq")int mseq);
	public int memberGomoAllListCount(int mseq);
	public int memberSeekAllListCount(int mseq);
	
	//유효성검사
	public int memberValidation(@Param("column") String column, @Param("value")String value);
	
	public ArrayList<LikedVO> myLikeList(@Param("startSeq") int startSeq, @Param("endSeq") int endSeq ,@Param("mseq")int mseq);
	public int myLikeListCount(int mseq);
	
	
}
