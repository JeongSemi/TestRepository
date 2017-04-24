package ch07.exam04;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child("a", "b");
		System.out.println(child.lastName);
		System.out.println(child.firstName);
		child.sound();
		child.play();
		
		child.parentSound();
		int a = -3;
		byte c = (byte)a;
		System.out.println(c);
	}

}
