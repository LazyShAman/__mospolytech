package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RacksController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox length;

    @FXML
    private VBox id;

    @FXML
    private VBox max_total_load;

    @FXML
    private VBox id_client;

    @FXML
    private VBox id_premises;

    @FXML
    private VBox number_of_storages;

    @FXML
    private VBox width;

    @FXML
    private VBox height;

    @FXML
    private Button clientsButton;

    @FXML
    private Button goodsButton;

    @FXML
    private Button premisessButton;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    void initialize() {
        assert length != null : "fx:id=\"length\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert max_total_load != null : "fx:id=\"max_total_load\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert id_client != null : "fx:id=\"id_client\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert id_premises != null : "fx:id=\"id_premises\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert number_of_storages != null : "fx:id=\"number_of_storages\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert width != null : "fx:id=\"width\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert height != null : "fx:id=\"height\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert clientsButton != null : "fx:id=\"clientsButton\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert goodsButton != null : "fx:id=\"goodsButton\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert premisessButton != null : "fx:id=\"premisessButton\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'RacksPage.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'RacksPage.fxml'.";

    }
}
