package GraphicDisplay;

import Resources.*;
import Resources.Game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
/**
 * Created by Omer Dekel on 12/01/2018.
 */
public class BoardController implements Initializable {
    @FXML
    private HBox root;
    @FXML
            private Label currentPlayer;
    @FXML
            private Label scorePlayer1;
    @FXML
            private Label scorePlayer2;
    private ArrayList<GuiPlayer> players = new ArrayList<>();
    private Color color1;
    private Color color2;
    private Board board;
    private GuiPlayer player1;
    private GuiPlayer player2;
    private int size;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readingSettingsFile();
        this.board = new Board(this.size);
        players.add(player1);
        players.add(player2);
        GuiDisplayer displayer = new GuiDisplayer();
        BasicRules rules = new BasicRules();
        Game game = new Game(board,players,displayer, rules);
        GuiBoard guiBoard = new GuiBoard(board, game, color1, color2);
        scorePlayer1.setText("2");
        scorePlayer2.setText("2");
        Listener scorelistener = new ScoreListener(scorePlayer1, scorePlayer2);
        Listener playerListener = new CurrentPlayerListener(currentPlayer);
        game.addListener(scorelistener);
        game.addListener(playerListener);
        guiBoard.setPrefWidth(400);
        guiBoard.setPrefHeight(400);
        guiBoard.setAlignment(Pos.CENTER);
        guiBoard.setPadding(new Insets(40,40,40,40));
        root.getChildren().add(0, guiBoard);
        guiBoard.draw();
    }

    /**
     * reading from the setting.
     */
    public void readingSettingsFile() {
        try {
               BufferedReader bufferedReader = new BufferedReader(new FileReader("settings.txt"));
               String lineFromFile = bufferedReader.readLine();
                if (null == lineFromFile) {
                    throw new Exception("there's no line in this file");
                }
                String settingsChoices[] = lineFromFile.split(",");
                size = Integer.parseInt(settingsChoices[3]);
                color1 = Color.web(settingsChoices[0]);
                color2 = Color.web(settingsChoices[1]);
                if(settingsChoices[2].equals("PLAYER 1")) {
                    player1 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_O, settingsChoices[0],color1 );
                    player2 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_X, settingsChoices[1], color2);
                    currentPlayer.setText(settingsChoices[0]);
                }  else {
                    player1 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_X, settingsChoices[1],color2 );
                    player2 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_O, settingsChoices[0], color1);
                    currentPlayer.setText(settingsChoices[1]);
                }
                bufferedReader.close();
        } catch (Exception e) {
            currentPlayer.setText("White");
            this.size = 8;
            player1 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_O, "White", Color.WHITE);
            player2 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_X,"Black", Color.BLACK);
            System.out.println("couldnt read file");
        }

    }

    }


