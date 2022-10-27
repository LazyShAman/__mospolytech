package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GoodsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox id_client;

    @FXML
    private VBox id;

    @FXML
    private VBox weight;

    @FXML
    private VBox id_premises;

    @FXML
    private VBox humidity;

    @FXML
    private VBox exp_date_of_contract;

    @FXML
    private Label length;

    @FXML
    private VBox width;

    @FXML
    private VBox rack_space;

    @FXML
    private VBox receipt_date;

    @FXML
    private VBox contract_number;

    @FXML
    private VBox id_rack;

    @FXML
    private VBox temperature;

    @FXML
    private VBox height;

    @FXML
    private Button clientsButton;

    @FXML
    private Button racksButton;

    @FXML
    private Button premisessButton;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    void initialize() {
        assert id_client != null : "fx:id=\"id_client\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert id_premises != null : "fx:id=\"id_premises\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert humidity != null : "fx:id=\"humidity\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert exp_date_of_contract != null : "fx:id=\"exp_date_of_contract\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert length != null : "fx:id=\"length\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert width != null : "fx:id=\"width\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert rack_space != null : "fx:id=\"rack_space\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert receipt_date != null : "fx:id=\"receipt_date\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert contract_number != null : "fx:id=\"contract_number\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert id_rack != null : "fx:id=\"id_rack\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert temperature != null : "fx:id=\"temperature\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert height != null : "fx:id=\"height\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert clientsButton != null : "fx:id=\"clientsButton\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert racksButton != null : "fx:id=\"racksButton\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert premisessButton != null : "fx:id=\"premisessButton\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'GoodsPage.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'GoodsPage.fxml'.";

    }
}
