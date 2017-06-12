package ch06.homework_board;

import java.util.Scanner;

public class BoardExample {

	private static Board[] boardArray = new Board[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("------------[게시판]----------------");
			System.out.println("1. 글 쓰기 | 2. 글 목록 | 3. 글 검색");
			System.out.println("4. 글 수정 | 5. 글 삭제 | 6. 종료 ");
			System.out.println("--------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();
			scanner.nextLine(); // 엔터 제거

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
		System.out.println("게시판 종료");
		/*
		 * 게시판 기능 글 쓰기 글 검색 글 수정 글 삭제
		 */
	}

	private static void write() {
		System.out.println("[새로운 글 작성]");

		// 데이터 입력받기
		System.out.print("제목: ");
		String title = scanner.nextLine();
		System.out.print("작성자: ");
		String writer = scanner.nextLine();
		System.out.print("글 내용: ");
		String content = scanner.nextLine();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine();
		System.out.print("공개하시겠습니까?(y,n): ");
		boolean open = true;
		while (true) {
			String open_s = scanner.nextLine();
			if (open_s.equals("n")) {
				open = false;
				break;
			} else if (!open_s.equals("y")) {
				System.out.println("y,n만 입력하세요: ");
				continue;
			} else
				break;
		}

		// 비어있는 글 번호를 찾음(글 번호는 1번부터)
		int bno = 0;
		for (int i = 0; i < boardArray.length; i++) {
			if (boardArray[i] == null) {
				bno = i + 1;
				break;
			}
		}

		Board board = new Board(bno, title, writer, content, password, open);

		// Array에 추가
		for (int i = 0; i < boardArray.length; i++) {
			if (boardArray[i] == null) {
				boardArray[i] = board;
				break;
			}
		}

	}

	private static void boardList() {
		System.out.println("[글 목록]");

		for (int i = 0; i < boardArray.length; i++) {
			// 공개된 글일 경우
			if (boardArray[i] != null && boardArray[i].isOpen() == true) {
				System.out.println("글 번호 <" + boardArray[i].getBno() + ">");
				System.out.println("제목: " + boardArray[i].getTitle());
				System.out.println("작성자: " + boardArray[i].getWriter());
				System.out.println("글 내용: " + boardArray[i].getContent());
				System.out.println("-------------------------------------------------------------");
			}
		}
	}

	private static void search() {
		System.out.println("[무엇으로 검색하시겠습니까?]");
		System.out.println("1. 작성자 | 2. 글 번호");
		int num = scanner.nextInt();
		scanner.nextLine(); // 엔터 제거

		// 작성자 선택
		if (num == 1) {
			System.out.print("작성자를 입력하세요: ");
			String writer = scanner.nextLine();
			Board board = searchByWriter(writer);

			if (board != null) {
				System.out.println("글 번호 <" + board.getBno() + ">");
				System.out.println("제목: " + board.getTitle());
				System.out.println("작성자: " + board.getWriter());
				System.out.println("글 내용: " + board.getContent());
				System.out.println("-------------------------------------------------------------");
			} else
				System.out.println("글을 찾을 수 없습니다.");

		} else if (num == 2) {
			System.out.print("글 번호를 입력하세요: ");
			int bno = scanner.nextInt();
			scanner.nextLine(); // 엔터 제거

			if (boardArray[bno - 1].isOpen() == false)
				System.out.println("비공개 글입니다.");
			else if (boardArray[bno - 1] == null)
				System.out.println("존재하지 않는 글 번호 입니다.");
			else {
				System.out.println("글 번호 <" + boardArray[bno - 1].getBno() + ">");
				System.out.println("제목: " + boardArray[bno - 1].getTitle());
				System.out.println("작성자: " + boardArray[bno - 1].getWriter());
				System.out.println("글 내용: " + boardArray[bno - 1].getContent());
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
		System.out.println("[글 수정]");
		// 작성자를 통한 검색
		System.out.print("작성자를 입력하세요: ");

		String name = scanner.nextLine();
		boolean find = false;
		int num;

		for (num = 0; num < boardArray.length; num++) {
			if (name.equals(boardArray[num].getWriter())) {
				find = true;
				break;
			}
		}
		// 찾으면
		if (find == true) {
			System.out.println("작성한 글 번호: " + boardArray[num].getBno());
			System.out.print("비밀번호를 입력하세요: ");
			String pwd = scanner.nextLine();
			// 비밀번호가 맞으면
			if (pwd.equals(boardArray[num].getPassword())) {
				System.out.print("수정할 내용을 입력하세요: ");
				String rewrite = scanner.nextLine();
				// 수정
				boardArray[num].setContent(rewrite);

				System.out.println("수정되었습니다.");
			}
			// 비밀번호 틀림
			else
				System.out.println("비밀번호가 일치하지 않습니다.");
		}
		// 못 찾음
		else
			System.out.println("해당하는 글이 없습니다.");
	}

	private static void delete() {
		System.out.println("[글 삭제]");

		System.out.print("작성자를 입력하세요: ");

		String name = scanner.nextLine();
		boolean find = false;
		int num;
		// 작성자로 검색
		for (num = 0; num < boardArray.length; num++) {
			if (name.equals(boardArray[num].getWriter())) {
				find = true;
				break;
			}
		}

		if (find == true) {
			System.out.println("작성한 글 번호: " + boardArray[num].getBno());
			System.out.print("비밀번호를 입력하세요: ");
			String pwd = scanner.nextLine();

			if (pwd.equals(boardArray[num].getPassword())) {
				boardArray[num] = null;

				System.out.println("삭제되었습니다.");
			} else
				System.out.println("비밀번호가 일치하지 않습니다.");
		} else
			System.out.println("해당하는 글이 없습니다.");
	}

}
