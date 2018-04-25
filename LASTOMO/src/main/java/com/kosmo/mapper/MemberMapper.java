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
	 * �������
	 */
	public int memberLeave(int mseq);
	
	/**
	 *���� ���� ���� 
	 */
	public MemberVO memberInfo(int mseq);
	
	
	/**
	 * ��ȸ��
	 * @return int
	 */
	public int memberCount();
	
	/**
	 * ȸ������
	 */
	public int memberReg(MemberVO mvo);
	public int memberAddrInsert(MemberVO mvo);
	
	
	/**
	 * �������� ����
	 */
	public int memberUpdate(MemberVO mvo);
	public ArrayList<MemberVO> dutyListCheck(int mseq);
	public int memberDutyDel(int mseq);
	public int memberDutyUpdate(@Param("mseq")int mseq, @Param("dseq")int dseq);
	
	
	/**
	 * �ּ� �߰�
	 */
	public int memberAddrUpdate(MemberAddrVO mavo);
	
	
	
	/**
	 * �α���
	 */
	public MemberVO memberLogin(@Param("mid") String mid, @Param("mpw") String mpw); 
	

	/**
	 * ���� �� �� ����
	 * ������
	 */
	public ArrayList<GongmoVO> memberGongmoList(GongmoVO gvo);
	
	/**
	 * ���� �� �� ����
	 * ����
	 */
	public ArrayList<OfferVO> memberOfferList(OfferVO ovo);
	
	/**
	 * ���� �� �� ����
	 * ����
	 */
	public ArrayList<SeekVO> memberSeekList(SeekVO svo);
	
	
	/**
	 * ���� ���ƿ� �� �� ����
	 * ������
	 */
	public ArrayList<GongmoVO> memberGongmoLike(GongmoVO gvo);
	
	
	/**
	 * ���� ���ƿ� �� �� ����
	 * ����
	 */
	public ArrayList<OfferVO> memberOfferLike(OfferVO ovo);
	
	
	/**
	 * ���� ���ƿ� �� �� ����
	 * ����
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
	
	//��ȿ���˻�
	public int memberValidation(@Param("column") String column, @Param("value")String value);
	
	public ArrayList<LikedVO> myLikeList(@Param("startSeq") int startSeq, @Param("endSeq") int endSeq ,@Param("mseq")int mseq);
	public int myLikeListCount(int mseq);
	
	
}
