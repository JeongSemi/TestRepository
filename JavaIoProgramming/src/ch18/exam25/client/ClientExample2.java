package ch18.exam25.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample2 {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            //소켓 생성
            socket = new Socket(); //생성한다고 바로 연결되는 건 아니다(정보부족)
            //연결 요청
            socket.connect(new InetSocketAddress("192.168.3.11", 50001));
           
            //통신하기
            OutputStream os = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            String strData = sc.nextLine();
            byte[] data = strData.getBytes("UTF-8");
            os.write(data);
            os.flush();
            System.out.println("데이터 전송 성공");

            InputStream is = socket.getInputStream();
            byte[] data2 = new byte[100];
            int readBytes = is.read(data2);
            String strData2 = new String(data2, 0, readBytes, "UTF-8");
            System.out.println("받은 데이터 : " + strData2);
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException ex) {
            }
        }
    }

}
