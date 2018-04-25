<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<div class="col-lg-9">
	<div>
		<div>
			<c:if test="${not empty SESS_MSEQ}">
			<button type="button" class="btn btn-primary btn-sm mb-2" style="float: right;" onclick="location.href='/gujik_insert.do'">글쓰기</button>
			</c:if>
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
	</div>
	<table class="table table-hover">
		<col style="width: 5%;"></col>
		<col style="width: 50%;"></col>
		<col style="width: 15%;"></col>
		<col style="width: 20%;"></col>
		<thead>
			<tr>
				<th style="text-align: center;">#</th>
				<th>제목</th>
				<th style="text-align: center;">글쓴이</th>
				<th style="text-align: center;">등록날짜</th>
				<th style="text-align: center;">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${seekAllList}" var="sal">
				<tr 
				<c:if test="${SESS_MSEQ != null}">
				onclick="location.href='/gujik_detail.do?sseq= ${sal.sseq}'"
				</c:if>
					style="cursor: pointer">
					<td style="vertical-align: middle;">${sal.sseq}</td>
					<td style="vertical-align: middle;">${sal.stitle}&nbsp;&nbsp;<i class="fas fa-heart"></i>${sal.lcnt}</td>
					<td style="text-align: center; vertical-align: middle;">${sal.mid}</td>
					<td style="text-align: center; vertical-align: middle;">${sal.sregdate}</td>
					<td style="text-align: center; vertical-align: middle;">${sal.sview}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<hr class="short">
	<div>
		<div>
			<c:if test="${not empty SESS_MSEQ}">
			<button type="button" class="btn btn-primary btn-sm mb-2" style="float: right;" onclick="location.href='/gujik_insert.do'">글쓰기</button>
			</c:if>
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
				<div style="width: 200px; margin: auto;">
				${gujikpaging}
			</div>
			
		<div class="header-search d-none d-md-block">
			<form id="searchGongmo" action="/gujik_search.do" method="get">
				<div class="input-group" style="width: 350px; margin: auto;">
					<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." value="${searchStr}" required>
					<span class="input-group-append">
						<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
					</span>
				</div>
			</form>
		</div>
	</div>

</div>