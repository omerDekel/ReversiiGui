package Resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    /*@FXML
            private Label message;*/
    private ArrayList<GuiPlayer> players = new ArrayList<>();
    GuiBoard guiBoard;
    Color color1;
    Color color2;
    Board board;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.board = new Board(4);
        GuiPlayer player1 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_O, "Player O", Color.WHITE);
        GuiPlayer player2 = new GuiPlayer(PlayerTypes.PLAYER_TYPE_X,"Player X", Color.BLACK);
        players.add(player1);
        players.add(player2);
        ConsoleDisplayer displayer = new ConsoleDisplayer();
        BasicRules rules = new BasicRules();
        Game game = new Game(board,players,displayer, rules);
        currentPlayer.setText("Player O");
        GuiBoard guiBoard = new GuiBoard(player1, player2,board, game);
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

        /*GuiPlayer player = players.get(game.getCurrent_player_index());
        currentPlayer.setText(player.getM_name());*/
        //scorePlayer1.setText(String.valueOf(game.GetPlayer1Score()));
        //scorePlayer2.setText(String.valueOf(game.GetPlayer2Score()));
    }
}


