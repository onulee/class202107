<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajaxTest</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		  //100개 json데이터 가져오기
		  function ajaxDo(){
		      alert("스크립트 테스트");
			  $.ajax({
				 url:"../js/board_data.json",  // 받아올 url
				 type:"post",                   // 요청방식 post,get
				 data:{                        // 보내는 데이터
					 "bid":1
				 },
				 dataType:"json",              // 리턴 타입 
				 success:function(data){
					 alert("성공");
					 var html;
					 for(var i=0;i<data.length;i++){
							html = html + "<tr>"; 
							html = html + "<td>"+data[i].bid+"</td>"; 
							html = html + "<td>"+data[i].btitle+"</td>"; 
							html = html + "<td>"+data[i].bname+"</td>"; 
							html = html + "<td>"+data[i].bgroup+"</td>"; 
							html = html + "</tr>"; 
					 }
					 
					 $("#ajaxData").html(html);
				 },
				 error:function(){
					 alert("실패");
				 }
			  });
		  }
		  
		  // list 1개 데이터 추가
		  function ajaxAdd(){
			  alert("추가 테스트");
			  $.ajax({
				 //url:"#",  // 받아올 url
				 //type:"get",                   // 요청방식 post,get
				 //dataType:"json",              // 리턴 타입 
				 data:{                        // 보내는 데이터
					 "bid":$("#bid").val(),
					 "btitle":$("#btitle").val(),
					 "bname":$("#bname").val(),
					 "bgroup":$("#bgroup").val()
					 // url링크로 보내서 -> db에 저장후 -> 다시 입력한 data가져오기                          
					 // url로 데이터 전달할것이 있으면 입력
				 },
				 success:function(data){
					 alert("성공");
					 var html;
					 html = html + "<tr>"; 
					 html = html + "<td>"+$("#bid").val()+"</td>"; 
					 html = html + "<td>"+$("#btitle").val()+"</td>"; 
					 html = html + "<td>"+$("#bname").val()+"</td>"; 
					 html = html + "<td>"+$("#bgroup").val()+"</td>"; 
					 html = html + "</tr>"; 
					 
					 $("#ajaxData").prepend(html);
				 },
				 error:function(){
					 alert("실패");
				 }
			  });
			  
			  
		  }
		  
		</script>
		<style type="text/css">
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	  <h3>ajax 테스트</h3>
	  <button type="button" onclick="ajaxDo()">데이터 가져오기</button>
	  <br>
	  <form>
	    <label>번호</label>
	    <input type="text" id="bid" name="bid"><br>
	    <label>제목</label>
	    <input type="text" id="btitle" name="btitle"><br>
	    <label>작성자</label>
	    <input type="text" id="bname" name="bname"><br>
	    <label>그룹</label>
	    <input type="text" id="bgroup" name="bgroup"><br>
	  </form>
	  <br>
	  <button type="button" onclick="ajaxAdd()">추가</button>
	  <br><br>
	  <table>
	    <tr>
	      <th>번호</th>
	      <th>제목</th>
	      <th>작성자</th>
	      <th>그룹</th>
	    </tr>
	    <tbody id="ajaxData">
	        <!-- 데이터 들어감 -->
		    <tr>
		      <td>1</td>
		      <td>ajax테스트</td>
		      <td>홍길동</td>
		      <td>1</td>
		    </tr>
	    </tbody>
	  
	  </table>
	
	</body>
</html>