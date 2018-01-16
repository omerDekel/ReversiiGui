package GraphicDisplay;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private GridPane menu;
    @FXML
    private Button startButton;
    @FXML
    private Button settingsButton;
    @FXML
    protected void startGame() {

        GameScene gameScene = new GameScene();
        Stage primaryStage = (Stage) menu.getScene().getWindow();
        try {
            gameScene.start(primaryStage);
        } catch (Exception e) {

        }
    }

    @FXML
    protected void startSettings() {

        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e) {

        }
    }

}
