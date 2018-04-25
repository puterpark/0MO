<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script>
	$(function() {
		$("#btnOfferEdit").click(function() {
				$("#updateForm").submit(); 
		});
	});
	
</script>

<script>
	$(function() {
		$("#btnOfferEdit2").click(function() {
				$("#updateForm").submit(); 
		});
	});
	
</script>


<script>
	$(function() {
		$("#btnOfferEdit2").click(function() {
			var val = [];
			var test = [];
			test = $(":checkbox:checked");
			console.log("바 랭쓰 : " + test.length);
			$("#flength").attr("value", test.length);
			var str = "";
			if (test.length <= 3 && test.length > 1) {
				$(":checkbox:checked").each(function(i) {
					val[i] = $(this).val();
					str += val[i] + ",";
				});
				console.log(str);
				$("#checkbox").val(str);
				console.log("=========="+$("#checkbox").val());
				$("#updateForm").submit(); 
				
			} else {
				alert("분야를 1 ~ 3개로 선택해주세요.");
			}
		});
	});
	
</script>



<section class="page-header">
	<div class="container">
		<div class="row" style="visibility: hidden;">
			<div class="col">
				<ul class="breadcrumb">
					<li><a href="#">hidden</a></li>
					<li class="active">hidden</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h1>구인게시판[모셔가요] 수정</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2"
				onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2"
					id="btnOfferEdit">수정</button>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<section class="card card-admin">
					<div class="card-body">
						<form class="form-horizontal form-bordered insertform"
							id="updateForm" action="/admin_offer_update.do" method="post">
							<input type="hidden" name="oseq" value="${ovo.oseq}">
							<hr class="short">
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">제목</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="otitle"
										name="otitle" value="${ovo.otitle}" required>
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">준비중인 공모전</label>
								<div class="col-lg-6">
								<select name="gtitle">
								<c:forEach items="${gvo}" var="gvo">
									<option value="${gvo.gseq}">${gvo.gtitle}</option>
									</c:forEach>
								</select>
								</div>
							</div>


							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">필요직무</label>
								<div class="col-lg-6">
									<c:forEach items="${dlist}" var="dlist">
										<div class="btn-group" data-toggle="buttons">
										<c:if test="i"></c:if>
											<c:choose>
												<c:when test="${dlist.oseq ==  ovo.oseq}">
													<label class="btn btn-outline btn-primary active">
													<input type="checkbox" class="form-control field" name="dseq"	id="duty${dlist.dseq}"
														 value="${dlist.dseq}" autocomplete="off" style="display: none;">${dlist.dname}
													</label>
												</c:when>
												<c:otherwise>
													<label class="btn btn-outline btn-primary">
													<input type="checkbox" class="form-control field" name="dseq" id="duty${dlist.dseq}" 
														value="${dlist.dseq}" autocomplete="off" style="display: none;">${dlist.dname}
													</label>
												</c:otherwise>
											</c:choose>
										</div>
									</c:forEach>
									<input type="hidden" id="checkbox" name="checkbox" value="">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2"
									for="textareaDefault">내용</label>
								<div class="col-lg-6">
									<textarea class="form-control" rows="15" id="obody"
										name="obody" required style="resize:none;"> ${ovo.obody} </textarea>
								</div>
							</div>

						</form>
					</div>
				</section>
			</div>
		</div>
		<div style="margin-top: 10px">
			<button type="button" class="btn btn-outline btn-light mb-2"
				onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2 btnOfferEdit2" 
					id="btnOfferEdit2">수정</button>
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