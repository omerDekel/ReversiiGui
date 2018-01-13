package sample;

import Resources.GameScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button startButton;

    @FXML
    private Button settingsButton;
    /*@FXML
    protected void signIn() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        if (username.equals("roi") && password.equals("123456")) {
            messageText.setText("You are approved!");
            messageText.setFill(Color.BLUE);
        }
        else {
            messageText.setText("Invalid username or password");
            messageText.setFill(Color.RED);
        }
    }*/
    @FXML
    protected void startGame() {

        GameScene gameScene = new GameScene();
        Stage stage = (Stage) startButton.getScene().getWindow();
        try {
            gameScene.start(stage);
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
