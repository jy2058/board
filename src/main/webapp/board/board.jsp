<%@page import="kr.or.ddit.managebd.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.managebd.service.BoardServiceImpl"%>
<%@page import="kr.or.ddit.managebd.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">

</head>

<body>
	<%@include file="/module/header.jsp"%>
	<%
		IBoardService boardService = new BoardServiceImpl();
		List<BoardVo> boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
	%>
		
		
	<div class="container-fluid">
	    <div class="row">
			<%@include file="/module/left.jsp"%>
			
			 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          		<h1 class="page-header">${param.boardName }</h1>
          			<div class="form-group">
						<div class="col-sm-9">
							<c:set var="postList" value="${postList}" scope="request"/>
             
				             <div class="table-responsive">
				            <table class="table table-striped">
				              <thead>
				                <tr>
				                  <th>게시글 번호</th>
				                  <th>제목</th>
				                  <th>작성자 아이디</th>
				                  <th>작성일시</th>
				                </tr>
				              </thead>
				              <tbody>
				              <c:forEach items="${postList}" var="postList">
				              	<tr class="postTr" data-postNum="${postList.postNum }">
					              	<td>${postList.postNum }</td>
					              	<td>${postList.title }</td>
					              	<td>${postList.user_id }</td>
					              	<td><fmt:formatDate value="${postList.post_date }" pattern="yyyy-MM-dd"/></td>
				              	</tr>
				              </c:forEach>
				              </tbody>
				            </table>
				            <button id="newBtn" type="button" class="btn btn-default">새글 등록</button>	
						</div>
						</div>
					</div>
				</div>
		</div>
		
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	<script>
		$(document).ready(function(){
			$(".postTr").on("click", function(){
				var postNum = $(this).attr("data-postNum");
				$("#postNum").val(postNum);
				$("#boardNum").val("${param.boardNum}");
				
				$("#detail_frm").submit();
			});
			
			$("#newBtn").on("click", function(){
				
				$("#boardNum2").val("${param.boardNum}");
				
				$("#post_frm").submit();
			});
		});
	</script>
	<form action="${pageContext.servletContext.contextPath}/postDetail" id="detail_frm" method="get">
		<input type="hidden" name="postNum" id="postNum"/>
		<input type="hidden" name="boardNum" id="boardNum"/>
	</form>
	<form action="${pageContext.servletContext.contextPath}/post" id="post_frm" method="get">
		<input type="hidden" name="boardNum" id="boardNum2"/>
		<!-- <input type="hidden" name="newPost" id="newPost"/> -->
	</form>
</body>
</html>
