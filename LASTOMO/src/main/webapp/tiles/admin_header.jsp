<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header" data-plugin-options="{'stickyEnabled': true, 'stickyEnableOnBoxed': false, 'stickyEnableOnMobile': true, 'stickyStartAt': 57, 'stickySetTop': '-55px', 'stickyChangeLogo': true}">
	<div class="header-body">
		<div class="header-container container">
			<div class="header-row">
				<div class="header-column">
					<div class="header-row">
						<div class="header-logo">
							<a href="/admin.do">
								<img alt="0MO" width="111" height="54" data-sticky-width="82" data-sticky-height="40" data-sticky-top="33" src="img/logo.png">
							</a>
						</div>
					</div>
				</div>
				<div class="header-column justify-content-end">
					<div class="header-row pt-3 pt-lg-0">
						<nav class="header-nav-top order-lg-2">
							<ul class="nav nav-pills">
								<li class="nav-item d-none d-sm-block">
									<a class="nav-link" href="/index.do">&nbsp;&nbsp;<i class="fas fa-male"></i>&nbsp;유저 페이지</a>
								</li>
							</ul>
						</nav>
					</div>
					<div class="header-row">
						<div class="header-nav">
							<div class="header-nav-main header-nav-main-effect-1 header-nav-main-sub-effect-1">
								<nav class="collapse">
									<ul class="nav nav-pills" id="mainNav">
										<c:choose>
										<c:when test="${not empty SESS_ASEQ}">
										<li class="dropdown dropdown-mega dropdown-mega-signin signin" id="headerAccount">
											<a class="nav-link">
												<i class="fas fa-user"></i><!--  로그인 --> 
												${SESS_AID} 님
											</a>
										</li>
										<li class="nav-item d-none d-sm-block">
											<a class="nav-link" href="/admin_logout.do"><i class="fas fa-sign-out-alt"></i>&nbsp;로그아웃</a>
										</li>
										<li class="nav-item d-none d-sm-block" style="visibility: hidden;">
											<a class="nav-link" href="#"><i class="fas fa-angle-right"></i>&nbsp;탈퇴</a>
										</li>
										<li style="visibility: hidden;">hidden</li>
										<li class="">
											<a class="nav-link" href="/admin.do">
												대시보드
											</a>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="/admin_gongmo.do">
												공모전
											</a>
											<ul class="dropdown-menu">
												<li>
													<a class="dropdown-item" href="/admin_gongmo_admin_list.do">공식</a>
												</li>
												<li>
													<a class="dropdown-item" href="/admin_gongmo_user_list.do">유저</a>
												</li>
												<li>
													<a class="dropdown-item" href="/admin_gongmo_field.do">분야 관리</a>
												</li>
											</ul>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="#">
												구인/구직
											</a>
											<ul class="dropdown-menu">
												<li>
													<a class="dropdown-item" href="/admin_offer.do">구인</a>
												</li>
												<li>
													<a class="dropdown-item" href="/admin_seek.do">구직</a>
												</li>
											</ul>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="/admin_body_pointpay_main.do">
												결제/포인트
											</a>
											<ul class="dropdown-menu">
												<li>
													<a class="dropdown-item" href="/admin_pay.do">결제</a>
												</li>
												<li>
													<a class="dropdown-item" href="/admin_point.do">포인트</a>
												</li>
											</ul>
										</li>
										<li class="dropdown">
											<a class="dropdown-item dropdown-toggle" href="">
												신고
											</a>
											<ul class="dropdown-menu">
												<li>
													<a class="dropdown-item" href="/admin_breport_list.do">게시글</a>
												</li>
												<li>
													<a class="dropdown-item" href="/admin_rreport_list.do">댓글</a>
												</li>
											</ul>
										</li>
										<li class="">
											<a class="nav-link" href="/admin_member_list.do">
												회원
											</a>
										</li>
										<c:if test="${SESS_AGRADE == 'Super'}">
										<li class="">
											<a class="nav-link" href="/admin_admin_list.do">
												관리자
											</a>
										</li>
										</c:if>
										<li class="">
											<a class="nav-link" href="">
												제휴(TO-DO)
											</a>
										</li>
									</ul>
								</nav>
							</div>
							<button class="btn header-btn-collapse-nav" data-toggle="collapse" data-target=".header-nav-main nav">
								<i class="fas fa-bars"></i>
							</button>
						</div>
										</c:when>
										<c:otherwise>
										
										</c:otherwise>
										</c:choose>

					</div>
				</div>
			</div>
		</div>
	</div>
</header>
