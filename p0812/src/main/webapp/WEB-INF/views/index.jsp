<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	  <c:if test="${session_flag != 'success'}">
		  <h2>메인페이지</h2>
		  <ul>
		    <a href="login"><li>로그인</li></a>
		    <a href="join"><li>회원가입</li></a>
		  </ul>
	  </c:if>
	  <c:if test="${session_flag == 'success' }">
		  <h2>${session_nickName }님 로그인</h2>
		  <ul>
		    <a href="logout"><li>로그아웃</li></a>
		    <a href="listpage"><li>리스트출력</li></a>
		    <a href="listpage?page=2"><li>2페이지출력</li></a>
		    <a href="board"><li>게시판</li></a>
		    <a href="board1?bid=22"><li>파라미터 22 게시판</li></a>
		    <a href="board2/22"><li>pathVariable 22 게시판</li></a>
		    <a href="board2/22"><li>pathVariable 2개 게시판</li></a>
		    <a href="mmodify"><li>회원정보수정</li></a>
		  </ul>
	  </c:if>
	
	</body>
</html>