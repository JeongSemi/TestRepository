package ch06.Homework_Robot;

public class Ear {
		//Field
		String direction;
		
		//Constructor
		Ear(String direction){
			this.direction = direction;
		}
		
		//Method
		void hear(){
			System.out.println(direction + "에서 소리를 들음");
		}
}
