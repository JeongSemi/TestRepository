package ch18.exam25.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample1 {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            //how1 -> 단점: 재사용가능 / 장점: 바로 연결할 수 있음
            //socket = new Socket("192.168.3.11", 50001); //연결요청 코드
            
            //how2 -> 장점: 언제든지 연결 주소 바꿀수 있다.(재사용가능)
            socket = new Socket(); //생성한다고 바로 연결되는 건 아니다(정보부족)
            socket.connect(new InetSocketAddress("192.168.3.11", 50001));
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
