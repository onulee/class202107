<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doBmodify</title>
		<script type="text/javascript">
		  if('${result}'!=1){
			  alert("게시글이 등록되지 않았습니다. 다시 입력하세요.");
			  location.href="blist.do";
		  }else{
			  alert("게시글이 수정되었습니다!");
			  location.href="blist.do";
		  }
		</script>
	</head>
	<body>
	
	</body>
</html>