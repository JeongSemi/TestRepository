package main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private Button btnVideo;
    @FXML
    private Button btnControl;
    @FXML
    private Button btnChart;
    @FXML
    private Button btnNotice;
    @FXML
    private Button btnSetting;
    @FXML
    private Button btnCall;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView btnHomeImage;
    @FXML
    private ImageView btnVideoImage;
    @FXML
    private ImageView btnControlImage;
    @FXML
    private ImageView btnChartImage;
    @FXML
    private ImageView btnNoticeImage;
    @FXML
    private ImageView btnSettingImage;
    @FXML
    private ImageView btnCallImage;
    @FXML
    private Label lblTime;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView packImage;

    private boolean packNotice = true;

    public void setPackNotice(boolean packNotice) {
        this.packNotice = packNotice;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //시간정보 설정
        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
                while (true) {
                    String strTime = sdf.format(new Date());
                    Platform.runLater(() -> {
                        lblTime.setText(strTime);
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        //택배알림
        if (packNotice == true) {
            FadeTransition ft = new FadeTransition(Duration.millis(700), packImage);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }

        //버튼 눌렀을 때 화면 전환
        btnCall.setOnAction(e -> handleBtnCall(e));
        btnVideo.setOnAction(e -> handleBtnVideo(e));
        btnControl.setOnAction(e -> handleBtnControl(e));
        btnChart.setOnAction(e -> handleBtnChart(e));
        btnNotice.setOnAction(e -> handleBtnNotice(e));
        btnSetting.setOnAction(e -> handleBtnSetting(e));

    }

    private void handleBtnCall(ActionEvent e) {

        //btnCallImage.setImage(new Image(getClass().getResource("images/icons/tel(white).png").toString()));
        
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("call/Call.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 login.fxml이 쌓인다

            parent.setTranslateX(800); //root의 루트컨테이너=350 이기 때문에 초기값을 350으로 지정

            KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0); //무엇을: parent의 translateX값을 종료값: 0까지 바꾸겠다.
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            //timeLine.playFrom(Duration.millis(300));
            timeLine.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void handleBtnVideo(ActionEvent e) { // suyang
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("video/Video.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnControl(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Control.fxml"));
            stackPane.getChildren().add(parent);

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnChart(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Chart.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Chart.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnNotice(ActionEvent e) {
    }

    private void handleBtnSetting(ActionEvent e) {
    }

}
