package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements IUserDao{
	
	/**
	* Method : getAllUser
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	public List<UserVo> getAllUser(SqlSession sqlSession){
		List<UserVo> userList = sqlSession.selectList("user.getAllUser");
		
		return userList;
	}
	
	public UserVo selectUser(SqlSession sqlSession, String userId){
		UserVo userVo =  sqlSession.selectOne("user.selectUser", userId);
		
		return userVo;
		
	}

	/**
	* Method : selectUserPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public List<UserVo> selectUserPagingList(SqlSession sqlSession, PageVo pageVo) {
		List<UserVo> userList = sqlSession.selectList("user.selectUserPagingList", pageVo);
		
		return userList;
	}

	/**
	* Method : getUserCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 수 조회
	*/
	@Override
	public int getUserCnt(SqlSession sqlSession) {
		int userCnt = sqlSession.selectOne("user.getUserCnt");
		return userCnt;
	}


	/**
	* Method : updUser
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 수정
	*/
	@Override
	public int updUser(SqlSession sqlSession, UserVo userVo) {
		int updCnt = sqlSession.update("user.updUser", userVo);
		return updCnt;
	}

	/**
	* Method : encyptPass
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 패스워드 암호화
	*/
	@Override
	public int encyptPass(SqlSession sqlSession, UserVo userVo) {
		int updCnt = sqlSession.update("user.encyptPass", userVo);
		return updCnt;
	}
}
