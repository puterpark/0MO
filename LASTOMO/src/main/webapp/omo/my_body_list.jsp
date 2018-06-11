<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9">
   <div class="container">
      <div class="col-12 mb-4 mb-lg-0">
         <div>
            <button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/userDetail.do?gubun=GONGMO'">내가 쓴 공모전</button>
         </div>
         <table class="table table-hover">
         	<col style="width: 50%;"></col>
            <col style="width: 35%;"></col>
            <col style="width: 15%;"></col>
            <thead>
               <tr>
                  <th>공모전</th>
                  <th>주최</th>
                  <th>등록일자</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${glist}" var="g">
               <tr onclick="location.href='/gongmo_detail.do?gseq=${g.gseq}'" style="cursor:pointer">
               		<td>${g.gtitle}</td>
               		<td>${g.gspon}</td>
               		<td>${g.gregdate}</td>
               		<tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
      
      <hr class="tall">
      
      <div class="col-12 mb-4 mb-lg-0">
         <div>
            <button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/mt_offer_list.do'">내가 쓴 모셔가요</button>
         </div>
 <table class="table table-hover">
         	<col style="width: 70%;"></col>
            <col style="width: 15%;"></col>
            <col style="width: 15%;"></col>
            <thead>
               <tr>
                  <th>제목</th>
                  <th>좋아요</th>
                  <th>등록일자</th>
               </tr>
            </thead>
            <tbody>
            	<c:forEach items="${olist}" var="o">
               <tr onclick="location.href='/guin_detail.do?oseq=${o.oseq}'" style="cursor:pointer">
                  <td style="vertical-align: middle;">${o.otitle}</td>
                  <td style="vertical-align: middle;">${o.lcnt}</td>
                  <td style="vertical-align: middle;">${o.oregdate}</td>
                  
               </tr>
               </c:forEach>
               
            </tbody>
         </table>
      </div>
      
      <hr class="tall">
      
      <div class="col-12 mb-4 mb-lg-0">
         <div>
            <button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/userDetail.do?gubun=SEEK'">내가 쓴 기다려요</button>
         </div>
         <table class="table table-hover">
     	    <col style="width: 70%;"></col>
            <col style="width: 15%;"></col>
            <col style="width: 15%;"></col>
            <thead>
               <tr>
                  <th>제목</th>
                  <th>좋아요</th>
                  <th>등록일자</th>
               </tr>
            </thead>
            <tbody>
            	<c:forEach items="${slist}" var="s">
               <tr onclick="location.href='/gujik_detail.do?sseq=${s.sseq}'" style="cursor:pointer">
                  <td style="vertical-align: middle;">${s.stitle}</td>
                  <td style="vertical-align: middle;">${s.lcnt}</td>
                  <td style="vertical-align: middle;">${s.sregdate}</td>
                  
               </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </div>
</div>