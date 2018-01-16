package GraphicDisplay;
import Resources.*;
import javafx.scene.paint.Color;

/**
 * Created by Omer Dekel on 13/01/2018.
 */
public class GuiPlayer implements IPlayer {
    public String getM_name() {
        return m_name;
    }

    private String m_name;

    public Color getColor() {
        return color;
    }

    private Color color;
    private PlayerTypes m_player_type;

    /**
     * consructor
     * @param player_type the player type
     * @param name the name
     * @param color1 the color1
     */

    GuiPlayer( PlayerTypes player_type,  String name, Color color1) {
        m_player_type = player_type;
        m_name = name;
        color = color1;
    }

    @Override
    public PlayerTypes get_player_type() {
        return m_player_type;
    }

    @Override
    public Point get_move(IRules rules, Board board) {
        return null;
    }
    public void draw() {

    }
}
