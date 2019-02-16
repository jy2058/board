package kr.or.ddit.managebd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.DebugGraphics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.managebd.dao.BoardDaoImplTest;
import kr.or.ddit.managebd.model.BoardVo;
import kr.or.ddit.managebd.service.BoardServiceImpl;
import kr.or.ddit.managebd.service.IBoardService;

@WebServlet("/manageBd")
public class ManageBdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(ManageBdController.class);
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> boardList = boardService.getAllBoard();
		request.setAttribute("boardList", boardList);
		
		
		request.getRequestDispatcher("/managebd/manageBd.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String info = request.getParameter("info");
		
		BoardVo boardVo;
		if(info.equals("insert")){
			String boardName = request.getParameter("newBd_t");
			String use = request.getParameter("newBd_use");
	
			if(!boardName.equals("")){
				boardVo = new BoardVo();
				boardVo.setBoardName(boardName);
				boardVo.setUse(use);
				
				int cnt = boardService.insertBoard(boardVo);
	
				if(cnt > 0){
					response.sendRedirect(request.getContextPath() + "/manageBd");
					return;
				}
			}
		}else if(info.equals("update")){
			logger.debug("boardNum = " + request.getParameter("boardNum"));
			String boardNum = request.getParameter("boardNum");
			String boardName = request.getParameter("bd_t" + boardNum);
			String use = request.getParameter("bd_use" + boardNum);
			
			boardVo = new BoardVo();
			boardVo.setBoardNum(boardNum);
			boardVo.setBoardName(boardName);
			boardVo.setUse(use);
			
			int updCnt = boardService.updBoard(boardVo);
			
			if(updCnt > 0){
				response.sendRedirect(request.getContextPath() + "/manageBd");
				return;
			}
		}
		
		doGet(request, response);
		
	}

}
