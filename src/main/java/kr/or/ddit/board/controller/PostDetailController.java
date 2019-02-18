package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.IPostService;
import kr.or.ddit.board.service.PostServiceImpl;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/postDetail")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPostService postService;
    
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postNum = request.getParameter("postNum");
		System.out.println("postNum = " + postNum);
		
		Map<String, List<Object>> detail_map = postService.getDetailPostAll(postNum);
		
		List<Object> postList = detail_map.get("post");
		List<Object> comList = detail_map.get("com");
		List<Object> attList = detail_map.get("att");
		
		System.out.println("postList" + postList);
		System.out.println("comList" + comList);
		System.out.println("attList" + attList);
		
		request.setAttribute("postList", postList);
		request.setAttribute("comList", comList);
		request.setAttribute("attList", attList);
		
		
		
//		PostVo postVo = postService.getDetailPost(postNum);
//		request.setAttribute("postVo", postVo);
		
		
		
		
		request.getRequestDispatcher("/board/postDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
