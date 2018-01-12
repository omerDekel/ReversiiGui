package Resources;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public interface IPlayer {
    //private PlayerTypes m_player_type;
    /**
     * getting the player type.
     * @return the player type.
     */
    PlayerTypes get_player_type();  /*{ return m_player_type; }*/
    /**
     * getting the move
     * @param rules the rules.
     * @param board the board.
     */
     Point get_move( IRules rules,  Board board);
}
