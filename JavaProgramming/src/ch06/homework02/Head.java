package ch06.homework02;

public class Head {
	//Field
	Mouth mouth=new Mouth();
	Eye eye=new Eye();
	Ear []ear={new Ear(), new Ear(), new Ear()};
	
	int checkNum=0;
	//Constructor
	
	//Method
	void bow(int num){
		switch(num){
		case 1: 
			if(checkNum==1){
				System.out.println("이미 고개를 숙인 상태입니다.");
			}else{
				System.out.println("고개를 숙였습니다.");
				checkNum=num;
			}
			break;
		case 2: 
			if(checkNum==2){
				System.out.println("이미 고개를 든 산태입니다.");
			}else{
				System.out.println("고개를 들었습니다.");
				checkNum=num;
			}
			break;
		case 3:
			if(checkNum==3){
				System.out.println("이미 고개를 우로 꺽은 상태입니다.");
			}else{
				System.out.println("고개를 우로 꺽었습니다.");
				checkNum=num;
			}
			break;
		case 4:
			if(checkNum==4){
				System.out.println("이미 고개를 좌로 꺽은 상태입니다.");
			}else{
				System.out.println("고개를 좌로 꺽었습니다.");
				checkNum=num;
			}
			break;
		default :
			if(!(checkNum>=1&&checkNum<=4)){
				System.out.println("이미 정면을 보고 있습니다.");
			}else{
				System.out.println("고개를 정면으로 합니다.");
				checkNum=num;	
			}
			
		}
	}
}
