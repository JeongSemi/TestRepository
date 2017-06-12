package ch06.homework03.exam06;

public class Earth {
	//상수 선언, 보통은 바로 초기화 
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	//상수 초기화는 static블록을 통해서 연산후 추기화 가능하다. 
	static{
		EARTH_SURFACE_AREA = 4*Math.PI*EARTH_RADIUS *EARTH_RADIUS;
	}
}
