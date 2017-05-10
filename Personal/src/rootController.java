/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrator
 */
public class rootController implements Initializable {

    @FXML
    private ImageView planImage;
    @FXML
    private ImageView lightBulbImage;
    @FXML
    private Button btnLight;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLight.setOnAction(e -> handleBtnLight(e));
    }

    private void handleBtnLight(ActionEvent e) {
        planImage.setImage(new Image(getClass().getResource("투명평면도(주방on).png").toString()));
        lightBulbImage.setImage(new Image(getClass().getResource("lightbulb(bright).png").toString()));
    }

}
