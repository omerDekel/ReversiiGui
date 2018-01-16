package GraphicDisplay;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Controller.
 * the controller of the menu .
 */
public class Controller {
    //members .
    @FXML
    private GridPane menu;
    @FXML
    private Button startButton;
    @FXML
    private Button settingsButton;

    @FXML
    /**
     * startGame .
     * starting the game .
     * this function wil be called when we press start .
     */
    protected void startGame() {

        GameScene gameScene = new GameScene();
        Stage primaryStage = (Stage) menu.getScene().getWindow();
        try {
            gameScene.start(primaryStage);
        } catch (Exception e) {

        }
    }

    @FXML
    /**
     * startSettings .
     * this function create file with the settings that the user choose .
     *
     */
    protected void startSettings() {

        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e) {

        }
    }

}
