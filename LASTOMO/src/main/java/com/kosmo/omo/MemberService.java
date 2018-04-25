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
	 * �������
	 * @return int
	 */
	public int memberLeave(int mseq);
	
	public int memberValidation(ValidationVO vvo);

	
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
	public int memberDutyUpdate(int mseq, int dseq);
	
	
	/**
	 * �ּ� �߰�
	 */
	public int memberAddrUpdate(MemberAddrVO mavo);
	
	/**
	 * �α���
	 */
	public MemberVO memberLogin(String mid, String mpw);



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

	
	/**
	 * ������������
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
	
	//���� ���ƿ� �� ��
	public Map<String,Object> myLikeList(HttpServletRequest request);
	
}
