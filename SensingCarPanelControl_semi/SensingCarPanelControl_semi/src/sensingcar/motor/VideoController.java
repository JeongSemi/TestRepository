package sensingcar.motor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sensingcar.motor.camera.ViewerCanvas;

public class VideoController implements Initializable {

    private String uri = "192.168.0.100";

    @FXML
    private AnchorPane videoPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewerCanvas viewer = new ViewerCanvas(500, 280);
        try {
            viewer.setCurrentURL(new URL("http://" + uri + ":50001/?action=stream"));
            viewer.setLayoutX(100);
            viewer.setLayoutY(80);
            videoPane.getChildren().add(viewer);
        } catch (MalformedURLException ex) {
        }
    }

}
