package kr.or.ddit.managebd.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.managebd.model.BoardVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoImplTest {
	IBoardDao boardDao;
	private SqlSession sqlSession;
	private Logger logger = LoggerFactory.getLogger(BoardDaoImplTest.class);
	
	@Before
	public void setUp(){
		boardDao = new BoardDaoImpl();
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testInsertBoard() {
		
		BoardVo vo = new BoardVo();
		vo.setBoardName("테스트보드");
		vo.setUse("y");
		int cnt = boardDao.insertBoard(sqlSession, vo);
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void testGetAllBoard(){
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardDao.getAllBoard(sqlSession);
		
		/***Then***/
//		assertEquals(3, boardList.size());
		assertNotNull(boardList.get(0).getBoardName());
	}
	@Test
	public void testUpdBoard(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardName("테스트");
		boardVo.setBoardNum("8");
		boardVo.setUse("0");
		
		/***When***/
		int cnt = boardDao.updBoard(sqlSession, boardVo);

		/***Then***/
		assertEquals(1, cnt);

		
	}

}
