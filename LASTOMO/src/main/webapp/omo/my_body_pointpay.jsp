<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#kakaopay").click(function(e){ /* e== 클릭시 발생된 값들을 가져올 수 있게 함  */
		var mseq ="${mvo.mseq}";
		var ptseq =1;
		var pamoney = $("input[name=payamount]:checked").val(); /*  */
		console.log(pamoney);
		Kakao.init("f309da56132ff21c66a49ed2676b29b1");
		Kakao.Auth.login({
		   success : function(authObj){
		      var access_token = "";
		      $.map(authObj, function(v,i){
		         if(i == "access_token"){
		            access_token = v;
		         }
		      });
		      
		      var obj = new Object();
		      obj.access_token = access_token;
		      obj.mseq = mseq;
		      obj.ptseq = ptseq;
		      obj.pamoney = pamoney;
		      
		       $.ajax({
		             url : "/kakao4.do",
		            headers : {
		            'Content-Type' : 'application/json',
		                     },
		            method : "post",
		            data : JSON.stringify(obj),
		            success : function(resMap) {
		               $.each(JSON.parse(resMap), function(i,v){
		                  if(i == "next_redirect_pc_url"){
		                   window.location.href = v; 
		                  }
		               });
		            }
		         });  
		   },
		   fail: function(err) {
		      console.log(JSON.stringify(err));
		   }
		});
	});
	
});
	

</script>


<div class="col-lg-9">
	
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>회원 아이디 : ${mid} 님</th>
						<th>현재 보유 포인트 : ${LVL_pointSum}</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<br><br>
	<div class="container">
		<div class="col-12 mb-2 mb-lg-0">
		<font class="heading-primary" size="5">충전금액 선택</font>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>충전금액</th>
						<th>포인트</th>
						<th>총 결제금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount" value="5000" checked="">
						5000원
						</td>
						<td>5000p</td>
						<td>5000원</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount1" value="10000" checked="">
							10000원
						</td>
						<td>10000p</td>
						<td>10000원</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount2" value="20000" checked="">
							20000원
						</td>
						<td>20000p</td>
						<td>20000원</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount3" value="30000" checked="">
							30000원
						</td>
						<td>30000p</td>
						<td>30000원</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount4" value="50000" checked="">
							50000원
						</td>
						<td>50000p</td>
						<td>50000원</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="payamount" id="payamount5" value="100000" checked="">
							100000원
						</td>
						<td>100000p</td>
						<td>100000원</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="container">
	<font class="heading-primary" size="5">결제 수단</font>
	<hr class="short">
		
		<br>
		<div class="col-sm-8">
			<div class="radio-custom">
				<input name="ptype" id="ptype" type="radio">
				<img src="../img/kakao/kakaopaybtn.png" >
			</div>
		</div>
		
		<hr class="short">

		<div class="col" align="center">
			<p>
				<button class="btn btn-primary btn-xl mb-2" type="button" id="kakaopay" >결제하기</button>
			</p>
		</div>
	</div>
</div>







