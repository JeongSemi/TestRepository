package ch18.exam13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample {

    public static void main(String[] args) throws IOException {
        /*
        InputStream is = System.in; // = 뒤쪽은 다양하게 줄 수있다. 
        InputStreamReader isr = new InputStreamReader(is); //주 스트림(연결스트림)을 매개값으로 준다.

        int data = isr.read();
        System.out.print((char) data);
         */

        InputStream is = new FileInputStream("src/ch18/exam13/test.txt");
        InputStreamReader isr = new InputStreamReader(is);

        int data = isr.read();
        System.out.println((char) data);
    }

}
