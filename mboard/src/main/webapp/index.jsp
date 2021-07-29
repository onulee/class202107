<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
	  <c:if test="${session_flag != 'success'}">
		  <ul>
		    <h3>로그인을 하시면 더 많은 정보를 볼수 있습니다.</h3>
		    <li><a href="member/login.do">로그인</a></li>
		    <li><a href="./member.do">회원가입</a></li>
		  </ul>
	  </c:if>
	  <c:if test="${session_flag == 'success'}">
		  <ul>
		    <h3>${session_nickname} 님 환영합니다.</h3>
		    <li><a href="member/logout.jsp">로그아웃</a></li>
		    <li><a href="board/blist.do">게시판</a></li>
		    <li><a href="./member_modify.do">회원정보수정</a></li>
		  </ul>
	  </c:if>
	</body>
</html>