package ch11.exam02;

public class Key {
	private int number;
	
	public Key(int number){
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		return number; //같은 number면 같은 hashcode를 가지도록 리턴
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key){
			Key target = (Key) obj;
			if(number == (target.number))
				return true;
		} 
		return false;
	}
}
