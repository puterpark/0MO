<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
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
				<h1>회원수정</h1>
			</div>
		</div>
	</div>
</section>

<script>
$(function() {
	$("#memberupdateBtn").click(function() {
	$("#memberupdatefrom").submit(); 
				}
	)}
);
</script>


										

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
								<form class="form-horizontal form-bordered" id="memberupdatefrom" method="get">
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputID" value="${allList.mid}">아이디</label>
										<div class="col-lg-3">
											<input type="text" value="${mvo.mid}" id="inputReadOnly" class="form-control" readonly="inputID">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputDefault">비밀번호</label>
										<div class="col-lg-3">
											<input type="password" class="form-control" id="inputPW"
												data-msg-required="비밀번호를 입력해주세요."
												placeholder="비밀번호를 입력해주세요.">
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2"
											for="inputDefault">비빌번호 체크</label>
										<div class="col-lg-3">
											<input type="password" class="form-control" id="inputPW2"
												data-msg-captcha="Wrong your password"
												data-msg-required="비밀번호를 다시 입력해주세요."
												placeholder="비밀번호를 다시 입력해주세요.">
										</div>
									 </div>
									 
									 <div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputDefault">이름</label>
										<div class="col-lg-2">
											<input type="text"  value="${mvo.mname}" class="form-control" id="inputNAME">
										</div>
									</div>
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">핸드폰 번호</label>
											<div class="col-lg-4">
												<div class="input-group mb-3">
													<input type="text" class="form-control" id="inputReadOnly" value="${mvo.mphone}"
												data-msg-captcha="숫자만 입력"
												data-msg-required="숫자만 입력해 주세요."
												placeholder="숫자만 입력해 주세요.">
													</span>
												</div>
											</div>
										</div>
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">주소</label>
											<div class="col-lg-6">
												<div class="input-group mb-3">
													<input type="text" class="form-control">
													<div class="input-group mb-3">
													<input type="text" class="form-control">
													<span class="input-group-btn">
														<button class="btn btn-success" type="button" onclick="location.href='/addrsearch.do'">주소찾기</button>
													</span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">활동주소</label>
											<div class="col-lg-6">
												<div class="input-group mb-3">
													<input type="text" class="form-control">
													<div class="input-group mb-3">
													<input type="text" class="form-control">
													<span class="input-group-btn">
														<button class="btn btn-success" type="button" onclick="location.href='/addrsearch.do'">활동주소찾기</button>
													</span>
													</div>
												</div>
											</div>
										</div>
													
									<div class="form-group row">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputID">생년월일</label>
										<div class="col-lg-2">
											<input type="text" values="${mvo.mbirth}" id="inputReadOnly" class="form-control" readonly="inputBirth">
										</div>
									</div>
									
									<div class="form-group row has-danger">
										<label class="col-lg-3 control-label text-lg-right pt-2" for="inputError">이메일</label>
										<div class="col-lg-4">
											<input type="text" value="${mvo.mmail}" id="inputReadOnly" class="form-control">
										</div>
									</div>
									
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">성별</label>
											<div class="col-sm-6">
												<div class="radio-custom">
													<input type="radio"  value="Read-Only Input" id="radioExample1" name="radioExample"  disabled="" checked="">
													<label for="radioExample1">남</label>
													<input type="radio"  value="Read-Only Input" id="radioExample2" name="radioExample" disabled>
													<label for="radioExample2">여</label>
												</div>
											</div>
									</div>
									
									<div class="form-group row">
											<label class="col-lg-3 control-label text-lg-right pt-2">직무</label>
											
												
										</div>
										<div style="float: right;">
											<button type="button" id="memberupdateBtn" class="btn btn-outline btn-primary mb-2" onclick="" location.href="/#">수정완료</button>
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


