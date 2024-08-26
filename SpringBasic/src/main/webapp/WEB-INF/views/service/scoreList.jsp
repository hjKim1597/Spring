<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="vo" items="${list }" varStatus="a">
	${a.index}
	<%-- ${a.count} --%>
	${vo.name }<br>
	${vo.kor }<br>
	${vo.eng }<br>
	${vo.math }
	<br>
	<button type="button" onclick="location.href= 'deleteScore?sno=${vo.sno}';">삭제</button>
	
	<br>
</c:forEach>

<a href="scoreRegist">추가등록하기</a>

</body>
</html>