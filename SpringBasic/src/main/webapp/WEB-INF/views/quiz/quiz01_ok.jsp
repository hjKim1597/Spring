<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>quiz_ok 화면</h3>
	
	<!-- param으로 받을 시 -->
<%-- 	
	${id }
	${pw }
	${name }
	${email } 
	--%>
	
<!-- vo설정후  ModelAttribute로 진행-->	
	${vo.id }
	${vo.pw }
	${vo.name }
	${vo.email }

	
</body>
</html>