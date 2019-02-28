package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.IPostService;
import kr.or.ddit.board.service.PostServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPostService postService;
	
	List<Object> postList;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String boardName = request.getParameter("boardName");
		String boardNum = request.getParameter("boardNum");

		System.out.println(boardNum);
		
		postService = new PostServiceImpl();
		postList = postService.getAllPost(boardNum);
		
		request.setAttribute("postList", postList);
//		request.setAttribute("boardNum", boardNum);
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post!!!");
		doGet(request, response);
	}
}
