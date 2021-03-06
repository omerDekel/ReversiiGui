package Resources;

import GraphicDisplay.GuiPlayer;
import GraphicDisplay.Listener;
import GraphicDisplay.Notifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Game implements Notifier {
    private  List<Listener> listeners = new ArrayList<>();
    private List<GuiPlayer> m_players = new ArrayList<>();
    private Board m_board;
	private IDisplayer m_displayer;
	private IRules m_rules;
	private int current_player_index;
	private boolean last_player_skipped ;

    /**
     * consructor
     * @param board the board
     * @param players the players
     * @param displayer the displayer
     * @param rules the rules
     */
    public Game(Board board, ArrayList<GuiPlayer> players, IDisplayer displayer, IRules rules) {
        this.m_board = board;
        this.m_displayer = displayer;
        this.m_rules = rules;
        this.m_players = players;
        current_player_index = 0;
        last_player_skipped = false;
    }

    /**
     * getting the current index
     * @return current_player_index
     */
    public int getCurrent_player_index() {
        return current_player_index;
    }


    /**
     * run ths game by the point it got .
     * @param point the point
     */
    public void run(Point point) {
        IPlayer current_player = m_players.get(current_player_index);
		ArrayList<Point> available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
		if (available_moves.isEmpty()) {
		    if (last_player_skipped) {
                Notify();
                m_displayer.display_game_over(m_rules.get_winner(m_board));
                return;
            }
            last_player_skipped = true;
            current_player_index = (current_player_index + 1) % m_players.size();
            current_player = m_players.get(current_player_index);
            //CHECK YHE NEXT PLAYER IF THERE'S NO MOVE GAME OVER
            available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
            if (available_moves.isEmpty()) {
                Notify();
                m_displayer.display_game_over(m_rules.get_winner(m_board));
                return;
            }
            Notify();
            return;
        }
        if (IsThere(point, available_moves)) {
            m_rules.make_move(m_board, point, current_player.get_player_type());
            current_player_index = (current_player_index + 1) % m_players.size();
            //CHECK THE NEXT PLAYER, IF THERE'S NO MOVES CONTINUE TO THE NEXT PLAYER .
            current_player = m_players.get(current_player_index);
            available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
            if (available_moves.isEmpty()) {
                last_player_skipped = true;
                current_player_index = (current_player_index + 1) % m_players.size();
                current_player = m_players.get(current_player_index);
                available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
                if (available_moves.isEmpty()) {
                    Notify();
                    m_displayer.display_game_over(m_rules.get_winner(m_board));
                    return;
                }
            }

        }
        Notify();

    }

    /**
     * there is a point
     * @param point the point
     * @param points the points
     * @return true or false
     */
    private boolean IsThere (Point point,ArrayList<Point> points) {
        for(int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(point)) {
                return true;
            }
        }
        return false;
    }

    /**
     * getting player1 score
     * @return the score
     */
    public int GetPlayer1Score () {
    Map<PlayerTypes,  Integer> playersScores = m_rules.playerScores(m_board);
        return playersScores.get(m_players.get(0).get_player_type());
}

    /**
     * getting player2 score
     * @return the score
     */
    public int GetPlayer2Score () {
        Map<PlayerTypes,  Integer> playersScores = m_rules.playerScores(m_board);
        return playersScores.get(m_players.get(1).get_player_type());
    }

    @Override
    public void addListener(Listener l) {
        listeners.add(l);
    }

    /**
     * notify
     */
    private void Notify() {
                List<Listener> listeners = new ArrayList<Listener>(this.listeners);
        // Notify all listeners about a hit event:
        for (Listener l : listeners) {
            l.Event(this);
        }

    }

    /**
     * current player.
     * @return the current player.
     */
    public GuiPlayer CurrentPlayer() {
        return m_players.get(current_player_index);
    }

    /**
     * getting list of players
     * @return the list
     */
    public List<GuiPlayer> getM_players() {
        return m_players;
    }
}
