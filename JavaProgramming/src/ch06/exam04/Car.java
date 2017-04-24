package ch06.exam04;

public class Car {
	//Field
	//부품
	Body body= new Body();
	Engine engine=new Engine();
	Dashboard dashboard=new Dashboard();
	Seat[] seats = {
			new Seat(),
			new Seat(),
			new Seat(),
			new Seat()
	};
	
	Tire[] tires={ 
			new Tire("앞1번바퀴"), 
			new Tire("앞2번바퀴"), 
			new Tire("뒤1번바퀴"), 
			new Tire("뒤2번바퀴")
	};
	
	//고유데이터, 생성자가 실행할때 외부에서 값을 받아와 셋팅하는 것이 맞다.
	String makeDay;
	String color;
	//상태데이터
	int speed;
	
	//Constructor
	Car(String makeDay, String color){
		this.makeDay=makeDay;
		this.color=color;
	}
	
	
	//Method
	
	void start(){
		engine.start();
	}
	
	void run(){
		
		tires[0].roll();
		tires[1].roll();
		tires[2].roll();
		tires[3].roll();
		setSpeed(60);
		dashboard.display(60);
	}
	
	void setSpeed(int speed){
		this.speed=speed;
	}
	
	void stop(){
		engine.stop();
		speed=0;
	}
	
}
