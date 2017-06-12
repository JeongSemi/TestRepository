package ch17.exam41;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

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
		//how1
		//RootController.rootPane.getChildren().remove(1); //최상위+1 엘리먼트 제거(최상위: 인덱스 0)
		//RootController.rootPane.getChildren().remove(login); //fx:id = "login"인 객체를 지워라

		//how2
		StackPane rootPane = (StackPane) btnMain.getScene().getRoot(); //Root가 바로 stackPane
		rootPane.getChildren().remove(login);
	}
}
