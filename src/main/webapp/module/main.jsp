<%@page import="kr.or.ddit.managebd.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.managebd.service.BoardServiceImpl"%>
<%@page import="kr.or.ddit.managebd.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
          		<h1 class="page-header">메인 페이지</h1>
          			<div class="form-group">
						<div class="col-sm-9">
							main
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
</body>
</html>
