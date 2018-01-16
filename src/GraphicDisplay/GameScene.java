package GraphicDisplay;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * GameScene.
*/
public class GameScene{
    /**
     * start the game
     * @param primaryStage the primaryStage
     */
    public void start(Stage primaryStage) {
        try {
            HBox root = (HBox) FXMLLoader.load(getClass().getClassLoader().getResource("GraphicDisplay/ReversiFXML.fxml"));
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(new Scene(root, 650, 650));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
