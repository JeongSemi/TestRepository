package ch18.exam23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/ch18/exam23/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        VVIP vvip = (VVIP) ois.readObject();

        System.out.println(vvip.getMemeberShipNo() + " " + vvip.getName() + " "
        + vvip.getGrade() + " " + vvip.getAge());

        ois.close();
        
        fis.close();

    }

}
