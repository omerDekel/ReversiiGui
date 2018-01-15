package Resources;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Omer Dekel on 12/01/2018.
// */
public class GameScene{
    /**
     * start the game
     * @param primaryStage the primaryStage
     */
    public void start(Stage primaryStage) {
        try {
            HBox root = (HBox) FXMLLoader.load(getClass().getResource("ReversiFXML.fxml"));
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(new Scene(root, 600, 600));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        try {
//            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("ReversiFXML.fxml"));
//            primaryStage.setTitle("Reversi");
//            primaryStage.setScene(new Scene(root, 780, 700));
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
