<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<c:choose>
	<c:when test="${SESS_MSEQ != null}">
<script>
	$(function() {
		$("#btnOfferUpdate").click(function() {
			var val = [];
			var test = [];
			var a = $("#gtitle option:selected").val();
			console.log(a);
			$('#gseq').val(a);
			
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
				$("#editForm").submit(); 
				
			} else {
				alert("분야를 1 ~ 3개로 선택해주세요.");
			}
		});
	});
	
</script>

		<div class="col-lg-9">
			<div class="container">
				<div style="margin-bottom: 1px">

					<div style="float: right;"></div>
				</div>
				<div class="row">
					<div class="col">
						<section class="card card-admin">
							<div class="card-body">
								<form class="form-horizontal form-bordered insertform"
									id="editForm" action="/guin_update.do" method="post">
									<hr class="short">
									<div class="form-group row">
										<input type="hidden" id="oseq" name="oseq" value="${ovo.oseq}">
										<label class="col-lg-3 control-label text-lg-right pt-2">제목</label>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="otitle"
												name="otitle" value="${ovo.otitle}" required>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2">준비중인
											공모전</label>
										<div class="col-lg-6">
											<select name="gtitle" id="gtitle">
												<c:forEach items="${glist}" var="glist">
													<option value="${glist.gseq}">${glist.gtitle}</option>
												</c:forEach>
											</select>
												<input type="hidden" id="gseq" name="gseq" value="">
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
										<div class="col-lg-9">
											<textarea class="form-control" rows="15" id="obody"
												name="obody" required style="resize:none;" > ${ovo.obody} </textarea>
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
						<button type="button"
							class="btn btn-outline btn-primary mb-2 btnOfferEdit2"
							id="btnOfferUpdate">수정</button>
					</div>
				</div>
			</div>
			<hr class="tall" style="visibility: hidden;">
		</div>
		</c:when>
	<c:otherwise>
	<%@ include file="/tiles/side_body_error.jsp" %>
	</c:otherwise>
</c:choose>