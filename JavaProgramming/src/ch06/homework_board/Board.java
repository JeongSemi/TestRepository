package ch06.homework_board;

public class Board {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String password;
	private boolean open;
	
	Board(int bno, String title, String writer, String content, String password, boolean open){
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.password = password;
		this.open = open;
	}
	
	public int getBno() {return bno;}
	public void setBno(int bno) {this.bno = bno;}
	public String getTitle() {	return title; }
	public void setTitle(String title) {	this.title = title;}
	public String getWriter() {	return writer;}
	public void setWriter(String writer) {	this.writer = writer;}
	public String getContent() {	return content;}
	public void setContent(String content) {	this.content = content;}
	public boolean isOpen() {	return open;}
	public void setOpen(boolean open) {	this.open = open;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}
