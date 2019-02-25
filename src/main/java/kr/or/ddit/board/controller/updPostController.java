package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.IPostService;
import kr.or.ddit.board.service.PostServiceImpl;

/**
 * Servlet implementation class updPostController
 */
@WebServlet("/updPost")
@MultipartConfig(maxFileSize=5 * 1024 * 1024, maxRequestSize=5*5 * 1024 * 1024)
public class updPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPostService postService;
	
	public updPostController() {
		postService = new PostServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = request.getParameter("postNum");
		
		Map<String, List<Object>> detailPostAll = postService.getDetailPostAll(postNum);
		
		List<Object> postList = detailPostAll.get("post");
		
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("/board/updPost.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = request.getParameter("postNum");
		String title = request.getParameter("title");
		String contents = request.getParameter("smarteditor");
		
		PostVo postVo = new PostVo();
		postVo.setPostNum(postNum);
		postVo.setTitle(title);
		postVo.setContents(contents);

		int updCnt = postService.updPost(postVo);
		
		if(updCnt > 0){
			response.sendRedirect(request.getContextPath()+"/postDetail?postNum="+ postNum);
		}else{
			doGet(request, response);
		}
		
		//request.getRequestDispatcher("/board/ .jsp").forward(request, response);
		
	}

}
