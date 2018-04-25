<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="container">
<div class="row">
<div class="col-lg-3">
	<aside class="sidebar" id="sidebar">
		<h4 class="heading-primary"><a class="nav-link" href="/gongmo.do">전체보기</a></h4>
		<ul class="nav nav-list flex-column narrow">
			<c:forEach items="${flist}" var="fvo">
				<li class="nav-item"><a class="nav-link" href="/gongmo_field.do?fseq=${fvo.fseq}">${fvo.fname}</a></li>
			</c:forEach>
			<!-- <li class="nav-item"><a class="nav-link" href="#">디자인</a></li>
			<li class="nav-item"><a class="nav-link" href="#">광고/마케팅</a></li>
			<li class="nav-item"><a class="nav-link" href="#">문학/시나리오</a></li>
			<li class="nav-item"><a class="nav-link" href="#">영상/UCC/사진</a></li>
			<li class="nav-item"><a class="nav-link" href="#">슬로건/네이밍</a></li>
			<li class="nav-item"><a class="nav-link" href="#">논문/리포트</a></li>
			<li class="nav-item"><a class="nav-link" href="#">캐릭터/만화/게임</a></li>
			<li class="nav-item"><a class="nav-link" href="#">음악/미술/무용</a></li>
			<li class="nav-item"><a class="nav-link" href="#">건축/인테리어</a></li>
			<li class="nav-item"><a class="nav-link" href="#">과학/공학</a></li>
			<li class="nav-item"><a class="nav-link" href="#">취업/창업</a></li>
			<li class="nav-item"><a class="nav-link" href="#">장학금</a></li>
			<li class="nav-item"><a class="nav-link" href="#">전시/페스티발</a></li>
			<li class="nav-item"><a class="nav-link" href="#">봉사활동</a></li>
			<li class="nav-item"><a class="nav-link" href="#">해외</a></li>
			<li class="nav-item"><a class="nav-link" href="#">인턴/정규직 채용</a></li> -->
			
		</ul>
	</aside>
</div>
	
<!-- <div class="col-lg-3">
	<aside class="sidebar" id="sidebar" data-plugin-sticky data-plugin-options="{'minWidth': 991, 'containerSelector': '.container', 'padding': {'top': 110}}">
		<h4 class="heading-primary">Categories</h4>
		<ul class="nav nav-list flex-column mb-4 show-bg-active">
			<li class="nav-item"><a class="nav-link" data-hash data-hash-offset="95" href="#first">First</a></li>
			<li class="nav-item">
				<a class="nav-link" data-hash data-hash-offset="95" href="#second">Second</a>
				<ul>
					<li class="nav-item"><a class="nav-link" data-hash data-hash-offset="95" href="#sub-second-1">Sub Second 1</a></li>
					<li class="nav-item"><a class="nav-link" data-hash data-hash-offset="95" href="#sub-second-2">Sub Second 2</a></li>
				</ul>
			</li>
			<li class="nav-item"><a class="nav-link" data-hash data-hash-offset="95" href="#third">Third</a></li>
		</ul>
	</aside>
</div> -->