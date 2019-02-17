package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.PostVo;

public interface IPostDao {
	
	/**
	* Method : insertPost
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시판 글 작성
	*/
	int insertPost(SqlSession sqlSession, PostVo postVo);

	/**
	* Method : getAllPost
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : 게시판별 리스트 출력
	*/
	List<PostVo> getAllPost(SqlSession sqlSession, String boardNum);
}
