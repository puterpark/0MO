<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 인덱스 부분 바디에 글을 작성 -->
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
				<h1>회원가입</h1>
			</div>
		</div>
	</div>
</section>


<script>
function goPopup(){
	var pop = window.open("/omo/jusoPopup2.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 

}

function jusoCallBack(zipNo, r_roadFullAddr,r_addrDetail, r_siNm, r_sggNm, r_emdNm){
	
	document.getElementById("msi1").value=r_siNm;
	document.getElementById("msgg1").value=r_sggNm;
	document.getElementById("memd1").value=r_emdNm;
	document.getElementById("fulladdr1").value=r_roadFullAddr;
	document.getElementById("mdetail1").value=r_addrDetail;
			
}
</script>


<script>
<!-- 유효성 검사 -->
$(function() {
	$("#memberjoinBtn").click(function(){
		var mid1 = $("#mid1").val();
		var mpw1 = $("#mpw1").val();
		var mpw2 = $("#mpw2").val();
		var mname1 = $("#mname1").val();
		var mphone1 = $("#mphone1").val();
		var msi1 = $("#msi1").val();
		var msgg1 = $("#msgg1").val();
		var memd1 = $("#memd1").val();
		var mbirth1 = $("#mbirth1").val();
		var memail1 = $("#memail1").val();
		var mgender1 = $("#mgender1").is(":checked");
		var mgender = $("#mgender").is(":checked");
		
		var fulladdr1 = $("#fulladdr1").val();
		var mdetail1 = $("#mdetail1").val();
		
		

		
		
		if(mid1 == "") {
			swal("아이디를 입력해주세요.");
			$("#mid1").focus();
		} else if(mpw1 == ""){
			swal("비밀번호를 입력해주세요.");
			$("#mpw1").focus();
		} else if(mpw2 == "") {
			swal("비밀번호를 확인해주세요.");
			$("#mpw2").focus();
		} else if(mname1 == "") {
			swal("이름를 입력해주세요.");
			$("#mname1").focus();
		} else if(mphone1 == "") {
			swal("핸드폰 번호를 입력해주세요.");
			$("#mphone1").focus();
		} else if(fulladdr1 == "") {
			swal("주소를 입력하세요.");
			$("#fulladdr1").focus();
		} else if(mdetail1 == "") {
			swal("상세 주소를 입력하세요.");
			$("#mdetail1").focus();
		} else if(mbirth1 == "") {
			swal("생년월일을 입력하세요.");
			$("#mbirth1").focus();
		} else if(memail1 == "") {
			swal("이메일을 입력하세요.");
			$("#memail1").focus();
		} else if( (mgender1 || mgender) == false) {
			swal("성별을 선택하세요.");
		} 
		
	       var val = [];
	       var test = [];
	       test = $(":checkbox:checked");
	       console.log("바 랭쓰 : " + test.length);
	       var str = "";
	       
	        if (test.length <= 3 && test.length > 0) {
	          $(":checkbox:checked").each(function(i) {
	             val[i] = $(this).val();
	             str += val[i] + ",";
	          });
	          console.log(str);
	          $("#checkbox").val(str);
	          console.log("=========="+$("#checkbox").val());
	       	  $("#memberjoinform").submit(); 
	       } else {
	          swal("직무를 1 ~ 3개로 선택해주세요.");
	       }
		
		  
 });
    
    
    function email_check( email ) {
        
        var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    }
    
	var delay = (function(){
		  var timer = 0;
		  return function(callback, ms){
		    clearTimeout (timer);
		    timer = setTimeout(callback, ms);
		  };
		})();
	
	$('#mid1, #mpw2, #mpw1, #mphone1, #memail1').keyup(function(e) {
	    delay(function(){
	    	var object = e.target.id + "";
	    	console.log(object);
	    	if(object == 'mid1'){
	    	var mid1 = $("#mid1").val();
		    	if(mid1 != "") {
		    		var regExp =  /^[a-z0-9]{4,12}$/;  
		    		
		    		if(mid1.match(regExp) != null) {
		    			
					var data = new Object();
					data.gubun = "id";
					data.column = "mid";
					data.value = mid1;
					console.log(data);
					
					$.ajax({
						url: "/memberValidation.do",
						headers: {
							"Content-Type" : "application/json"
						},
						data: JSON.stringify(data),
						type: "post",
						success: function(res){
							if(res >= 1) {
								
								$("#id_validation_res").empty();
								$("#id_validation_res").append("<font color='red' size='1px'>중복된 아이디입니다. 다시 확인해주세요.</font>");
								
							} else {
								$("#id_validation_res").empty();
								$("#id_validation_res").append("<font color='blue' size='1px'>사용 가능한 아이디입니다.</font>");
								
								
							}
					}
				});
		    		} else {
		    			$("#id_validation_res").empty();
						$("#id_validation_res").append("<font color='red' size='1px'>4-12자리의 소문자, 숫자만 지원합니다.</font>");
			
		    		}
				} else {
					$("#id_validation_res").empty();
					$("#id_validation_res").append("<font color='black' size='1px'>아이디를 입력해주세요.</font>");
			
				}
	    		
	    	} else if((object == 'mpw1') || (object == 'mpw2')) {
	    		var mpw1 = $("#mpw1").val();
		    	var mpw2 = $("#mpw2").val();
		    	if(mpw2 != "") {
		    		var regExp = /^\w{4,12}$/;
				
		    		if(mpw2.match(regExp) != null) {
		    			
		    		if(mpw2 != mpw1){
		    			
					$("#pw_validation_res").empty();
					$("#pw_validation_res").append("<font color='red' size='1px'>비밀번호가 일치 하지 않습니다. 다시 확인해주세요.</font>");
				
		    		} else {
		    			$("#pw_validation_res").empty();
						$("#pw_validation_res").append("<font color='blue' size='1px'>비밀번호가 일치 합니다.</font>");
				
		    		}
		    		} else {
		    			$("#pw_validation_res").empty();
						$("#pw_validation_res").append("<font color='red' size='1px'>4자리 이상 12자리 이하로 작성하세요.</font>");
			
		    		}
		    	} 
	    	} else if (object == 'mphone1') {
	    		var mphone1 = $("#mphone1").val();
		    	if(mphone1 != "") {
		    	var regExp = /^\d{10,11}$/;
		    	if(mphone1.match(regExp) != null) {
		    		
	    		var data = new Object();
				data.gubun = "mphone";
				data.column = "mphone";
				data.value = mphone1;
				console.log(data);
	    		
	    		$.ajax({
					url: "/memberValidation.do",
					headers: {
						"Content-Type" : "application/json"
					},
					data: JSON.stringify(data),
					type: "post",
					success: function(res){
						if(res >= 1) {
							
							$("#mb_validation_res").empty();
							$("#mb_validation_res").append("<font color='red' size='1px'>이미 등록된 번호입니다. 다시 확인해 주세요.</font>");
							
						} else {
							$("#mb_validation_res").empty();
							$("#mb_validation_res").append("<font color='blue' size='1px'>사용 가능한 번호입니다.</font>");
							
							
						}
				}
			});
		    	} else {
		    		$("#mb_validation_res").empty();
					$("#mb_validation_res").append("<font color='red' size='1px'>숫자만 10 혹은 11자리 입력하세요.</font>");
	
		    	}
		    	} else {
					$("#mb_validation_res").empty();
					$("#mb_validation_res").append("<font color='black' size='1px'>핸드폰 번호를 입력해주세요.</font>");
			
				}
	    	} else if (object == 'memail1') {
	    		var memail1 = $("#memail1").val();
		    	if(memail1 != "") {
		    		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		    		if(memail1.match(regExp) != null){
		    			
		    		var data = new Object();
					data.gubun = "memail";
					data.column = "mmail";
					data.value = memail1;
					console.log(data);
		    		
		    		$.ajax({
						url: "/memberValidation.do",
						headers: {
							"Content-Type" : "application/json"
						},
						data: JSON.stringify(data),
						type: "post",
						success: function(res){
							if(res >= 1) {
								
								$("#em_validation_res").empty();
								$("#em_validation_res").append("<font color='red' size='1px'>이미 등록된 메일입니다. 다시 확인해 주세요.</font>");
								
							} else {
								$("#em_validation_res").empty();
								$("#em_validation_res").append("<font color='blue' size='1px'>사용 가능한 메일입니다.</font>");
								
								
							}
					}
				});
		    		} else {
		    			$("#em_validation_res").empty();
						$("#em_validation_res").append("<font color='red' size='1px'>이메일 형식이 올바르지 않습니다.</font>");
				
		    		}
		    	}
	    	}
	    }, 500 );
	});
    
	
	
 });
 

</script>
<div role="main" class="main">
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="row">
					<div class="col">
						<div style="margin-bottom: 1px">
							<button type="button" class="btn btn-outline btn-light mb-2"
								onclick="javascript:history.back()">«이전</button>
						</div>
						<section class="card card-admin">
							<div class="card-body">
								
								
								
								<form class="form-horizontal form-bordered" id="memberjoinform"
									method="POST" action="/memberjoin.do">
									
									
									
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputDefault">아이디</label>
										<div class="col-lg-3">
											<input type="text" value="" class="form-control" id="mid1"
												name="mid">
											<span class="help-block" id="id_validation_res"></span>
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputDefault">비밀번호</label>
										<div class="col-lg-3">
											<input type="password" class="form-control" id="mpw1"
												name="mpw" value="" data-msg-required="비밀번호를 입력해주세요."
												placeholder="비밀번호를 입력해주세요.">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputDefault">비빌번호 체크</label>
										<div class="col-lg-3">
											<input type="password" class="form-control" id="mpw2"
												name="mpw2" value="" data-msg-captcha="Wrong your password"
												data-msg-required="비밀번호를 다시 입력해주세요."
												placeholder="비밀번호를 다시 입력해주세요.">
											<span class="help-block" id="pw_validation_res"></span>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputDefault">이름</label>
										<div class="col-lg-2">
											<input type="text" class="form-control" id="mname1"
												name="mname" value="">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2">핸드폰
											번호</label>
										<div class="col-lg-4">
												<input type="text" class="form-control"
													data-msg-captcha="숫자만 입력" data-msg-required="숫자만 입력해 주세요."
													placeholder="숫자만 입력해 주세요." value="" id="mphone1"
													name="mphone"/>
													<span class="help-block" id="mb_validation_res"></span>
										</div>
									</div>
									<input type="hidden" id="msi1" name="msi1" value="" >
									<input type="hidden" id="msgg1" name="msgg1" value="" >
									<input type="hidden" id="memd1" name="memd1" value="" >
									
									
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2">주소</label>
										<div class="col-lg-6">
											<div class="input-group mb-3">
												<input type="text" class="form-control" id="fulladdr1" name="fulladdr1"> <span
													class="input-group-btn">
													<button class="btn btn-success" type="button"
														onclick="goPopup();">주소찾기</button>
												</span> 
											
												<div class="input-group mb-3">
													<input type="text" class="form-control" id="mdetail1" name="mdetail1">
												</div>								
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputHelpText">생년월일</label>
										<div class="col-lg-2">
											<input type="text" class="form-control" id="mbirth1"
												name="mbirth" value=""> <span class="help-block">ex)20180405</span>
										</div>
									</div>
									<div class="form-group row has-danger">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputError">이메일</label>
										<div class="col-lg-4">
											<input type="text" class="form-control" id="memail1"
												name="memail" value="">
												<span class="help-block" id="em_validation_res"></span>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2">성별</label>
										<div class="col-sm-6">
											<div class="radio-custom">
												<input type="radio" id="mgender1" name="mgender" value="m">
												<label for="radioExample1">남</label> <input type="radio"
													id="mgender" name="radioExample" value="f"> <label
													for="radioExample2">여</label>
											</div>
										</div>
									</div>

								<div class="form-group row">
                        <label class="col-lg-3 control-label text-lg-right pt-2">직무</label>
                        <div class="col-lg-6">
                           <c:forEach items="${dlist}" var="dlist">
                              <div class="btn-group" data-toggle="buttons"> 
                                 <label class="btn btn-outline btn-primary"> 
                                    <input type="checkbox" class="form-control field" name="dseq" 
                                    id="duty${dlist.dseq}" value="${dlist.dseq}" autocomplete="off" style="display: none;">${dlist.dname}
                                 </label>
                              </div>
                           </c:forEach>
                           <input type="hidden" id="checkbox" name="checkbox" value=""> 
                        </div>
                     </div>
									<div style="float: right;">
										<button type="button" id="memberjoinBtn" name="memberjoinBtn"
											class="btn btn-outline btn-primary mb-2">회원가입</button>
									</div>
									<div style="visibility: hidden;">
										<br> <br> <br>
									</div>
									<div style="float: right;">
										<p class="log-in-info">
											이미 회원이신가요? <a href="#" id="headerSignIn" class="p-0 m-0 ml-1">로그인</a>
										</p>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




