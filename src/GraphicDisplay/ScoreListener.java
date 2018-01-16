package GraphicDisplay;

import GraphicDisplay.Listener;
import Resources.Game;
import javafx.scene.control.Label;

/**
 * Created by Omer Dekel on 15/01/2018.
 */
public class ScoreListener implements Listener {
    private Label scorePlayer1;
    private Label scorePlayer2;
    public ScoreListener(Label player1, Label player2) {
        this.scorePlayer1 = player1;
        this.scorePlayer2 = player2;
    }

    @Override
    public void Event(Game game) {

        this.scorePlayer1.setText(String.valueOf(game.GetPlayer1Score()));
        this.scorePlayer2.setText(String.valueOf(game.GetPlayer2Score()));

    }
}
