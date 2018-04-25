<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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



</script>

</head>

   <body> 
 
   <form action="/fileUpload.do" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data" >
    pdf파일만 첨부해주세요. <br>
    파일 : <input type="file" name="upfile" > <br> 
    <input type="button" name="업로드" value="제출" onclick = "fileCheck(this.form)"><br> 
    </form> 
    </body>
    
    
        <body>
        <form action="https://v2.convertapi.com/docx/to/pdf?Secret=RgOH5SdqKt26Dr8i&download=attachment" method="post" enctype="multipart/form-data" >
            <input type="file" name="File" />
            <input type="submit" value="Convert file"/>
        </form>
    </body>
    <br>
    <br>
    <br>
    <br>
    <br>
    
    
   
   <div id="player"></div>

    <script>
      // 2. This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.
      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '360',
          width: '640',
          videoId: 'M7lc1UVf-VE',
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {
        event.target.playVideo();
      }

      // 5. The API calls this function when the player's state changes.
      //    The function indicates that when playing a video (state=1),
      //    the player should play for six seconds and then stop.
      var done = false;
      function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
          setTimeout(stopVideo, 6000);
          done = true;
        }
      }
      function stopVideo() {
        player.stopVideo();
      }
    </script>
    
    


