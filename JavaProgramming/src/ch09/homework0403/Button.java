package ch09.homework0403;

public class Button {
	//Field
	private OnClickListener listener; //interface 타입
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener listener) { //interface타입 객체가 들어온다
		this.listener = listener;
	}
	public void touch() {
		if(listener != null){
			listener.onClick(); //interface타입 객체의 메소드가 실행된다
		}
	}
	//Nested Interface
	interface OnClickListener {
		void onClick();
	}

	
	
}
