package com.kosmo.omo;

import java.util.ArrayList;

import com.kosmo.vo.AdminVO;

public interface AdminService {

	
		/**
		 * ȸ������
		 */
		public int adminReg(AdminVO avo);
	
		/**
		 * ���������� ����
		 */
		public int adminUpdate(AdminVO avo);
		
		/**
		 * ȸ����� ����
		 */
		public ArrayList<AdminVO> adminMemberList(AdminVO avo);
		
		/**
		 * ������ ��Ϻ���(��������)
		 */
		public ArrayList<AdminVO> adminList(AdminVO avo);
		
		public AdminVO adminAList();
		
		public int adminValidation(String aid);
		
		
		
		
		
}
