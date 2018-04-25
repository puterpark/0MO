<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
   <div class="container">
      <div class="col-12 mb-4 mb-lg-0">
         <!-- <div>
            <button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/my_gongmo_like.do'">내가 좋아요 한 공모전</button>
         </div> -->
         <table class="table table-hover">
            <thead>
               <tr>
                  <th>구분</th>
                  <th>제목</th>
                  <th>등록일자</th>
               </tr>
            </thead>
            <tbody>
            <c:forEach items="${likeList}" var="l">
            	<c:choose>
            		<c:when test="${l.gvo.gseq != 0}">
		            	<tr onclick="location.href='/gongmo_detail.do?gseq=${l.gvo.gseq}'" style="cursor:pointer">
		                  <td style="vertical-align: middle;">공모</td>
		                  <td style="vertical-align: middle;">${l.gvo.gtitle}</td>
		                  <td style="vertical-align: middle;">${l.gvo.gregdate}</td>
		               </tr>
            		</c:when>
            		<c:when test="${l.svo.sseq != 0}">
		            	<tr onclick="location.href='/gongmo_detail.do?sseq=${l.svo.sseq}'" style="cursor:pointer">
		                  <td style="vertical-align: middle;">구직</td>
		                  <td style="vertical-align: middle;">${l.svo.stitle}</td>
		                  <td style="vertical-align: middle;">${l.svo.sregdate}</td>
		               </tr>
            		</c:when>
            		<c:when test="${l.ovo.oseq !=0}">
            			<tr onclick="location.href='/gongmo_detail.do?oseq=${l.ovo.gseq}'" style="cursor:pointer">
		                  <td style="vertical-align: middle;">구인</td>
		                  <td style="vertical-align: middle;">${l.ovo.otitle}</td>
		                  <td style="vertical-align: middle;">${l.ovo.oregdate}</td>
		               </tr>
            		</c:when>
            	</c:choose>
            </c:forEach>
            </tbody>
         </table>
         
         <hr class="short">
			
			<div style="width: 200px; margin: auto;">
				${html}
			</div>
      </div>
      
      
      
   </div>
</div>