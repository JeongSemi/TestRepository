package ch18.exam28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveExample {

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket(50002); // 받는쪽은 반드시 포트번호 지정해주어야한다

        DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);

        datagramSocket.receive(datagramPacket);

        byte[] data = datagramPacket.getData();
        int readBytes = datagramPacket.getLength();
        String strData = new String(data, 0, readBytes);
        
        System.out.println("받은 데이터: " + strData);
        datagramSocket.close();
    }

}
