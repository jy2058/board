package kr.or.ddit.board.dao;

import static org.junit.Assert.*;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostDaoImplTest {

	IPostDao postDao;
	private SqlSession sqlSession;
	private Logger logger = LoggerFactory.getLogger(PostDaoImplTest.class);
	
	@Test
	public void setUp(){
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		
		postDao = new PostDaoImpl();
	}

	/**
	* Method : testInsertPost
	* 작성자 : kjy
	* 변경이력 :
	* Method 설명 : 글 등록 테스트
	*/
	@Test
	public void testInsertPost() {
		/***Given***/
		PostVo postVo = new PostVo();
		postVo.setBoardNum("1");
		postVo.setUser_id("cony");
		postVo.setTitle("xx스트코드");
		postVo.setPostNum(postVo.getPostNum());
		postVo.setParent_postNum("");
		postVo.setRootNum("5");
		postVo.setBoard_info("1");
		postVo.setContents("테스dfdf텟트");
		
		/***When***/
		int cnt = postDao.insertPost(sqlSession, postVo);

		/***Then***/
		assertNotNull(cnt);

		
	}

}
