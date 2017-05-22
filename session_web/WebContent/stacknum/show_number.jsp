<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<p>
<%= session.getAttribute("num") %>
</p>
<a href="/session_web/stacknum/stack">숫자누적</a>
<a href="/session_web/stacknum/remove">누적숫자제거</a>

</body>
</html>