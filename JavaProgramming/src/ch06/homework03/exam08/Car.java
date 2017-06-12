package ch06.homework03.exam08;

//Tire와 Engine클래스를 사용하기 위해서 import시킴
import ch06.exam10.parts.*;
import ch06.exam10.parts2.*;;

public class Car {
	//Field
	//ch06. ch06.exam10.parts.Engine 에 접근이 가능하다. 
	Engine engine=new Engine();
	//Tire클래스가 parts와 parts2패키지에 둘다 있기 때문에 패키지 명시화 해야 한다. 
	ch06.exam10.parts.Tire tire1 = new ch06.exam10.parts.Tire();
	ch06.exam10.parts2.Tire tire2 = new ch06.exam10.parts2.Tire();
}
