package ch18.exam03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        //String path = WriteExample.class.getResource("test.txt").getPath();
        OutputStream os = new FileOutputStream("src/ch18/exam03/test.txt"); //원래는 src폴더에 파일 생성하면 안됨!

        for (int i = 0; i < 20; i++) {
            os.write(97);
        }
        os.flush();
        os.close();

    }

}
