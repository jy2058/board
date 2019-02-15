package kr.or.ddit.managebd.model;

public class BoardVo {
	private String boardNum;	//게시판 번호
	private String use;			//사용 여부
	private String boardName;	//게시판 이름
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	@Override
	public String toString() {
		return "BoardVo [boardNum=" + boardNum + ", use=" + use
				+ ", boardName=" + boardName + "]";
	}
	

	
	
	
	

}
