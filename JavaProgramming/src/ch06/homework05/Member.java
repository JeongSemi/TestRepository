package ch06.homework05;

class Member {
	
	//feild
	private final String id;
	private String pw;
	//Constructor
	Member(String id, String pw){
		this.id=id;
		this.pw=pw;
	}
	//Method
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
