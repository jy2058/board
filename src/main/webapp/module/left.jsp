<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="kr.or.ddit.managebd.model.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
<div class="col-sm-3 col-md-2 sidebar">
<ul class="nav nav-sidebar">
	<li><a href="<%=request.getContextPath()%>/manageBd">게시판 관리</a></li>
</ul>

<ul id="name" class="nav nav-sidebar">

<c:forEach items="${boardList }" end="${fn:length(boardList) }" var="list">
	<c:if test="${list.use == '1'}">
		<li><a href="<%=request.getContextPath()%>/board?boardName=${list.boardName }&boardNum=${list.boardNum}">${list.boardName }</a></li>
	</c:if>
</c:forEach>
</ul>
</div>

<%-- <script>
	$("#name li").on("click", function() {
	    var text = $(this).text();
	    if(text == "자유게시판"){
	    	$("a").attr("href", "<%=request.getContextPath()%>/manageBd");
	    }
	    if(text == "Q&A게시판"){
	    	$("a").attr("href", "<%=request.getContextPath()%>/manageBd");
	    }
	});
</script> --%>