package com.kosmo.omo;

import java.util.ArrayList;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.common.PagingUtil;
import com.kosmo.vo.AdminVO;
import com.kosmo.vo.EmailVO;
import com.kosmo.vo.OfferAllVO;
import com.kosmo.vo.SeekAllVO;

@Controller
public class MailingController {

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MailingService msvc;

	@RequestMapping(value="/sendmailing.do")
	public ModelAndView mail(HttpServletRequest request, HttpServletResponse reponse){

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
		String content = "<img src ='https://postfiles.pstatic.net/MjAxODA1MjRfMjEw/MDAxNTI3MTQ3NjI0NjYw.dqBfbXEH6DonZnjDfBFtODz6L6l6ScCmN6yOtTiEqmsg.zKE5L4ISCMQeFtIzVkUsJCPjk0ua07QRhjUSwRPuyqsg.PNG.me0_2me0/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png?type=w773' > "
				+ "<br>새로운 공모전이 등록되었습니다.<br> 등록 된 공모전의 내용은 웹사이트에서 확인하시기 바랍니다.<br>"
				+ "<b>공모전 확인 바로가기</b> -> http://192.168.0.47/index.do";    // 내용
		
		
		helper.setFrom(new InternetAddress(setfrom, "0MO, 너를 위한 공모"));
		helper.setTo(tomail);
//		helper.setTo("me0_2me0@naver.com");
		helper.setSubject(title); // 메일제목은 생략이 가능하다
		helper.setText("", content);  // 메일 내용
		
		mailSender.send(message);
		}catch (Exception e) {
			System.out.println("....!?");
		}
		
		
		//final MimeMessagePreparator[] preparators = new MimeMessagePreparator[list.size()];


	/*	for(int i=0; i<list.size();){ //보낼 준비 중 
			preparators[i] = new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					ArrayList<EmailVO> list = msvc.mailSending();
					InternetAddress[] emailList = new InternetAddress[list.size()];

					for(int i=0; i<list.size();i++){ //vo로 받았던 메일 주소를 emailList에 String 배열로 담기. 
						emailList[i] = new InternetAddress(list.get(i).getMmail());

					}

					for(int i=0;i<emailList.length ;i++){
						System.out.println(emailList[i]);
					}
					String setfrom = "omo.testservice@gmail.com";         
					InternetAddress tomail[]  = emailList;  // 받는 사람 이메일
					System.out.println("[LOG] tomail에 담긴 값 확인 개념 : "+tomail[0]);
					String title   = "0MO에 새로운 공모전이 등록되었습니다. ";      // 제목
					String content = "새로운 공모전이 등록되었습니다.<br> 등록 된 공모전의 내용은 웹사이트에서 확인하시기 바랍니다.<br>"
							+ "<b>공모전 확인 바로가기</b> -> http://192.168.0.47/index.do";    // 내용

					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					helper.setFrom(new InternetAddress(setfrom, "0MO, 너를 위한 공모"));
					helper.setTo(tomail);
//					helper.setTo("me0_2me0@naver.com");
					helper.setSubject(title); // 메일제목은 생략이 가능하다
					helper.setText("", content);  // 메일 내용
					
					System.out.println("[LOG] ++++++++++!????????? "+helper.getMimeMessage().getContent().toString());
					System.out.println();

					mimeMessage.setRecipients(Message.RecipientType.TO,tomail);

				}
			};

			mailSender.send(preparators);
		}*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index_body_success");
		
		return mav;
	}
	
	@RequestMapping(value="/sendmail.do",method=RequestMethod.GET)
	public String EmailForm(){
		System.out.println("[LOG] sendmail.do _ GET");
		return "index_body_testmail";
	}
	
}