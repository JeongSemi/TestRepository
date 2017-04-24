package ch10.exam03;

public class CatchByExceptionKindExample3 {

	public static void main(String[] args) {
		try{
			String str = null;
			System.out.println(str.length());
			
			int[] scores = { 90, 85 };
			for(int i=0; i<3; i++) { System.out.println(scores[i]);}
			
			String strNum = "a";
			int num = Integer.parseInt(strNum);
			
		}
		catch(NumberFormatException e){ //자바 8에서 추가된 내용 -> 코드 중복 방지 "|"
			//코드1
			System.out.println("예외 처리 코드1");
		}
		
		catch(Exception e){
			//코드2
			System.out.println("예외 처리 코드2");
		}
		
		
	}

}
