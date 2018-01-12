package Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Board {
    private ArrayList<ArrayList<PlayerTypes>> CellMatrix =  new ArrayList<ArrayList<PlayerTypes>>();;

    public Board(int size) {
        for (int i = 0; i < size; i++) {
            ArrayList<PlayerTypes> row = new ArrayList<>();//CellMatrix.get(i);
            for (int j = 0; j < size; j++) {
                row.add(j, PlayerTypes.PLAYER_TYPE_NONE);
            }
            CellMatrix.add(i, row);
        }

        Point center = new Point(size / 2 - 1, size / 2 - 1);

        CellMatrix.get(center.getX()).set(center.getY(), PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(center.getX() + 1).set(center.getY() + 1, PlayerTypes.PLAYER_TYPE_O);
        CellMatrix.get(center.getX() + 1).set(center.getY(), PlayerTypes.PLAYER_TYPE_X);
        CellMatrix.get(center.getX()).set(center.getY() + 1, PlayerTypes.PLAYER_TYPE_X);

    }

    /**
     * get the cell.
     *
     * @return the cells.
     */
    ArrayList<ArrayList<PlayerTypes>> get_cells() {
        return CellMatrix;
    }
    public void set_cell( Point point,  PlayerTypes player)
    {
        if (!is_in_board(point))
        {
            return;
        }

        CellMatrix.get(point.getX()).set(point.getY(), player);
    }

    public int get_num_rows()
    {
        return CellMatrix.size();
    }

    public int get_num_columns()
    {
        return  CellMatrix.get(0).size();
    }

    public boolean is_in_board( Point point)
    {

        return (0 <= point.getX()) && (get_num_rows() > point.getX()) && (0 <= point.getY()) && (get_num_columns() > point.getY());
    }

}

