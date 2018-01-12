package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class SettingsControl implements Initializable{
    ObservableList<String> colors1 = FXCollections.observableArrayList("green", "white", "yellow");
    ObservableList<String> colors2 = FXCollections.observableArrayList("pink", "black", "blue");
    ObservableList<String> boardSizes =  FXCollections.observableArrayList("4x4","6x6","8x8", "10x10","12x12",
            "14x14","16x16","18x18","20x20");
    ObservableList<String> players = FXCollections.observableArrayList("PLAYER O","PLAYER X");
    @FXML
    private ComboBox player1Color = new ComboBox();
    @FXML
    private ComboBox player2Color= new ComboBox();
    @FXML
    private ComboBox whoStarts = new ComboBox();
    @FXML
    private ComboBox boardSize = new ComboBox();
    @FXML
    protected void initialize() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardSize.setValue("8x8");
        boardSize.setItems(boardSizes);
        player1Color.setValue("Player O COLOR");
        player1Color.setItems(colors1);
        player2Color.setValue("PLAYER X");
        player2Color.setItems(colors2);
        whoStarts.setValue("PLAYER O");
        whoStarts.setItems(players);


    }
}
