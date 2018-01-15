package Resources;

import java.util.ArrayList;
import java.util.List;

import static Resources.PlayerTypes.PLAYER_TYPE_O;
import static Resources.PlayerTypes.PLAYER_TYPE_X;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Board {
    //private ArrayList<ArrayList<PlayerTypes>> CellMatrix =  new ArrayList();
private PlayerTypes [][] CellMatrix;
    public Board(int size) {
        CellMatrix = new PlayerTypes[size][size];
        for (int i = 0; i < size; i++) {
            //ArrayList<PlayerTypes> row = new ArrayList<>();//CellMatrix.get(i);
            for (int j = 0; j < size; j++) {
                //row.add(j, PlayerTypes.PLAYER_TYPE_NONE);
                CellMatrix[i][j] = PlayerTypes.PLAYER_TYPE_NONE;
            }
            //CellMatrix.add(i, row);
        }

        Point center = new Point(size / 2 - 1, size / 2 - 1);

        /*CellMatrix.get(center.getY()).set(center.getX(), PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(center.getY() + 1).set(center.getX() + 1, PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(center.getY() + 1).set(center.getX(), PlayerTypes.PLAYER_TYPE_X);
        CellMatrix.get(center.getY()).set(center.getX() + 1, PlayerTypes.PLAYER_TYPE_X);
        /*CellMatrix.get(1).set(0, PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(2).set(0,PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(3).set(0, PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(2).set(1,PlayerTypes.PLAYER_TYPE_O);*/
        CellMatrix[center.getX()][center.getY()] = PLAYER_TYPE_O;
        CellMatrix[center.getX() + 1][center.getY() + 1] = PLAYER_TYPE_O;
        CellMatrix[center.getX() + 1][center.getY()] = PLAYER_TYPE_X;
        CellMatrix[center.getX()][center.getY() + 1] = PLAYER_TYPE_X;


    }

    /**
     * get the cell.
     *
     * @return the cells.
     */
    PlayerTypes[][] get_cells() {
        return CellMatrix;
    }
    public void set_cell( Point point,  PlayerTypes player)
    {
        if (!is_in_board(point))
        {
            return;
        }
        CellMatrix[point.getX()][point.getY()] = player;
    }

    public int get_num_rows()
    {
        return CellMatrix.length;
    }

    public int get_num_columns()
    {
        return  CellMatrix.length;
    }

    public boolean is_in_board( Point point)
    {

        return (0 <= point.getX()) && (get_num_rows() > point.getX()) && (0 <= point.getY()) && (get_num_columns() > point.getY());
    }
    public PlayerTypes getCell(Point point) {
        return CellMatrix[point.getX()][point.getY()];
    }

}

