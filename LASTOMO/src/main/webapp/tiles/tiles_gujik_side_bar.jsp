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
				<h1>기다려요</h1>
			</div>
		</div>
	</div>
</section>
<div class="container">
<div class="row">
<div class="col-lg-3">
	<aside class="sidebar" id="sidebar">
		<h4 class="heading-primary"><a class="nav-link" href="/gujik.do">전체보기</a></h4>
		<ul class="nav nav-list flex-column narrow">
			<c:forEach items="${dutyList}" var="dl">
				<li class="nav-item"><a class="nav-link" href="/gujik_duty.do?dseq=${dl.dseq}">${dl.dname}</a></li>				
			</c:forEach>
			
		</ul>
	</aside>
</div>
