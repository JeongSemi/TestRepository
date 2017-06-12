package ch09.homework0403;

public class Button {
	//Field
	private OnClickListener listener; //interface Ÿ��
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener listener) { //interfaceŸ�� ��ü�� ���´�
		this.listener = listener;
	}
	public void touch() {
		if(listener != null){
			listener.onClick(); //interfaceŸ�� ��ü�� �޼ҵ尡 ����ȴ�
		}
	}
	//Nested Interface
	interface OnClickListener {
		void onClick();
	}

	
	
}
