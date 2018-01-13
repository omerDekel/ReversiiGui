package Resources;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Omer Dekel on 13/01/2018.
 */
public class GuiBoard extends GridPane{
    private Board board;
    //private IRules m_rules;
    private List<IPlayer> m_players = new ArrayList<>();
    GuiBoard(IPlayer player_1, IPlayer player_2, Board board,  IRules rules) {
        this.board = board;
        //this.m_rules = rules;
        m_players.add(player_1);
        m_players.add(player_2);
        this.board = board;
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("BoardFXML.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public void draw() {
        this.getChildren().clear();

        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.get_num_rows();
        int cellWidth = width / board.get_num_columns();

        /*Map<PlayerTypes,Color> cells_strings = new TreeMap<>();
        cells_strings.put(PlayerTypes.PLAYER_TYPE_O, " O ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_X, " X ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_NONE, Color.YELLOWGREEN);*/

        for (int i = 0; i < board.get_num_rows(); i++) {
            for (int j = 0; j < board.get_num_columns(); j++) {
                //if (board[i][j] == FREE)
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, Color.YELLOWGREEN);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(2);
                this.add(rectangle, j, i);
            }
        }
    }
}
