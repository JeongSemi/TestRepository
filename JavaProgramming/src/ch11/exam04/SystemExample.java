package ch11.exam04;

public class SystemExample {

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				if(status != 54321){
					throw new SecurityException(); //실행예외이므로 try catch 안붙임
				}
			}
		});
		for(int i=0; i<10; i++){
			System.out.println(i);
			if(i == 5){
				try{
					System.exit(1);
				} catch(SecurityException e) { }
			}
				
		}
	}

}
