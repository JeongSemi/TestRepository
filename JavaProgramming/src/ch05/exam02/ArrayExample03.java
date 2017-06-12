package ch05.exam02;

public class ArrayExample03 {

	public static void main(String[] args) {
		int[] v1 =new int[5];
		v1[0]=10;
		v1[2]=10;
		
		String[] v2= new String[5];
		v2[0] = new String("Java");
		v2[2] = new String("Java");
		
		System.out.println(v1[0] == v1[2]);
		System.out.println(v2[0] == v2[2]);
		System.out.println(v2[0].equals(v2[2]));
		
		aa(new String[] {"aaa","bbb","ccc"});
	}
	
	public static void aa(String[] args){
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}
	}
}
