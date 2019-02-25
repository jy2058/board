package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.IPostDao;
import kr.or.ddit.board.dao.PostDaoImpl;
import kr.or.ddit.board.model.AttVo;
import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
	public List<Object> getAllPost(String boardNum) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Object> postList = postDao.getAllPost(sqlSession, boardNum);
		
		sqlSession.close();
		
		return postList;
	}
	@Override
	public List<Object> getDetailPost(String postNum) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Object> PostVo = postDao.getDetailPost(sqlSession, postNum);
		
		sqlSession.close();
		return PostVo;
	}
	@Override
	public Map<String, List<Object>> getDetailPostAll(String postNum) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<Object> all_post = postDao.getDetailPost(sqlSession, postNum);
		List<Object> all_att = postDao.getAllAtt(sqlSession, postNum);
		List<Object> all_com = postDao.getAllCom(sqlSession, postNum);
		
		Map<String, List<Object>> detail_all = new HashMap<String, List<Object>>();
		
		detail_all.put("post", all_post);
		detail_all.put("com", all_com);
		detail_all.put("att", all_att);
		
		return detail_all;
	}
	@Override
	public int updPost(PostVo postVo) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int updCnt = postDao.updPost(sqlSession, postVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updCnt;
	}

}
