<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.pdfobject-container {
    width: 100%;
    max-width: 770px;
    height: 700px;
    margin: 2em 0;
    opacity: 1;
}
 
.pdfobject { border: solid 1px #666; }
#results { padding: 1rem; }
.hidden { display: none; }
.success { color: #4F8A10; background-color: #DFF2BF; }
.fail { color: #D8000C; background-color: #FFBABA; }
</style>
<script src="/pdfjs/pdfobject.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#deleteBtn").click(function() {
		$(".deleteform").submit(); 
	});
});


$(function() {
	$("#replydeleteBtn").click(function() {
		$(".replydeleteform").submit(); 
	});
});

$(function() {
	$("#updateBtn").click(function() {
		$(".updateform").submit(); 
	});
});


</script>
<script>
function paypofol(pdf){
	if (confirm("포인트를 사용하시겠습니까?") == true){
		return;
	}else{   //취소
	    return;
	}
}


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

<script type="text/javascript">
	$(document).ready(function(){
	    $("#up").click(function(){
	    	var pay = $("#hiddenkey").val();   
			console.log(pay);
			$("#paybtnform").submit();
		});
	});
</script>




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
				<c:if test="${seekDetail.mseq == SESS_MSEQ || SESS_MSEQ == 1}">
				<button type="button" class="btn btn-outline btn-warning mb-2" id="reportBtn"><i class="fas fa-ban"></i></button>
				</c:if>
			</div>
		</div>

		<div style="margin-bottom: 1px"> </div> 
		<div class="row">
			<div class="featured-box featured-box-primary featured-box-text-left" style="width: 100%; height: 340px;">
				<div class="box-content">
					<div class="row">
						<div>
							<h3 class="mb-0"> ${seekDetail.stitle} </h3>
						</div>
					</div>
					<div class="row">						
						<div class="col-12 mb-4 mb-lg-0">
							<div class="row">
								<div class="col-9 mb-4 mb-lg-0" style="padding-top: 30px">
									<table style="height: 200px; width: 100%;">
										<col style="width: 30%;"></col>
										<col style="width: 70%;"></col>

										<tr>
											<td><b>아이디</b></td>
											<td>${seekDetail.mid}</td>
										</tr>
										<tr>
											<td><b>활동지역</b></td>
											<td>${seekDetail.msi1} ${seekDetail.msgg1} ${seekDetail.memd1} ${seekDetail.mdetail1}</td>
										</tr>
										<tr>
											<td><b>성별</b></td>
											<td style="vertical-align: middle;">
											<c:choose>
												<c:when test="${seekDetail.mgender == 'm'}">
													남성
												</c:when>
												<c:otherwise>
													여성
												</c:otherwise>
											</c:choose>
											</td>
										</tr>
										<tr>
											<td><b>직무</b></td>
											<td style="padding-top: 8px;">
												<c:forEach items="${seekDetailDuty}" var="sdd">
													<button type="button" class="btn btn-outline btn-light btn-xs mb-2">${sdd.dname}</button>
												</c:forEach>
											</td>
										</tr>

									</table>
								</div>
								<div class="col-3 mb-4 mb-lg-0" style="padding-top: 10px">
									<div>
										<table style="text-align: center;">
											<col style="width: 20%;"></col>
											<col style="width: 50%;"></col>
	
											<tr>
												<td colspan="2">조회한 사람들</td>
											</tr>
											<tr style="font-size: 2em">
												<td><i class="fas fa-eye"></i></td>
												<td>${seekDetail.sview}</td>
											</tr>
											<tr>
												<td colspan="2"><br>
												<br></td>
											</tr>
											<tr>
												<td colspan="2">좋아요한 사람들</td>
											</tr>
											<tr style="font-size: 2em">
												<td>
												<c:choose>
													<c:when test="${SESS_MSEQ != null}">
														<label id="likeLbl" class="btn btn-outline btn-warning"> 
															<input type="checkbox" class="form-control field" id="likeBtn" name="lcheck" value="1" autocomplete="off" style="display: none;"><i class="far fa-heart"></i>
														</label>
													</c:when>
													<c:otherwise>
														<i class="fas fa-heart"></i>
													</c:otherwise>
												</c:choose>
												</td>
												<td> ${seekDetail.lcnt} </td>
											</tr>
											<tr>
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
	
						
		<h4 style="display: inline-block;">▣Detail </h4>
		<hr class="short">
		<div class="col-12 mb-4 mb-lg-0">
			<div class="col-lg-14">			
				<div class="col-12 mb-4 mb-lg-0">
					${seekDetail.sbody}
					<div class="col-lg-14">			
							
					<hr class="tall">
					<h4>[지도] 활동지역 </h4>

								<div id="map" style="width:100%;height:350px;"></div>
								<br><br><br>
					<h4 style="display: inline-block;">▣Portfolio </h4>
					<hr class="short">
					<c:choose>
						<c:when test="${seekDetail.pffile eq null}">
							포트폴리오가 없습니다.
						</c:when>
   						<c:when test="${gubun eq 5}">
   							<form action="/gujik_detail.do?"  id="paybtnform" >
   							<input type="hidden" name="sseq" id="hiddenkey" value="${seekDetail.sseq}">
   							<input type="hidden" name="paykey" id="hiddenkey" value="10">
							<button type="button" id="up" class="btn btn-primary btn-sm mb-2">포트폴리오 결제하기</button>
							</form>
   						</c:when>
					
						<c:when test="${gubun eq 1}"><!-- 결제 한사람  -->
							<div id="results" class="hidden"></div>
							<div id="pdf"></div>
   						</c:when>
   						
	   				</c:choose>	
			<c:if test="${seekDetail.mseq ==  SESS_MSEQ || SESS_MSEQ == 1}">
			<div style="float: right;">
				<form class="updateform" action="/gujik_update.do" method="post" id="updateForm" style="display: inline-block;">
							<button type="button" class="btn btn-primary btn-sm mb-2" id="updateBtn">수정</button>
							<input type="hidden" name="sseq" value="${seekDetail.sseq}">
						</form>
				
				<form class="deleteform" action="/gujik_delete.do" method="post" id="deleteForm" style="display: inline-block;">
							<button type="button" class="btn btn-warning btn-sm mb-2" id="deleteBtn">삭제</button>
							<input type="hidden" name="sseq" value="${seekDetail.sseq}">
						</form>
			</div>
			<div style="visibility: hidden;">히든</div>
   			</c:if>
			<div class="post-block post-comments clearfix">
					<h3 class="heading-primary">
						<i class="fas fa-comments"></i>Comments ${seekRcnt.rcnt}
					</h3>
				
					<ul class="comments">
						<li>
						
								<c:forEach items="${seekReply}" var="sr">
							<div class="comment">
								<div class="comment-block">
									<div class="comment-arrow"></div>
									<span class="comment-by"> <strong>${sr.rmid}</strong> 
									<span
										class="float-right">
												
												
	<script>
	function kang(rseq) {
		/* var d = $('.k').attr('id'); */
		$('#editBtn'+rseq).hide();
		$('#saveBtn'+rseq).show();
		$('#con'+rseq).attr('contenteditable','true');
		$('#con'+rseq).focus();
	}
	
	
	function pang(rseq) {
		/* var d = $('.k').attr('id'); */
		$('#saveBtn'+rseq).hide();
		$('#editBtn'+rseq).show();
		$('#con'+rseq).attr('contenteditable','false');
		var k = $('#con'+rseq).text();
		$('#val').val(k);
		$('#rupdatesubmit').submit();
	}
	
	</script>
					
								<form class="replydeleteform" action="/gujik_reply_delete.do" method="post" id="replydeleteform">
									<input type="hidden" name="sseq" value="${seekDetail.sseq}">
									<input type="hidden" name="rseq" value="${sr.rseq}">
								</form>
					<c:choose>
					 	<c:when test="${sr.rmseq eq SESS_MSEQ}">
								<button type="button" class="btn btn-primary btn-xs mb-2" style="float: right;" id="replydeleteBtn"> delete </button>
	
								<button type="button" id="editBtn${sr.rseq }" class="btn btn-primary btn-xs mb-2" style="float: right;" onclick="kang(${sr.rseq})"> edit </button>
								
								<button type="button" id="saveBtn${sr.rseq }" class="btn btn-primary btn-xs mb-2" style="float: right; display:none;" onclick="pang(${sr.rseq})"> save </button>
						</c:when>
						<c:otherwise>
								<button type="button" class="btn btn-primary btn-xs mb-2" style="float: right;"> report </button>
						</c:otherwise>
						</c:choose>
							</span>
					</span>
							<form action="/gujik_reply_update.do" method="post" id="rupdatesubmit">
											<input type="hidden" value="${seekDetail.sseq}" name="sseq"> 
											<input type="hidden" value="${sr.rbody}" name="rbody" id="val">
											<input type="hidden" value="${SESS_MSEQ }" name="rmseq">
											<p id="con${sr.rseq}" class="k">${sr.rbody}</p>
							</form>
											<span class="date float-right">${sr.rregdate}</span>
						
										</div>
									</div>
										</c:forEach>
								<!-- foreach -->
									
							</ul>
						</div>
						<div class="post-block post-leave-comment">
							<form action="/gujik_reply_insert.do" method="post">
								<input type="hidden" value="${SESS_MSEQ}" name="rmseq"/>
								<input type="hidden" value="${seekDetail.sseq}" name="sseq"/>							
								<div class="form-row">
									
								</div>
								<div class="form-row">
									<div class="form-group col">
										<label>Comment *</label>
										<textarea maxlength="3000" rows="3" class="form-control"
											name="rbody" id="rbody" style="resize:none;"></textarea>
									</div>
								</div>
								<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
								<div class="form-row" style="float: right;">
									<div class="form-group col">
										<input type="submit" value="Post Comment"
											class="btn btn-primary btn-lg" data-loading-text="Loading...">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>




