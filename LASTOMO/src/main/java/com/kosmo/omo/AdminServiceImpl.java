package com.kosmo.omo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.mapper.AdminMapper;
import com.kosmo.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	public AdminMapper adminMapper;

	@Override
	public int adminReg(AdminVO avo) {
		return adminMapper.adminReg(avo);
	}

	@Override
	public int adminUpdate(AdminVO avo) {
		return adminMapper.adminUpdate(avo);
	}

	@Override
	public ArrayList<AdminVO> adminMemberList(AdminVO avo) {
		return adminMapper.adminMemberList(avo);
	}

	@Override
	public ArrayList<AdminVO> adminList(AdminVO avo) {
		return adminMapper.adminList(avo);
	}

	@Override
	public AdminVO adminAList() {
		return adminMapper.adminAList();
	}

	@Override
	public int adminValidation(String aid) {
		System.out.println(aid);
		int res = adminMapper.adminValidation(aid);
		System.out.println("res : impl : " +res);
		return res;
	}

	
	
	
	
	 


}
