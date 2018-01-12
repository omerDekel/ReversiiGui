package Resources;

import java.util.ArrayList;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public interface IRules {

    /**
     * getting legal moves.
     * @param board the board.
     * @param player_type
     */
  public ArrayList<Point> get_legal_moves(Board board, PlayerTypes player_type);
    /**
     * making move.
     * @param board the board.
     * @param point the point.
     * @param player the player type.
     */
     public void make_move(Board board, Point point,  PlayerTypes player);
    /**
     * get winner.
     * @param board the board
     */
      public PlayerTypes get_winner(Board board);
}
