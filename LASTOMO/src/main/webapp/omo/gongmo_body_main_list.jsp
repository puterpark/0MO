<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div>
				<c:choose>
					<c:when test="${fseq == null}">
						<button type="button" class="btn btn-primary mb-2">전체보기</button>
						<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gongmo_cal.do'">달력으로 보기</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-primary mb-2" style="visibility: hidden;">전체보기</button>
						<button type="button" class="btn btn-outline btn-primary mb-2" style="visibility: hidden;">달력으로 보기</button>
					</c:otherwise>
				</c:choose>
				<!-- <button type="button" class="btn btn-primary mb-2">전체보기</button>
				<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gongmo_cal.do'">달력으로 보기</button> -->
				<c:if test="${not empty SESS_MSEQ}">
				<button type="button" class="btn btn-primary btn-sm mb-2" style="float: right;" onclick="location.href='/gongmo_write_page.do'">글쓰기</button>
				</c:if>
			</div>
			<table class="table table-hover">
				<col style="width: 5%;"></col>
				<col style="width: 50%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 20%;"></col>
				<col style="width: 10%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>공모전</th>
						<th style="text-align: center;">진행상태</th>
						<th style="text-align: center;">진행기간</th>
						<th style="text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="gvo">
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
							</td>
							<td style="vertical-align: middle;">
								<b><font size="3">${gvo.gtitle}</font></b>&nbsp;&nbsp;<i class="fas fa-heart"></i>${gvo.lvo.lcnt}<br>
								${gvo.gspon}<br>
								<c:forEach items="${gvo.flist}" var="flist">
									<button type="button" class="btn btn-outline btn-light btn-xs mb-2">${flist.fname}</button>
								</c:forEach>
							</td>
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
							<td style="text-align: center; vertical-align: middle;">${gvo.gsday}<br>~<br>${gvo.geday}</td>
							<td style="text-align: center; vertical-align: middle;">${gvo.gview}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr class="short">
			<div>
				<c:choose>
					<c:when test="${fseq == null}">
						<button type="button" class="btn btn-primary mb-2">전체보기</button>
						<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gongmo_cal.do'">달력으로 보기</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-primary mb-2" style="visibility: hidden;">전체보기</button>
						<button type="button" class="btn btn-outline btn-primary mb-2" style="visibility: hidden;">달력으로 보기</button>
					</c:otherwise>
				</c:choose>
				<c:if test="${not empty SESS_MSEQ}">
				<button type="button" class="btn btn-primary btn-sm mb-2" style="float: right;" onclick="location.href='/gongmo_write_page.do'">글쓰기</button>
				</c:if>
			</div>
			
			<div style="width: 200px; margin: auto;">
				${paging}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="searchGongmo" action="/gongmo_search.do" method="get">
					<div class="input-group" style="width: 350px; margin: auto;">
						<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." required>
						<span class="input-group-append">
							<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>