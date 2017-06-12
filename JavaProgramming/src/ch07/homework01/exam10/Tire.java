package ch07.homework01.exam10;

public class Tire {
	public int maxRotation; //타이어 수명
	public int accumulatedRotation; //누적 회전수 
	public String location; //타이어 위치 
	
	public Tire(String location, int maxRotation){
		this.location=location; 
		this.maxRotation=maxRotation;
	}
	
	public boolean roll(){
		++accumulatedRotation;
		if (accumulatedRotation<maxRotation){
			System.out.println("남은 수명 :"+(maxRotation-accumulatedRotation) +"회");
			return true;
		}else{
			System.out.println("*** " +location +"Tire 평크 ***");
			return false;
		}
	}
}
