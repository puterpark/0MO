<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->
<div class="col-lg-9" align="center">
	<font size="5"><b>결제가 완료 되었습니다.</b></font>
	<hr class="short">
	
	<table class="table table-bordered">
		<col style="width:30%"></col>
		<thead>
			<tr>
				<td align="center">
					<strong>충전 포인트</strong>
				</td>
				<td align="center">
					<strong>${LVL_PAYCOM.popoint}</strong>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center">
					<strong>결제 금액</strong>
				</td>
				<td align="center">
					<strong>${LVL_PAYCOM.pamoney}</strong>
				</td>
			</tr>
			<tr>
				<td align="center">
					<strong>결제 수단</strong>
				</td>
				<td align="center">
					<strong>${LVL_PAYCOM.ptname}</strong>
				</td>
			</tr>
		</tbody>
	</table>
	
	<div class="col">
		<button class="btn btn-outline btn-quaternary mb-2" type="button" onclick="location.href='/my_body_paylook.do'">결제내역보기</button>
		<button class="btn btn-outline btn-quaternary mb-2" type="button" onclick="location.href='/index.do'">홈으로 가기</button>
	</div>
	
</div>

