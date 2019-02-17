package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.dao.IPostDao;
import kr.or.ddit.board.dao.PostDaoImpl;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

public class PostServiceImpl implements IPostService{
	IPostDao postDao;
	
	public PostServiceImpl() {
		postDao = new PostDaoImpl();
	}
	@Override
	public int insertPost(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int insertCnt = postDao.insertPost(sqlSession, postVo);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public List<PostVo> getAllPost(String boardNum) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<PostVo> postList = postDao.getAllPost(sqlSession, boardNum);
		
		sqlSession.close();
		
		return postList;
	}

}
