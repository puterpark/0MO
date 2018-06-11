<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<script>
	$(function() {
		$("#deleteBtn").click(function() {
			$(".deleteform").submit();
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
				<c:if test="${ovo.mseq == SESS_MSEQ || SESS_MSEQ == 1}">
				<button type="button" class="btn btn-outline btn-warning mb-2" id="reportBtn"><i class="fas fa-ban"></i></button>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="featured-box featured-box-primary featured-box-text-left"
				style="width: 100%; height: 370px;">
				<div class="box-content">
					<div class="row">
						<div>
							<h3>
								<i class="far fa-check-circle"></i>&nbsp;${ovo.otitle}
							</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-12 mb-4 mb-lg-0">
							<div class="row">
								<div class="col-9 mb-4 mb-lg-0">
									<table style="height: 250px; width: 100%;">
										<col style="width: 30%;"></col>
										<col style="width: 70%;"></col>

										<tr>
											<td><b>아이디</b></td>
											<td>${ovo.mid}</td>
										</tr>
										<tr>
											<td><b>활동지역</b></td>
											<td>${ovo.msi1} ${ovo.msgg1}</td>
										</tr>
										<tr>
											<td><b>성별</b></td>
											<td style="vertical-align: middle;">
											<c:choose>
												<c:when test="${ovo.mgender == 'm'}">
													남성
												</c:when>
												<c:otherwise>
													여성
												</c:otherwise>
											</c:choose>
											</td>
										</tr>
										<tr>
											<td><b>준비중인<br>공모전</b></td>
											<td style="vertical-align: middle;"><a href="/gongmo_detail.do?gseq=${ovo.gseq}">${ovo.gtitle}</a>
											</td>
										</tr>
										<tr>
											<td><b>직무</b></td>
											<td style="padding-top: 8px;">
														<c:forEach items="${ovo.dlist}" var="dlist">
															<button type="button" class="btn btn-outline btn-light btn-xs mb-2">${dlist.dname}</button>
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
												<td>${ovo.oview}</td>
											</tr>
											<tr>
												<td colspan="2"><br> <br></td>
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
												<td id="lcnt">${ovo.lcnt}</td>
											</tr>
											<tr>
												<td colspan="2"><br> <br></td>
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
			<br>
			<h4 style="display: inline-block;">▣Detail</h4>
			<hr class="short">
			<div class="col-12 mb-4 mb-lg-0">${ovo.obody}</div>

			<hr class="tall">
			<br>
			<h4>[지도] 활동지역</h4>

				<div id="map" style="width:80%;height:350px;"></div>
			

			

			<hr class="short">


			<div>
				<button type="button" class="btn btn-outline btn-light mb-2"
					onclick="javascript:history.back()">«이전</button>
					<c:if test="${ovo.mseq == SESS_MSEQ || SESS_MSEQ == 1}">
				<div style="float: right;">
					<div style="margin-bottom: 1px">
						<button type="button" class="btn btn-primary btn-sm mb-2"
							onclick="location.href='/guin_edit.do?oseq=${ovo.oseq}'">수정</button>
						&nbsp;
						<div style="float: right;">
							<form class="deleteform" action="/delete_offer.do"
								method="post">
								<button type="button" class="btn btn-warning btn-sm mb-2"
									id="deleteBtn">삭제</button>
								<input type="hidden" name="oseq" value="${ovo.oseq}">
							</form>
						</div>
					</div>
				</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
<hr class="tall" style="visibility: hidden;">
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
var keywords = "${ovo.msgg1}청";


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
