package ch06.homework0329;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run){
			System.out.println("----------------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ���� ");
			System.out.println("-----------------------------------------------------------");
			System.out.print("����> ");
			
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
		System.out.println("���α׷� ����");
	}

	private static void createAccount(){
		scanner.nextLine(); // ���� ����
		System.out.println("------------");
		System.out.println("���»���");
		System.out.println("------------");
		
		System.out.print("���¹�ȣ: ");
		String ano = scanner.nextLine();
		System.out.print("������: ");
		String owner = scanner.nextLine();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		Account account = new Account(ano, owner, balance);
		
		for(int i=0; i<accountArray.length; i++){
			if(accountArray[i] == null){
				accountArray[i] = account;
				System.out.println("���: ���°� �����Ǿ����ϴ�.");
				break;
			}	
		}
		
	}
	
	private static void accountList(){
		
		System.out.println("------------");
		System.out.println("���¸��");
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
		scanner.nextLine(); // ���� ����
		System.out.println("------------");
		System.out.println("����");
		System.out.println("------------");
		
		System.out.print("���¹�ȣ: ");
		String ano = scanner.nextLine();
		System.out.print("���ݾ�: ");
		int deposit = scanner.nextInt();
		
		Account find = findAccount(ano);
		//���¸� ã���� ���
		if(find != null)
		{
			find.setBalance(find.getBalance() + deposit);
			System.out.println("���: ������ �����Ǿ����ϴ�.");
		}
		//���°� �������� ���� ���
		else
			System.out.println("���: ���¸� ã�� �� �����ϴ�.");
		
	}
	
	private static void withdraw(){
		scanner.nextLine(); // ���� ����
		System.out.println("------------");
		System.out.println("���");
		System.out.println("------------");
		
		System.out.print("���¹�ȣ: ");
		String ano = scanner.nextLine();
		System.out.print("��ݾ�: ");
		int withdraw = scanner.nextInt();
		
		Account find = findAccount(ano);
		//���°� ������ ���
		if(find != null)
		{
			//(�ܾ�>=��ݾ�)�� ��� ��� ����
			if(find.getBalance()>=withdraw){
				find.setBalance(find.getBalance() - withdraw);
				System.out.println("���: ����� �����Ǿ����ϴ�.");
			}
			//(�ܾ�<��ݾ�)�� ��� ��� �Ұ�
			else
				System.out.println("���: �ܾ��� �����Ͽ� ����� �� �����ϴ�.");
		}
		//���°� �������� ���� ���
		else
			System.out.println("���: ���¸� ã�� �� �����ϴ�.");
	}
	
	private static Account findAccount(String ano){
		boolean find = false; //�ʱⰪ false
		int i;
		
		for(i=0; i<accountArray.length; i++){
			if(accountArray[i] != null){
				//���°� ������ �ݺ��� �������´�
				if(ano.equals(accountArray[i].getAno())){
					find = true;
					break;
					}
				}
		}
		//���� ���°� ���� ��� �� ���� return
		if(find == true)
			return accountArray[i];
		//���� ��� null����
		else
			return null;
	}
}
