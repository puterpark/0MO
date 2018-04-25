<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>카카오페이</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- <script>
$(document).ready(function(){

	$('#btn_pay').click(function(){

	     Kakao.API.request({
	        url: '/v1/payment/ready',
	    	Authorization: 'KakaoAK c37c8a820f74c3581028ea3cb4f7448b',
	    	cid: "TC0ONETIME",
			partner_order_id: 'partner_order_id',
			partner_user_id: 'partner_user_id',
			item_name: '라이언빵',
			quantity: '1',
			total_amount: 1000,
			vat_amount: 200,
			tax_free_amount: 0,
			approval_url: 'success.jsp',
			fail_url: 'fail.jsp',
			cancel_url: 'cancel.jsp',
	        success: function(res) {
	          	alert('성공');
	        },
	        fail: function(error) {
	          	alert('실패');
	        }
	      }); 
	      
	    
	});
	});
</script> -->
</head>
<body>
<button id="#btn_pay">구매하기</button>
<br>
<br>
 <form action="https://kapi.kakao.com/v1/payment/ready" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
	<input type="text" name="cid" value="TC0ONETIME"><br>
	<input type="text" name="authorization" value="KakaoAK c37c8a820f74c3581028ea3cb4f7448b"><br>
	<input type="text" name="admin_key" value="c37c8a820f74c3581028ea3cb4f7448b"><br>
	<input type="text" name="access_token" value="FzoCNYJCAPoFhFEzeJSIVlrtBxcqOAwJcGj73wopdaYAAAFirlYYxg"><br>
	<input type="text" name="item_name" value="러브볼50개"><br>
	<input type="text" name="quantity" value="1"><br>
	<input type="text" name="total_amount" value="5000"><br>
	<input type="text" name="vat_amount" value="5000"><br>
	<input type="text" name="tax_free_amount" value="0"><br>
	<input type="text" name="approval_url" value="http://192.168.0.20/alone/community/redirect.jsp"><br>
	<input type="text" name="fail_url" value="http://192.168.0.20/alone/community/redirect.jsp"><br>
	<input type="text" name="cancel_url" value="http://192.168.0.20/alone/community/redirect.jsp"><br>
	<input type="text" name="tfPhone"><br>
	<input type="text" name="tfBirthday"><br>
	<input type="submit" value="제출">
</form> 
<div class="result"></div>

<a id="kakao-login-btn"></a>
<a href="http://alpha-developers.kakao.com/logout"></a>
<script type='text/javascript'>
	Kakao.init("85ea84bf977b718430c0c5080c450249");
	Kakao.Auth.createLoginButton({
		container: "#kakao-login-btn",
		success : function(authObj){
			console.log(JSON.stringify(authObj));
			var access_token = "";
			$.map(authObj, function(v,i){
				if(i == "access_token"){
					access_token = v;
				console.log(access_token);
				}
			});
			var obj = new Object();
			obj.access_token = access_token;
			
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
						console.log("++++++++++"+v);
						window.location.href = v;
						}
					});
				}
			});  
		},
		fail: function(err) {
			console.log(JSON.stringify(err));
		}
	})
</script>


</body>
</html>




