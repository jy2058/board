package kr.or.ddit.managebd.service;

import java.util.List;

import kr.or.ddit.managebd.model.BoardVo;

public interface IBoardService {
	
	/**
	* Method : insertBoard
	* 작성자 : PC08
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	int insertBoard(BoardVo boardVo);
	
	/**
	* Method : getAllBoard
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 조회
	*/
	List<BoardVo> getAllBoard();

}
