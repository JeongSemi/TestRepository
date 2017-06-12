package ch18.exam04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        //String path = WriteExample.class.getResource("test.txt").getPath();
        OutputStream os = new FileOutputStream("src/ch18/exam03/test.txt"); //원래는 src폴더에 파일 생성하면 안됨!

        byte[] data = {97, 98, 99};
        //byte[] data = "abc".getBytes();

        os.write(data);
        os.flush();
        os.close();

    }

}
