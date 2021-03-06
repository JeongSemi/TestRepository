package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SmartHomePanel extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml")); //AppMain.class.getResource() 똑같음
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SmartHomePanel");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
