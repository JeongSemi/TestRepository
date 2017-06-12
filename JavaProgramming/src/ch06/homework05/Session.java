package ch06.homework05;

class Session {
	private static Session session=new Session();
	private String sessionID;
	
	private Session(){
		
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public static Session getInstance(){
		return session;
	}
}
