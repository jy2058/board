package kr.or.ddit.board.model;

import java.util.Date;

public class PostVo {
	private String postNum      ;	//게시글 번호
	private String user_id       ;	//작성자 아이디
	private String contents     ;	//내용
	private String title        ;	//제목
	private Date post_date     ;	//작성일시
	private String parent_postNum;	//부모게시글번호
	private String rootNum   ;	//최상위 번호
	private String boardNum     ;	//게시판 분류 번호
	private String board_info    ; 	//삭제여부
	
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getParent_postNum() {
		return parent_postNum;
	}
	public void setParent_postNum(String parent_postNum) {
		this.parent_postNum = parent_postNum;
	}
	public String getRootNum() {
		return rootNum;
	}
	public void setRootNum(String rootNum) {
		this.rootNum = rootNum;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoard_info() {
		return board_info;
	}
	public void setBoard_info(String board_info) {
		this.board_info = board_info;
	}
	
	@Override
	public String toString() {
		return "PostVo [postNum=" + postNum + ", user_id=" + user_id
				+ ", contents=" + contents + ", title=" + title
				+ ", post_date=" + post_date + ", parent_postNum="
				+ parent_postNum + ", rootNum=" + rootNum + ", boardNum="
				+ boardNum + ", board_info=" + board_info + "]";
	}

	
}
