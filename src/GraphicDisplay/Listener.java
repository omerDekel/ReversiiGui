package GraphicDisplay;

import Resources.Game;

/**
 *Listener .
 * listener interface that listen that has been notified after move has been preformed un our game .
 */
public interface Listener {
    /**
     * the event after move has been preformed.
     * @param game the game .
     */
    void Event(Game game);
}
