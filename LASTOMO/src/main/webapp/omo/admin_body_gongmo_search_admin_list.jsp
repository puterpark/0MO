<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<section class="page-header">
	<div class="container">
		<div class="row" style="visibility: hidden;">
			<div class="col" >
				<ul class="breadcrumb">
					<li><a href="#">hidden</a></li>
					<li class="active">hidden</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1>공모전</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
				<c:if test="${mseq == 1}">
				<div style="float: right;">
					<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_gongmo_crawl.do'">크롤링</button>
				</div>
				</c:if>
			</div>
			<table class="table table-hover">
				<col style="width: 55%;"></col>
				<col style="width: 20%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 15%;"></col>
				<thead>
					<tr>
						<th>공모전</th>
						<th>주최</th>
						<th>회원</th>
						<th>등록일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
					<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${list.gseq}'" style="cursor:pointer">
						<td>
							<b>${list.gtitle}</b>&nbsp;&nbsp;<i class="fas fa-heart"></i>${alist.lvo.lcnt}
						</td>
						<td>${list.gspon}</td>
						<td>${list.mvo.mid}</td>
						<td>${list.gregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${paging}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="searchGongmo" action="/admin_gongmo_admin_search.do" method="get">
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
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>