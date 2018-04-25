<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->

<script type='text/javascript'>
   $(document).ready(
         function() {
            var scheduleArr = new Array();
            var now = new Date();

            <c:forEach items="${LVL_CAL}" var="cal">
	            var sdate = new Date(new Date("${cal.gsday}"))
	                  .toDateString("yyyy-MM-dd");
	            var edate = new Date(new Date("${cal.geday}"))
	                  .toDateString("yyyy-MM-dd");
	
	            var gtitle = '${cal.gtitle}'; // + '--'+'${fn:length(cal.gtitle)}';
	            /*          <c:if test="${fn:length(cal.gtitle) > 16}">
	             gtitle = "${fn:substring(cal.gtitle, 1, 12)}..."; 
	             </c:if>  */
	
	            var json = {
	               title : gtitle,
	               start : sdate,
	               end : edate,
	               url : '/gongmo_detail.do?gseq=${cal.gseq}'
	            };
	            scheduleArr.push(json);
	            //console.log(scheduleArr);
            </c:forEach>

            $('#calendar').fullCalendar({
               header : {
                  left : 'prev, today',
                  center : 'title',
                  right : 'month, next'
               },
               defaultDate : now,
               editable : false,
               eventLimit : true, // allow "more" link when too many events
               events : scheduleArr
            });

         });
</script>



<style type='text/css'>
th.fc-day-header {
   color: black;
}

td.fc-day-top{
   color: black;
}
a.fc-more {
   color: black;
}

td.fc-more-cell{
   color: gray;
   }
/* .fc-title{
   color: blue;
}    */
/* .td fc-day-number{ color:black;} */
</style>

<div class="col-lg-9">
	<div class="container">
		<div class="col-12 mb-4 mb-lg-0">
			<button type="button" class="btn btn-outline btn-primary mb-2" onclick="location.href='/gongmo.do'">전체보기</button>
			<button type="button" class="btn btn-primary mb-2">달력으로 보기</button>
			<div id="calendar" style="max-width: 850px; margin: 30 auto; color: white;"></div>
		</div>
	</div>
</div>
