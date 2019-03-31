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
.in-box{
		margin: 5px;
		width:80%;
		text-align: top;
		vertical-align: middle;
		
	}
	
	.main-box{
		text-align: center;
	
	}	
	
</style>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#btn_submit").click(function(){
		location.replace("<c:url value='insert' />")
	})
	
	$("#btn_list").click(function(){
		location.href="<c:url value='/' />"
	})
	
})


</script>
<header class="main-header"><h2>독서록 작성</h2></header>

<body>
<section>
<form action="<c:url value='book'/>" method="POST" class="main-box">

	
	<label for="b_userid">사용자ID</label>
		<input type="text" id="b_userid" class="in-box" name="b_userid" value="${BOOK.b_userid}"><br/>
		
	<label for="b_isbn">도서코드</label>
		<input type="text" id="b_isbn" class="in-box" name="b_isbn" value="${BOOK.b_isbn}"><br/>
		
	<label for="b_title">도서제목</label>
		<input type="text" id="b_title" class="in-box" name="b_title" value="${BOOK.b_title}"><br/>	
	
	<label for="b_date">독서일자</label>
		<input type="date" id="b_date" class="in-box" name="b_date" value="${BOOK.b_date}"><br/>
		
		
	<label for="b_text">내용</label>
		<textarea rows="5" id="b_text" class="in-box" name="b_text">${BOOK.b_text}</textarea><br/>
	
	<label for="b_star">별점</label>
		<input type="text" id="b_star" class="in-box" name="b_star" value="${BOOK.b_star}"><br/>	
	
	<hr/>
	<button type="submit" id="btn_submit">확인</button>
	<button type="reset">취소</button>
	<button type="button" id="btn_list">목록보기</button>

	
</form>			
</section>

</body>
</html>