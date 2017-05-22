<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="vo.Customer" %>
<%
	Customer customer = new Customer("유재석", "yu@y.com", 39, 65.1, true);
	request.setAttribute("customer", customer);
	
	Customer cust = new Customer("박명수", "back@b.com", 41, 60.7, true);
	session.setAttribute("customer", cust);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- getAttribute("customer").getName() -->
이름 : ${requestScope.customer.name}<br>
이메일 : ${requestScope.customer.email}<br><!-- getAttribute("customer").getEmail() -->
나이 : ${requestScope.customer.age}<br><!-- getAttribute("customer").getAge() -->
몸무게 : ${requestScope.customer.weight}<br><!-- getAttribute("customer").getWeight() -->
결혼여부 : ${requestScope.customer.marriage ? "기혼" : "미혼"}<!-- getAttribute("customer").isMarriage() : boolean이라서 is -->
<br>

<p>
${customer}<!-- getAttribut("customer") -->
${result}<!-- 출력할 내용이 null일 경우는 출력을 하지 않는다.
			  출력대상을 찾아가는 도중 null이 나온경우 연산을 멈추고 아무것도 출력하지 않는다. -->
</p>
${sessionScope.customer}

<h1>Session Scope에서 조회한 고객 정보</h1>
이름 : ${sessionScope.customer.name}<br>
이메일 : ${sessionScope.customer.email}<br>
나이 : ${sessionScope.customer.age}<br>
몸무게 : ${sessionScope.customer.weight}<br>
결혼여부 : ${sessionScope.customer.marriage ? "기혼" : "미혼"}
</body>
</html>