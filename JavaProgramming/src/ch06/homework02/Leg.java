package ch06.homework02;

public class Leg {
	//Field
	String location;
	boolean bendState=false;
	//Construct
	Leg(String location){
		this.location=location;
	}
	
	//Method
	void move(){
		System.out.println(location+"다리를 앞으로 옮겼습니다.");
	}
	
	void bend(){
		if(bendState==true){
			System.out.println(location+"다리는 이미 구부렸습니다.");
		}else{
			System.out.println(location+"다리를 구부렸습니다.");
			bendState= true;	
		}
		
	}
	
	void strech(){
		if(bendState==false){
			System.out.println(location+"다리는 이미 펴져있습니다.");
		}else{
			System.out.println(location+"다리를 폈습니다.");
			bendState= false;
		}
		
	}
}
