<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
	<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			</div>
			<table class="table table-hover">
				<col style="width: 10%;"></col>
				<col style="width: 35%;"></col>
				<col style="width: 35%;"></col>
				<col style="width: 15%;"></col>
				<c:choose>
					<c:when test="${gubun == 'GONGMO'}">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>주최</th>
						<th>등록일자</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach items="${allList}" var="a"  varStatus="i">
					<tr onclick="location.href='/gongmo_detail.do?gseq=${a.gseq}'" style="cursor:pointer">
						<td>${i.index + 1}</td>
						<td>${a.gtitle}</td>
						<td>${a.gspon}</td>
						<td>${a.gregdate}</td>
					</tr>
					</c:forEach>
				</tbody> 
					</c:when>
					
				<c:when test="${gubun == 'SEEK'}">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>등록일자</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach items="${allList}" var="a"  varStatus="i">
					<tr onclick="location.href='/gongmo_detail.do?sseq=${a.sseq}'" style="cursor:pointer">
						<td>${i.index + 1}</td>
						<td >${a.stitle}</td>
						<td>${a.sregdate}</td>
					</tr>
					</c:forEach>
				</tbody> 
					</c:when>
				</c:choose>
					
				
				
			</table>
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${html}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="breportSearch" action="/admin_breport_search.do" method="get">		
					<div class="input-group" style="width: 350px; margin: auto;">
						<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." value="${searchStr}" required>
						<span class="input-group-append">
							<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
						</span>
					</div>
				</form>
			</div>
			
			<hr class="tall">
</div>