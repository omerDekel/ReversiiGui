package Resources;

/**
 * Created by Omer Dekel on 15/01/2018.
 */
public interface Notifier {
    // Add hl as a listener to hit events.
    void addListener(Listener l);
    // Remove hl from the list of listeners to hit events.
    void removeListener(Listener l);

}
