package ch07.exam08;

public abstract class Tire {
	//F
	int diameter;
	
	//D
	Tire(){
		
		System.out.println("Tire °´Ã¼ »ý¼º");
	}
	//M
	abstract void roll();

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
} 
