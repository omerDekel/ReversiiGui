package GraphicDisplay;

import Resources.Game;
import javafx.scene.control.Label;

/**
 * ScoreListener.
 * listener that responsible on the labels of the players .
 */
public class ScoreListener implements Listener {
    //members .
    private Label scorePlayer1;
    private Label scorePlayer2;

    /**
     * constructor .
     * @param player1 label of player 1 .
     * @param player2 label of player 2.
     */
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
