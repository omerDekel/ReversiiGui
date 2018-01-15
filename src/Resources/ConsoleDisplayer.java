package Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class ConsoleDisplayer implements IDisplayer {
    @Override
    public void display(Board board) {
        /*ArrayList<ArrayList<PlayerTypes>> cells = board.get_cells();
	  int num_rows = board.get_num_rows();
	  int num_cols = board.get_num_columns();

        System.out.print(" |");
        for ( int i = 0; i < num_cols; i++)
        {
            System.out.print( " " + i + " |");
        }
        System.out.println();
       String line_separator = "--";
        for ( int i = 0; i < num_cols; i++)
        {
            line_separator += "----";
        }

        System.out.println(line_separator);


        Map<PlayerTypes,String> cells_strings = new TreeMap<>();
        cells_strings.put(PlayerTypes.PLAYER_TYPE_O, " O ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_X, " X ");
        cells_strings.put(PlayerTypes.PLAYER_TYPE_NONE, "   ");

        for ( int i = 0; i < num_rows; i++)
        {
            System.out.print( i + "|");
            List<PlayerTypes> row = cells.get(i);
            for ( int j = 0; j < num_cols; j++)
            {
                System.out.print(cells_strings.get(row.get(j))+"|");
            }
            System.out.println();
            System.out.println(line_separator);
        }*/

    }

    @Override
    public void display_game_over(PlayerTypes player) {
       /* System.out.println( "    Game Over!");

        String winner_string;
        switch (player)
        {
            case PLAYER_TYPE_X:
                winner_string = "Player X WON!";
                break;

            case PLAYER_TYPE_O:
                winner_string = "Player O WON!";
                break;

            default:
                winner_string = "It's a tie!";
                break;
        }
        System.out.println(winner_string );*/

    }
}
