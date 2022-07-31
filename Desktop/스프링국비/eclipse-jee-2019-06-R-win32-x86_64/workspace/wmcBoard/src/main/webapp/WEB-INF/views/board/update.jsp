<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
<h3>게시글 수정</h3>
<form method="POST" enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${dto.idx }">
	<p>
		<select name="category">
			<option ${dto.category == '일반'? 'selected':'' }>일반</option>
			<option ${dto.category == '공지'? 'selected':'' }>공지</option>
			<option ${dto.category == '등산'? 'selected':'' }>등산</option>
			<option ${dto.category == '게임'? 'selected':'' }>게임</option>
			<option ${dto.category == '여행'? 'selected':'' }>여행</option>
		</select>
	<p><input type="text" name="title" value="${dto.title }" required autofocus></p>
	<p><input type="text" name="writer" value="${dto.writer}" readonly></p>
	<p><textarea name="content" required>${dto.content }</textarea></p>
	<p><input type="file" name="upload"></p>
	<p><input type="submit" value="수정">
	<p><input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr }">
</form>
</div>






</section>

</body>
</html>