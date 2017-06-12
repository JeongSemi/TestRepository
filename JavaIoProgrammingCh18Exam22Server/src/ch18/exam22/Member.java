package ch18.exam22;

import java.io.Serializable;

public class Member implements Serializable{

    //Field
     private static final long serialVersionUID = 1;
    private String mname;
    private int age;
    private String job;
    //Constructor
    public Member(String mname, int age) {
        this.mname = mname;
        this.age = age;
    }
    //Method

    public String getMname() {
        return mname;
    }

    public int getAge() {
        return age;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}
