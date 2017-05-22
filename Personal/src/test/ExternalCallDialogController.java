package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ExternalCallDialogController implements Initializable {

    @FXML
    private Button dialogBtnClose;
    @FXML
    private Button dialogBtnReceive;
    @FXML
    private ImageView imageClose;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dialogBtnReceive.setOnAction(e -> {
            dialogBtnReceive.setOpacity(0);
            imageClose.setImage(new Image(getClass().getResource("call(close).png").toString()));
            dialogBtnReceive.setLayoutX(0);
            dialogBtnClose.setLayoutX(173);
        });

          }

}
