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
				<h1>신고(게시글)</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			</div>
			<table class="table table-hover">
				<col style="width: 10%;"></col>
				<col style="width: 35%;"></col>
				<col style="width: 35%;"></col>
				<col style="width: 15%;"></col>
				<thead>
					<tr>
						<th>구분</th>
						<th>제목</th>
						<th>사유</th>
						<th>신고일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${brlist}" var="brlist">
					<c:choose>
						<c:when test="${brlist.gseq > 0}">
							<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${brlist.gseq}'" style="cursor:pointer">
						</c:when>
						<c:when test="${brlist.oseq > 0}">
							<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${brlist.gseq}'" style="cursor:pointer">
						</c:when>
						<c:when test="${brlist.sseq > 0}">
							<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${brlist.gseq}'" style="cursor:pointer">
						</c:when>
					</c:choose>
						<td>
							<c:choose>
								<c:when test="${brlist.gseq > 0}">
									공모전
								</c:when>
								<c:when test="${brlist.oseq > 0}">
									모셔가요
								</c:when>
								<c:when test="${brlist.sseq > 0}">
									기다려요
								</c:when>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${brlist.gseq > 0}">
									${brlist.gtitle}
								</c:when>
								<c:when test="${brlist.oseq > 0}">
									${brlist.otitle}
								</c:when>
								<c:when test="${brlist.sseq > 0}">
									${brlist.stitle}
								</c:when>
							</c:choose>
						</td>
						<td>${brlist.brwhy}</td>
						<td>${brlist.brregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${paging}
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
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>