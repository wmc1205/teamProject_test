<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>로그인</h3>
<form method="POST">
	<table>
		<tr>
			<td>로그인</td>
			<td><input type="text" name="userid" placeholder="ID" required
				autofocus></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userpw" placeholder="PASSWORD"
				required></td>
		</tr>

		<tr>
			<td><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>


</section>
</body>
</html>