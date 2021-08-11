<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>table</title>
		<style type="text/css">
		  table,td{border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	   <table>
	     <tr>
	       <td>아이디</td>
	       <td>${memberVo.id}</td>
	     </tr>
	     <tr>
	       <td>패스워드</td>
	       <td>${memberVo.pw}</td>
	     </tr>
	     <tr>
	       <td>이름</td>
	       <td>${memberVo.name}</td>
	     </tr>
	     <tr>
	       <td>취미</td>
	       <td>${hobbys}</td>
	     </tr>
	   
	   </table>
	</body>
</html>