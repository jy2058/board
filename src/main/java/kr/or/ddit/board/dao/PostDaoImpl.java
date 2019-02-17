package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.PostVo;

import org.apache.ibatis.session.SqlSession;

public class PostDaoImpl implements IPostDao{
	
	@Override
	public int insertPost(SqlSession sqlSession, PostVo postVo) {
		int insertCnt = sqlSession.insert("post.insertPost", postVo);
		return insertCnt;
	}

	@Override
	public List<PostVo> getAllPost(SqlSession sqlSession, String boardNum) {
		List<PostVo> postList = sqlSession.selectList("post.getAllPost", boardNum);
		return postList;
	}

}
