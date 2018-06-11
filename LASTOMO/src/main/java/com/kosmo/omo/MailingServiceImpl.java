package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.MailingMapper;
import com.kosmo.vo.EmailVO;

@Service
public class MailingServiceImpl implements MailingService {

	@Autowired
	private MailingMapper maildao;
	
	@Override
	public ArrayList<EmailVO> mailSending() {
		
		ArrayList<EmailVO> vo = maildao.mailsending();
		System.out.println("[LOG]      "+vo.get(1).getMmail());
		
		return maildao.mailsending();
	}

	@Override
	public int totalMember() {

		return 0;
	}

}