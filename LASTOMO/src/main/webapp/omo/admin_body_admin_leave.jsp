<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

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
				<h1>회원 탈퇴</h1>
			</div>
		</div>
	</div>
</section>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<title>스위트als</title>
<script type="text/javascript">

function secession(){
	//여기에 ID PW 매칭을 ㄱㄱ 해야합니다. 네네 
	//그래서 막 잘 되었으면.....
	swal({
		icon: "success",
		text: "탈퇴되었습니다.",
	});
	//잘못되었을경우에느느....
	swal({
		icon: "warning",
		text: "비밀번호를 확인해주세요",
	});
	var a = document.getElementById("pw");
	a.value="";
}
//취소눌렀을때는....
function nonono(){
	swal({
		icon: "info",
		text: "취소되었습니다. ",
	});
	var a = document.getElementById("pw");
	console.log(a);
	a.value="";
}

</script>
</head>
<body>

탈퇴하시겠습니까?
<input type="password" value="" id="pw" name="pw">
<input type="button" value="탈퇴" onclick="secession()">
<input type="reset" value="취소" onclick="nonono()">


</body>
</html>

