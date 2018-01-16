package GraphicDisplay;


/**
 * Notifier.
 * notify the listeners that move has been made on the game .
 */
public interface Notifier {
    // Add l as a listener to move on the game events.
    void addListener(Listener l);
}
