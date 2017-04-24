package ch05.exam01;

public class NullPointerException {

	public static void main(String[] args) {
	
		/*int[] scores = null;
		
		System.out.println(scores[0]);	//아무런 객체도 참조하고 있지 않은데 달라하면 안됨!! 이럴때 널퐇인터 익셉션 
		*/
		
		String name = null;
		System.out.println(name.length());
	}

}
