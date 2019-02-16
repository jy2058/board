package kr.or.ddit.managebd.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.managebd.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceImplTest {
	IBoardService boardService;
	BoardVo boardVo;
	
	@Before
	public void setUp(){
		boardService = new BoardServiceImpl();
		boardVo = new BoardVo();
	}

	@Test
	public void testInsertBoard() {
		boardVo.setUse("1");
		boardVo.setBoardName("테스트");
		
		int cnt = boardService.insertBoard(boardVo);
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void testGetAllBoard(){
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardService.getAllBoard();
		
		/***Then***/
//		assertEquals(3, boardList.size());
		assertNotNull(boardList.get(0).getBoardName());

		
	}
	
	/**
	* Method : testUpdBoard
	* 작성자 : kjy
	* 변경이력 :
	* Method 설명 : 게시판 수정
	*/
	@Test
	public void testUpdBoard(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardName("테스트");
		boardVo.setBoardNum("8");
		boardVo.setUse("0");
		
		/***When***/
		int cnt = boardService.updBoard(boardVo);

		/***Then***/
		assertEquals(1, cnt);

		
	}



}
