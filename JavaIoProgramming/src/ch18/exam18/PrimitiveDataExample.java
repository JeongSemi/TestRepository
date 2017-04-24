package ch18.exam18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrimitiveDataExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int value = 10;
        double value2 = 2.5;
        boolean value3 = false;
        String value4 = "자바";

        OutputStream os = new FileOutputStream("src/ch18/exam18/test.dat");
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeInt(value);
        dos.writeDouble(value2);
        dos.writeBoolean(value3);
        dos.writeChars(value4);
        dos.flush();
        dos.close();

        os.flush();
        os.close();

        InputStream is = new FileInputStream("src/ch18/exam18/test.dat");
        DataInputStream dis = new DataInputStream(is);
        int readValue1 = dis.readInt();
        double readValue2 = dis.readDouble();
        boolean readValue3 = dis.readBoolean();
        String readValue4 = dis.readUTF();

        System.out.println(readValue1 + " " + readValue2 + " " + readValue3);

        dis.close();
        is.close();
    }

}
