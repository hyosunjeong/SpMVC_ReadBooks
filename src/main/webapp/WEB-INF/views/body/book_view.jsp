<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
.book_box{
		margin: 5px;
		width:80%;
		text-align: top;
		vertical-align: middle;
		
	}
	

</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		$("#book_update").click(function(){
			let id = ${bookVO.b_id}
			location.href="<c:url value='update' />" + "?b_id="+id
		})
		
		$("#book_delete").click(function(){
			let id = ${bookVO.b_id}
			if(confirm("삭제할까요?")){
				location.href="<c:url value='delete'/>" + "?b_id="+id
			}
		})
		
	})
</script>
<body>
<header class="main-header">내용 읽기</header>
	<article id="book_view" class="book_box">
		
		<p>도서 코드 : ${bookVO.b_isbn}</p>
		<p>도서 제목 : ${bookVO.b_title}</p>
		<p>독서 일자 : ${bookVO.b_date}</p>
		<p>내용 : ${bookVO.b_text}</p>
		
		
		<div>
			<button type="button" id="book_update">편집</button>
			<button type="button" id="book_delete">삭제</button>
			
		</div>
	</article>
</body>
</html>