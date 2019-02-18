package kr.or.ddit.board.model;

public class AttVo {
	private String attfile_num   ; //첨부파일 번호
	private String postNum      ;  //글 번호
	private String attfile_name  ; //첨부파일 이름
	private String path			;  //경로

	public String getAttfile_num() {
		return attfile_num;
	}
	public void setAttfile_num(String attfile_num) {
		this.attfile_num = attfile_num;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getAttfile_name() {
		return attfile_name;
	}
	public void setAttfile_name(String attfile_name) {
		this.attfile_name = attfile_name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "AttVo [attfile_num=" + attfile_num + ", postNum=" + postNum
				+ ", attfile_name=" + attfile_name + ", path=" + path + "]";
	}

	
}
