package ch06.homework03.exam04;

public class SingletonExample {

	public static void main(String[] args) {
		/*
		 Singleton obj1 =new Singleton();	//생성자에 접근 할수 없기 때문에 생성 불가능
		 */
		
		//두개가 모두 같은 객체를 가르킨다. 
		Singleton obj1=Singleton.getInstance();
		Singleton obj2=Singleton.getInstance();
		
		if(obj1 ==obj2){
			System.out.println("같은객체");
		}else{
			System.out.println("다른객체");
		}
	}

}
