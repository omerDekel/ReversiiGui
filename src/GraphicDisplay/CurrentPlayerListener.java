package GraphicDisplay;

import Resources.Game;
import javafx.scene.control.Label;

/**
 * Created by Omer Dekel on 15/01/2018.
 */
public class CurrentPlayerListener implements Listener {
    private Label currentPlayer;
    public CurrentPlayerListener(Label label) {
        this.currentPlayer = label;
    }
    @Override
    public void Event(Game game) {
        this.currentPlayer.setText(game.CurrentPlayer().getM_name());
    }
}
