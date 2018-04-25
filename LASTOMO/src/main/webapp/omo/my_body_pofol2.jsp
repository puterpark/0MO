<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.pdfobject-container {
    width: 100%;
    max-width: 200px;
    height: 350px;
    margin: 2em 0;
}
 
.pdfobject { border: solid 1px #666; }
#results { padding: 1rem; }
.hidden { display: none; }
.success { color: #4F8A10; background-color: #DFF2BF; }
.fail { color: #D8000C; background-color: #FFBABA; }
</style>

	<div class="col-lg-9">
	<table class="table table-hover">
	
				<thead>
					<tr>
						<th colspan="4">
<hr class="tall">

									<h1 class="mb-2 word-rotator-title">	
											<span class="word-rotator" data-plugin-options="{'delay': 2000, 'animDelay': 300}">
											<span class="word-rotator-items">
												<span>금천구</span>
												<span>동작구 </span>
											</span>
										</span>		
									<strong class="inverted">						
										<span class="word-rotator" data-plugin-options="{'delay': 2000, 'animDelay': 300}">
											<span class="word-rotator-items">
												<span> 개발자</span>
												<span> 디자이너</span>
												<span> 커피셔틀</span>


											</span>
										</span>
									</strong>
										입니다
									</h1>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td id="1" colspan="2">
						
						ㅁ기본정보<br>
						이름 : 윤공모<br>
나이 : 24살<br>
성별 : 여자<br>
지역 : 서울시 금천구 / 서울시 영등포구 <br>
<br>
<br>
<br>
<br>
<br>
★이부분은 작성받은 내용 (수정가능)<br>
(금천구에 살고 있습니다. )<br>
(공모전에 참여하고 싶어요. ) <br>
(공모전은 처음입니다…..etc)<br>
						
						</td>
						<td colspan="2">
						
<div id="results" class="hidden"></div>
    <div id="pdf"></div>
        <input type="button" value="결제">
    
</td>
					</tr>
					<tr >
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
					</tr>
					</tr>
					<tr >
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
						<td>구인구직담당자관할</td>
					</tr>

				</tbody>
			</table>
</div>
    <body>
        <form action="https://v2.convertapi.com/docx/to/pdf?Secret=RgOH5SdqKt26Dr8i&download=attachment" method="post" enctype="multipart/form-data">
            <input type="file" name="File" />
            <input type="submit" value="Convert file"/>
        </form>
    </body>


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
    PDFJS_URL: "/pdfjs/web/viewernone1.jsp"
};
 
var myPDF = PDFObject.embed("/uploads/pdf_sample.pdf", "#pdf", options);


 
/* var el = document.querySelector("#results");
el.setAttribute("class", (myPDF) ? "success" : "fail");
el.innerHTML = (myPDF) ? "PDFObject was successful!" : "Uh-oh, the embed didn't work.";
 */
</script>