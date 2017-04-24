package ch06.homework0329;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run){
			System.out.println("----------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 ");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1){
				createAccount();
			}
			else if(selectNo == 2){
				accountList();
			}
			else if(selectNo == 3){
				deposit();
			}
			else if(selectNo == 4){
				withdraw();
			}
			else if(selectNo == 5){
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void createAccount(){
		scanner.nextLine(); // 엔터 제거
		System.out.println("------------");
		System.out.println("계좌생성");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.print("계좌주: ");
		String owner = scanner.nextLine();
		System.out.print("초기입금액: ");
		int balance = scanner.nextInt();
		Account account = new Account(ano, owner, balance);
		
		for(int i=0; i<accountArray.length; i++){
			if(accountArray[i] == null){
				accountArray[i] = account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}	
		}
		
	}
	
	private static void accountList(){
		
		System.out.println("------------");
		System.out.println("계좌목록");
		System.out.println("------------");
		
		for(int i=0; i<accountArray.length; i++){
			if(accountArray[i] != null){
				System.out.println(accountArray[i].getAno() + "       " + accountArray[i].getOwner() + "      " + accountArray[i].getBalance());
			}
			else
				break;
		}
	}
	
	private static void deposit(){
		scanner.nextLine(); // 엔터 제거
		System.out.println("------------");
		System.out.println("예금");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.print("예금액: ");
		int deposit = scanner.nextInt();
		
		Account find = findAccount(ano);
		//계좌를 찾았을 경우
		if(find != null)
		{
			find.setBalance(find.getBalance() + deposit);
			System.out.println("결과: 예금이 성공되었습니다.");
		}
		//계좌가 존재하지 않을 경우
		else
			System.out.println("결과: 계좌를 찾을 수 없습니다.");
		
	}
	
	private static void withdraw(){
		scanner.nextLine(); // 엔터 제거
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.print("출금액: ");
		int withdraw = scanner.nextInt();
		
		Account find = findAccount(ano);
		//계좌가 존재할 경우
		if(find != null)
		{
			//(잔액>=출금액)인 경우 출금 가능
			if(find.getBalance()>=withdraw){
				find.setBalance(find.getBalance() - withdraw);
				System.out.println("결과: 출금이 성공되었습니다.");
			}
			//(잔액<출금액)인 경우 출금 불가
			else
				System.out.println("결과: 잔액이 부족하여 출금할 수 없습니다.");
		}
		//계좌가 존재하지 않을 경우
		else
			System.out.println("결과: 계좌를 찾을 수 없습니다.");
	}
	
	private static Account findAccount(String ano){
		boolean find = false; //초기값 false
		int i;
		
		for(i=0; i<accountArray.length; i++){
			if(accountArray[i] != null){
				//계좌가 같으면 반복문 빠져나온다
				if(ano.equals(accountArray[i].getAno())){
					find = true;
					break;
					}
				}
		}
		//같은 계좌가 있을 경우 그 계좌 return
		if(find == true)
			return accountArray[i];
		//없을 경우 null리턴
		else
			return null;
	}
}
