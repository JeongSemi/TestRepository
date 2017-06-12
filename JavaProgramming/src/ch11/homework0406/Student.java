package ch11.homework0406;

public class Student {
	private String studentNum;
	
	public Student(String studentNum){
		this.studentNum = studentNum;
	}
	
	public String getStudentNum(){
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student std = (Student) obj;
		if(studentNum == std.studentNum){
			if(this.hashCode() == std.hashCode())
				return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

}
