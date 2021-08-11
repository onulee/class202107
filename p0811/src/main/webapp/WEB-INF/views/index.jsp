<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript"></script>
	</head>
	<body>
	  <c:if test="${session_flag == null || session_flag=='fail'}">
		  <h2>main페이지</h2>
		  <ul>
		    <a href="login"><li>로그인</li></a> 
		    <li>회원가입</li>
	  </c:if>
	  <c:if test="${session_flag == 'success'}">
	      <h2>로그인성공</h2>
	      <h2>id : ${id }</h2>
	      <h2>pw : ${pw }</h2>
	      <a href="logout"><li>로그아웃</li></a>
	      <li>게시판</li>
	      <li>회원정보수정</li>
	  </c:if>
	  </ul>
	
	</body>
</html>