<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
<h3>게시글 작성</h3>

<form method="POST" enctype="multipart/form-data">
<table>
	<tr>
		<td>
			<select name="category">
				<option>일반</option>
				<option>공지</option>
				<option>등산</option>
				<option>게임</option>
				<option>여행</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" placeholder="제목" required></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" value="${login.userid }" readonly></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content"  placeholder="내용을 입력하세요" required></textarea></td>
	</tr>
	<tr>
		<td>파일 첨부</td>
		<td><input type="file" name="upload"></td>
	</tr>
</table>
	<input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr }">
	<p><input type="submit" value="작성"></p>
</form>
</div>
</section>
</body>
</html>