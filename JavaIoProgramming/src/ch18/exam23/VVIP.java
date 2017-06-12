package ch18.exam23;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable {

    private int memeberShipNo;
    private String grade;

    public VVIP() {
    }

    public VVIP(int memeberShipNo, String grade, String name, int age) {
        super(name, age);
        this.memeberShipNo = memeberShipNo;
        this.grade = grade;
    }

    public int getMemeberShipNo() {
        return memeberShipNo;
    }

    public void setMemeberShipNo(int memeberShipNo) {
        this.memeberShipNo = memeberShipNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    //꼭 private으로 작성해야함
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(getName()); //자신에게 없는 필드(부모에게만 있는 필드)를 따로 작성해준다.
        out.writeInt(getAge());
        out.defaultWriteObject(); //자기 자신의 필드를 직렬화한다.
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        setName(in.readUTF()); //따로 작성해준 필드를 먼저 읽어들인다.
        setAge(in.readInt());
        in.defaultReadObject(); //자기 자신의 필드를 역직렬화한다.
    }
}
