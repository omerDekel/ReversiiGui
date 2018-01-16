package GraphicDisplay;

import GraphicDisplay.Listener;

/**
 * Created by Omer Dekel on 15/01/2018.
 */
public interface Notifier {
    // Add l as a listener to hit events.
    void addListener(Listener l);
    // Remove l from the list of listeners to hit events.
    void removeListener(Listener l);

}
