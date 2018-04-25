<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function goPopup(){
	var pop = window.open("/omo/jusoPopup2.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 

}

function jusoCallBack(roadFullAddr,addrDetail, siNm, sggNm, emdNm){
	
	document.getElementById("msi2").value=siNm;
	document.getElementById("msgg2").value=sggNm;
	document.getElementById("memd2").value=emdNm;
	document.getElementById("fulladdr2").value=roadFullAddr;
	document.getElementById("mdetail2").value=addrDetail;
			
}
</script>

<script>
$(function(){
	$('#btnAddr').click(function(){
		$('#frmSignUp').submit();
	})
})
</script>

</head>

<div class="col-lg-9">
	<div class='right-box'>
		<div class="row">
			<div class="col-md-10">
				<div class="featured-box featured-box-primary text-left mt-5" style="height: 477.031px;">
					<div class="box-content">
						<h4 class="heading-primary text-uppercase mb-3">활동지역 추가</h4>
						<form action="/member_addr.do" id="frmSignUp" name="frmSignUp" method="post">
						<input type="hidden" id="msi2" name="msi2" value="">
						<input type="hidden" id="msgg2" name="msgg2" value="">
						<input type="hidden" id="memd2" name="memd2" value="">
							<div class="form-row">
								<div class="form-group col-lg-6">
									
								</div>
								<div class="form-group col">
									<input type="button" value="주소 검색" class="btn btn-primary float-right mb-5" onclick="goPopup()">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
									<input type="text" value="" id="fulladdr2" name="fulladdr2" class="form-control form-control-lg">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-lg-6">
									<input type="text" value="" id="mdetail2" name="mdetail2" class="form-control form-control-lg">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-lg-6">
									<input type="button" id="btnAddr" name="btnAddr" value="주소 추가" class="btn btn-primary float-right mb-5">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div style="visibility: hidden;"><br></div>
	</div>
	
	<hr class="tall">
</div>