<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

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
				<h1>구직게시판</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
	
	</div>
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>