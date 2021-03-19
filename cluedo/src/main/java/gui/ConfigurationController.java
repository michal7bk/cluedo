package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfigurationController {

    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 2;

    @FXML
    public TextArea textPlayersNumber;
    @FXML
    public Button buttonStart;

    public void buttonStartOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getClassLoader().getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        final PlayerController playerController = fxmlLoader.getController();
        final Integer playersNumber = getValidPlayerNumber();
        if (playersNumber != null) {
            playerController.initData(playersNumber);
            openNewWindow(event, scene);
        }
    }

    private void openNewWindow(ActionEvent event, Scene scene) {
        Stage stage = new Stage();
        stage.setTitle("Game configuration");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private Integer getValidPlayerNumber() {
        final String text = textPlayersNumber.getText();
        try {
            final int input = Integer.parseInt(text);
            if (input > MAX_PLAYERS || input < MIN_PLAYERS) {
                textPlayersNumber.clear();
                showAlert();
            } else {
                return input;
            }
        } catch (NumberFormatException e) {
            textPlayersNumber.clear();
            showAlert();
        }
        return null;
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Incorrect players number");
        alert.setContentText(String.format("Number of players available : [%s:%s]", MIN_PLAYERS, MAX_PLAYERS));
        alert.showAndWait();
    }
}

