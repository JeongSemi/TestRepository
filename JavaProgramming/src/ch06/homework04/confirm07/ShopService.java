package ch06.homework04.confirm07;

public class ShopService {
	private static ShopService shopService=new ShopService();
	
	private ShopService(){
		
	}
	
	public static ShopService getInstance(){
		return shopService;
	}
}
