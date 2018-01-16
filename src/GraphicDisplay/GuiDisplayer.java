package GraphicDisplay;

import Resources.Board;
import Resources.IDisplayer;
import Resources.PlayerTypes;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Omer Dekel on 15/01/2018.
 */
public class GuiDisplayer implements IDisplayer {

    @Override
    public void display(Board board) {

    }

    @Override
    public void display_game_over(PlayerTypes player) {
        String winner_string;
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        GridPane root = new GridPane();
        Label label = new Label();
        switch (player)
        {
            case PLAYER_TYPE_X:
                winner_string = "Player 2 WON!";
                label.setText(winner_string);
                root.getChildren().addAll(label);
                break;

            case PLAYER_TYPE_O:
                winner_string = "Player 1 WON!";
                label.setText(winner_string);
                root.getChildren().addAll(label);
                break;
            default:
                label.setText("It's a tie!");
                 root.getChildren().addAll(label);
            break;
        }
        Scene scene = new Scene(root, 200, 100);
        root.setPrefSize(scene.getWidth(), scene.getHeight());
        stage.setScene(scene);
        stage.showAndWait();
    }

}
