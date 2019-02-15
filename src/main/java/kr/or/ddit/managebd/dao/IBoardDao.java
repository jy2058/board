package kr.or.ddit.managebd.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.managebd.model.BoardVo;

public interface IBoardDao {
	
	int insertBoard(SqlSession sqlSession, BoardVo boardVo);

}
