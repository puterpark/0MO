<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
	<div class="right-box">
		<c:if test="${not empty SESS_MSEQ}">
		<button type="button" class="btn btn-primary btn-sm mb-2" style="float: right;" onclick="location.href='//guin_insert.do'">글쓰기</button>
		</c:if>
	</div>
	<table class="table table-hover">
		
		<col style="width: 30%;"></col>
		<col style="width: 40%;"></col>
		<col style="width: 10%;"></col>
		<col style="width: 12%;"></col>
		<col style="width: 13%;"></col>
		<thead>
			<tr>
				<th style="text-align: center;">공모전</th>
				<th style="text-align: center;">제목</th>
				<th style="text-align: center;">글쓴이</th>
				<th style="text-align: center;">등록일자</th>
				<th style="text-align: center;">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ovo">
				<tr onclick="location.href='/guin_detail.do?oseq=${ovo.oseq}'"
					style="cursor: pointer">
					<td style="vertical-align: middle;">${ovo.gtitle}</td>
					<td style="vertical-align: middle;">${ovo.otitle}<br> <c:forEach
							items="${ovo.dlist}" var="dlist">
							<button type="button"
								class="btn btn-outline btn-light btn-xs mb-2">${dlist.dname}</button>
						</c:forEach>
					</td>
					<td style="vertical-align: middle; text-align: center;">${ovo.mid}</td>
					<td style="vertical-align: middle; text-align: center;">${ovo.oregdate}</td>
					<td style="vertical-align: middle; text-align: center;">${ovo.oview}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr class="short">
	<div style="width: 200px; margin: auto;">${guinpaging}</div>

				<form id="searchGongmo" action="/guin_search.do" method="get">
					<div class="input-group" style="width: 350px; margin: auto;">
						<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." value="${searchStr}" required>
						<span class="input-group-append">
							<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
						</span>
					</div>
				</form>
</div>