package com.kosmo.omo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.GongmoMapper;
import com.kosmo.vo.AdminVO;
import com.kosmo.vo.BreportVO;
import com.kosmo.vo.EmailVO;
import com.kosmo.vo.FieldVO;
import com.kosmo.vo.GongmoVO;
import com.kosmo.vo.MemberVO;
import com.kosmo.vo.RreportVO;

@Service
public class GongmoServiceImpl implements GongmoService {

	@Autowired
	private GongmoMapper dao;
	
	/* 메일링서비스로 인해 넣어 둡니다. 둡둡. */
	
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MailingService msvc;
	
	
	@Override
	public int breportCount() {
		return dao.breportCount();
	}

	@Override
	public int rreportCount() {
		return dao.rreportCount();
	}

	@Override
	public int memberCount() {
		return dao.memberCount();
	}

	@Override
	public int gongmoCount() {
		return dao.gongmoCount();
	}
	
	@Override
	public int gongmoFieldCount(int fseq) {
		return dao.gongmoFieldCount(fseq);
	}

	@Override
	public int gongmoSearchCount(String searchStr) {
		return dao.gongmoSearchCount(searchStr);
	}

	@Override
	public Map<String, Object> indexPage() {
		
		ArrayList<GongmoVO> glist = dao.gongmoListFive();
		ArrayList<GongmoVO> list = dao.gongmoList(1, 10);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("glist", glist);
		map.put("list", list);
		
		return map;
	}
	
	@Override
	public ArrayList<GongmoVO> gongmoListFive() {
		return dao.gongmoListFive();
	}

	@Override
	public ArrayList<GongmoVO> gongmoList(int sseq, int eseq) {
		ArrayList<GongmoVO> list = dao.gongmoList(sseq, eseq);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = dao.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}
		
