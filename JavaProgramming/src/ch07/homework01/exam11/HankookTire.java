package ch07.homework01.exam11;

public class HankookTire extends Tire {
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation<maxRotation){
			System.out.println(location+"Hankook tire 남은 수명 :"+(maxRotation-accumulatedRotation) +"회");
			return true;
		}else{
			System.out.println("*** " +location +"Hankook Tire 평크 ***");
			return false;
		}
	}
}
