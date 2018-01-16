package GraphicDisplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Settings  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("Sett.fxml"));
        primaryStage.setTitle("Settings");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}
