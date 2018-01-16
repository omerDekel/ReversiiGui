package GraphicDisplay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * SettingsControl .
 * controller of the settings screen .
 */
public class SettingsControl implements Initializable {
    //members .
    ObservableList<String> colors1 = FXCollections.observableArrayList("green", "white", "yellow");
    ObservableList<String> colors2 = FXCollections.observableArrayList("pink", "black", "blue");
    ObservableList<String> boardSizes = FXCollections.observableArrayList("4", "6", "8", "10", "12", "14"
            , "16", "18", "20");
    ObservableList<String> players = FXCollections.observableArrayList("PLAYER 1", "PLAYER 2");
    @FXML
    private ComboBox player1Color = new ComboBox();
    @FXML
    private ComboBox player2Color = new ComboBox();
    @FXML
    private ComboBox whoStarts = new ComboBox();
    @FXML
    private ComboBox boardSize = new ComboBox();
    @FXML
    private RadioButton okBtn = new RadioButton();

    /**
     * getSettings .
     * getting the settings choices from the user and write it to file .
     */
    @FXML
    public void getSettings() {
        StringBuffer inputStrBuffer = new StringBuffer();
        // getting the settings choices after the user chose.
        String colorp1 = player1Color.getValue().toString();
        String colorp2 = player2Color.getValue().toString();
        String opnPlayerString = whoStarts.getValue().toString();
        String sizeString = boardSize.getValue().toString();
        // creating buffer the settings write it to file .
        inputStrBuffer.append(colorp1);
        inputStrBuffer.append(",");
        inputStrBuffer.append(colorp2);
        inputStrBuffer.append(",");
        inputStrBuffer.append(opnPlayerString);
        inputStrBuffer.append(",");
        inputStrBuffer.append(sizeString);
        inputStrBuffer.append(",");
        //try to write settings to file .
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("settings.txt");
            fileOutputStream.write(inputStrBuffer.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("couldn't write to file");
        }
        // going back to the menu .
        Stage stage = (Stage) okBtn.getScene().getWindow();

        try {
            backToMenu(stage);
        } catch (Exception e) {
            System.out.println("couldn't go back to menu");
        }
    }

    /**
     * backToMenu .
     * going back to the menu .
     * @param primaryStage stage to show the menu on it .
     * @throws Exception  if we couldn't  go back to the menu .
     */
    public void backToMenu(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Reversi");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file;
        String filePath;
        BufferedReader bufferedReader;
        String lineFromFile;
        String settingsChoices[];
        boardSize.setItems(boardSizes);
        player1Color.setItems(colors1);
        player2Color.setItems(colors2);
        whoStarts.setItems(players);
        boardSize.setValue("8");
        player1Color.setValue("White");
        player2Color.setValue("Black");
        whoStarts.setValue("PLAYER 1");
        // try initialize the settings according the setttings file .
        try {
            file = new File("settings.txt");
            if (file.exists()) {
                filePath = file.getAbsolutePath();
                bufferedReader = new BufferedReader(new FileReader(filePath));
                lineFromFile = bufferedReader.readLine();
                if (null == lineFromFile) {
                    throw new Exception("there's no line in this file");
                }
                settingsChoices = lineFromFile.split(",");
                boardSize.setValue(settingsChoices[3]);
                player1Color.setValue(settingsChoices[0]);
                player2Color.setValue(settingsChoices[1]);
                whoStarts.setValue(settingsChoices[2]);
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println("couldnt read file");
        }
    }
}
