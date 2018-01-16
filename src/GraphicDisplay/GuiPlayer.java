package GraphicDisplay;
import Resources.*;
import javafx.scene.paint.Color;

/**
 * GuiPlayer .
 */
public class GuiPlayer implements IPlayer {
    // members .
    private String m_name;
    private Color color;
    private PlayerTypes m_player_type;

    /**
     * constructor
     * @param player_type the player type
     * @param name the name
     * @param color1 the color1
     */

    GuiPlayer( PlayerTypes player_type,  String name, Color color1) {
        m_player_type = player_type;
        m_name = name;
        color = color1;
    }

    /**
     * getM_name .
     * @return the name of the player .
     */
    public String getM_name() {
        return m_name;
    }

    /**
     * getColor .
     * @return the color of the player .
     */
    public Color getColor() {
        return color;
    }

    @Override
    public PlayerTypes get_player_type() {
        return m_player_type;
    }
}
