<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
<script>
function goPopup(){
	var pop = window.open("/omo/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 

}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		
	document.getElementById("msi2").value=siNm;
	document.getElementById("msgg2").value=sggNm;
	document.getElementById("memd2").value=emdNm;
	document.getElementById("fulladdr2").value=roadFullAddr;
	document.getElementById("mdetail2").value=addrDetail;
			
}
</script>

<script>
	$(function() {
		$("#memberUpdate").click(function() {
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
				$("#memupdate").submit(); 
				
			} else {
				alert("직무를 1 ~ 3개로 선택해주세요.");
			}
		});
	});
	
</script>


<div class="col-lg-9">									
<div role="main" class="main">
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="row">
					<div class="col">
						<div style="margin-bottom: 1px">
					         <button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
					      </div>
						<section class="card card-admin">
							<div class="card-body">
								<form class="form-horizontal form-bordered" action="/mupdate.do" method="post" id="memupdate" name="memupdate">
								<input type="hidden" name="mseq" value="${SESS_MSEQ}"/>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputID">아이디</label>
										<div class="col-lg-3">
											<input type="text" name="mid" value="${mvo.mid}" id="inputReadOnly" class="form-control" readonly="inputID">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputID">비밀번호</label>
										<div class="col-lg-3">
											<input type="password" name="mpw" value="" id="inputReadOnly" class="form-control" >
										</div>
									</div>
									 
									 <div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputDefault">이름</label>
										<div class="col-lg-2">
											<input type="text" name="mname" value="${mvo.mname}" class="form-control" id="inputReadOnly" >
										</div>
									</div>
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">핸드폰 번호</label>
											<div class="col-lg-4">
												<div class="input-group mb-3">
													<input name="mphone" type="text" value="${mvo.mphone}" class="form-control" id="inputReadOnly" "
												data-msg-captcha="숫자만 입력"
												data-msg-required="숫자만 입력해 주세요."
												placeholder="숫자만 입력해 주세요.">
													</span>
												</div>
											</div>
										</div>
									
									
									<input type="hidden" id="msi2" name="msi2">
									<input type="hidden" id="msgg2" name="msgg2">
									<input type="hidden" id="memd2" name="memd2">
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">주소</label>
											<div class="col-lg-6">
												<div class="input-group mb-3">
													<input type="text" class="form-control" id="inputReadOnly" id="fulladdr2" name="fulladdr2" value="${mvo.msi1} ${mvo.msgg1} ${mvo.memd1} " >
													<div class="input-group mb-3">
													<input type="text" class="form-control" id="mdetail2" name="mdetail2" value="${mvo.mdetail1} ">
													<span class="input-group-btn">
														<button class="btn btn-success" type="button" onclick="goPopup()">주소찾기</button>
													</span>
													</div>
												</div>
											</div>
										</div>
										
													
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputID">생년월일</label>
										<div class="col-lg-2">
											<input type="text" name="mbirth" value="${mvo.mbirth}" id="inputReadOnly" class="form-control" readonly="inputBirth" >
										</div>
									</div>
									
									<div class="form-group row has-danger">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputError" id="inputReadOnly">이메일</label>
										<div class="col-lg-4">
											<input type="text" name="mmail" value="${mvo.mmail}" id="inputReadOnly" class="form-control"  >
										</div>
									</div>
									
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">성별</label>
											<div class="col-sm-6">
												<div class="radio-custom">
												<c:choose>
													<c:when test="${mvo.mgender = 'm'}">
													<input type="radio" name="mgender" value="Read-Only Input" name="mgender"  disabled readonly="readonly">
													<label for="radioExample1">남</label>
													<input type="radio" name="mgender" value="Read-Only Input" name="mgender" disabled readonly="readonly">
													<label for="radioExample2">여</label>
													</c:when>
													<c:otherwise>
													<input type="radio" name="mgender" value="Read-Only Input" id="radioExample1" name="radioExample"  disabled=""  readonly="readonly">
													<label for="radioExample1">남</label>
													<input type="radio" name="mgender" value="Read-Only Input" id="radioExample2" name="radioExample" disabled checked readonly="readonly">
													<label for="radioExample2">여</label>
													</c:otherwise>
												</c:choose>
												</div>
											</div>
									</div>
									
								<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">직무</label>
								<div class="col-lg-6">
									<c:forEach items="${clist}" var="clist">
										<div class="btn-group" data-toggle="buttons">
											<c:choose>
												<c:when test="${clist.mseq ==  mvo.mseq}">
													<label class="btn btn-outline btn-primary active">
												</c:when>
												<c:otherwise>
													<label class="btn btn-outline btn-primary">
												</c:otherwise>
											</c:choose>
												<input type="checkbox" class="form-control field" name="fseq" id="field${clist.dseq}" value="${clist.dseq}" autocomplete="off" style="display: none;">${clist.dname}
											</label>
										</div>
									</c:forEach>
									<input type="hidden" id="checkbox" name="checkbox" value=""> 
								</div>
							</div>
										<div style="float: right;">
											<button type="button" id="memberUpdate" class="btn btn-outline btn-primary mb-2">수정하기</button>
										</div>
										<div style="visibility: hidden;"><br><br><br></div>
									</form>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>


