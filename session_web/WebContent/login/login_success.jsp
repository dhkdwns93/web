<%@page import="vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/menu.jsp"/><br>
	로그인 성공<br>
	<!-- 
		JSP에서 
			HttpServletRequest 객체를 사용 -> request 변수 사용 
			HttpSession 객체를 사용 -> session 변수 사용	
			(request, session => JSP 내장 객체)
			
			Object o = session.getAttribute("loginInfo")
			Member m = (Member)o;
			String name = m.getName();
			
			((Member)session.getAttribute("loginInfo")).getName();
	-->
	<%= ((Member)session.getAttribute("loginInfo")).getName() %>님 환영합니다.<br>
	<%= ((Member)session.getAttribute("loginInfo")).getPoint() %> 포인트 사용가능합니다.<br>
	
	<p>
		<a href="/session_web/index.jsp">메인페이지</a>
		<a href="/session_web/logout">로그아웃</a>
	</p>
</body>
</html>