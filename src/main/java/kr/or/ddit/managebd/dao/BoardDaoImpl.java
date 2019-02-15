package kr.or.ddit.managebd.dao;

import kr.or.ddit.managebd.model.BoardVo;

import org.apache.ibatis.session.SqlSession;

public class BoardDaoImpl implements IBoardDao{

	@Override
	public int insertBoard(SqlSession sqlSession, BoardVo boardVo) {
		int insertCnt = sqlSession.insert("board.insertBoard");
		return insertCnt;
	}
	

}
