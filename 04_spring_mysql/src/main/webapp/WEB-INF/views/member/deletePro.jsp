<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check eq 1}">
<%-- 		<c:set var="log" value="${id}" scope="session" /> --%>
		<script>
			alert("탈퇴 성공.");
			location.href="${cp}/member/userMenu";
		</script>
	</c:if>
	
	<c:if test="${check ne 1}">
		<script>
			alert("탈퇴 실패.");
			location.href="${cp}/";
		</script>
	</c:if>
</body>
</html>