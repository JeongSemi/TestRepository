package ch17.exam02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        
        vbox.setPrefWidth(400);
        vbox.setPrefHeight(300);

        Button button = new Button();
        button.setText("확인");
        Label label = new Label(); // 컨트롤
        label.setText("Hello, JavaFX");
        
        vbox.getChildren().add(label);
        vbox.getChildren().add(button);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
