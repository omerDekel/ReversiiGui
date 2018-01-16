package Resources;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * BasicRules.
 */
public class BasicRules implements IRules {
    @Override
    public ArrayList<Point> get_legal_moves(Board board, PlayerTypes player) {
        int num_rows = board.get_num_rows();
        int num_columns = board.get_num_columns();
        ArrayList<Point> legal_moves = new ArrayList<>();

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_columns; j++) {
                if (PlayerTypes.PLAYER_TYPE_NONE != board.getCell(new Point(i, j))) {
                    continue;
                }
                Point point = new Point(i, j);
                if (!get_flipping_cells(board, point, player).isEmpty()) {
                    legal_moves.add(point);
                }
            }
        }

        return legal_moves;

    }

    @Override
    public void make_move(Board board, Point point, PlayerTypes player) {
        ArrayList<Point> flipping_cells = get_flipping_cells(board, point, player);

        board.set_cell(point, player);
        for (int i = 0; i < flipping_cells.size(); i++) {
            board.set_cell(flipping_cells.get(i), player);
        }

    }

    @Override
    public PlayerTypes get_winner(Board board) {

        Map<PlayerTypes, Integer> total_cells = playerScores(board);
        if (total_cells.get(PlayerTypes.PLAYER_TYPE_X) == total_cells.get(PlayerTypes.PLAYER_TYPE_O)) {
            return PlayerTypes.PLAYER_TYPE_NONE;
        }

        if (total_cells.get(PlayerTypes.PLAYER_TYPE_X) > total_cells.get(PlayerTypes.PLAYER_TYPE_O)) {
            return PlayerTypes.PLAYER_TYPE_X;
        }
        return PlayerTypes.PLAYER_TYPE_O;
    }

    /**
     * getting flippinf cells
     *
     * @param board  the board
     * @param point  the point
     * @param player the player
     * @return the point
     */
    private ArrayList<Point> get_flipping_cells(Board board, Point point, PlayerTypes player) {
        ArrayList<Point> flipping_points = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((0 == i) && (0 == j)) {
                    continue;
                }

                ArrayList<Point> points_to_add = get_flipping_cells(board, point, player, new Point(i, j));
                flipping_points.addAll(points_to_add);
            }
        }

        return flipping_points;
    }

    /**
     * getting flipping
     *
     * @param board     the board
     * @param point     the point
     * @param player    the player
     * @param direction the direction
     * @return the point
     */

    private ArrayList<Point> get_flipping_cells(Board board, Point point, PlayerTypes player, Point direction) {
        ArrayList<Point> points = new ArrayList<>();
        Point current_point = new Point(point.getX() + direction.getX(), point.getY() + direction.getY());
        boolean found_keen = false;

        for (; board.is_in_board(current_point); current_point = new Point(current_point.getX() + direction.getX(),
                current_point.getY() + direction.getY())) {
            PlayerTypes cell = board.getCell(current_point);

            if (PlayerTypes.PLAYER_TYPE_NONE == cell) {
                return new ArrayList<>();
            }

            if (player == cell) {
                found_keen = true;
                break;
            }

            points.add(current_point);
        }

        if (!found_keen) {
            return new ArrayList<Point>();
        }

        return points;
    }

    /**
     * map of player scores
     *
     * @param board the board
     * @return the total cells
     */
    public Map<PlayerTypes, Integer> playerScores(Board board) {
        Map<PlayerTypes, Integer> total_cells = new TreeMap<>();
        total_cells.put(PlayerTypes.PLAYER_TYPE_X, 0);
        total_cells.put(PlayerTypes.PLAYER_TYPE_O, 0);
        total_cells.put(PlayerTypes.PLAYER_TYPE_NONE, 0);
        int num_rows = board.get_num_rows();
        int num_columns = board.get_num_columns();
        PlayerTypes[][] cells = board.get_cells();
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_columns; j++) {
                total_cells.put(cells[i][j], total_cells.get(cells[i][j]) + 1);
            }
        }

        return total_cells;
    }

}
