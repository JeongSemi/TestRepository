package ch18.exam15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        byte[] data = "가나다".getBytes();

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            os.write(data);
        }

        long endTime = System.nanoTime();
        System.out.println("Normal: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bos.write(data);
        }
        endTime = System.nanoTime();
        System.out.println("Buffered: " + (endTime - startTime));

        os.flush();
        bos.flush();
        os.close();
        bos.close();

    }

}
