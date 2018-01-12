package Resources;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class ConsolePlayer implements IPlayer{
    private String m_name;
    private PlayerTypes m_player_type;
    ConsolePlayer( PlayerTypes player_type,  String name) {
    m_player_type = player_type;
    m_name = name;
    }
    public Point get_move(IRules rules, Board board) {
	    List<Point> legal_points = rules.get_legal_moves(board, get_player_type());
        System.out.println(m_name+" your legal moves: \n");
        for ( int i = 0; i < legal_points.size(); i++)
        {
            System.out.println("[" + legal_points.get(i).getX()+ ", " + legal_points.get(i).getY() + "]");
        }
        System.out.println(m_name+", please insert x y: ");
        int x = 0;
        int y = 0;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        /*while (std::cin.fail()) {
        std:: cout << "ERROR,cannot enter a letter!"<<std::endl ;
        std:: cout << m_name << ", please insert x y: " ;
        std:: cin.clear();
        std::cin.ignore(256,'\n');
        std::cin >> x >> y;*/
    //}

        return new Point(x, y);
    }

    @Override
    public PlayerTypes get_player_type() {
        return this.m_player_type;
    }

}
