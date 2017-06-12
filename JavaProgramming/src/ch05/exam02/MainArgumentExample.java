package ch05.exam02;

public class MainArgumentExample {

	public static void main(String[] args) {
		if(args.length==2){
			String v1=args[0];
			int intV1= Integer.parseInt(v1);
			String v2=args[1];
			int intV2=Integer.parseInt(v2);
			
			int sum=intV1+intV2;
			System.out.println(sum);
		}else{
			System.out.println("Usage : Input two arguments");
		}
		
		
	}

}
