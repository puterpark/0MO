<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script>
	$(function() {
		$("#deleteBtn").click(function() {
			swal({
				title: "삭제하시겠습니까?",			
				icon: "warning",
				buttons: true,
				dangerMode: true 
			})
			.then((willDelete) => {
				if (willDelete) {
	              swal("삭제 완료 되었습니다.", {
	                icon: "success",
	              })
	              .then(() => {
	            	  $(".deleteform").submit();
	              });
	            } else {
	            }
			}); 
		});
	});
</script>



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
				<h1>공모전</h1>
			</div>
		</div>
	</div>
</section>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
		</div>
		<div class="row">
			<div class="featured-box featured-box-primary featured-box-text-left" style="width: 100%; height: 480px;">
				<div class="box-content">
					<div class="row">
						<div>
							<h3><i class="far fa-check-circle"></i>&nbsp;${gvo.gtitle}</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-3 mb-4 mb-lg-0">
							<c:choose>
								<c:when test="${gvo.gposter == null}">
									<a class="lightbox" href="/uploads/gposter/noImage.png" data-plugin-options="{'type':'image'}">
										<img class="img-fluid" src="/uploads/gposter/noImage.png" alt="No Image" width="500px">
									</a>
								</c:when>
								<c:otherwise>
									<a class="lightbox" href="${gvo.gposter}" data-plugin-options="{'type':'image'}">
										<img class="img-fluid" src="${gvo.gposter}" alt="${gvo.gtitle}" width="500px">
									</a>
								</c:otherwise>
							</c:choose>	
						</div>
						<div class="col-9 mb-4 mb-lg-0">
							<div class="row">
								<div class="col-9 mb-4 mb-lg-0">
									<table style="height: 250px; width: 100%;">
										<col style="width: 20%;"></col>
										<col style="width: 85%;"></col>
										
										<tr>
											<td><b>주최</b></td>
											<td>${gvo.gspon}</td>
										</tr>
										<tr>
											<td><b>분야</b></td>
											<td style="padding-top: 8px;">
												<c:forEach items="${gvo.flist}" var="flist">
													<button type="button" class="btn btn-outline btn-light btn-xs mb-2">${flist.fname}</button>
												</c:forEach>
											</td>
										</tr>
										<tr>
											<td><b>일정</b></td>
											<td>
												${gvo.gsday} ~ ${gvo.geday}
												<c:choose>
													<c:when test="${gvo.gsrday < 0 && gvo.gerday < 0}">
														&nbsp;&nbsp;<span class="badge badge-warning badge-sm">마감</span>
													</c:when>
													<c:when test="${gvo.gsrday > 0 && gvo.gerday > 0}">
														&nbsp;&nbsp;<span class="badge badge-success badge-sm">접수예정</span>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${gvo.gerday == 0}">
																&nbsp;&nbsp;<span class="badge badge-primary badge-sm">D-DAY</span>
															</c:when>
															<c:otherwise>
																&nbsp;&nbsp;<span class="badge badge-primary badge-sm">D-${gvo.gerday}</span>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td><b>링크</b></td>
											<td style="padding-top: 8px;">
												<button type="button" class="btn btn-outline btn-light btn-xs mb-2" onclick="window.open('${gvo.glink}')"><i class="fas fa-link"></i>링크</button>
											</td>
										</tr>
									</table>
								</div>
								<div class="col-3 mb-4 mb-lg-0" style="padding-top: 10px">
									<div>
										<table style="text-align: center;">
											<col style="width: 20%;"></col>
											<col style="width: 50%;"></col>
											
											<tr><td colspan="2">조회한 사람들</td></tr>
											<tr style="font-size:2em">
												<td><i class="fas fa-eye"></i></td>
												<td>${gvo.gview}</td>
											</tr>
											<tr><td colspan="2"><br><br></td></tr>
											<tr><td colspan="2">좋아요한 사람들</td></tr>
											<tr style="font-size:2em">
												<td><i class="fas fa-heart"></i></td>
												<td id="lcnt">${gvo.lvo.lcnt}</td>
											</tr>
											<tr><td colspan="2"><br><br></td></tr>
											<tr style="font-size:2em">
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<br><br>
			<h4 style="display: inline-block;">▣공모요강</h4>
			<hr class="short">
			<div class="col-12 mb-4 mb-lg-0">
				${gvo.gbody}
			</div>
			<hr class="short">
			<div>
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
				<div style="float: right;">
					<div style="margin-bottom: 1px">
						<button type="button" class="btn btn-primary btn-sm mb-2" onclick="location.href='/admin_gongmo_edit_page.do?gseq=${gvo.gseq}'">수정</button>
						&nbsp;
						<div style="float: right;">
							<form class="deleteform" action="/admin_gongmo_delete.do" method="post">
								<button type="button" class="btn btn-warning btn-sm mb-2" id="deleteBtn">삭제</button>
								<input type="hidden" name="gseq" value="${gvo.gseq}">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<hr class="tall" style="visibility: hidden;">
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>