package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.AttVo;
import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.PostVo;

import org.apache.ibatis.session.SqlSession;

public class PostDaoImpl implements IPostDao{
	
	@Override
	public int insertPost(SqlSession sqlSession, PostVo postVo) {
		int insertCnt = (int)sqlSession.insert("post.insertPost", postVo);
		return insertCnt;
	}

	@Override
	public List<Object> getAllPost(SqlSession sqlSession, String boardNum) {
		List<Object> postList = sqlSession.selectList("post.getAllPost", boardNum);
		return postList;
	}

	@Override
	public List<Object> getDetailPost(SqlSession sqlSession, String postNum) {
		List<Object> postVo = sqlSession.selectList("post.getDetailPost", postNum);
		return postVo;
	}

	@Override
	public List<Object> getAllCom(SqlSession sqlSession, String postNum) {
		List<Object> comList = sqlSession.selectList("post.getAllCom", postNum);
		return comList;
	}

	@Override
	public List<Object> getAllAtt(SqlSession sqlSession, String postNum) {
		List<Object> attList = sqlSession.selectList("post.getAllAtt", postNum);
		return attList;
	}

}
