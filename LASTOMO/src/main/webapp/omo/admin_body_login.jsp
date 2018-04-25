<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>

function idCheck(){
	var delay = (function(){
        var timer = 0;
        return function(callback, ms){
          clearTimeout (timer);
          timer = setTimeout(callback, ms);
        };
      })();
   
   $("#aid_join, #apw2, #apw1").keyup(function(e) {
       delay(function(){
          var object = e.target.id + "";
          console.log(object);
          if(object == 'aid_join'){
          var aid= $("#aid_join").val();
             if(aid != "") {
               var data = new Object();
          
               data.aid = aid;
               console.log(data);
               
               $.ajax({
                  url: "/adminValidation.do",
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
               $("#id_validation_res").append("<font color='black' size='1px'>아이디를 입력해주세요.</font>");
         
            }
             
          }  else {
             $.ajax({
               url: "/adminValidation.do",
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
          }
       }, 500 );
   });
   
}


</script>

</head>

<div role="main" class="main">
	<hr class="tall">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="featured-box featured-box-primary text-left mt-5" style="height: 477.031px;">
					<div class="box-content">
						<h4 class="heading-primary text-uppercase mb-3">로그인</h4>
						<form action="/admin_login.do" id="frmSignIn" name="frmSignIn" method="post">
							<div class="form-row">
								<div class="form-group col">
									<label>아이디</label>
									<input type="text" value="" id="aid1" name="aid" class="form-control form-control-lg">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
									<label>비밀번호</label>
									<input type="password" value="" id="apw" name="apw" class="form-control form-control-lg">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-lg-6">
									<div class="form-check form-check-inline">
										<label class="#">
											
										</label>
									</div>
								</div>
								<div class="form-group col-lg-6">
									<input type="submit" value="Login" class="btn btn-primary float-right mb-5" data-loading-text="Loading..."> 
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="featured-box featured-box-primary text-left mt-5" style="height: 477.031px;">
					<div class="box-content">
						<h4 class="heading-primary text-uppercase mb-3">회원가입</h4>
						<form action="/admin_join.do" id="frmSignUp" name="frmSignUp" method="post">
							<div class="form-row">
								<div class="form-group col-lg-6">
									<label>아이디</label>
									<input type="text" value="" id="aid" name="aid" class="form-control form-control-lg" oninput="idCheck()">
									<div id="id_validation_res" ></div>
								</div>
								<div class="form-group col-lg-6">
									<label>이름</label>
									<input type="text" value="" id="aname" name="aname" class="form-control form-control-lg">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-lg-6">
									<label>비밀번호</label>
									<input type="password" value="" id="apw1" name="apw" class="form-control form-control-lg">
								</div>
								<div class="form-group col-lg-6">
									<label>비밀번호 확인</label>
									<input type="password" value="" id="apw2" name="apw2" class="form-control form-control-lg">
									<div id="pw_validation_res"></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
									<input type="submit" id="btnRegister" name="btnRegister" value="Register" class="btn btn-primary float-right mb-5" >
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