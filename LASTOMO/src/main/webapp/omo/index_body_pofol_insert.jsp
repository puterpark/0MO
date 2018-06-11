<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 여기에 사이드 우측 바디에 들어갈 컨텐츠를 작성 -->


<style>
/* body {margin: 10px}
.where {
  display: block;
  margin: 25px 15px;
  font-size: 11px;
  color: #000;
  text-decoration: none;
  font-family: verdana;
  font-style: italic;
}  */

.filebox input[type="file"] {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip:rect(0,0,0,0);
    border: 0;
}

.filebox label {
    display: inline-block;
    padding: .5em .75em;
    color: #999;
    font-size: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: #fdfdfd;
    cursor: pointer;
    border: 1px solid #ebebeb;
    border-bottom-color: #e2e2e2;
    border-radius: .25em;
}

/* named upload */
.filebox .upload-name {
    display: inline-block;
    padding: .5em .75em;
    font-size: inherit;
    font-family: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: #f5f5f5;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
}

.filebox.bs3-primary label {
  color: #fff;
    background-color: #337ab7;
    border-color: #2e6da4;
}
</style>

<script language="javascript">
 
function fileCheck(frm) {   

  var file = frm.upfile.value;
  var FileFilter = /\.(pdf)$/i;
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
     alert("pdf파일만 업로드 가능합니다."+"\n 업로드할 파일을 "
     + " 다시 선택하여 주세요.");
     return false;
   }

} 



$(document).ready(function(){
	  var fileTarget = $('.filebox .upload-hidden');

	    fileTarget.on('change', function(){
	        if(window.FileReader){
	            var filename = $(this)[0].files[0].name;
	        } else {
	            var filename = $(this).val().split('/').pop().split('\\').pop();
	        }

	        $(this).siblings('.upload-name').val(filename);
	    });
	}); 
 

</script>

<br>

<div role="main" class="main">
	<div class="container">
		<div style="margin-bottom: 1px">
			<button type="button" class="btn btn-outline btn-light mb-2" onclick="javascript:history.back()">«이전</button>
			<div style="float: right;">
				<!-- <button type="button" class="btn btn-outline btn-primary mb-2" id="gujikBtn">저장</button> -->
				 <input type="button" class="btn btn-outline btn-primary mb-2" name="업로드" value="저장" onclick = "fileCheck(fileUpload)">
				<!-- onclick="location.href='/index.do'" -->
			</div>
		</div>

		
		<div class="row">
			<div class="col">
				<section class="card card-admin">
					<div class="card-body">
						<form class="form-horizontal form-bordered insertform" id="fileUpload" action="/mypofol_insert.do" method="post" enctype="multipart/form-data">
							<div style="visibility: hidden;">히든<br></div>
							<input type="hidden" value="${SESS_MSEQ}" name = "mseq">
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">포트폴리오 제목</label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="pftitle" name="pftitle" placeholder="제목을 입력해주세요." required>
								</div>
							</div>
							<hr class="short">
							
							<div class="form-group row">
								<label class="col-lg-3 control-label text-lg-right pt-2">PDF</label>
								<div class="col-lg-6">

												    
												    <div class="filebox bs3-primary">
                            <input class="upload-name" value="파일선택" disabled="disabled">

                            <label for="ex_filename">업로드</label> 
                          <input type="file" id="ex_filename" class="upload-hidden" name="upfile">
                          <br>* pdf파일만 첨부해주세요. <br> 
                        <!-- </div> -->
							 <br> 
												
												   <!--  -->

												    <!--  -->
												    
												   <!--  <input type="button" class="btn btn-outline btn-light mb-2" name="업로드" value="제출" onclick = "fileCheck(this.form)"> --><br> 
												    
								
												       

							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<hr class="tall" style="visibility: hidden;">
</div>

