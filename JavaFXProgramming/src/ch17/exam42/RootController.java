package ch17.exam42;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private StackPane stackPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnAction(e -> handleBtnLogin(e));
    }

    private void handleBtnLogin(ActionEvent e) { //화면 전환
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 login.fxml이 쌓인다

            parent.setTranslateX(350); //root의 루트컨테이너=350 이기 때문에 초기값을 350으로 지정

            KeyValue keyValue = new KeyValue(parent.translateXProperty(), 0); //무엇을: parent의 translateX값을 종료값: 0까지 바꾸겠다.
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
