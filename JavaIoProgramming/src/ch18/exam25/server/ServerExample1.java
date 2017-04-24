package ch18.exam25.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //ServerSocket 생성
            serverSocket = new ServerSocket();
            //포트바인딩
            serverSocket.bind(new InetSocketAddress(50001));
            //연결 기다리기
            Socket socket = serverSocket.accept();
            //클라이언트의 정보 얻기
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println(isa.toString());
            System.out.println(isa.getHostName());
            //통신하기

            //연결끊기
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //ServerSocket이 50001을 현재 사용하고 있는가?
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                // 네트워크가 사용 불가능한 상태라면(사용중이 아니라면)
                // ServerSocket 닫기(50001번을 해제한다)
                serverSocket.close();
            } catch (IOException ex1) {
            }
        }
    }

}
