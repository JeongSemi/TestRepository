package ch05.exam02;

public class ArrayExample04 {

	public static void main(String[] args) {
		String[] v2= {"Java","C#","C++"};
		for(int i=0; i<v2.length; i++){
			System.out.println(v2[i]);
		}
		
		for(String lang : v2){
			System.out.println(lang);
		}
		
	}
}
