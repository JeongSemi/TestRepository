package ch17.exam28;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private Button btnPopup;
    @FXML
    private Button btnCustom;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOpenFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Button button = (Button) event.getSource();
        Scene scene = button.getScene();
        Stage stage = (Stage) scene.getWindow();
        File file = fileChooser.showOpenDialog(stage);
        System.out.println(file.getPath());
    }

    @FXML
    private void handleSaveFileChooser(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(((Button) event.getSource()).getScene().getWindow());
        if (file != null) {
            System.out.println(file.getPath());
        }
    }

    @FXML
    private void handleDirectoryChooser(ActionEvent event) {
        DirectoryChooser directoryChooer = new DirectoryChooser();
        File file = directoryChooer.showDialog(primaryStage);
    }

    @FXML
    private void handlePopup(ActionEvent event) throws Exception {
        // showNotification("알림", "메시지가 도착했습니다.");
        showNotification("경고", "도둑이 침입했습니다.");
    }

    private void showNotification(String type, String message) throws Exception {
        Popup popup = new Popup();
        HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("popup.fxml"));
        ImageView imgMessage = (ImageView) hbox.lookup("#imgMessage");
        Label lblMessage = (Label) hbox.lookup("#lblMessage");
        if (type.equals("알림")) {
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
            lblMessage.setText(message);
        } else if (type.equals("경고")) {
            imgMessage.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
            lblMessage.setText(message);
        }
        popup.getContent().add(hbox);
        popup.setAutoHide(true);
        popup.show(AppMain.primaryStage);

    }

    @FXML
    private void handleCustom(ActionEvent event) throws Exception {
        //showCustomDialog("warning", "확인하셨습니까?");
        showCustomDialog("error", "네트워크 에러가 발생했습니다.");
    }

    private void showCustomDialog(String type, String message) throws Exception {
        Stage dialog = new Stage(StageStyle.TRANSPARENT);
        Parent parent = FXMLLoader.load(getClass().getResource("custom-dialog.fxml"));

        ImageView icon = (ImageView) parent.lookup("#icon");
        Label lblMessage = (Label) parent.lookup("#message");
        Button btnOK = (Button) parent.lookup("#btnOK");

        if (type.equals("error")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-error.png").toString()));
        } else if (type.equals("help")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-help.png").toString()));
        } else if (type.equals("info")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        } else if (type.equals("warning")) {
            icon.setImage(new Image(getClass().getResource("images/dialog-warning.png").toString()));
        }

        lblMessage.setText(message);

        btnOK.setOnAction(e -> {
            dialog.hide();
        });

        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        dialog.setScene(scene);
        dialog.initOwner(AppMain.primaryStage); //소유자 윈도우 지정
        dialog.initModality(Modality.WINDOW_MODAL); //창 닫기전까지 나머지 창에서 작업 불가(지정안해주면 modaless)
        dialog.show();

    }

}
