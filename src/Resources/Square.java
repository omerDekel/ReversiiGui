package Resources;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


/**
 * Created by Omer Dekel on 13/01/2018.
 */
public class Square extends Rectangle{
    private Point location;
    private GuiPlayer player;
    private Game game;
    private BoardController board;
    public Square ( Point loc, GuiPlayer player1, Game game1, BoardController boardController ,Paint paint
            , double height, double width) {
        super(width,height,paint);
        this.location = loc;
        this.board = boardController;
        this.game = game1;
        this.player = player1;
    }
    public void clickHandler(){
        this.game.run(location);
    }
}
