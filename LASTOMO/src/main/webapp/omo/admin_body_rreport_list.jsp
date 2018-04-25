<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<script>
	function block(mseq) {
		swal({
			title: "차단각? 되돌릴 수 없습니다.",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
		.then((willDelete) => {
			if (willDelete) {
				swal("앙 차단띠", {
				icon: "success",
			})
			.then(() => {
				document.getElementById(mseq).submit();
			});
			} else {
				swal("살아있네!");
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
				<h1>신고(댓글)</h1>
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
				<col style="width: 30%;"></col>
				<col style="width: 10%;"></col>
				<col style="width: 40%;"></col>
				<col style="width: 20%;"></col>
				<thead>
					<tr>
						<th>신고된 댓글</th>
						<th>댓글 작성자</th>
						<th>신고 사유</th>
						<th>신고일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rrlist}" var="rrlist">
					<tr onclick="block(${rrlist.mseq})" style="cursor:pointer">
						<td>${rrlist.rbody}</td>
						<td><form class="blockform${rrlist.mseq}" id="${rrlist.mseq}" action="/member_delete.do" method="post"><input type="hidden" name="mseq" value="${rrlist.mseq}"></form>${rrlist.mid}</td>
						<td>${rrlist.rrwhy}</td>
						<td>${rrlist.rrregdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${paging}
			</div>
			
			<div class="header-search d-none d-md-block">
				<form id="rreportSearch" action="/admin_rreport_search.do" method="get">		
					<div class="input-group" style="width: 350px; margin: auto;">
						<input type="text" class="form-control" name="searchStr" id="searchStr" placeholder="검색어를 입력하세요." required>
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