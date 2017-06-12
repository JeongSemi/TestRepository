package ch18.exam10;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleExample {

    public static void main(String[] args) throws IOException {
        InputStream is = System.in; //in은 inputstream type이다

        //how1
        byte[] keycodes = new byte[10];
        int readBytes = is.read(keycodes);
        System.out.println(Arrays.toString(keycodes));
        String str = new String(keycodes, 0, readBytes - 2);
        System.out.println(str);

        //how2
        Scanner sc = new Scanner(System.in);
        String str2 = sc.nextLine(); //한줄 전부 다 읽기
        System.out.println(str2);

        //how3
        Console console = System.console();
        String str3 = console.readLine(); //무조건 문자열로만 읽는다 -> scanner가 더 다양하게 이용가능하다.
        System.out.println(str3);

    }

}
