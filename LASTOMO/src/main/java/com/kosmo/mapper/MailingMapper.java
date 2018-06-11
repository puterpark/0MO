package com.kosmo.mapper;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

 

import com.kosmo.vo.EmailVO;
@Repository("maildao")

public interface MailingMapper {
	public ArrayList<EmailVO> mailsending();
	public int totalMember();

}