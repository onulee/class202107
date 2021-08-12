<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	  <h2>메인페이지</h2>
	  <ul>
	    <a href="login"><li>로그인</li></a>
	    <a href="member"><li>회원가입</li></a>
	  </ul>
	  <h2>${session_nicname }님 로그인</h2>
	  <ul>
	    <a href="logout"><li>로그아웃</li></a>
	    <a href="board"><li>게시판</li></a>
	    <a href="mmodify"><li>회원정보수정</li></a>
	  </ul>
	
	</body>
</html>