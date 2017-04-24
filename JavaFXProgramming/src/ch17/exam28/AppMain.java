package ch17.exam28;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent parent = FXMLLoader.load(getClass().getResource("root.fxml")); //AppMain.class.getResource() 똑같음

        //how1
        AppMain.primaryStage = primaryStage;
        
        //how2
        FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
        Parent parent = loader.load();
        RootController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MenuBar");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
