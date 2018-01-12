package Resources;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public interface IDisplayer {
    /**
     * display the board.
     * @pharm
     */
    public void display( Board board);
    /**
     * display game over.
     * @param player the player type.
     */
    public void display_game_over( PlayerTypes player);

}
