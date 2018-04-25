<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<!DOCTYPE html>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_MSEQ != null}">



<div class="col-12 mb-4 mb-lg-0">

<script>
	/* $(function() {
		$("#gujikBtn").click(function() {
			var val = [];
			var test = [];
			var gsday = $("#gsday").val;
			test = $(":checkbox:checked");
			console.log("바 랭쓰 : " + test.length);
			$("#flength").attr("value", test.length);
			var str = "";
			if (test.length <= 3 && test.length > 1) {
				$(":checkbox:checked").each(function(i) {
					val[i] = $(this).val();
					/* console.log(val[i]);
					$("#farr").attr("value", val[i]); 
					str += val[i] + ",";
				});
				console.log(str);
				$("#checkbox").val(str);
				console.log("=========="+$("#checkbox").val());
				$("#babo").submit(); 
				
			} else {
				alert("분야를 1 ~ 3개로 선택해주세요.");
			}
		});
	}); */
	
</script>

<script type="text/javascript">
	function insertCoin() {
		$("#coin").submit();
	}
</script>

<br>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<button type="button" class="btn btn-outline btn-primary mb-2" id="gujikBtn" onclick="insertCoin()">게시글 등록</button>
				<!-- onclick="location.href='/index.do'" -->
			</div>
		</div>
<br>
<br>
		
		<div class="row">
			<div class="col">
				<section class="card card-admin">
					<div class="card-body">
						<form id="coin" action="/gujik_insert2.do" method="post">
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">제목</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="stitle" name="stitle" placeholder="제목을 입력해주세요." required>
								</div>
							</div>
							<hr class="short">
							
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">포트폴리오</label>
								<div class="col-lg-6">
									<div class="input-group mb-3">
									<select class="form-control form-control-lg mb-3" name="pfseq">
													<option value=-1>선택 안함</option>
												<c:if test="${fn:length(pofollist)> 0}">
													<c:forEach items="${pofollist}" var="pfl">
													<option value="${pfl.pfseq}">${pfl.pftitle}</option>
													</c:forEach>
												</c:if>
												</select>
									</div>
								</div>
							</div>
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2" for="textareaDefault">내용</label>
								<div class="col-lg-6">
									<textarea class="form-control" rows="15" id="sbody" name="sbody" required></textarea>
								</div>
							</div>
							
						</form>
					</div>
				</section>
			</div>
		</div>
	</div>
	<hr class="tall" style="visibility: hidden;">
</div>
</div>
	</c:when>
	<c:otherwise>
	<%@ include file="/tiles/error.jsp" %>
	</c:otherwise>
</c:choose>
