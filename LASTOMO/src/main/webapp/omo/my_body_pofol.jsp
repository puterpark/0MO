<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.pdfobject-container {
    width: 100%;
    max-width: 375px;
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
				<td colspan="4">
				<script language="javascript">

function fileCheck(frm) {   

  var file = frm.upfile.value;
  var FileFilter = /\.(pdf)$/i;
  var extArray = new Array(".pdf");   
  var bSubmitCheck = false;
    
  if( !file ){ 
    alert( "파일을 첨부해주세요.");
    return false;
  }
  
  if( frm.upfile.value.match(FileFilter))
  { 
    bSubmitCheck = true;
  }
  
  
  if (bSubmitCheck) {
     frm.submit(); 
   } else {
     alert("다음 파일만 업로드가 가능합니다.\n\n"  + (extArray.join("  ")) + "\n\n 업로드할 파일을 "
     + " 다시 선택하여 주세요.");
     return false;
   }

}

</script>

</head>

   <body> 
 
   <form action="/fileUpload.do" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data" >
    pdf파일만 첨부해주세요. <br>
    파일 : <input type="file" name="upfile" > <br> <input type="button" name="업로드" value="제출" onclick = "fileCheck(this.form)"><br> 
    </form> 
    </body>
				</td>
				</tr>
				
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
 
var myPDF = PDFObject.embed("/uploads/pdf_sample.pdf", "#pdf", options);
 
/* var el = document.querySelector("#results");
el.setAttribute("class", (myPDF) ? "success" : "fail");
el.innerHTML = (myPDF) ? "PDFObject was successful!" : "Uh-oh, the embed didn't work.";
 */
</script>