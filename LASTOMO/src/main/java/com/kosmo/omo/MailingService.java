package com.kosmo.omo;

import java.util.ArrayList;

import com.kosmo.vo.EmailVO;

public interface MailingService {

	public ArrayList<EmailVO> mailSending();
	public int totalMember();
}
