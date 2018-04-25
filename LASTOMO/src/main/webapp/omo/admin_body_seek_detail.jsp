<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<c:choose>
	<c:when test="${SESS_ASEQ != null}">
<script>
	$(function() {
		$("#deleteBtn").click(function() {
			$(".deleteform").submit();
		});
	});
</script>
<script type="text/javascript">


$(function() {
	$("#deleteBtn").click(function() {
		$(".deleteform").submit(); 
	});
});

</script>


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
				<h1>구직게시판 상세보기</h1>
			</div>
		</div>
	</div>
</section>


<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2"
				onclick="javascript:history.back()">«이전</button>
		</div>
		
		<div class="row">
			<div class="featured-box featured-box-primary featured-box-text-left" style="height: 380px;">
				<div class="box-content">
					<div class="row">
						<h3>
							&nbsp;${svo.stitle}
						</h3>
					</div>
					<div class="row">
						<div class="col-12 mb-4 mb-lg-0">
							<div class="row">
								<div class="col-9 mb-4 mb-lg-0">
									<table style="height: 250px;">
										<col style="width: 20%;"></col>
										<col style="width: 85%;"></col>

										<tr>
											<td><b>이름</b></td>
											<td>${svo.mname}</td>
										</tr>
										<tr>
											<td><b>거주지역</b></td>
											<td style="padding-top: 8px;">${svo.msi2} ${svo.msgg2}
												${svo.memd2}</td>
										</tr>
										<tr>
											<td><b>활동지역</b></td>
											<td>${svo.msi1} ${svo.msgg1} ${svo.memd1}
											</td>
										</tr>
										<tr>
											<td><b>성별</b></td>
											<td style="padding-top: 8px;"><font class="btn-primary" 	disabled>&nbsp;${svo.mgender}&nbsp;</font></td>
										</tr>
											<td><b>직무</b></td>
											<td style="padding-top: 8px;"><c:forEach items="${seekDetailDuty}" var="sdd">
									<span class="badge badge-primary">${sdd.dname}</span>
							</c:forEach>
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
												<td>${svo.sview}</td>
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
													<form class="lcheckform" action="#" method="post">
														<!-- 	<div class="btn-group" data-toggle="buttons" id="like"> -->
														<label id="likeLbl" class="btn btn-outline btn-warning">
															<input type="checkbox" class="form-control field"
															id="likeBtn" name="lcheck" value="1" autocomplete="off"
															style="display: none;"><i class="far fa-heart"></i>
														</label>
			
													</form>
												</td>
												<td id="lcnt">${svo.lcnt}</td>
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
			<div class="col-12 mb-4 mb-lg-0">${svo.sbody}</div>
			<hr class="short">
			<div id="results" class="hidden"></div>
			<h4>[지도] 활동지역</h4>

				<div id="map" style="width:80%;height:350px;"></div>
			<br>
			
   													<div id="pdf"></div>
			<div>
				<button type="button" class="btn btn-outline btn-light mb-2"
					onclick="javascript:history.back()">«이전</button>
				<div style="float: right;">
					<div style="margin-bottom: 1px">
						<button type="button" class="btn btn-primary btn-sm mb-2"
							onclick="location.href='/admin_edit_seek.do?sseq=${svo.sseq}'">수정</button>
						&nbsp;
						<div style="float: right;">
							<form class="deleteform" action="/admin_seek_delete.do" method="post" id="deleteForm">
								<button type="button" class="btn btn-warning btn-sm mb-2" id="deleteBtn">삭제</button>
								<input type="hidden" name="sseq" value="${svo.sseq}">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<hr class="tall" style="visibility: hidden;">
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
 
var myPDF = PDFObject.embed("/uploads/pdf/pdf_sample.pdf", "#pdf", options);
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
var keywords = "${svo.msgg2}청";


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
           	
           	if(data[i].category_name ==  "사회,공공기관 > 행정기관"){
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
</c:when>
	<c:otherwise>
	<%@ include file="/tiles/admin_error.jsp" %>
	</c:otherwise>
</c:choose>
