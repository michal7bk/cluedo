package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ConfigurationController implements Initializable {

    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 3;

    @FXML
    public Button buttonStart;
    @FXML
    public ComboBox<Integer> comboBoxNumberPlayers;
    @FXML
    public Label firstPlayerLabel;
    @FXML
    public Label secondPlayerLabel;
    @FXML
    public Label thirdPlayerLabel;
    @FXML
    public TextField firstPlayerText;
    @FXML
    public TextField secondPlayerText;
    @FXML
    public TextField thirdPlayerText;
    @FXML
    public Label fourthPlayerLabel;
    @FXML
    public Label fifthPlayerLabel;
    @FXML
    public Label sixthPlayerLabel;
    @FXML
    public TextField fourthPlayerText;
    @FXML
    public TextField fifthPlayerText;
    @FXML
    public TextField sixthPlayerText;

    Map<Integer, TextField> textToPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxNumberPlayers.getItems().addAll(6, 5, 4, 3);
        comboBoxNumberPlayers.getSelectionModel().select(0);
        textToPlayer = new HashMap<>();
        textToPlayer.put(1, firstPlayerText);
        textToPlayer.put(2, secondPlayerText);
        textToPlayer.put(3, thirdPlayerText);
        textToPlayer.put(4, fourthPlayerText);
        textToPlayer.put(5, fifthPlayerText);
        textToPlayer.put(6, sixthPlayerText);
        //TODO remove
        firstPlayerText.setText("First player");
        secondPlayerText.setText("Second player");
        thirdPlayerText.setText("Third player");
        fourthPlayerText.setText("Forth player");
        fifthPlayerText.setText("Fifth player");
        sixthPlayerText.setText("Sixth player");
    }

    public void buttonStartOnAction(ActionEvent event) throws IOException {
        List<Player> players;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        final GameController gameController = fxmlLoader.getController();
        final Integer playersNumber = comboBoxNumberPlayers.getValue();
        if (playersNumber != null) {
            players = new ArrayList<>();
            for (int i = 1; i <= playersNumber; i++) {
                Player player = new Player(i, textToPlayer.get(i).getText(),0);
                players.add(player);
            }
            gameController.initData(players);
            openNewWindow(event, scene);
        } else {
            showAlert();
        }
    }

    private void openNewWindow(ActionEvent event, Scene scene) {
        Stage stage = new Stage();
        stage.setTitle("Game configuration");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Incorrect players number");
        alert.setContentText(String.format("Number of players available : [%s:%s]", MIN_PLAYERS, MAX_PLAYERS));
        alert.showAndWait();
    }

    @FXML
    public void comboBoxOnEntered(ActionEvent dragEvent) {
        final Integer selected = comboBoxNumberPlayers.getValue();
        if (selected == 3) {
            setFourthVisible(false);
            setFifthVisible(false);
            setSixthVisible(false);
        } else if (selected == 4) {
            setFourthVisible(true);
            setFifthVisible(false);
            setSixthVisible(false);
        } else if (selected == 5) {
            setFourthVisible(true);
            setFifthVisible(true);
            setSixthVisible(false);
        } else if (selected == 6) {
            setFourthVisible(true);
            setFifthVisible(true);
            setSixthVisible(true);
        }
    }

    private void setFourthVisible(boolean visible) {
        fourthPlayerLabel.setVisible(visible);
        fourthPlayerText.setVisible(visible);
    }

    private void setFifthVisible(boolean visible) {
        fifthPlayerLabel.setVisible(visible);
        fifthPlayerText.setVisible(visible);
    }

    private void setSixthVisible(boolean visible) {
        sixthPlayerLabel.setVisible(visible);
        sixthPlayerText.setVisible(visible);
    }
}

