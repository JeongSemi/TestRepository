package ch06.homework05;

import java.util.Scanner;

import ch06.homework04.confirm09.Account;


public class BoardApplication {
	private static Member[] memberArray=new Member[100];
	private static Board[] boardArray=new Board[100];
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		Session sessionInfo=Session.getInstance();
		int selectNo;
		while(sessionInfo.getSessionID()==null){
			System.out.println("---------------------------");
			System.out.println("1.회원가입 | 2.로그인 | 3.종료");
			System.out.println("---------------------------");
			System.out.print("선택>");
			
			selectNo=Integer.parseInt(scanner.nextLine());
			
			if(selectNo==1){
				createMember();	
			}else if(selectNo==2){
				login();
			}else if(selectNo==3){
				System.exit(0);
			}
			
			while(sessionInfo.getSessionID()!=null){
				System.out.println("-------------------------------------------------------------");
				System.out.println("1.글목록보기 | 2.글쓰기 | 3.글보기 | 4.글삭제 | 5.회원목록보기 | 6.로그아웃");
				System.out.println("-------------------------------------------------------------");
				System.out.print("선택>");
			
				selectNo=Integer.parseInt(scanner.nextLine());
			
				if(selectNo==1){
					boardList();	
				}else if(selectNo==2){
					createBoard();
				}else if(selectNo==3){
					boardRead();
				}else if(selectNo==4){
					boardDelete();
				}else if(selectNo==5){
					memberList();
				}else if(selectNo==6){
					System.out.println(sessionInfo.getSessionID()+"님 안녕히 가세요");
					sessionInfo.setSessionID(null);
				}
			
			}
		}
		
	}
	
	private static void memberList(){
		System.out.println("------------------------");
		System.out.println("        회원 목록 ");
		System.out.println("-------------------------");
		
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null){
				System.out.println(memberArray[i].getId());		
			}
		}
	}
	
	private static void boardDelete(){
		
		System.out.print("글번호:");
		int boardNum=Integer.parseInt(scanner.nextLine());
		Board target=findBoard(boardNum);
		int target2=findBoard2(boardNum);
		Session session=Session.getInstance();
		if(target!=null&&target.getWriter()==session.getSessionID()){
			boardArray[target2]=null;
			System.out.println("글이삭제되었습니다.");
		}else{
			System.out.println("해당번호의 글이 없거나 작성자가 아니어서 지울수 없습니다.");
		}
		
	}
	
	private static void boardRead(){
		
		System.out.print("글번호:");
		int boardNum=Integer.parseInt(scanner.nextLine());
		Board target=findBoard(boardNum);
		if(target!=null){
			System.out.println("글번호 :"+target.getBoardNum());
			System.out.println("글제목 :"+target.getTitle());
			System.out.println("글내용 :"+target.getContent());
			System.out.println("글쓴이 :"+target.getWriter());
		}else{
			System.out.println("해당번호의 글이 없습니다.");
		}
		
	}
	
	private static void boardList(){
		System.out.println("---------------------------");
		System.out.println("   게시물 목록 ");
		System.out.println("-------------------------");
		System.out.println("번호     제목     글쓴이");
		System.out.println("--------------------------");
		
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null){
				System.out.println(boardArray[i].getBoardNum()+"   "+boardArray[i].getTitle()+"   "+boardArray[i].getWriter());		
			}
		}
	}
	
	private static void createBoard(){
		System.out.println("--------");
		System.out.println(" 글쓰기");
		System.out.println("--------");
		
		System.out.print("제목:");
		String title=scanner.nextLine();
		
		System.out.print("내용:");
		String content=scanner.nextLine();
		
		Session session=Session.getInstance();
		String writer=session.getSessionID();
		
		int boardnum=Board.getNextboardNum()+1;
		
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]==null){
				boardArray[i]=new Board(boardnum, title, content, writer);
				System.out.println(writer+"님의 글이 등록 되었습니다.");
				break;
			}
		}

	}
	
	private static void createMember(){
		System.out.println("--------");
		System.out.println(" 회원가입");
		System.out.println("--------");
		String id;
		while(true){
			System.out.print("ID:");
			id=scanner.nextLine();
			if(findID(id)){
				break;
			}
			System.out.println("아이디가 중복입니다.");
		}
		System.out.print("비밀번호:");
		String pw=scanner.nextLine();
		
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]==null){
				memberArray[i]=new Member(id, pw);
				System.out.println(id+"님회원가입 되었습니다.");
				break;
			}
		}

	}
	
	
	private static void login(){
		System.out.print("ID:");
		String id=scanner.nextLine();
		System.out.print("PW:");
		String pw=scanner.nextLine();
		Member target=findMember(id);
		if(target!=null&&target.getPw().equals(pw)){
			String sessionID=target.getId();
			Session session=Session.getInstance();
			session.setSessionID(sessionID);
			System.out.println("로그인 되었습니다.");
			System.out.println(session.getSessionID()+"님 환영합니다.");
		}else{
			System.out.println("아이디 혹은 비밀번호를 확인해주세요");
		}
	}
	
	private static Member findMember(String id){
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null&&memberArray[i].getId().equals(id)){
				return memberArray[i];	
				
			}
		}
		return null;
		
	}
	
	
	private static Board findBoard(int boardNum){
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null&&boardArray[i].getBoardNum()==boardNum){
				return boardArray[i];	
				
			}
		}
		return null;
		
	}
	private static int findBoard2(int boardNum){
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null&&boardArray[i].getBoardNum()==boardNum){
				return i;	
				
			}
		}
		return -1;
		
	}
	
	private static boolean findID(String id){
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null&&memberArray[i].getId().equals(id)){
				return false;	
				
			}
		}
		return true;
		
	}
}
