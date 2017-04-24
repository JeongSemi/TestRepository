package ch06.homework_board;

import java.util.Scanner;

public class BoardExample {

	private static Board[] boardArray = new Board[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("------------[�Խ���]----------------");
			System.out.println("1. �� ���� | 2. �� ��� | 3. �� �˻�");
			System.out.println("4. �� ���� | 5. �� ���� | 6. ���� ");
			System.out.println("--------------------------------------");
			System.out.print("����> ");

			int selectNo = scanner.nextInt();
			scanner.nextLine(); // ���� ����

			if (selectNo == 1) {
				write();
			} else if (selectNo == 2) {
				boardList();
			} else if (selectNo == 3) {
				search();
			} else if (selectNo == 4) {
				rewrite();
			} else if (selectNo == 5) {
				delete();
			} else if (selectNo == 6) {
				run = false;
			}
		}
		System.out.println("�Խ��� ����");
		/*
		 * �Խ��� ��� �� ���� �� �˻� �� ���� �� ����
		 */
	}

	private static void write() {
		System.out.println("[���ο� �� �ۼ�]");

		// ������ �Է¹ޱ�
		System.out.print("����: ");
		String title = scanner.nextLine();
		System.out.print("�ۼ���: ");
		String writer = scanner.nextLine();
		System.out.print("�� ����: ");
		String content = scanner.nextLine();
		System.out.print("��й�ȣ: ");
		String password = scanner.nextLine();
		System.out.print("�����Ͻðڽ��ϱ�?(y,n): ");
		boolean open = true;
		while (true) {
			String open_s = scanner.nextLine();
			if (open_s.equals("n")) {
				open = false;
				break;
			} else if (!open_s.equals("y")) {
				System.out.println("y,n�� �Է��ϼ���: ");
				continue;
			} else
				break;
		}

		// ����ִ� �� ��ȣ�� ã��(�� ��ȣ�� 1������)
		int bno = 0;
		for (int i = 0; i < boardArray.length; i++) {
			if (boardArray[i] == null) {
				bno = i + 1;
				break;
			}
		}

		Board board = new Board(bno, title, writer, content, password, open);

		// Array�� �߰�
		for (int i = 0; i < boardArray.length; i++) {
			if (boardArray[i] == null) {
				boardArray[i] = board;
				break;
			}
		}

	}

	private static void boardList() {
		System.out.println("[�� ���]");

		for (int i = 0; i < boardArray.length; i++) {
			// ������ ���� ���
			if (boardArray[i] != null && boardArray[i].isOpen() == true) {
				System.out.println("�� ��ȣ <" + boardArray[i].getBno() + ">");
				System.out.println("����: " + boardArray[i].getTitle());
				System.out.println("�ۼ���: " + boardArray[i].getWriter());
				System.out.println("�� ����: " + boardArray[i].getContent());
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

	private static void search() {
		System.out.println("[�������� �˻��Ͻðڽ��ϱ�?]");
		System.out.println("1. �ۼ��� | 2. �� ��ȣ");
		int num = scanner.nextInt();
		scanner.nextLine(); // ���� ����

		// �ۼ��� ����
		if (num == 1) {
			System.out.print("�ۼ��ڸ� �Է��ϼ���: ");
			String writer = scanner.nextLine();
			Board board = searchByWriter(writer);

			if (board != null) {
				System.out.println("�� ��ȣ <" + board.getBno() + ">");
				System.out.println("����: " + board.getTitle());
				System.out.println("�ۼ���: " + board.getWriter());
				System.out.println("�� ����: " + board.getContent());
				System.out.println("-------------------------------------------------------------");
			} else
				System.out.println("���� ã�� �� �����ϴ�.");

		} else if (num == 2) {
			System.out.print("�� ��ȣ�� �Է��ϼ���: ");
			int bno = scanner.nextInt();
			scanner.nextLine(); // ���� ����

			if (boardArray[bno - 1].isOpen() == false)
				System.out.println("����� ���Դϴ�.");
			else if (boardArray[bno - 1] == null)
				System.out.println("�������� �ʴ� �� ��ȣ �Դϴ�.");
			else {
				System.out.println("�� ��ȣ <" + boardArray[bno - 1].getBno() + ">");
				System.out.println("����: " + boardArray[bno - 1].getTitle());
				System.out.println("�ۼ���: " + boardArray[bno - 1].getWriter());
				System.out.println("�� ����: " + boardArray[bno - 1].getContent());
				System.out.println("-------------------------------------------------------------");
			}

		}

	}

	private static Board searchByWriter(String writer) {
		boolean find = false;
		int i;

		for (i = 0; i < boardArray.length; i++) {
			if (boardArray[i] != null) {
				if (writer.equals(boardArray[i].getWriter())) {
					find = true;
					break;
				}
			}
		}

		if (find == true)
			return boardArray[i];
		else
			return null;
	}

	private static void rewrite() {
		System.out.println("[�� ����]");
		// �ۼ��ڸ� ���� �˻�
		System.out.print("�ۼ��ڸ� �Է��ϼ���: ");

		String name = scanner.nextLine();
		boolean find = false;
		int num;

		for (num = 0; num < boardArray.length; num++) {
			if (name.equals(boardArray[num].getWriter())) {
				find = true;
				break;
			}
		}
		// ã����
		if (find == true) {
			System.out.println("�ۼ��� �� ��ȣ: " + boardArray[num].getBno());
			System.out.print("��й�ȣ�� �Է��ϼ���: ");
			String pwd = scanner.nextLine();
			// ��й�ȣ�� ������
			if (pwd.equals(boardArray[num].getPassword())) {
				System.out.print("������ ������ �Է��ϼ���: ");
				String rewrite = scanner.nextLine();
				// ����
				boardArray[num].setContent(rewrite);

				System.out.println("�����Ǿ����ϴ�.");
			}
			// ��й�ȣ Ʋ��
			else
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		// �� ã��
		else
			System.out.println("�ش��ϴ� ���� �����ϴ�.");
	}

	private static void delete() {
		System.out.println("[�� ����]");

		System.out.print("�ۼ��ڸ� �Է��ϼ���: ");

		String name = scanner.nextLine();
		boolean find = false;
		int num;
		// �ۼ��ڷ� �˻�
		for (num = 0; num < boardArray.length; num++) {
			if (name.equals(boardArray[num].getWriter())) {
				find = true;
				break;
			}
		}

		if (find == true) {
			System.out.println("�ۼ��� �� ��ȣ: " + boardArray[num].getBno());
			System.out.print("��й�ȣ�� �Է��ϼ���: ");
			String pwd = scanner.nextLine();

			if (pwd.equals(boardArray[num].getPassword())) {
				boardArray[num] = null;

				System.out.println("�����Ǿ����ϴ�.");
			} else
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else
			System.out.println("�ش��ϴ� ���� �����ϴ�.");
	}

}
