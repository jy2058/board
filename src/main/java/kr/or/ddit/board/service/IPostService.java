package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.PostVo;

public interface IPostService {
	/**
	* Method : insertPost
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @param postVo
	* @return
	* Method 설명 : 게시판 글 작성
	*/
	int insertPost(PostVo postVo);

	/**
	* Method : getAllPost
	* 작성자 : kjy
	* 변경이력 :
	* @param sqlSession
	* @param boardNum
	* @return
	* Method 설명 : 게시판별 리스트 출력
	*/
	List<Object> getAllPost(String boardNum);

	/**
	* Method : getDetailPost
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param postNum
	* @return
	* Method 설명 : 선택한 게시글 가져오기
	*/
	List<Object> getDetailPost(String postNum);
	
	/**
	* Method : getDetailPostAll
	* 작성자 : PC08
	* 변경이력 :
	* @param postNum
	* @return
	* Method 설명 : 상세 게시글
	*/
	Map<String, List<Object>> getDetailPostAll(String postNum);
}
