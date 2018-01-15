package Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Game implements Notifier{
    private  List<Listener> listeners = new ArrayList<>();
    private List<GuiPlayer> m_players = new ArrayList<>();
    private Board m_board;
	private IDisplayer m_displayer;
	private IRules m_rules;
	private int current_player_index;
	private boolean last_player_skipped ;

    /**
     * getting the current index
     * @return current_player_index
     */
    public int getCurrent_player_index() {
        return current_player_index;
    }

    /**
     * consructor
     * @param board the board
     * @param players the players
     * @param displayer the displayer
     * @param rules the rules
     */
    Game(Board board, ArrayList<GuiPlayer> players, IDisplayer displayer, IRules rules) {
        this.m_board = board;
        this.m_displayer = displayer;
        this.m_rules = rules;
        this.m_players = players;
        /*m_players.add(player_1);
        m_players.add(player_2);*/
        current_player_index = 0;
        last_player_skipped = false;

    }

    /**
     * run ths game
     * @param point the point
     */
    public void run(Point point/*, Board board*/) {
        System.out.println("run: x is "+point.getX());
        System.out.println("run: y is"+point.getY());
        //boolean last_player_skipped = false;
        /*for (;; current_player_index = (current_player_index + 1) % m_players.size())
        {*/
        IPlayer current_player = m_players.get(current_player_index);

		ArrayList<Point> available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
		for (int i = 0 ; i < available_moves.size(); i++) {
            System.out.println("available move: "+available_moves.get(i).getX()+" "+ available_moves.get(i).getY());
        }
            if (!available_moves.isEmpty()) {
                if (IsThere(point, available_moves)) {
                    System.out.println("is there");
                    /*if (this.last_player_skipped) {
                        //break;
                        //m_displayer.display_game_over(m_rules.get_winner(board));
                        //m_displayer.display(board);
                        return;

                    } else {
                        this.last_player_skipped = true;
                    }*/
                    //continue;
                    m_rules.make_move(m_board, point, current_player.get_player_type());
                    current_player_index = (current_player_index + 1) % m_players.size();
                    Notify();
                }
            } else {
                if (last_player_skipped) {
                    return;
                }
                this.last_player_skipped = true;
            }
        //m_displayer.display(m_board)
                //Point point;
            /*do
            {
            } while (available_moves.contains(point));*/
                //point = current_player.get_move(m_rules, m_board);
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

    @Override
    public void removeListener(Listener l) {

    }
    private void Notify() {
                List<Listener> listeners = new ArrayList<Listener>(this.listeners);
        // Notify all listeners about a hit event:
        for (Listener l : listeners) {
            l.Event(this);
        }

    }
    public GuiPlayer CurrentPlayer() {
        return m_players.get(current_player_index);
    }

    public List<GuiPlayer> getM_players() {
        return m_players;
    }
}
