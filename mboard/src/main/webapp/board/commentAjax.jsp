<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>댓글입력</title>
		<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		  $(function(){
		      alert("자동실행 테스트");
			  $.ajax({
				  url:"../js/comment_data.json",  // 받아올 url
					 type:"get",                   // 요청방식 post,get
					 dataType:"json",              // 리턴 타입 
					 data:{                        // 보내는 데이터
						 // url로 데이터 전달할것이 있으면 입력
					 },
					 success:function(data){
						 var html;
						 for(var i=0;i<data.length;i++){
								html = html + "<tr>"; 
								html = html + "<td>"+data[i].bname+"</td>"; 
								html = html + "<td>"+data[i].bcontent+"</td>"; 
								html = html + "</tr>"; 
						 }
						 
						 $("#ajaxData").html(html);
					 },
					 error:function(){
						 alert("실패");
					 }
			  });
		  }); //$function
		  
		  //클릭해서 실행
		  function ajaxAdd(){
			  $.ajax({
				 //url:"#",  // 받아올 url
				 //type:"get",                   // 요청방식 post,get
				 //dataType:"json",              // 리턴 타입 
				 data:{                        // 보내는 데이터
					 "bname":$("#bname").val(),
					 "bcontent":$("#bcontent").val()
					 // url링크로 보내서 -> db에 저장후 -> 다시 입력한 data가져오기                          
					 // url로 데이터 전달할것이 있으면 입력
				 },
				 success:function(data){
					 var html;
					 html = html + "<tr>"; 
					 html = html + "<td>"+$("#bname").val()+"</td>"; 
					 html = html + "<td>"+$("#bcontent").val()+"</td>"; 
					 html = html + "</tr>"; 
					 
					 $("#ajaxData").prepend(html);
					 $("#bname").val("");
					 $("#bcontent").val("");
				 },
				 error:function(){
					 alert("실패");
				 }
			  });
		  }
		
		
		
		</script>
		
		
	</head>
	<body>
	  <h3>댓글화면</h3>
	  <form>
	    <label>이름</label>
	    <input type="text" id="bname" name="bname"><br>
	    <label>내용</label>
	    <input type="text" id="bcontent" name="bcontent"><br>
	  </form>
	  <br>
	  <button type="button" onclick="ajaxAdd()">댓글등록</button>
	  <br><br>
	  <table>
	    <tr>
	      <th>이름</th>
	      <th>내용</th>
	    </tr>
	    <tbody id="ajaxData">
	        <!-- 데이터 들어감 -->
		    <tr>
		      <td>홍길동</td>
		      <td>내용</td>
		    </tr>
	    </tbody>
	  
	  </table>
	
	</body>
</html>