package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.AttVo;
import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.PostVo;

import org.apache.ibatis.session.SqlSession;

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
	List<Object> getAllPost(SqlSession sqlSession, String boardNum);
	
	/**
	* Method : getDetailPost
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : 선택한 게시글 가져오기
	*/
	List<Object> getDetailPost(SqlSession sqlSession, String postNum);
	
	/**
	* Method : getAllCom
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : 모든 댓글 가져오기
	*/
	List<Object> getAllCom(SqlSession sqlSession, String postNum);
	
	/**
	* Method : getAllAtt
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : 모든 첨부파일 가져오기
	*/
	List<Object> getAllAtt(SqlSession sqlSession, String postNum);
	
	/**
	* Method : updPost
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updPost(SqlSession sqlSession, PostVo postVo);
	
	/**
	* Method : delPost
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : 게시글 삭제
	*/
	int delPost(SqlSession sqlSession, String postNum);
}
