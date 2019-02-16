package kr.or.ddit.managebd.dao;

import java.util.List;

import kr.or.ddit.managebd.model.BoardVo;

import org.apache.ibatis.session.SqlSession;

public interface IBoardDao {
	
	/**
	* Method : insertBoard
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	int insertBoard(SqlSession sqlSession, BoardVo boardVo);
	
	/**
	* Method : getAllBoard
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 모든 게시판 조회
	*/
	List<BoardVo> getAllBoard(SqlSession sqlSession);
	
	
	/**
	* Method : updBoard
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updBoard(SqlSession sqlSession, BoardVo boardVo);
}
