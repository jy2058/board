package kr.or.ddit.board.service;

import static org.junit.Assert.assertNotNull;
import kr.or.ddit.board.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostServiceImplTest {

	IPostService postService;
	PostVo postVo;
	
	@Before
	public void setUp(){
		postService = new PostServiceImpl();
		postVo = new PostVo();
	}

	@Test
	public void testInsertBoard() {
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
		int cnt = postService.insertPost(postVo);

		/***Then***/
		assertNotNull(cnt);
		
	}

}
