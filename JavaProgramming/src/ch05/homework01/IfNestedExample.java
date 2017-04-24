package ch05.homework01;

public class IfNestedExample {

	public static void main(String[] args) {
		int score=(int)(Math.random()*20)+81;	//81~100까지 수중 랜덤수 생성 , 형변환

		//랜덤으로 나온 점수 출력
		System.out.println("점수: "+ score);
		
		String grade;
		
		if(score>=90){			//중첩 if문으로 95이상이면 A+ 90이상 95미만 이면 A
			if(score>=95){
				grade="A+";
			}else{
				grade="A";
			}
		}else{					//중첩 if문으로 90미만 85이상이면 B+ 80이상 85미만 이면 B
			if(score>=85){
				grade="B+";
			}else{
				grade="B";
			}
		}
		
		System.out.println("학점: "+ grade);
	}

}
