<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	$(function() {
		$("#leave").click(function() {
			swal({
				title: "탈퇴하시겠습니까?",
				icon: "warning",
				buttons: true,
				dangerMode: true,
			})
			.then((willDelete) => {
				if (willDelete) {
					swal("탈퇴되었습니다.", {
					icon: "success",
				})
				.then(() => {
					$(".leaveform").submit();
				});
				} else {
					swal("더 함께해요.");
				}
			});
		});
	});
</script>

<header id="header" data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': true, 'stickyEnableOnMobile': true, 'stickyStartAt': 0, 'stickySetTop': '0', 'stickyChangeLogo': false}">
	<div class="header-body">
		<div class="header-container container">
			<div class="header-row">
				<div class="header-column">
					<div class="header-row">
						<div class="header-logo">
							<a href="/index.do">
								<img alt="Porto" width="111" height="54" data-sticky-width="82" data-sticky-height="40" data-sticky-top="33" src="/img/logo.png">
							</a>
						</div>
					</div>
				</div>
				<div class="header-column justify-content-end">
					<div class="header-row pt-3">
						<div class="header-search d-none d-md-block" style="visibility: hidden;">
							<form id="searchForm" action="page-search-results.html" method="get">
								<div class="input-group" style="width: 350px">
									<input type="text" class="form-control" name="q" id="q" placeholder="Search..." required>
									<span class="input-group-append">
										<button class="btn btn-light" type="submit"><i class="fas fa-search"></i></button>
									</span>
								</div>
							</form>
						</div>
					</div>
					<div class="header-row">
						<div class="header-nav">
							<div class="header-nav-main header-nav-main-effect-1 header-nav-main-sub-effect-1">
								<nav class="collapse">
									<ul class="nav nav-pills" id="mainNav">
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="/gongmo.do">
												공모전
											</a>
											<ul class="dropdown-menu">
												<c:forEach items="${flist}" var="fvo">
												<li>
													<a class="dropdown-item" href="/gongmo_field.do?fseq=${fvo.fseq}">${fvo.fname}</a>
												</li>
												</c:forEach>
											</ul>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="/guin.do">
												모셔가요
											</a>
											<ul class="dropdown-menu">
												<c:forEach items="${dutyList}" var="dl">
												
												<li>
													<a class="dropdown-item" href="/guin_duty.do?dseq=${dl.dseq}">${dl.dname}</a>
												</li>
												
												</c:forEach>
											</ul>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="/gujik.do">
												기다려요
											</a>
											<ul class="dropdown-menu">
												<c:forEach items="${dutyList}" var="dl">
												
												<li>
													<a class="dropdown-item" href="/gujik_duty.do?dseq=${dl.dseq}">${dl.dname}</a>
												</li>
												
												</c:forEach>
											</ul>
										</li>
										<li class="dropdown dropdown-mega dropdown-mega-signin signin" id="headerAccount">
											<a class="dropdown-item dropdown-toggle" href=""> 
												<i class="fas fa-user"> </i> 
												<c:choose>
													<c:when test="${not empty SESS_MSEQ}">
														${SESS_MEMBERID} 님
														</a>
											<ul class="dropdown-menu">
												<li>

													<div class="dropdown-mega-content">

														<div class="row">
															<div class="col">
																<div class="signin-form">

																	<span class="dropdown-mega-sub-title"><font size="5"><b>마이페이지</b></font></span> 
																	
																		<div class="form-row">
																			<div class="col-6">
																				<div class="form-row">
																					<a href="/myinfo.do" class="p-0 m-0 ml-1 float-left">정보 수정</a>
																				</div>
																				<div class="form-row">
																					<a href="/mypofol_list.do" class="p-0 m-0 ml-1 float-left">포트폴리오</a>
																				</div>
																				<div class="form-row">
																					<a href="/userList.do" class="p-0 m-0 ml-1 float-left">내가 쓴 글</a>
																				</div>
																				<div class="form-row">
																					<a href="#" class="p-0 m-0 ml-1 float-left">좋아요 한 글</a>
																				</div>
																				<div class="form-row">
																					<a href="/my_body_paylook.do" class="p-0 m-0 ml-1 float-left">결제 내역</a>
																				</div>
																				<div class="form-row">
																					<a href="/my_body_pointlook.do" class="p-0 m-0 ml-1 float-left">포인트 내역</a>
																				</div>
																				<div class="form-row">
																					<form class="leaveform" action="/mleave.do" method="post" id="leaveform">
																						<a href="#" class="p-0 m-0 ml-1 float-left" id="leave">회원 탈퇴</a>
																						<input type="hidden" name="mseq" value="${SESS_MSEQ}">
																						<!-- <input type="button" class="p-0 m-0 ml-1 float-left" id="leave" value="회원 탈퇴"> -->
																					</form>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
																<p class="sign-up-info">
																<div class="col-6">
																	<div style="padding-top: 50px;">
																	<span class="dropdown-mega-sub-title"><font size="4">잔여포인트 : ${LVL_PAYSUM}p</font></span>
																	<span>
																		<button type="button"
																					class="btn btn-primary mb-2 float-right btn-xl" onclick="location.href='/my_body_pointpay.do'">포인트
																					충전하기</button>
																	</span>
																		<a href="/logout.do" class="p-0 m-0 ml-1 float-right">로그아웃</a>
																	</div>
																</div>
																</p>
														</div>
													</div>
												</div>
											</div>
										</li>
									</ul>


											</li>
										</c:when>
										<c:otherwise>
											로그인
										</c:otherwise>
										</c:choose>
										<!-- puter. -->
										</a>
										<ul class="dropdown-menu">
											<li>
												<div class="dropdown-mega-content">
													<div class="row">
														<div class="col">

															<div class="signin-form">

																<span class="dropdown-mega-sub-title">로그인</span>

																<form action="/login.do" id="frmSignIn" method="post">
																	<div class="form-row">
																		<div class="form-group col">
																			<label>회원 아이디</label>
																			<input type="text" value="" id="mid" name="mid"
																				class="form-control form-control-lg" tabindex="1">
																		</div>
																	</div>
																	<div class="form-row">
																		<div class="form-group col">
																			<label>비밀번호</label> <input type="password" value="" id="mpw" name="mpw"
																				class="form-control form-control-lg" tabindex="2">
																		</div>
																	</div>
																	<div class="form-row">
																		<div class="form-group col-lg-6 pl-0"></div>
																		<div class="form-group col-lg-6 pr-0">
																			<input type="submit" value="로그인" class="btn btn-primary float-right mb-3" data-loading-text="Loading...">
																		</div>
																	</div>
																</form>

																<p class="sign-up-info">
																	아직 회원이 아니세요? <a href="/reg_page.do" class="p-0 m-0 ml-1">회원가입</a>
																</p>
															</div>
														</div>
													</div>
												</div>
											</li>
										</ul>
										
										
										</li>
									</ul>
								</nav>
							</div>
							<button class="btn header-btn-collapse-nav" data-toggle="collapse" data-target=".header-nav-main nav">
								<i class="fas fa-bars"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>