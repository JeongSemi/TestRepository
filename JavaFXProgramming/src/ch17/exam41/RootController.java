package ch17.exam41;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {

	@FXML
	private Button btnLogin;
	@FXML
	private StackPane stackPane;

	// public static StackPane rootPane;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//rootPane = stackPane;
		btnLogin.setOnAction(e -> handleBtnLogin(e));
	}

	private void handleBtnLogin(ActionEvent e) { //화면 전환
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
			stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 login.fxml이 쌓인다
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
