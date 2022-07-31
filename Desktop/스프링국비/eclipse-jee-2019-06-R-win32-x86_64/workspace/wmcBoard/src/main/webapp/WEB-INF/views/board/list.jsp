<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="list_wrap">

<h2>게시판</h2>
<div class="board_choice" style="display:flex; justify-content: space-between;">
	<div>
	<select id="category">
		<option ${param.category == '전체' ? 'selected' : ''} value="">전체</option>
		<option ${param.category == '일반' ? 'selected' : ''} value="일반">일반</option>
		<option ${param.category == '공지' ? 'selected' : ''} value="공지">공지</option>
		<option ${param.category == '등산' ? 'selected' : ''} value="등산">등산</option>
		<option ${param.category == '게임' ? 'selected' : ''} value="게임">게임</option>
		<option ${param.category == '여행' ? 'selected' : ''} value="여행">여행</option>	
	</select>
	</div>
<div class="menu" >
		<form>
			<select name="column" required>
				<option ${param.column == 'title' ? 'selected' : '' } value="title">제목으로 검색</option>
				<option ${param.column == 'writer' ? 'selected' : '' } value="writer">작성자로 검색</option>
				<option ${param.column == 'content' ? 'selected' : '' } value="content">내용으로 검색</option>
			</select>
				<!-- jsp에서 값을 넘겨줄 때는 'param.xx' 으로 넘겨준다 -->
				<!-- 카테고리별로 검색내용을 확인하기 위해서 hidden type으로 값을 넘겨준다. -->
				<input type="hidden" name="category" value="${param.category }">
				<input type="search" name="search" placeholder="검색어를 입력하세요 " value="${param.search }">
				<input type="submit" value="검색">
		</form>
</div>
</div>
<table class="list_board">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일시</th>
		<th>ip</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td><a href="${cpath }/board/view/${dto.idx}"><span>(${dto.category })</span>${dto.title }</a></td>
			<td>${dto.writer }</td>
			<td>${dto.viewCount }</td>
			<td><fmt:formatDate value="${dto.writeDate }" pattern="yyyy-MM-dd hh:mm"/></td>
			<td>${dto.ipaddr }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${cpath }/board/write"><button>작성</button></a>
</div>
<div class="pagingNumber">
	<!-- 이전 페이지 존재 유무 -->
	<c:if test="${paging.prev }">
		<a href="${cpath }/board?page=${paging.begin - 10}&cateogry=${param.category}&column=${param.column}&search=${param.search}">[이전]</a>
	</c:if>
	<!-- 현재 페이지를 지정하지 않았을 경우, 1페이지가 기본 값 -->
	<c:set var="p" value="${empty param.page ?  1 : param.page}"/> 
	<c:forEach var="i" begin="${paging.begin }" end="${paging.end }">
		<span class="${p == i? 'currentPage' : '' }"> 
			<a href="${cpath }/board?page=${i }&cateogry=${param.category}&column=${param.column}&search=${param.search}">[${i }]</a>
		</span>
	</c:forEach>
	<!-- 다음 페이지 존재 유무 -->
	<c:if test="${paging.next }">
		<a href="${cpath }/board?page=${paging.end + 1}&category=${param.category}&column=${param.column}&search=${param.search}">[다음]</a>
	</c:if>
</div>
</section>
<script>
//카테고리별 리스트 조회
	const categorySelect = document.getElementById('category') //'category' 변수를 호출하여 변수 지정
	const changeHandler = function(event){ //이벤트 실행
		const value = event.target.value 	//target: 이미 지정되어있는 값을 호출('category로 지정한 value값')
		const url = '${cpath}/board'//기본 이동 주소(리스트)
		location.href = url + (value !=''? '?category='+ value : '')
		//value가 빈 값이 아닐 때, 파라미터 형식으로 category를 전달하여 다시 요청
		//빈 값이면 전체 리스트 조회
		
}
	categorySelect.addEventListener('change',changeHandler)
</script>

</body>
</html>