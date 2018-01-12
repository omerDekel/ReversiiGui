package Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Game {
    private List<IPlayer> m_players = new ArrayList<>();
    private Board m_board;
	private IDisplayer m_displayer;
	private IRules m_rules;
    Game(IPlayer player_1, IPlayer player_2, Board board,  IDisplayer displayer,  IRules rules) {
        this.m_board = board;
        this.m_displayer = displayer;
        this.m_rules = rules;
        m_players.add(player_1);
        m_players.add(player_2);
    }

    public void run() {
         int current_player_index = 0;
        boolean last_player_skipped = false;
        for (;; current_player_index = (current_player_index + 1) % m_players.size())
        {
            IPlayer current_player = m_players.get(current_player_index);

		List<Point> available_moves = m_rules.get_legal_moves(m_board, current_player.get_player_type());
            if (available_moves.isEmpty())
            {
                if (last_player_skipped)
                {
                    break;
                }

                last_player_skipped = true;
                continue;
            }

            m_displayer.display(m_board);

            Point point;

            do
            {
                point = current_player.get_move(m_rules, m_board);
            } while (available_moves.contains(point));

            m_rules.make_move(m_board, point, current_player.get_player_type());
        }

        m_displayer.display_game_over(m_rules.get_winner(m_board));
        m_displayer.display(m_board);
    }

}
