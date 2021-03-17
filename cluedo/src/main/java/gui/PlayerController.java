package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    @FXML
    public Button buttonLeftDown;
    @FXML
    public Button buttonCenterDown;
    @FXML
    public Button buttonLeftUp;
    @FXML
    public Button buttonRightUp;
    @FXML
    public Button buttonCenterUp;
    @FXML
    public Button buttonRightDown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Button> buttons = Arrays.asList(buttonLeftDown, buttonCenterDown, buttonLeftUp, buttonRightUp, buttonCenterUp, buttonRightDown);
    }
}
