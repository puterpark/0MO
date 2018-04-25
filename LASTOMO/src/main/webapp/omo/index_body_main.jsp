<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<div role="main" class="main">
	<div class="container">
		<hr class="tall">
		<div class="row">
			<div class="col-12">
				<div class="owl-carousel owl-theme show-nav-hover" data-plugin-options="{'items': 6, 'margin': 10, 'loop': true, 'nav': true, 'dots': false, 'autoplay': true, 'autoplayTimeout': 3000}">
					<c:forEach items="${list}" var="list">
						<div>
							<c:choose>
								<c:when test="${list.gposter == null}">
									<img alt="" class="img-fluid rounded" src="/uploads/gposter/noImage.png" width="500px">
								</c:when>
								<c:otherwise>
									<img alt="" class="img-fluid rounded" src="${list.gposter}" width="500px">
								</c:otherwise>
							</c:choose>	
							<%-- <img alt="" class="img-fluid rounded" src="${list.gposter}"> --%>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<hr class="tall">
	
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gongmo.do'">최근 공모전</button>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>공모전</th>
						<th>주최</th>
						<th style="text-align: center; vertical-align: middle;">진행상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${glist}" var="gvo">
					<tr onclick="location.href='/gongmo_detail.do?gseq=${gvo.gseq}'" style="cursor:pointer">
						<td style="vertical-align: middle;">
							<c:choose>
								<c:when test="${gvo.mvo.mseq == 1}">
									<i class="far fa-check-circle"></i>
								</c:when>
								<c:otherwise>
									<i class="far fa-user-circle"></i>
								</c:otherwise>
							</c:choose>
							<b>${gvo.gtitle}</b>&nbsp;&nbsp;<i class="fas fa-heart"></i>${gvo.lvo.lcnt}
						</td>
						<td style="vertical-align: middle;">${gvo.gspon}</td>
						<td style="text-align: center; vertical-align: middle;">
							<c:choose>
								<c:when test="${gvo.gsrday < 0 && gvo.gerday < 0}">
									<span class="badge badge-warning badge-sm">마감</span>
								</c:when>
								<c:when test="${gvo.gsrday > 0 && gvo.gerday > 0}">
									<span class="badge badge-success badge-sm">접수예정</span>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${gvo.gerday == 0}">
											<b>D-DAY</b><br><span class="badge badge-primary badge-sm">진행중</span>
										</c:when>
										<c:otherwise>
											<b>D-${gvo.gerday}</b><br><span class="badge badge-primary badge-sm">진행중</span>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<hr class="tall">
	
	<div class="container">
		<div class="row">
			<div class="col-lg-6 mb-4 mb-lg-0">
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/guin.do'">최근 모셔가요</button>
				<table class="table table-hover">
					<col style="width: 10%;">
					<col style="width: 50%;">
					<col style="width: 10%;">
					<col style="width: 20%;">
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
							<th style="width: 150px">ID</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${offerAllList}" var="offer"  begin="${fn:length(offerAllList)- fn:length(offerAllList)}" end="${fn:length(offerAllList)- (fn:length(offerAllList)-2)}">
							
							<tr
							 <c:if test="${SESS_MSEQ != null}">
							onclick="location.href='/guin_detail.do?oseq= ${offer.oseq}'" 
							</c:if>
							style="cursor:pointer">
							
								<td>${offer.oseq}</td>
								<td>${offer.otitle} &nbsp;&nbsp;<i class="fas fa-heart"></i>${offer.lcnt}</td>
								<td>${offer.mid}</td>
								<td>${offer.oregdate}</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="col-lg-6 mb-4 mb-lg-0">
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gujik.do'">최근 기다려요</button>
				<table class="table table-hover">
					<col style="width: 10%;">
					<col style="width: 50%;">
					<col style="width: 10%;">
					<col style="width: 20%;">
					<thead>
						<tr>
							<th>#</th>
							<th>제목</th>
							<th style="width: 150px">ID</th>
							<th>등록날짜</th>
						</tr>
					</thead>
					<c:forEach items="${seekAllList}" var="sal"  begin="${fn:length(seekAllList)- fn:length(seekAllList)}" end="${fn:length(seekAllList)- (fn:length(seekAllList)-2)}">
					
							<tr 
							<c:if test="${SESS_MSEQ != null}">
							onclick="location.href='/gujik_detail.do?sseq=${sal.sseq}'"
							</c:if>
							style="cursor:pointer">
							
								<td>${sal.sseq}</td>
								<td>${sal.stitle} &nbsp;&nbsp;<i class="fas fa-heart"></i>${sal.lcnt}</td>
								<td>${sal.mid}</td>
								<td>${sal.sregdate}</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<hr class="tall">
</div>