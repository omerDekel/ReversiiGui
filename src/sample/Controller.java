package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    protected void startSettings() {

        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e) {

        }
    }

}
