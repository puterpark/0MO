
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<section class="page-header">
	<div class="container">
		<div class="row" style="visibility: hidden;">
			<div class="col">
				<ul class="breadcrumb">
					<li><a href="#">hidden</a></li>
					<li class="active">hidden</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1>구인게시판[모셔가요]</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2"
					onclick="javascript:history.back()">«이전</button>
				<div class="header-search d-none d-md-block">
					
				</div>
			</div>
			<table class="table table-hover">
				<col style="width: 5%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 40%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 12%;"></col>
				<col style="width: 13%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>공모전</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="ovo">
						<tr onclick="location.href='/admin_offer_detail.do?oseq=${ovo.oseq}'" style="cursor: pointer">
							<td style="vertical-align: middle;">${ovo.oseq}</td>
							<td style="vertical-align: middle;">${ovo.gtitle}</td>
							<td style="vertical-align: middle;">${ovo.otitle}<br>
							<c:forEach items="${ovo.dlist}" var="dlist">
								<button type="button" class="btn btn-outline btn-light btn-xs mb-2">${dlist.dname}</button>
							</c:forEach>
							</td>
							<td style="vertical-align: middle;">${ovo.mid}</td>
							<td style="vertical-align: middle;">${ovo.oregdate}</td>
							<td style="vertical-align: middle;">${ovo.oview}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr class="short">
			<div style="width: 200px; margin: auto;">${paging}</div>

<form id="searchGongmo" action="page-search-results.html"
						method="get">
						<div class="input-group" style="width: 350px; margin: auto;">
							<input type="text" class="form-control" name="q1" id="q1"
								placeholder="검색어를 입력하세요." required> <span
								class="input-group-append">
								<button class="btn btn-light" type="submit">
									<i class="fas fa-search"></i>
								</button>
							</span>
						</div>
					</form>
		</div>
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>