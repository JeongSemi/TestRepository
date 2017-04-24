package ch17.exam42;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController implements Initializable {

	@FXML
	private BorderPane login;
	@FXML
	private Button btnMain;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnMain.setOnAction(e -> handleBtnMain(e));
	}

	private void handleBtnMain(ActionEvent e) {
		StackPane rootPane = (StackPane) btnMain.getScene().getRoot(); //Root가 바로 stackPane

		login.setOpacity(1); //opacity: 투명도 (1이 불투명 0이 투명)

		KeyValue keyValue = new KeyValue(login.opacityProperty(), 0); //무엇을: login의 opacity값을 종료값: 0까지 바꾸겠다.
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500),
				event -> rootPane.getChildren().remove(login), //애니메이션 종료 후 실행되는 코드
				keyValue
		);
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.play();

	}
}
