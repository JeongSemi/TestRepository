package ch06.homework05;

class Board {
	
	//feild
	private int boardNum;
	private static int nextBoardNum;
	private String title;
	private String content;
	private final String writer;
	//Constructor
	Board(int boardNum, String title, String content, String writer){
		this.boardNum=boardNum;
		this.title=title;
		this.content=content;
		this.writer=writer;
		Board.nextBoardNum=boardNum;
	}

	//Method
	public int getBoardNum() {
		return boardNum;
	}
	
	public static int getNextboardNum() {
		return nextBoardNum;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	
}
