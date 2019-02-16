package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardName = request.getParameter("boardName");
		if(boardName.equals("자유게시판")){
			//response.sendRedirect("/board/free_bd.jsp");
			request.getRequestDispatcher("/board/free_bd.jsp").forward(request, response);
		}
		
		if(boardName.equals("Q")){
			request.getRequestDispatcher("/board/qna_bd.jsp").forward(request, response);
		}
		
		else{
			request.getRequestDispatcher("/module/main.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
