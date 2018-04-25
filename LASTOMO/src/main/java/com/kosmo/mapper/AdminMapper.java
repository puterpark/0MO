package com.kosmo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kosmo.vo.AdminVO;

@Repository("adminMapper")
public interface AdminMapper {

	/**
	 * 로그인
	 */
	public AdminVO adminLogin(@Param("aid") String aid,@Param("apw") String apw);
	
	/**
	 *관리자가입 
	 */
	public int adminReg(AdminVO avo);
	
	/**
	 * 관리자 정보 수정
	 */
	public int adminUpdate(AdminVO avo);
	
	/**
	 * 회원목록보기
	 */
	public ArrayList<AdminVO> adminMemberList(AdminVO avo);
	
	/**
	 * 관리자 목록 보기(슈퍼전용)
	 */
	public ArrayList<AdminVO> adminList(AdminVO avo);
	
	public AdminVO adminAList();
	
	public int adminValidation(@Param("aid") String aid);
	
}
