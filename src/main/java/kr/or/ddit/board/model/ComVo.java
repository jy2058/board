package kr.or.ddit.board.model;

import java.util.Date;

public class ComVo {
	private String com_num    ;  //댓글번호
	private Date com_date    ;  //댓글작성일시
	private String userId     ;  //댓글작성자
	private String postNum    ;  //게시글번호
	private String com_delinfo ;  //삭제여부
	private String com_contents; // 댓글내용
	
	public String getCom_num() {
		return com_num;
	}
	public void setCom_num(String com_num) {
		this.com_num = com_num;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getCom_delinfo() {
		return com_delinfo;
	}
	public void setCom_delinfo(String com_delinfo) {
		this.com_delinfo = com_delinfo;
	}
	public String getCom_contents() {
		return com_contents;
	}
	public void setCom_contents(String com_contents) {
		this.com_contents = com_contents;
	}
	@Override
	public String toString() {
		return "ComVo [com_num=" + com_num + ", userId=" + userId
				+ ", postNum=" + postNum + ", com_delinfo=" + com_delinfo
				+ ", com_contents=" + com_contents + "]";
	}
}
	
	