<script>
var options = {
    pdfOpenParams: {
        navpanes: 0,
        toolbar: 0,
        statusbar: 0,
        view: "FitV",
        pagemode: "thumbs",
        page: 1
    },
    forcePDFJS: true,
    PDFJS_URL: "/pdfjs/web/viewer1.jsp"
};
 
var myPDF = PDFObject.embed("/uploads/pdf/${seekDetail.pffile}", "#pdf", options);
</script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f9464a4c95f997a019636010d0aad75&libraries=services"></script>
<script>

var infowindow = new daum.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), 
    mapOption = {
        center: new daum.maps.LatLng(37.566826, 126.9786567), 
        level: 2
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new daum.maps.services.Places(); 

//키워드 객체 생성.
var keywords = "${seekDetail.msgg1}청";


console.log(keywords);

// 키워드로 장소를 검색합니다
ps.keywordSearch(keywords, placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === daum.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new daum.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
           	console.log(data[i]);
           	console.log(data[i].category_name);
           	
           	if(data[i].category_name ==  "사회,공공기관 > 행정기관 > 행정기관관련기타"){
           		console.log("행정기관입니다아~");
           		 bounds.extend(new daum.maps.LatLng(data[i].y, data[i].x));
          	 	map.setBounds(bounds);
          	 	return;
           	}
           	
           	
           
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new daum.maps.Marker({
        map: map,
        position: new daum.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    daum.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}
</script>
