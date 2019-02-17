package kr.or.ddit.board.service;

import java.util.List;

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
	List<PostVo> getAllPost(String boardNum);

}
