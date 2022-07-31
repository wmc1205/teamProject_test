<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<style>
a {
	text-decoration: none;
	color: inherit;
}
.list_wrap{
	width:1000px;

}
.board_choice{
	max-width:700px;
}
.list_board{
	max-width:1000px;
}
.list_board> tr,td{
	text-align:center;
}
td > a:hover{
	text-decoration: underline;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center"><a href="${cpath }">wmcBoard</a></h1>
<div class="loginInfo">
<c:if test="${empty login }">
<div align="right">
	<a id="nav_login" href="${cpath }/member/login"><button>로그인</button></a>
</div>
</c:if>
<c:if test="${not empty login }">
	<div align="right">
	<a href="${cpath }/member/mypage">${login.userid }(${login.username })</a>
	<a href="${cpath }/member/logout"><button>로그아웃</button></a>
	</div>
</c:if>
</div>
<hr>

<br>
<section>
	<div>
		<ul>
			<li><a href="${cpath }/member/join">회원가입</a></li>
			<li><a href="${cpath }/member/login">로그인</a></li>
			<li><a href="${cpath }/board">게시판</a>			
		
		</ul>
	</div>




