package com.kosmo.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kosmo.vo.DutyVO;
import com.kosmo.vo.MemberVO;

@Repository("dutydao")
public interface DutyMapper {
	public ArrayList<DutyVO> DutyList();

}
