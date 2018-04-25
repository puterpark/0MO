package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.*;
import com.kosmo.vo.DutyVO;

@Service
public class DutyServiceImpl implements DutyService{
	
	@Autowired
	private DutyMapper DutyMapper;
	
	@Override
	public ArrayList<DutyVO> DutyList(){
		return DutyMapper.DutyList();
	}
	



}
