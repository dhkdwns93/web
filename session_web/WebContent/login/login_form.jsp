<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/menu.jsp"/><br>
<h2>로그인 폼</h2>
<% if(request.getAttribute("errorMessage")!=null){ %>
	<span style="color:red;"><%=request.getAttribute("errorMessage") %></span>
<% }//end of if %>
 <form action="/session_web/login" method="post">
 
 ID : <input type ="text" name="id" ><br>
 PWD : <input type="password" name="password"><br>
 <button type="submit">로그인</button>
 
 
 
 </form>
</body>
</html>