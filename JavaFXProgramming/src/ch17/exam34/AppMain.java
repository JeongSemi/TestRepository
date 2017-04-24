package ch17.exam34;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml")); //AppMain.class.getResource() 똑같음
        //parent.getStylesheets().add(getClass().getResource("root.css").toString()); //CSS파일 적용코드
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CSS");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