		return list;
	}
	
	@Override
	public ArrayList<GongmoVO> gongmoListField(int fseq, int sseq, int eseq) {
		ArrayList<GongmoVO> list = dao.gongmoListField(fseq, sseq, eseq);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = dao.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}
		
		return list;
	}

	@Override
	public ArrayList<FieldVO> gongmoField(int gseq) {
		// TODO Auto-generated method stub
		return dao.gongmoField(gseq);
	}

	@Override
	public ArrayList<GongmoVO> gongmoListSearch(int sseq, int eseq, String searchStr) {
		ArrayList<GongmoVO> list = dao.gongmoListSearch(sseq, eseq, searchStr);
		
		for(int i = 0; i < list.size(); i++) {
			ArrayList<FieldVO> tempList = dao.gongmoField(list.get(i).getGseq());
			list.get(i).setFlist(tempList);
		}
		
		return list;
	}
	
	@Override
	public ArrayList<GongmoVO> gongmoCal() {
		ArrayList<GongmoVO> list = new ArrayList<GongmoVO>();
		list = dao.gongmoCal();
		return list;
	}
	
	@Override
	public GongmoVO gongmoDetail(int gseq) {
		GongmoVO gvo = new GongmoVO();
		
		gvo = dao.gongmoDetail(gseq);
		ArrayList<FieldVO> tempList = dao.gongmoField(gseq);
		gvo.setFlist(tempList);
		
		dao.gongmoViewUp(gseq);
		
		return gvo; 
	}

	@Override
	public int gongmoInsert(GongmoVO gvo) {
		return dao.gongmoInsert(gvo);
	}

	@Override
	public int adminGongmoInsert(GongmoVO gvo) {
		
		try{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			ArrayList<EmailVO> list = msvc.mailSending(); // DB에서 주소 가져오기
			InternetAddress[] emailList = new InternetAddress[list.size()]; //메일주소로 변환

			for(int i=0; i<list.size();i++){ //메일 주소를 emailList에 String 배열로 담기. 
				emailList[i] = new InternetAddress(list.get(i).getMmail());
				System.out.println(emailList[i]);
			}

			String setfrom = "omo.testservice@gmail.com";         
			InternetAddress tomail[]  = emailList;  // 받는 사람 이메일
			System.out.println("[LOG] tomail에 담긴 값 확인 개념 : "+tomail[0]);
			String title   = "0MO에 새로운 공모전이 등록되었습니다. ";      // 제목
			String content = "<img src ='https://postfiles.pstatic.net/MjAxODA1MjRfMjEw/MDAxNTI3MTQ3NjI0NjYw.dqBfbXEH6DonZnjDfBFtODz6L6l6ScCmN6yOtTiEqmsg.zKE5L4ISCMQeFtIzVkUsJCPjk0ua07QRhjUSwRPuyqsg.PNG.me0_2me0/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png?type=w773' style='width:186px;height:150px;' > "
					+ "<hr><br>새로운 공모전이 등록되었습니다.<br> 등록 된 공모전의 내용은 웹사이트에서 확인하시기 바랍니다.<br>"
					+ "<b>공모전 확인 바로가기</b> -> http://192.168.0.5/index.do";    // 내용
			
			
			helper.setFrom(new InternetAddress(setfrom, "0MO, 너를 위한 공모","UTF-8"));
			helper.setTo(tomail);

			helper.setSubject(title); // 메일제목은 생략이 가능하다
			helper.setText("", content);  // 메일 내용
			
			mailSender.send(message);
			}catch (Exception e) {
				System.out.println("....!?");
			}
		
		
		return dao.adminGongmoInsert(gvo);
	}

	@Override
	public int gongmoFieldInsert(int fseq) {
		return dao.gongmoFieldInsert(fseq);
	}
	
	@Override
	public int gongmoFieldUpdate(int gseq, int fseq) {
		return dao.gongmoFieldUpdate(gseq, fseq);
	}

	@Override
	public int gongmoUpdate(GongmoVO gvo) {
		return dao.gongmoUpdate(gvo);
	}
	
	@Override
	public int gongmoUpdateForPoster(GongmoVO gvo) {
		return dao.gongmoUpdateForPoster(gvo);
	}

	@Override
	public int gongmoFieldDelete(int gseq) {
		return dao.gongmoFieldDelete(gseq);
	}
	
	@Override
	public int gongmoDelete(int gseq) {
		return dao.gongmoDelete(gseq);
	}

	@Override
	public int gongmoViewUp(int gseq) {
		return dao.gongmoViewUp(gseq);
	}

	@Override
	public int gongmoLike(int gseq, int mseq, int lcnt) {
		return dao.gongmoLike(gseq, mseq, lcnt);
	}

	@Override
	public int adminGongmoCount() {
		return dao.adminGongmoCount();
	}

	@Override
	public int userGongmoCount() {
		return dao.userGongmoCount();
	}
	
	@Override
	public int adminGongmoSearchCount(String searchStr) {
		return dao.adminGongmoSearchCount(searchStr);
	}

	@Override
	public int userGongmoSearchCount(String searchStr) {
		return dao.userGongmoSearchCount(searchStr);
	}

	@Override
	public ArrayList<GongmoVO> adminGongmoListFive() {
		return dao.adminGongmoListFive();
	}

	@Override
	public ArrayList<GongmoVO> userGongmoListFive() {
		return dao.userGongmoListFive();
	}

	@Override
	public ArrayList<GongmoVO> adminGongmoList(int sseq, int eseq) {
		return dao.adminGongmoList(sseq, eseq);
	}

	@Override
	public ArrayList<GongmoVO> userGongmoList(int sseq, int eseq) {
		return dao.userGongmoList(sseq, eseq);
	}

	@Override
	public ArrayList<GongmoVO> adminGongmoListSearch(int sseq, int eseq, String searchStr) {
		return dao.adminGongmoListSearch(sseq, eseq, searchStr);
	}

	@Override
	public ArrayList<GongmoVO> userGongmoListSearch(int sseq, int eseq, String searchStr) {
		return dao.userGongmoListSearch(sseq, eseq, searchStr);
	}

	@Override
	public ArrayList<FieldVO> fieldList() {
		return dao.fieldList();
	}
	
	@Override
	public ArrayList<GongmoVO> fieldListCheck(int gseq) {
		return dao.fieldListCheck(gseq);
	}

	@Override
	public int fieldInsert(FieldVO fvo) {
		return dao.fieldInsert(fvo);
	}

	@Override
	public int fieldUpdate(FieldVO fvo) {
		return dao.fieldUpdate(fvo);
	}

	@Override
	public int gongmoReport(BreportVO brvo) {
		return dao.gongmoReport(brvo);
	}


	@Override
	public int breportListCount() {
		return dao.breportListCount();
	}

	@Override
	public ArrayList<BreportVO> breportList(int sseq, int eseq) {
		return dao.breportList(sseq, eseq);
	}

	@Override
	public int breportSearchListCount(String searchStr) {
		return dao.breportSearchListCount(searchStr);
	}

	@Override
	public ArrayList<BreportVO> breportSearchList(int startSeq, int endSeq, String searchStr) {
		return dao.breportSearchList(startSeq, endSeq, searchStr);
	}

	@Override
	public int rreportListCount() {
		return dao.rreportListCount();
	}

	@Override
	public ArrayList<RreportVO> rreportList(int startSeq, int endSeq) {
		return dao.rreportList(startSeq, endSeq);
	}
	
	@Override
	public int rreportSearchListCount(String searchStr) {
		return dao.rreportSearchListCount(searchStr);
	}

	@Override
	public ArrayList<RreportVO> rreportSearchList(int startSeq, int endSeq, String searchStr) {
		return dao.rreportSearchList(startSeq, endSeq, searchStr);
	}

	@Override
	public int memberDelete(int mseq) {
		return dao.memberDelete(mseq);
	}

	@Override
	public int memberSearchCount(String searchStr) {
		return dao.memberSearchCount(searchStr);
	}

	@Override
	public ArrayList<MemberVO> memberList(int startSeq, int endSeq) {
		return dao.memberList(startSeq, endSeq);
	}

	@Override
	public ArrayList<MemberVO> memberSearchList(int startSeq, int endSeq, String searchStr) {
		// TODO Auto-generated method stub
		return dao.memberSearchList(startSeq, endSeq, searchStr);
	}

	@Override
	public int adminListCount() {
		return dao.adminListCount();
	}

	@Override
	public ArrayList<AdminVO> adminList(int startSeq, int endSeq) {
		return dao.adminList(startSeq, endSeq);
	}

	@Override
	public int adminSearchListCount(String searchStr) {
		return dao.adminSearchListCount(searchStr);
	}

	@Override
	public ArrayList<AdminVO> adminSearchList(int startSeq, int endSeq, String searchStr) {
		return dao.adminSearchList(startSeq, endSeq, searchStr);
	}

	@Override
	public AdminVO adminDetail(int aseq) {
		return dao.adminDetail(aseq);
	}

	@Override
	public int adminGradeUp(int aseq) {
		return dao.adminGradeUp(aseq);
	}

	@Override
	public int adminGradeDown(int aseq) {
		return dao.adminGradeDown(aseq);
	}

	@Override
	public int adminAckOn(int aseq) {
		return dao.adminAckOn(aseq);
	}

	@Override
	public int adminAckOff(int aseq) {
		return dao.adminAckOff(aseq);
	}
	
	
	/* Admin 가입*/
	@Override
	public int adminJoin(AdminVO avo) {
		return dao.adminJoin(avo);
	}

	@Override
	public AdminVO adminLogin(String aid, String apw) {
		AdminVO avo = new AdminVO();
		avo = dao.adminLogin(aid, apw);
		return avo;
	}

	@Override
	public int adminLeave(int aseq) {
		return dao.adminLeave(aseq);
	}

	@Override
	public int likeInfo(int mseq, String column, int value) {
		return dao.likeInfo(mseq, column, value);
	}
	
	

}
