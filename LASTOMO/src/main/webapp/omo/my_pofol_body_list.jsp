<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->


<title>구직 글쓰기</title>

<style>
.right-box {
  float: right;
}
</style>
<div class="col-lg-9">

	<div class='right-box'>
				<button type="button" onclick="location.href='/mypofol_insert_view.do'" class="btn btn-primary mb-2" >포트폴리오 작성</button>
					
			</div>		
<table class="table table-hover">
			<col style="width: 5%;"></col>
				<col style="width: 50%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th style="text-align: center;">등록날짜</th>
						<th style="text-align: center;">파일명</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pofollist}" var="pfl">
					<tr>
						<td>${pfl.pfseq}</td>
						<td>${pfl.pftitle}</td>
						<td style="text-align: center;">${pfl.pfregdate}</td>
						<td style="text-align: center;">${pfl.pffile}</td>
					</tr>
				</c:forEach>
	
				</tbody>
			</table>
	<div class='right-box'>
				<button type="button" onclick="location.href='/mypofol_insert_view.do'"
					class="btn btn-primary mb-2" >포트폴리오 작성</button>
			</div>				
					


		
	
			
</div>