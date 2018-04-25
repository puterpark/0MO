<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<div role="main" class="main">
	<hr class="tall">
	<div class="container">
		<div style="visibility: hidden;">히든</div>
		<div class="row counters">
			<div class="col-sm-6 col-lg-3 mb-4 mb-lg-0">
				<div class="counter counter-primary">
					<strong data-to="${gcount}" data-append="+">0</strong>
					<label>총 공모전</label>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3 mb-4 mb-lg-0">
				<div class="counter counter-secondary">
					<strong data-to="${rcount}">0</strong>
					<label>오늘 신고</label>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3 mb-4 mb-sm-0">
				<div class="counter counter-tertiary">
					<strong data-to="${mcount}">0</strong>
					<label>총 회원</label>
				</div>
			</div>
			<div class="col-sm-6 col-lg-3">
				<div class="counter counter-quaternary">
					<strong data-to="${pcount}">0</strong>
					<label>오늘 결제</label>
				</div>
			</div>
		</div>
		<div style="visibility: hidden;"><br></div>
	</div>
	
	<hr class="tall">
	
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_gongmo.do'">최근 공모전</button>
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
					<tr onclick="location.href='/admin_gongmo_detail.do?gseq=${gvo.gseq}'" style="cursor:pointer">
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
								<c:when test="${gvo.gsrday < 0 && gvo.gerday <= 0}">
									<span class="badge badge-warning badge-sm">마감</span>
								</c:when>
								<c:when test="${gvo.gsrday <= 0 && gvo.gerday > 0}">
									<b>D-${gvo.gerday}</b><br><span class="badge badge-primary badge-sm">진행중</span>
								</c:when>
								<c:otherwise>
									<span class="badge badge-success badge-sm">접수예정</span>
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
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_member_list.do'">회원</button>
				<table class="table table-hover">
					<col style="width: 15%;"></col>
					<col style="width: 10%;"></col>
					<col style="width: 20%;"></col>
					<col style="width: 30%;"></col>
					<thead>
						<tr>
							<th>ID</th>
							<th>이름</th>
							<th>상태</th>
							<th>가입일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mlist}" var="mlist">
						<tr>
							<td>${mlist.mid}</td>
							<td>${mlist.mname}</td>
							<td>
							<c:choose>
								<c:when test="${mlist.mdel == 'y'}">
									차단 또는 탈퇴
								</c:when>
								<c:otherwise>
									활동 중
								</c:otherwise>
							</c:choose>
							</td>
							<td>${mlist.mregdate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="col-lg-6 mb-4 mb-lg-0">
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_pay.do'">결제</button>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>결제 금액</th>
							<th>결제일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${iplist}" var="ipl">
							<tr>
								<td>${ipl.mid}</td>
								<td>${ipl.pamoney}</td>
								<td>${ipl.paregdate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		
	<hr class="tall">
	
	<div class="container">
		<div class="row">
			<div class="col-lg-6 mb-4 mb-lg-0">
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_breport_list.do'">신고(게시글)</button>
				<table class="table table-hover">
					<col style="width: 15%;"></col>
					<col style="width: 40%;"></col>
					<col style="width: 30%;"></col>
					<thead>
						<tr>
							<th>구분</th>
							<th>신고 사유</th>
							<th>신고일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${brlist}" var="brlist">
						<tr>
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
							<td>${brlist.brwhy}</td>
							<td>${brlist.brregdate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="col-lg-6 mb-4 mb-lg-0">
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/admin_rreport_list.do'">신고(댓글)</button>
				<table class="table table-hover">
					<col style="width: 60%;"></col>
					<col style="width: 40%;"></col>
					<thead>
						<tr>
							<th>신고 사유</th>
							<th>신고일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rrlist}" var="rrlist">
						<tr>
							<td>${rrlist.rrwhy}</td>
							<td>${rrlist.rrregdate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<hr class="tall">
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>