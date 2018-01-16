package GraphicDisplay;

import Resources.Game;
import javafx.scene.control.Label;

/**
 * CurrentPlayerListener.
 * listener that responsible on the current player label .
 */
public class CurrentPlayerListener implements Listener {
    //member .
    private Label currentPlayer;

    /**
     * constructor.
     * @param label of the current player .
     */
    public CurrentPlayerListener(Label label) {
        this.currentPlayer = label;
    }
    @Override
    public void Event(Game game) {
        this.currentPlayer.setText(game.CurrentPlayer().getM_name());
    }
}
