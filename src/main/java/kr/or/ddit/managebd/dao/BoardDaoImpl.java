package kr.or.ddit.managebd.dao;

import java.util.List;

import kr.or.ddit.managebd.model.BoardVo;

import org.apache.ibatis.session.SqlSession;

public class BoardDaoImpl implements IBoardDao{

	@Override
	public int insertBoard(SqlSession sqlSession, BoardVo boardVo) {
		int insertCnt = sqlSession.insert("board.insertBoard", boardVo);
		return insertCnt;
	}

	@Override
	public List<BoardVo> getAllBoard(SqlSession sqlSession) {
		List<BoardVo> boardList = sqlSession.selectList("board.getAllBoard");
		return boardList;
	}
	
	

}
