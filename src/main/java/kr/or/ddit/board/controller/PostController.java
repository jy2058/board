package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.IPostService;
import kr.or.ddit.board.service.PostServiceImpl;
import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/post")
@MultipartConfig(maxFileSize=5 * 1024 * 1024, maxRequestSize=5*5 * 1024 * 1024)

public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		if(request.getSession().getAttribute("userVo") == null){
			response.sendRedirect(request.getContextPath() + "/login");
		}*/
		request.getRequestDispatcher("/board/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contents = request.getParameter("smarteditor");
		String boardNum = request.getParameter("boardNum");
		String title = request.getParameter("title");
		
		System.out.println("title" + title);
		
		if( request.getSession().getAttribute("userVo") == null){
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("userVo");
		String userId = userVo.getUserId();
		
		PostVo postVo = new PostVo();
		postVo.setBoard_info("1");
		postVo.setBoardNum(boardNum);
		postVo.setContents(contents);
		postVo.setTitle(title);
		postVo.setUser_id(userId);
		postVo.setParent_postNum("");
		
		int insertCnt = postService.insertPost(postVo);
		
		System.out.println("postNum"+ postVo.getPostNum());
		
		//request.setAttribute("postNum", postVo.getPostNum());
		
		response.sendRedirect(request.getContextPath() + "/postDetail?postNum="+postVo.getPostNum());
	
		
		
		//Collection<Part> parts = request.getParts();
		
		/*		
		Part uploadFilePart = request.getPart("uploadFile");
		String ContentDisposition = uploadFilePart.getHeader("Content-Disposition");
		
		
		
		 	
		System.out.println("ContentDisposition=" + ContentDisposition);
		System.out.println("uploadFilePart=" + uploadFilePart);
		
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload");
		
		if(uploadFilePart.getSize() > 0){
			
			String filename = PartUtil.getFileNameFromPart(ContentDisposition);
			System.out.println("filename ==" + filename);
			String uuidFilename = UUID.randomUUID().toString();
			
			uploadFilePart.write(path + File.separator + uuidFilename);
			uploadFilePart.delete();
		}
		*/
	}

}
