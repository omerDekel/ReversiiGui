package GraphicDisplay;

import Resources.Board;
import Resources.Game;
import Resources.PlayerTypes;
import Resources.Point;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Created by Omer Dekel on 13/01/2018.
 */
public class GuiBoard extends GridPane {
    private Color player1Color;
    private Color player2Color;
    private Board board;
    private Game m_game;
    GuiBoard(Board board, Game game, Color color1, Color color2) {
        this.player1Color = color1;
        this.player2Color = color2;
        m_game = game;
        this.board = board;
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getClassLoader().getResource("GraphicDisplay/BoardFXML.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * getting the board
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * draw the game
     */
    public void draw() {
        this.getChildren().clear();

        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();
        int cellHeight = height / board.get_num_rows();
        int cellWidth = width / board.get_num_columns();
        for (int i = 0; i < board.get_num_rows(); i++) {
            for (int j = 0; j < board.get_num_columns(); j++) {
                StackPane stackPane = new StackPane();
                stackPane.setPrefHeight(cellHeight);
                stackPane.setPrefWidth(cellWidth);
                Rectangle rectangle = new Rectangle(cellWidth, cellHeight, Color.YELLOWGREEN);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(2);
                stackPane.getChildren().add(rectangle);
                PlayerTypes playerType = board.getCell(new Point(i, j));
                if (playerType == PlayerTypes.PLAYER_TYPE_X) {
                    Circle circle = new Circle(Math.min(cellHeight, cellWidth) / 4);
                    circle.setFill(player2Color);
                    stackPane.getChildren().add(circle);
                }
                if (playerType == PlayerTypes.PLAYER_TYPE_O) {
                    Circle circle = new Circle(Math.min(cellHeight, cellWidth) / 4);
                    circle.setFill(player1Color);
                    stackPane.getChildren().add(circle);
                }
                this.add(stackPane, j, i);
                final int fi = i ;
                final int fj =  j;
                Point p = new Point(fi, fj);
                stackPane.setOnMouseClicked(event -> {this.clickHandler(p);});

            }
        }
    }

    /**
     * click handle of the game
     * @param location the point
     */
    public void clickHandler(Point location) {
        this.m_game.run(location);
        this.draw();
    }
}
