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
@MultipartConfig(maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class updPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IPostService postService;

	public updPostController() {
		postService = new PostServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = request.getParameter("postNum");
		String info = request.getParameter("info");
		Map<String, List<Object>> detailPostAll = postService.getDetailPostAll(postNum);

		List<Object> postList = detailPostAll.get("post");

		request.setAttribute("postList", postList);
		request.setAttribute("info", info);

		request.getRequestDispatcher("/board/updPost.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNum = request.getParameter("postNum");
		String title = request.getParameter("title");
		String contents = request.getParameter("smarteditor");

		String info = request.getParameter("info");
		System.out.println(info);
		
		int cnt=0;
		if (info.equals("delete")) {
			cnt = postService.delPost(postNum);
			List<Object> list = postService.getDetailPost(postNum);
			PostVo postVo = (PostVo) list.get(0);
			String boardNum = postVo.getBoardNum();
			
			if (cnt > 0) {
				response.sendRedirect(request.getContextPath() + "/board?boardNum=" + boardNum);
			}else{
				
			}
			
		}else{
			PostVo postVo = new PostVo();
			postVo.setPostNum(postNum);
			postVo.setTitle(title);
			postVo.setContents(contents);

			cnt = postService.updPost(postVo);
			
			if (cnt > 0) {
				response.sendRedirect(request.getContextPath() + "/postDetail?postNum=" + postNum);
			}else{
				
			}

		}
		
	}
		
}



