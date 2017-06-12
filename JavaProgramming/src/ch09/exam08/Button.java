package ch09.exam08;

public class Button {
	//Field
	private OnClickListener onClickListener; //interface Ÿ��
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener onClickListener) { //interfaceŸ�� ��ü�� ���´�
		this.onClickListener = onClickListener;
	}
	public void touch() {
		if(onClickListener != null){
			onClickListener.onClick(); //interfaceŸ�� ��ü�� �޼ҵ尡 ����ȴ�
		}
	}
	//Nested Interface
	interface OnClickListener {
		void onClick();
	}

	
	
}
