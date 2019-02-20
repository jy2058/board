<%@page import="kr.or.ddit.managebd.service.BoardServiceImpl"%>
<%@page import="kr.or.ddit.managebd.service.IBoardService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">

  </head>
  <body>
  
	<%@ include file="/module/header.jsp" %>
    <%
		IBoardService boardService = new BoardServiceImpl();
		List<BoardVo> boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
	%>

	<div class="container-fluid">
      <div class="row">
       <%@ include file="/module/left.jsp" %>
       
       
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">게시글 상세조회</h1>
          	<form id="frm" action="${pageContext.request.contextPath }/userForm" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
				<div class="form-group">
					<label for="postTitle" class="col-sm-3 control-label">제목</label>
					<div class="col-sm-9">
					<input type="text" class="form-control" id="title" name="title"
							placeholder="제목">
					</div>
				</div>
				
				<div class="form-group">
					<label for="postContents" class="col-sm-3 control-label">글 내용</label>
					<div class="col-sm-9" >
						<div class="form-control">${postList[0].contents}</div>
					</div>
				</div>

				<div class="form-group">
					<label for="file" class="col-sm-3 control-label ">첨부파일</label>
					<div class="col-sm-9">
					<table>
						<c:forEach items="${attList}" var="attList">
	              			<tr class="postTr">
		              			<td>${attList.attfile_name }</td>
              				</tr>
			            </c:forEach>  	
					</table>
				</div>
				</div>
				
				<div class="form-group">
					<label for="file" class="col-sm-3 control-label">댓글</label>
					<div class="col-sm-9">
					<table class="table table-striped">
						<tr>
							<td class="col-sm-4">내용</td>
							<td class="col-sm-3">작성자</td>
							<td class="col-sm-3">작성일시</td>
						</tr>
						<c:forEach items="${comList}" var="comList">
	              			<tr class="postTr">
		              			<td class="col-sm-4">${comList.com_contents }</td>
		              			<td class="col-sm-3">${comList.userId }</td>
		              			<td class="col-sm-3"><fmt:formatDate value="${comList.com_date }" pattern="yyyy-MM-dd"/></td>
              				</tr>
			            </c:forEach>  	
					</table>
					<input type="text" class="form-control" id="title" name="title"
							placeholder="댓글">
					<button id="regBtn" type="button" class="btn btn-default">댓글저장</button>
				</div>
				</div>
				
			</form>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<form id="upd" action="${pageContext.request.contextPath }/updPost" method="post">
							<button type="button" id="updBtn" class="btn btn-default">수정</button>
							<button id="delBtn" type="button" class="btn btn-default">삭제</button>
						</form>
						<button id="reBtn" type="button" class="btn btn-default">답글</button>
					</div>
				</div>
				
        </div>
      </div>
    </div>
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  	
  	<script>
  		function initData(){
  			$("#title").val("${postList[0].title}");
  			/* $("#contents").val("${postList[0].contents}"); */
  		}
  	
  		$(document).ready(function(){
  			initData();
  			
  			$("#regBtn").on("click",function(){
  				// 이렇게 하지 말고 있던 form을 이용
  				//attr(action)-> 이런식으로 액션 속성값(경로)을 바꾼다.
  				$("#upd").submit();
  			});
  			
  		});
  	</script>

  </body>
</html>
    