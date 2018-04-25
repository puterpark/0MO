<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script>
	$(function() {
		$("#btnSeekEdit").click(function() {
				$("#updateForm").submit(); 
		});
	});
	
</script>

<script>
	$(function() {
		$("#btnSeekEdit2").click(function() {
				$("#updateForm").submit(); 
		});
	});
	
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
				<h1>구직게시판[기다려요] 수정</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2" id="btnSeekEdit">수정</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<section class="card card-admin">
					<div class="card-body">
						<form class="form-horizontal form-bordered insertform" id="updateForm" action="/admin_seek_update.do" method="post">
							<input type="hidden" name="sseq" value="${svo.sseq}">
							<hr class="short">
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">제목</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="stitle" name="stitle" value="${svo.stitle}" required>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2" for="textareaDefault">내용</label>
								<div class="col-lg-6">
									<textarea class="form-control" rows="15" id="sbody" name="sbody"  required> ${svo.sbody} </textarea>
								</div>
							</div>
							
						</form>
					</div>
				</section>
			</div>
		</div>
		<div style="margin-top: 10px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2" id="btnSeekEdit2">수정</button>
			</div>
		</div>
	</div>
	<hr class="tall" style="visibility: hidden;">
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>