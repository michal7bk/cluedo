package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import lombok.Getter;
import model.Player;
import model.Round;
import model.cards.Character;
import model.cards.Place;
import model.cards.Weapon;

import static data.CollectionSource.*;
import static java.util.List.copyOf;
import static javafx.collections.FXCollections.observableList;

public class CardPicker {

    @FXML
    public ComboBox<Weapon> comboBoxWeapon;
    @FXML
    public ComboBox<Character> comboBoxCharacter;
    @FXML
    public ComboBox<Place> comboBoxPlace;
    @FXML
    public Button buttonAccept;

    private Player player;

    private GameController parentController;

    @Getter
    protected Round round;

    protected void setParentController(GameController parentController) {
        this.parentController = parentController;
    }

    protected void initData(Player player) {
        this.player = player;
        comboBoxCharacter.setItems(observableList(copyOf(getCharacters())));
        comboBoxCharacter.getSelectionModel().select(0);
        comboBoxPlace.setItems(observableList(copyOf(getPlaces())));
        comboBoxPlace.getSelectionModel().select(0);
        comboBoxWeapon.setItems(observableList(copyOf(getWeapons())));
        comboBoxWeapon.getSelectionModel().select(0);
    }

    @FXML
    public void buttonAcceptOnAction(ActionEvent actionEvent) {
        round = new Round(comboBoxWeapon.getValue(), comboBoxCharacter.getValue(), comboBoxPlace.getValue());
        parentController.updateRound(player, round);
        Stage stage = (Stage) buttonAccept.getScene().getWindow();
        stage.close();
    }
}