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
				<h1>구인구직게시판</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_offer.do'"><i class="far fa-check-circle"></i>&nbsp;구인 게시판</button>
			</div>
			<table class="table table-hover">
				<col style="width: 10%;"></col>
				<col style="width: 45%;"></col>
				<col style="width: 25%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th style="width: 150px">글쓴이</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
			
				</tbody>
			</table>
		</div>
		
		<hr class="tall">
		
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_seek.do'"><i class="far fa-user-circle"></i>&nbsp;구직 게시판</button>
			</div>
			<table class="table table-hover">
				<col style="width: 40%;"></col>
				<col style="width: 40%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th style="width: 150px">글쓴이</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>