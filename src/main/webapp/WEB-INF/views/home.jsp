<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
header{
		margin: 0 auto;
		padding:20px;
		background-color: #FF00FF;
		color: #F7BE81;
		text-align: center;
		font-weight: bold;
	}	
	
table {
	border-collapse:collapse;
	border-spacing: 0;
	width:100%;
	border:1px solid #ccc;
}

		
	
tr {
	border:1px solid #ddd;
}
tr:nth-child(even) {
	background-color: #ccc;
}
tr:nth-child(odd) {
	background-color: #fff;
}
tr:hover {
	background-color: #ddd;
}
td {
	text-align: center;
}
td, th {
	padding: 8px 8px;
	vertical-align: top;
	border: 1px sold blue;
	
}
td:first-child, th:first-child {
	padding-left:16px;
}	
</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#btn-add").click(function(){
			location.href="<c:url value='/write' />"
		})
		
		$(".book_tr").click(function(){
		let id = $(this).attr("data-id")
		location.href="<c:url value='/view' />" + "?id="+id
		
	})
})

</script>
<body>
<header class="main-header"><h2>도서 리스트</h2></header>
<section>
	<table class="book-list">
		<tr>
			<th>NO</th>
			<th>사용자ID</th>
			<th>도서코드</th>
			<th>도서제목</th>
			<th>독서일자</th>
			<th>별점</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty BOOKS}">
				<tr><td colspan="6">도서 리스트가 없습니다</td></tr>
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${BOOKS}" var="book" varStatus="i">
					<tr class="book_tr" data-id="${book.id}">
					<td>${i.count}</td>
					<td>${book.b_userid}</td>
					<td>${book.b_isbn}</td>
					<td>${book.b_subject}</td>
					<td>${book.b_date}</td>
					<td>${book.b_star}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</section>
<hr/>
<button class="btn-book" id="btn-add">추가</button>
</body>
</html>