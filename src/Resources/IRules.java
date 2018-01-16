package Resources;

import java.util.ArrayList;
import java.util.Map;

/**
 * IRules.
 */
public interface IRules {

    /**
     * getting legal moves.
     * @param board the board.
     * @param player_type
     */
   ArrayList<Point> get_legal_moves(Board board, PlayerTypes player_type);
    /**
     * making move.
     * @param board the board.
     * @param point the point.
     * @param player the player type.
     */
      void make_move(Board board, Point point,  PlayerTypes player);
    /**
     * get winner.
     * @param board the board
     */
       PlayerTypes get_winner(Board board);

    /**
     * the player scores
     * @param board the board
     * @return the player
     */
       Map<PlayerTypes,  Integer> playerScores(Board board);
}
