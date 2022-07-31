<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<h2>게시글 읽기</h2>
	<div>
		<div>
			${dto.idx } | ${dto.category } | ${dto.title }
		</div>
		<div>
			${dto.viewCount } | ${dto.writeDate } | ${dto.ipaddr }
		</div>
	</div>
	<pre>${dto.content }</pre>
	<c:if test="${not empty dto.uploadFile }">
	<img src="${cpath }/upload/${dto.uploadFile}" height=200px;>
	</c:if>
	<div class="menu">
		<div>
		<a href="${cpath }/board"><button>목록</button></a>
		</div>
		<!-- 작성자와 로그인 유저가 다를 경우, 수정/삭제 버튼 제거 -->
		<c:if test="${sessionScope.login.userid == dto.writer }">
		<div>
			<a href="${cpath }/board/update/${dto.idx}"><button>수정</button></a>
			<button id="deleteBtn">삭제</button>
		</div>
		</c:if>
	</div>
	<hr>
	
</div>
</section>
<script>
	const deleteBtn = document.getElementById('deleteBtn')
	const deleteHandler = () =>{
		const flag = confirm('정말 삭제하시겠습니까?')
		if(flag){
			location.href='${cpath}/board/delete/${dto.idx}'
		}
	}
	deleteBtn.addEventListener('click',deleteHandler)
</script>
</body>
</html>