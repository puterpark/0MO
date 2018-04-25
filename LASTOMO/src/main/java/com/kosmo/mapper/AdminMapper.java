package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.AdminVO;

@Repository("adminMapper")
public interface AdminMapper {

	/**
	 * �α���
	 */
	public AdminVO adminLogin(@Param("aid") String aid,@Param("apw") String apw);
	
	/**
	 *�����ڰ��� 
	 */
	public int adminReg(AdminVO avo);
	
	/**
	 * ������ ���� ����
	 */
	public int adminUpdate(AdminVO avo);
	
	/**
	 * ȸ����Ϻ���
	 */
	public ArrayList<AdminVO> adminMemberList(AdminVO avo);
	
	/**
	 * ������ ��� ����(��������)
	 */
	public ArrayList<AdminVO> adminList(AdminVO avo);
	
	public AdminVO adminAList();
	
	public int adminValidation(@Param("aid") String aid);
	
}
