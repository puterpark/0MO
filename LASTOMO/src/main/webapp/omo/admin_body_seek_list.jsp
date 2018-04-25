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
				<h1>구직게시판[기다려요]</h1>
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
				<col style="width: 50%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 10%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var ="seekvo">
					<tr onclick="location.href='/admin_seek_detail.do?sseq=${seekvo.sseq}'" style="cursor:pointer">
						<td style="vertical-align: middle;"> ${seekvo.sseq}	</td>
						<td style="vertical-align: middle;">${seekvo.stitle}</td>
						<td style="vertical-align: middle;">${seekvo.mid}</td>
						<td style="vertical-align: middle;">${seekvo.sregdate}</td>
						<td style="vertical-align: middle;">${seekvo.sview}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



				<div style="width: 200px; margin: auto;">
				${seekpaging}
			</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>