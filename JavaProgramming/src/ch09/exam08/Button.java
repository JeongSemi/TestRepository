package ch09.exam08;

public class Button {
	//Field
	private OnClickListener onClickListener; //interface 타입
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener onClickListener) { //interface타입 객체가 들어온다
		this.onClickListener = onClickListener;
	}
	public void touch() {
		if(onClickListener != null){
			onClickListener.onClick(); //interface타입 객체의 메소드가 실행된다
		}
	}
	//Nested Interface
	interface OnClickListener {
		void onClick();
	}

	
	
}
