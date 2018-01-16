package Resources;

import static Resources.PlayerTypes.PLAYER_TYPE_O;
import static Resources.PlayerTypes.PLAYER_TYPE_X;

/**
 * Created by Omer Dekel on 09/01/2018.
 */
public class Board {
    private PlayerTypes[][] CellMatrix;

    /**
     * the constractor.
     *
     * @param size the size.
     */
    public Board(int size) {
        CellMatrix = new PlayerTypes[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                CellMatrix[i][j] = PlayerTypes.PLAYER_TYPE_NONE;
            }
        }

        Point center = new Point(size / 2 - 1, size / 2 - 1);
        CellMatrix[center.getX()][center.getY()] = PLAYER_TYPE_O;
        CellMatrix[center.getX() + 1][center.getY() + 1] = PLAYER_TYPE_O;
        CellMatrix[center.getX() + 1][center.getY()] = PLAYER_TYPE_X;
        CellMatrix[center.getX()][center.getY() + 1] = PLAYER_TYPE_X;


    }

    /**
     * get_cells
     *
     * @return the cells.
     */
    PlayerTypes[][] get_cells() {
        return CellMatrix;
    }

    public void set_cell(Point point, PlayerTypes player) {
        if (!is_in_board(point)) {
            return;
        }
        CellMatrix[point.getX()][point.getY()] = player;
    }

    /**
     * get num rows.
     *
     * @return return the number of the rows.
     */
    public int get_num_rows() {
        return CellMatrix.length;
    }

    /**
     * get num columns.
     *
     * @return return the columns.
     */
    public int get_num_columns() {
        return CellMatrix.length;
    }

    /**
     * check if the point is in the board.
     *
     * @param point the point.
     * @return return the answer.
     */

    public boolean is_in_board(Point point) {

        return (0 <= point.getX()) && (get_num_rows() > point.getX()) && (0 <= point.getY()) && (get_num_columns() > point.getY());
    }

    /**
     * getCell .
     * @param point on the board .
     * @return the value of the cell in that point .
     */
    public PlayerTypes getCell(Point point) {
        return CellMatrix[point.getX()][point.getY()];
    }

}

