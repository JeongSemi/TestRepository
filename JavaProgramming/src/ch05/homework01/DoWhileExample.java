package ch05.homework01;

//Scanner 클래스를 사용하기 위해 필요
import java.util.Scanner;
public class DoWhileExample {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner scanner=new Scanner(System.in);	//스캐너 객체 생성
		String inputString;
		
		//우선 한번은 돌고, q입력 받을때까지 입력받은 내용 출력
		do{
			System.out.print(">");
			//스트링 변수에 스캐너 객체의 nextLine()메소드를 이용해서 문자열 입력 
			inputString = scanner.nextLine();
			System.out.println(inputString);
		}while(!inputString.equals("q"));
		
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
