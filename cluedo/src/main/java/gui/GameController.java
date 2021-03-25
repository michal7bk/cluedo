package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Player;
import model.Round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class GameController {

    @FXML
    public Button buttonLeftDown;
    @FXML
    public Button buttonCenterDown;
    @FXML
    public Button buttonRightDown;
    @FXML
    public Button buttonLeftUp;
    @FXML
    public Button buttonRightUp;
    @FXML
    public Button buttonCenterUp;
    @FXML
    public TextArea textAreaLogs;

    List<Button> buttons;

    List<Player> players;

    List<Round> rounds;

    protected void initData(List<Player> players) {
        this.players = players;
        this.rounds = new ArrayList<>();
        int numberOfPlayers = players.size();
        if (numberOfPlayers == 5) {
            buttonLeftDown.setVisible(false);
        }
        if (numberOfPlayers == 4) {
            buttonLeftDown.setVisible(false);
            buttonLeftUp.setVisible(false);
        }
        if (numberOfPlayers == 3) {
            buttonLeftDown.setVisible(false);
            buttonLeftUp.setVisible(false);
            buttonRightUp.setVisible(false);
        }
        buttons = Arrays.asList(buttonLeftUp, buttonCenterUp, buttonRightUp, buttonRightDown, buttonCenterDown, buttonLeftDown);
        final List<Button> visibleButtons = buttons.stream().filter(Node::isVisible).collect(toList());
        Iterator<Button> visibleButtonIterator = visibleButtons.iterator();
        for (Player next : players) {
            visibleButtonIterator.next().setText(next.getName());
        }
    }

    public void onPlayerClick(ActionEvent actionEvent) throws Exception {
        final Player player = getActionSourcePlayer(actionEvent);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cardPicker.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        CardPicker cardPicker = loader.getController();
        cardPicker.initData(player);
        cardPicker.setParentController(this);
        stage.setScene(scene);
        stage.show();
    }

    private Player getActionSourcePlayer(ActionEvent actionEvent) {
        final String playerName = ((Button) actionEvent.getSource()).getText();
        return players.stream().filter(x -> x.getName().equals(playerName)).findFirst().get();
    }

    protected void updateRound(Player player, Round round) {
        rounds = concat(rounds.stream(), List.of(round).stream()).sorted().collect(toList());
        log(String.format("%s - %s", player.toString(), round.toString()));
    }

    private void log(String text) {
        textAreaLogs.appendText(text);
        textAreaLogs.appendText("\n");
    }
}
