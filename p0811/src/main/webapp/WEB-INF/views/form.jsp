<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	</head>
	<body>
	  <form action="formOk" method="post">
	    <label>아이디</label>
	    <input type="text" id="id" name="id"><br>
	    <label>패스워드</label>
	    <input type="text" id="pw" name="pw"><br>
	    <label>이름</label>
	    <input type="text" id="name" name="name"><br>
	    <label>취미</label><br>
	    <input type="checkbox" id="game" name="hobby" value="game">
	    <label for="game">게임</label>
	    <input type="checkbox" id="read" name="hobby" value="read">
	    <label for="read">독서</label>
	    <input type="checkbox" id="run" name="hobby" value="run">
	    <label for="run">조깅</label>
	    <input type="checkbox" id="golf" name="hobby" value="golf">
	    <label for="golf">골프</label><br>
	    <input type="submit" value="전송"><br>
	  
	  </form>
	</body>
</html>