<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<c:choose>
	<c:when test="${gvo.mvo.mseq == SESS_MSEQ || SESS_MSEQ == 1}">
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
<script>
	$(function() {
		$(".gongmoBtn").click(function() {
			var gtitle = $("#gtitle").val();
			gtitle = $.trim(gtitle);
			var gspon = $("#gspon").val();
			gspon = $.trim(gspon); 
			var gsday = $("#gsday").val();
			console.log(gsday);
			var geday = $("#geday").val();
			var gbody = $("#gbody").val();
			gbody = $.trim(gbody); 
			var tgsday = gsday.replace(/-/gi, "");
			var tgeday = geday.replace(/-/gi, "");
			var pgsday = Date.parse(gsday);
			var pgeday = Date.parse(geday);
			console.log(tgsday);
			console.log(tgeday);
			
			gsday.replace("")
			
			var val = [];
			var test = [];
			/* var gsday = $("#gsday").val; */
			test = $(":checkbox:checked");
			console.log("바 랭쓰 : " + test.length);
			$("#flength").attr("value", test.length);
			var str = "";
			
			if (gtitle == "") {
				swal("공모명을 입력하세요.");
				$("#gtitle").focus();
			} else if (gspon == "") {
				swal("주최를 입력하세요.");
				$("#gspon").focus();
			} else if (gsday == "" || gsday == null) {
				swal("시작 날짜를 입력하세요.");
				$("#gsday").focus();
			} else if (geday == "") {
				swal("종료 날짜를 입력하세요.");
				$("#geday").focus();
			/* } else if (gsday == "" && (tgeday - tgsday) < 0) {
				swal("접수기간을 확인하세요.");
				$("#gsday").focus(); */
			} else if (pgsday > pgeday) {
				swal("접수기간을 확인하세요.");
				$("#gsday").prop("value", "");
				$("#gsday").focus();
			} else if (gbody == "") {
				swal("공모 요강을 입력하세요.");
				$("#gbody").focus();
			} else if (test.length <= 3 && test.length > 0) {
				$(":checkbox:checked").each(function(i) {
					val[i] = $(this).val();
					/* console.log(val[i]);
					$("#farr").attr("value", val[i]); */
					str += val[i] + ",";
				});
				console.log(str);
				$("#checkbox").val(str);
				console.log("=========="+$("#checkbox").val());
				$(".insertform").submit(); 
			} else {
				swal("분야를 1 ~ 3개로 선택해주세요.");
			}
		});
	});
</script>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2 gongmoBtn" id="gongmoBtn">공모전 수정</button>
				<!-- onclick="location.href='/index.do'" -->
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<section class="card card-admin">
					<div class="card-body">
						<form class="form-horizontal form-bordered insertform" id="insertform" action="/gongmo_update.do" method="post" enctype="multipart/form-data">
							<input type="hidden" name="gseq" value="${gvo.gseq}">
							<input type="hidden" name="gposter" value="${gvo.gposter}">
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">공모명</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="gtitle" name="gtitle" placeholder="공모전 이름을 입력해주세요." value="${gvo.gtitle}" required >
								</div>
							</div>
							<hr class="short">
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">주최</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="gspon" name="gspon" value="${gvo.gspon}" required>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">분야</label>
								<div class="col-lg-6">
									<c:forEach items="${clist}" var="clist">
										<div class="btn-group" data-toggle="buttons">
											<c:choose>
												<c:when test="${clist.gseq ==  gvo.gseq}">
													<label class="btn btn-outline btn-primary active">
												</c:when>
												<c:otherwise>
													<label class="btn btn-outline btn-primary">
												</c:otherwise>
											</c:choose>
												<input type="checkbox" class="form-control field" name="fseq" id="field${clist.fseq}" value="${clist.fseq}" autocomplete="off" style="display: none;">${clist.fname}
											</label>
										</div>
									</c:forEach>
									<input type="hidden" id="checkbox" name="checkbox" value=""> 
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">접수기간</label>
								<div class="col-lg-3">
									<input type="date" class="form-control" id="gsday" name="gsday" value="${gvo.gsday}" required>
								</div>
								<div class="col-lg-3">
									<input type="date" class="form-control" id="geday" name="geday" value="${gvo.geday}" required>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">링크</label>
								<div class="col-lg-6">
									<div class="input-group mb-3">
										<input type="text" class="form-control" id="glink" name="glink" value="${gvo.glink}">
										<!-- <span class="input-group-btn">
											<button class="btn btn-success" type="button" onclick="location.href='/addrsearch.do'">확인</button>
										</span> -->
									</div>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">포스터 등록</label>
								<div class="col-lg-6">
									<div class="fileupload fileupload-new" data-provides="fileupload" style="padding-left: 5px;">
										<div class="input-append">
											<div class="uneditable-input">
												<span class="fileupload-preview"></span>
											</div>
											<span class="btn btn-default btn-file">
												<input type="file" name="ufile">
											</span>
											<br>현재 파일: ${gvo.gposter}
										</div>
									</div>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2" for="textareaDefault">공모요강</label>
								<div class="col-lg-6">
									<textarea class="form-control" rows="15" id="gbody" name="gbody" required>${gvo.gbody}</textarea>
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
				<button type="button" class="btn btn-outline btn-primary mb-2 gongmoBtn" id="insertform">공모전 수정</button>
				<!-- onclick="location.href='/index.do'" -->
			</div>
		</div>
	</div>
	<hr class="tall" style="visibility: hidden;">
</div>
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/error.jsp" %>
	</c:otherwise>
</c:choose>