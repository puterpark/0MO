<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
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

<script>
	$(function() {
		$("#likeBtn").click(function() {
			var id = $(this).attr("id");
/* 			var mseq = "${SSES_MSEQ}"; */
			var mseq = $("#mseq").val();
			var gseq = "${gvo.gseq}";
			var obj = new Object();
			obj.mseq = mseq;
			obj.gseq = gseq;
			console.log(obj);
			
			if(id.indexOf("like") != -1) {
				console.log("id:"+id);				
				$("#likeLbl").attr("class", "btn btn btn-warning");
				$(this).attr("id", "hateBtn");
				obj.lcnt = 1;
				
				$.ajax({
					url: "/gongmo_like.do",
				 headers:{
	                      'Content-Type':'application/json'
	                   },
					type: "post",
					data: JSON.stringify(obj),
					success: function(result){
						console.log("+1됨");
						$("#lcnt").html(result);
					}
				});
				
			} else {
				console.log("id:"+id);				
				$("#likeLbl").attr("class", "btn btn-outline btn-warning");
				$(this).attr("id", "likeBtn");
				obj.lcnt = -1;

				$.ajax({
					url: "/gongmo_like.do",
				 headers:{
	                      'Content-Type':'application/json'
	                   },
					type: "post",
					data: JSON.stringify(obj),
					success: function(result){
						console.log("-1됨");
						$("#lcnt").html(result);
					}
				});
				
			}
		});
	});
</script>

<script>
	$(function() {
		$("#reportBtn").click(function() {
			swal({
				title: "신고 사유를 적어주세요.",			
				content: "input",
				icon: "warning",
				buttons: true,
				dangerMode: true 
			})
			.then((value) => {
				console.log(value);
 				swal(value);
 				$("#brwhy").val(value);
				//$(".reportform").submit(); 			
				console.log("전송완료");
			})
			.then(() => {
				swal("신고되었습니다.", {
					icon: "success",
				})
				.then(() => {
					$(".reportform").submit();
				});
			});
		}); 
		
	});
</script>
<input type="hidden" id="mseq" value="${SESS_MSEQ}">
<form class="reportform" action="/gongmo_report.do" method="post">
	<input type="hidden" id="brwhy" name="brwhy">
	<input type="hidden" id="gseq" name="gseq" value="${gvo.gseq}">
</form>
<div class="col-lg-9">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:window.open('https://twitter.com/intent/tweet?text=[%EA%B3%B5%EC%9C%A0]%20'
					+encodeURIComponent(document.URL)+'%20-%20'+encodeURIComponent(document.title), 'twittersharedialog',
					 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
						target="_blank" alt="Share on Twitter"><i class="fab fa-twitter"></i></button>
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:window.open('https://www.facebook.com/sharer/sharer.php?u='
					+encodeURIComponent(document.URL)+'&amp;t='+encodeURIComponent(document.title), 'facebooksharedialog',
					 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');return false;"
						target="_blank" alt="Share on Facebook" style="padding-left: 10px; padding-right: 10px;">&nbsp;&nbsp;<i class="fab fa-facebook-f">&nbsp;</i></button>
				<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()"><i class="far fa-envelope"></i></button>
				<c:if test="${SESS_MSEQ != null}">
				<button type="button" class="btn btn-outline btn-warning mb-2" id="reportBtn"><i class="fas fa-ban"></i></button>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="featured-box featured-box-primary featured-box-text-left" style="width: 100%; height: 380px;">
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
												<td>
												<!-- <form class="lcheckform" action="/gongmo_like.do" method="post"> -->
												<!-- 	<div class="btn-group" data-toggle="buttons" id="like"> -->
												
												<c:choose>
													<c:when test="${SESS_MSEQ != null}">
														<c:choose>
															<c:when test="${likeInfo == 0}">
																<label id="likeLbl" class="btn btn-outline btn-warning"> 
																	<input type="checkbox" class="form-control field" id="likeBtn" name="lcheck" value="1" autocomplete="off" style="display: none;"><i class="far fa-heart"></i>
																</label>
															</c:when>
															<c:otherwise>
																<label id="hateBtn" class="btn btn btn-warning"> 
																	<input type="checkbox" class="form-control field" id="likeBtn" name="lcheck" value="1" autocomplete="off" style="display: none;"><i class="far fa-heart"></i>
																</label>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<i class="fas fa-heart"></i>
													</c:otherwise>
												</c:choose>
												
													<!--  <label class="btn btn btn-warning"> 
															<input type="checkbox" class="form-control field" id="hateBtn" name="lcheck" value="-1" autocomplete="off" style="display: none;"><i class="fas fa-heart"></i>
														</label> - -->
											<!-- 		</div> -->
<!-- 												</form> -->
												</td>
												<td id="lcnt">${gvo.lvo.lcnt}</td>
											</tr>
											<tr><td colspan="2"><br><br></td></tr>
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
				<c:if test="${gvo.mseq == SESS_MSEQ || SESS_MSEQ == 1}">
				<div style="float: right;">
					<div style="margin-bottom: 1px">
						<button type="button" class="btn btn-primary btn-sm mb-2" onclick="location.href='/gongmo_edit_page.do?gseq=${gvo.gseq}'">수정</button>
						&nbsp;
						<div style="float: right;">
							<form class="deleteform" action="/gongmo_delete.do" method="post">
								<button type="button" class="btn btn-warning btn-sm mb-2" id="deleteBtn">삭제</button>
								<input type="hidden" name="gseq" value="${gvo.gseq}">
								<input type="hidden" name="mseq" value="${gvo.mvo.mseq}">
							</form>
						</div>
					</div>
				</div>
				</c:if>
			</div>
		</div>
	</div>
</div>