package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/post")
@MultipartConfig(maxFileSize=5 * 1024 * 1024, maxRequestSize=5*5 * 1024 * 1024)

public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(PostController.class);
       
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
		//UserVo userVo = (UserVo) request.getSession().getAttribute("userVo");
		//String userId = userVo.getUserId();

		
		Part uploadFilePart = request.getPart("uploadFile");
		String ContentDisposition = uploadFilePart.getHeader("Content-Disposition");
		
		
		/*	
		 	
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
