<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="session" var="session_web"/>

<!-- 포함될 페이지. 포함될 내용 -->
<a href="/session_web/index.jsp">메인페이지</a>

<c:choose>
	<c:when test= "${empty sessionScope.loginInfo}"><!-- empty : 글자수 체크도 할수있다. -->
	<a href="/session_web/login/login_form.jsp">로그인</a>
	</c:when>
	<c:otherwise>
	<a href="/session_web/logout">로그아웃</a>
	<a href="/session_web/stacknum/show_number.jsp">숫자누적요청</a>
	</c:otherwise>
</c:choose>



<% if(session.getAttribute("loginInfo")==null){ %>
<a href="/session_web/login/login_form.jsp">로그인</a><!-- 로그인 안한 상태의 메뉴 -->
<% }else{ %>
	<a href="/session_web/logout">로그아웃</a><!-- 로그인 한 상태의 메뉴 -->
	<a href="/session_web/stacknum/show_number.jsp">숫자누적요청</a>
<% } %>