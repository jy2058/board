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
    <!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(
			function() {
				// Editor Setting
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors, // 전역변수 명과 동일해야 함.
					elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
					sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
					fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
					}
				});

				var i = 1;
				$("#addBtn").on("click", function() {
					i += 1;
					if(i > 5){
						alert("5개 까지 첨부 가능 합니다.");
						return;
					}
					var html = "<tr>";
					html += "<td><input type=\"file\" name=\"uploadFile\" multiple=\"multiple\"id=\"uploadFile\"></td>";
					html += "<td><button>삭제</button></td>";
					html += "</tr>"
					$(".add_div").append(html);
				});

				// 전송버튼 클릭이벤트
				$("#saveBtn").click(
						function() {
							if (confirm("저장하시겠습니까?")) {
								// id가 smarteditor인 textarea에 에디터에서 대입
								oEditors.getById["smarteditor"].exec(
										"UPDATE_CONTENTS_FIELD", []);

								// 이부분에 에디터 validation 검증
								if (validation()) {
									$("#insert").submit();
								}
							}
							
						})
			});

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>

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
          <h1 class="page-header">게시글 수정</h1>
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
						<textarea name="smarteditor" id="smarteditor" rows="12"
										cols="100" style="width: 766px; height: 412px;"></textarea>
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
					<div class="col-sm-offset-3 col-sm-9">
						<button id="regBtn" type="button" class="btn btn-default">저장</button>
					</div>
				</div>
				
			</form>
        </div>
      </div>
    </div>
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  	

  </body>
</html>
    