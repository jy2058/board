package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface IUserService {
	
	/**
	* Method : getAllUser
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 모든 사용자 조회
	*/
	List<UserVo> getAllUser();
	
	/**
	* Method : selectUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 조회
	*/
	UserVo selectUser(String userId);
	
	/**
	* Method : selectUserPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 유저 페이징
	*/
	Map<String, Object> selectUserPagingList(PageVo pageVo);

	
	/**
	* Method : updUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 :
	*/
	int updUser(UserVo userVo);
	
	/**
	* Method : encyptPass
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 패스워드 암호화
	*/
	int encyptPass();
	
}
