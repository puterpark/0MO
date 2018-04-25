package com.kosmo.omo;

import java.util.ArrayList;

import com.kosmo.vo.AdminVO;

public interface AdminService {

	
		/**
		 * 회원가입
		 */
		public int adminReg(AdminVO avo);
	
		/**
		 * 관리자정보 수정
		 */
		public int adminUpdate(AdminVO avo);
		
		/**
		 * 회원목록 보기
		 */
		public ArrayList<AdminVO> adminMemberList(AdminVO avo);
		
		/**
		 * 관리자 목록보기(슈퍼전용)
		 */
		public ArrayList<AdminVO> adminList(AdminVO avo);
		
		public AdminVO adminAList();
		
		public int adminValidation(String aid);
		
		
		
		
		
}
