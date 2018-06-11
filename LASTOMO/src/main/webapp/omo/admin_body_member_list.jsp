<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script>
	function block(mseq) {
		swal({
			title: "선택한 회원을 차단하겠습니까?",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
		.then((willDelete) => {
			if (willDelete) {
				swal("차단되었습니다.", {
				icon: "success",
			})
			.then(() => {
				document.getElementById(mseq).submit();
			});
			} else {
				swal("취소되었습니다.");
			}
		});
	}
</script>

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
				<h1>회원</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<div style="margin-bottom: 1px">
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
				<div style="float: right;">
					<button type="button" class="btn btn-outline btn-primary mb-2 totalBtn" id="totalBtn" onclick="location.href='/admin_member_list.do'">전체보기</button>
					<!-- onclick="location.href='/index.do'" -->
				</div>
			</div>
			<table class="table table-hover">
				<col style="width: 10%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<col style="width: 15%;"></col>
				<thead>
					<tr>
						<th>#</th>
						<th>ID</th>
						<th>이름</th>
						<th>상태</th>
						<th>가입일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mlist}" var="mlist">
					<tr onclick="block(${mlist.mseq})" style="cursor:pointer">
						<td><form class="blockform${mlist.mseq}" id="${mlist.mseq}" action="/member_delete_toList.do" method="post"><input type="hidden" name="mseq" value="${mlist.mseq}"></form>${mlist.mseq}</td>
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
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${paging}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="searchMember" action="/admin_member_search.do" method="get">
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