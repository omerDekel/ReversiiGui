package Resources;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Omer Dekel on 13/01/2018.
 */
public class GuiBoard extends GridPane {
    public Board getBoard() {
        return board;
    }

    private Board board;
    private Game m_game;
    //private IRules m_rules;
    private List<IPlayer> m_players = new ArrayList<>();

    GuiBoard(IPlayer player_1, IPlayer player_2, Board board, Game game) {
        this.board = board;
        //this.m_rules = rules;
        m_game = game;
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

        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();

        int cellHeight = height / board.get_num_rows();
        int cellWidth = width / board.get_num_columns();

        /*Map<PlayerTypes,Color> cells_strings = new TreeMap<>();
        cells_strings.put(PlayerTypes.PLAYER_TYPE_O, " O ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_X, " X ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_NONE, Color.YELLOWGREEN);*/

        for (int i = 0; i < board.get_num_rows(); i++) {
            for (int j = 0; j < board.get_num_columns(); j++) {
                //if (board[i][j] == FREE)
                //StackPane sp = new StackPane();
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, Color.YELLOWGREEN);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(2);
                this.add(rectangle, j, i);
                BorderPane bordPane = new BorderPane();
                this.add(bordPane, j, i);
                PlayerTypes playerType = board.getCell(new Point(i, j));
                if (playerType == PlayerTypes.PLAYER_TYPE_X) {
                    Circle circle = new Circle(Math.min(cellHeight, cellWidth) / 2 - 10);
                    circle.setFill(Color.BLACK);
                    this.add(circle, j, i);
                }
                if (playerType == PlayerTypes.PLAYER_TYPE_O) {
                    Circle circle = new Circle(Math.min(cellHeight, cellWidth) / 2 - 10);
                    circle.setFill(Color.WHITE);
                    this.add(circle, j, i);
                }
                final int fi = i ;
                final int fj =  j;
                Point p = new Point(fi, fj);
                bordPane.setOnMouseClicked(event -> {this.clickHandler(p);});

            }
        }
    }

    public void clickHandler(Point location) {
        System.out.println("x is"+location.getX());
        System.out.println("y is"+location.getY());
        this.m_game.run(/*new Point(location.getY(), location.getX())*/location);
        this.draw();
    }
    /*public void drawPlayer(Color playerColor,Point location) {
        HBox hb = new HBox();

        PlayerTypes playerType = board.getCell(location);
        if (playerType != PlayerTypes.PLAYER_TYPE_NONE) {
            if (playerType == PlayerTypes.PLAYER_TYPE_X) {

            }
        }
        //Circle disk = new Circle()
    }*/
}
