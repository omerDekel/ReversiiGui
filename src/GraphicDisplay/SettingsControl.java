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
 * Created by Omer Dekel on 09/01/2018.
 */
public class SettingsControl implements Initializable {
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

    @FXML
    public void getSettings() {
        StringBuffer inputStrBuffer = new StringBuffer();
        String colorp1 = player1Color.getValue().toString();
        String colorp2 = player2Color.getValue().toString();
        String opnPlayerString = whoStarts.getValue().toString();
        String sizeString = boardSize.getValue().toString();
        inputStrBuffer.append(colorp1);
        inputStrBuffer.append(",");
        inputStrBuffer.append(colorp2);
        inputStrBuffer.append(",");
        inputStrBuffer.append(opnPlayerString);
        inputStrBuffer.append(",");
        inputStrBuffer.append(sizeString);
        inputStrBuffer.append(",");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("settings.txt");
            fileOutputStream.write(inputStrBuffer.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("couldn't write to file");
        }
        Stage stage = (Stage) okBtn.getScene().getWindow();

        try {
            backToMenu(stage);
        } catch (Exception e) {
            System.out.println("couldn't go back to menu");
        }
    }
    public void backToMenu(Stage primaryStage) throws  Exception {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            primaryStage.setTitle("Reversy");
            Scene scene = new Scene(root, 300, 275);
            primaryStage.setScene(scene);
            primaryStage.show();

}
@FXML
public void initialize(){}
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
                //boardSize.setItems(boardSizes);
                player1Color.setValue(settingsChoices[0]);
                //player1Color.setItems(colors1);
                player2Color.setValue(settingsChoices[1]);
                //player2Color.setItems(colors2);
                whoStarts.setValue(settingsChoices[2]);
                //whoStarts.setItems(players);
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println("couldnt read file");
        }

    }
}
