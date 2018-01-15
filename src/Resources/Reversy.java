package Resources;

/**
 * Created by Omer Dekel on 08/01/2018.
 */
public class Reversy {

    public static void main(String[] args)
    {
        Board board = new Board(4);
        ConsolePlayer player_1= new ConsolePlayer(PlayerTypes.PLAYER_TYPE_O, "Player O");
        ConsolePlayer player_2= new ConsolePlayer(PlayerTypes.PLAYER_TYPE_X, "Player X");
        ConsoleDisplayer displayer = new ConsoleDisplayer();
        BasicRules rules = new BasicRules();

        //Game game= new Game(player_1, player_2, board, displayer, rules);

        //game.run();

    }

}
