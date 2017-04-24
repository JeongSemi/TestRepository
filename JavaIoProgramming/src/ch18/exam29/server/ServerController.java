package ch18.exam29.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {

    public static ServerController instance;

    @FXML
    private Button btnStartStop;
    @FXML
    private TextArea txtDisplay;

    private ExecutorService executorService;
    private ServerSocket serverSocket; //연결 수락
    private List<Client> connections = new Vector<Client>(); //스레드풀-> 단일스레드 환경이 아니기 때문에 vector(동기화된 list)를 사용한다.

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServerController.instance = this; //자기자신을 넣어준다
        btnStartStop.setOnAction(e -> handleBtnStartStop(e));
    }

    private void handleBtnStartStop(ActionEvent e) {
        if (btnStartStop.getText().equals("시작")) {
            startServer();
        } else if (btnStartStop.getText().equals("멈춤")) {
            stopServer();
        }
    }

    private void startServer() {
        //스레드풀 생성
        executorService = Executors.newFixedThreadPool(100);

        try {
            //서버 소켓 생성
            serverSocket = new ServerSocket();
            //포트바인딩
            serverSocket.bind(new InetSocketAddress("192.168.3.11", 50001));
        } catch (IOException ex) {
            stopServer(); //포트가 이미 사용중일 때
            return;
        }

        //연결 수락 작업 정의
        Runnable acceptTask = () -> {
            //UI 변경 (acceptTask는 스레드풀 안의 스레드가 실행한다. 그런데 btnStartStop의 메소드는 UI변경 작업이므로 JAVAFX thread가 실행해야한다.)
            Platform.runLater(() -> {
                btnStartStop.setText("멈춤");
                display("서버 시작");
            });

            while (true) {
                try {
                    //수락
                    Socket socket = serverSocket.accept();
                    //연결된 클라이언트 정보 출력
                    String clientInfo = "[연결 수락: " + socket.getRemoteSocketAddress() + "]";
                    Platform.runLater(() -> display(clientInfo));
                    //통신용 Client 객체 생성
                    Client client = new Client(socket);
                    //Vector Client 저장
                    connections.add(client);
                    //총 Client 수 출력
                    Platform.runLater(() -> display("[연결 개수: " + connections.size() + "]"));
                } catch (IOException ex) {
                    stopServer();
                    break;
                }
            }
        };

        //스레드풀의 작업큐에 작업 넣기
        executorService.submit(acceptTask);
    }

    public void stopServer() {
        try {
//			//모든 클라이언트의 socket닫기
//			for(Client client: connections){
//				client.socket.close();
//			} 
//			//소켓을 닫은 클라이언트는 다 삭제한다 ->for문에서는 remove하면 안된다.
//			connections.clear();

            Iterator<Client> iterator = connections.iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }
            if (executorService != null) {
                executorService.shutdownNow();
                serverSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Platform.runLater(() -> {
            btnStartStop.setText("시작");
            display("서버 멈춤");
        });

    }

    private void display(String text) {
        txtDisplay.appendText(text + "\n"); //이어붙이기
    }

    class Client {

        Socket socket;

        Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        void receive() {
            //받기 작업 정의
            Runnable receiveTask = () -> {
                try {
                    while (true) {
                        InputStream inputStream = socket.getInputStream();
                        byte[] byteArr = new byte[100];
                        int readBytes = inputStream.read(byteArr);
                        if (readBytes == -1) {
                            throw new Exception();
                        }
                        //받은 데이터를 client 전부에 보낸다
                        String strData = new String(byteArr, 0, readBytes);
                        for (Client client : connections) {
                            client.send(strData);
                        }
                    }
                } catch (Exception e) {
                    try {
                        //연결이 끊겼을 때
                        String clientInfo = "[연결 끊김: " + socket.getRemoteSocketAddress() + "]";
                        Platform.runLater(() -> display(clientInfo));
                        //소켓을 닫는다
                        this.socket.close();
                        //Vector 에서 지운다
                        connections.remove(Client.this);
                        Platform.runLater(() -> display("[연결 개수: " + connections.size() + "]"));
                    } catch (IOException ex) {
                    }
                }
            };

            //스레드풀의 작업큐에 작업 넣기
            executorService.submit(receiveTask);
        }

        void send(String message) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        OutputStream os = socket.getOutputStream();
                        byte[] byteArr = message.getBytes();
                        os.write(byteArr);
                        os.flush();
                    } catch (IOException ex) {
                        connections.remove(Client.this);
                        try {
                            socket.close();
                        } catch (IOException ex1) {
                        }
                    }
                }
            };
            thread.start();

        }
    }

}
