package ch07.homework01.exam11;

public class KKumhoTire extends Tire{
	public KKumhoTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation<maxRotation){
			System.out.println(location+"KKumho tire 남은 수명 :"+(maxRotation-accumulatedRotation) +"회");
			return true;
		}else{
			System.out.println("*** " +location +"KKumho Tire 평크 ***");
			return false;
		}
	}
}
