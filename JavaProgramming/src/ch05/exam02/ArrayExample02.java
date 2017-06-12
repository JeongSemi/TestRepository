package ch05.exam02;

public class ArrayExample02 {

	public static void main(String[] args) {
		int[] v1={10, 20, 30};
		
		int[] v2;
		//v2={10,20,30};
		v2=new int[] {10, 20, 30};	//두개 해석은 똑같은데 안되는 이유는 무엇일까요 , 컴파일러는 정확하게 얼마를 할당할지 정하는데 이렇게 하면 얼마를 하는지 몰라서 에러남 이렇게 하면 v2가 생성되지 않았는데 선언하는 것처럼 받아드림
		
		int result1= sum(v1);
		int result2=sum(v2);
		//sum({10,20,30});   //v2={10,20,30} 와 같은 경우
		int result3=sum(new int[] {10,20,30});	//이런식으로 넣어주어야 한다. 
		System.out.println(result1 + result2 + result3);
	}

	public static int sum(int[] args){
		int sum=0;
		for(int i=0; i<args.length; i++){
			sum+=args[i];	
		}
		
		return sum;
				
	}
}
