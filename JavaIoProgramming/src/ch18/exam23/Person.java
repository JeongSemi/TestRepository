package ch18.exam23;

public class Person {

    //Field
    private String name;
    private int age;

    //Constructor
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //Method

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
