<%@page import="java.util.List"%>
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
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
 
  </head>
  <body>
  
	<%@ include file="/module/header.jsp" %>

	<div class="container-fluid">
      <div class="row">
       <%@ include file="/module/left.jsp" %>
       
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">게시판 관리</h1>
          
          
			
          		<form action="/userModifyForm" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-9">
							<label for="userNm" class="col-sm-3 control-label">게시판 생성</label>
							<input type="text" name="newBd_t" id="newBd_t" value="게시판 이름">
							<select name="newBd_useS" id="newBd_useS">
								<option>사용</option>
								<option>미사용</option>
							</select>
							<input type="button" value="생성">
						</div>
					</div>

					<c:forEach begin="1" end="3" var="i">
						<div class="form-group">
							<div class="col-sm-9">
								<label for="userNm" class="col-sm-3 control-label">게시판 이름</label>
								<input type="text" name="newBd_t" id="newBd_t" value="${i }">
								<select name="newBd_useS" id="newBd_useS">
									<option>사용</option>
									<option>미사용</option>
								</select>
								<input type="button" value="수정">
							</div>
						</div>
					</c:forEach>
					
				</form>
             
        </div>
      </div>
    </div>
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  </body>
</html>
    