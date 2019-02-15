package kr.or.ddit.managebd.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.managebd.dao.BoardDaoImpl;
import kr.or.ddit.managebd.dao.IBoardDao;
import kr.or.ddit.managebd.model.BoardVo;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl(); 
	}

	/**
	* Method : insertBoard
	* 작성자 : PC08
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int insertCnt = boardDao.insertBoard(sqlSession, boardVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	/**
	* Method : getAllBoard
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 조회
	*/
	@Override
	public List<BoardVo> getAllBoard() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVo> boardList = boardDao.getAllBoard(sqlSession);
		
		sqlSession.close();
		
		return boardList;
	}

}
