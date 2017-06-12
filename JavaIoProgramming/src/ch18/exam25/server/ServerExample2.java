package ch18.exam25.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //ServerSocket 생성
            serverSocket = new ServerSocket();
            //포트바인딩
            serverSocket.bind(new InetSocketAddress(50001));
            //연결 기다리기
            while (true) {
                Socket socket = serverSocket.accept();
                //통신하기
                InputStream is = socket.getInputStream();
                byte[] data = new byte[100];
                int readBytes = is.read(data);
                if (readBytes == -1) {
                    throw new IOException("클라이언트가 정상 종료됨");
                }
                String strData = new String(data, 0, readBytes, "UTF-8");
                System.out.println("받은 데이터 : " + strData);

                OutputStream os = socket.getOutputStream();
                byte[] data2 = strData.getBytes("UTF-8");
                os.write(data2);
                os.flush();
                System.out.println("데이터 전송 성공");

                //연결끊기
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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
