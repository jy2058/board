package kr.or.ddit.managebd.dao;

import java.util.List;

import kr.or.ddit.managebd.model.BoardVo;

import org.apache.ibatis.session.SqlSession;

public class BoardDaoImpl implements IBoardDao{

	/**
	* Method : insertBoard
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	@Override
	public int insertBoard(SqlSession sqlSession, BoardVo boardVo) {
		int insertCnt = sqlSession.insert("board.insertBoard", boardVo);
		return insertCnt;
	}

	/**
	* Method : getAllBoard
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 모든 게시판 조회
	*/
	@Override
	public List<BoardVo> getAllBoard(SqlSession sqlSession) {
		List<BoardVo> boardList = sqlSession.selectList("board.getAllBoard");
		return boardList;
	}

	/**
	* Method : updBoard
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 수정
	*/
	@Override
	public int updBoard(SqlSession sqlSession, BoardVo boardVo) {
		int updCnt = sqlSession.update("board.updBoard", boardVo);
		return updCnt;
	}
	
	

}
