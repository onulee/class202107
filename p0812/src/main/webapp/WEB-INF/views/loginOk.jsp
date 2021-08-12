<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginOk</title>
	</head>
	<body>
	  <c:if test="${session_flag}=='success'">
	     <script type="text/javascript">
	       alert("로그인 성공");
	       location.href="index";
	     </script>
	  </c:if>
	  <c:if test="${session_flag}!='success'">
	     <script type="text/javascript">
	       alert("로그인 실패");
	       location.href="login";
	     </script>
	  </c:if>
	
	</body>
</html>