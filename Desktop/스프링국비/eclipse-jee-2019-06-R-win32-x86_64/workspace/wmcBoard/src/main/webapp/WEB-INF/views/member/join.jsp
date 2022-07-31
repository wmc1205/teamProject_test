<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<div>

<h3>회원 가입</h3>
<form method="POST">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="userid" placeholder="ID" required autofocus>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="userpw" placeholder="PASSWORD" required >
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="username" placeholder="NAME" required >
		</tr>
		<tr>
			<td>EMAIL</td>
			<td><input type="email" name="email" placeholder="EMAIL" required >
		</tr>
			<tr>
			<td>BIRTH</td>
			<td><input type="date" name="birth" placeholder="BIRTH" required >
		</tr>
		<tr>
			<td><input type="submit" value="가입"></td>
		</tr>
	
	</table>
</form>
</div>
</section>
</body>
</html>