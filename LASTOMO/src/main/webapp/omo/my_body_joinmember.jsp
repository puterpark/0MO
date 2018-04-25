<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
	<button class="btn btn-quaternary mb-2" type="button" style="height:25pt;"
	onclick="location.href='/my_body_joinpointmember.do'">회원가입 했다</button>
	
	<button class="btn btn-quaternary mb-2" type="button" style="height:25pt;"
	onclick="location.href='/gdeletepoint.do'">공모전 삭제 했다</button>
	
	<button class="btn btn-quaternary mb-2" type="button" style="height:25pt;"
	onclick="location.href='/poViewPoint.do'">포폴 상세 보기</button>
	
	<button class="btn btn-quaternary mb-2" type="button" style="height:25pt;"
	onclick="location.href='/gUploadPoint.do'">공모전 등록</button>
	
	<div class="col-lg-9">
		<div class="container">
			<font size="5"><b>인덱스 결제 리스트</b></font>
			<hr class="short">
		</div>
		
		<div class="container">
		<br>
		</div>
			
		<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>ID</th>
						<th>결제 금액</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${LVL_INDEXPAYLIST}" var="ipl">
						<tr>
							<td>${ipl.mseq}</td>
							<td>${ipl.mid}</td>
							<td>${ipl.pamoney}</td>
							<td>${ipl.paregdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	
</div>

