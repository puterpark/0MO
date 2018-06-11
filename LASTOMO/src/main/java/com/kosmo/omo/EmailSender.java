package com.kosmo.omo;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.kosmo.vo.EmailVO;

@Component
public class EmailSender {

	private JavaMailSender mailSender;
	public void sendEmail(EmailVO evo){

		try {
			MimeMessage msg = mailSender.createMimeMessage();

			msg.setSubject(evo.getSubject());
			msg.setText(evo.getContents());
			msg.setRecipient(RecipientType.TO, new InternetAddress(evo.getReceiver()));			

			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}