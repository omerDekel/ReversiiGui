package sample;

import Resources.GameScene;
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
        /*            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("BoardFXML.fxml"));
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(new Scene(root, 780, 700));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
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
