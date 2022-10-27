package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PremisessController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox name;

    @FXML
    private VBox id;

    @FXML
    private VBox useful_volume;

    @FXML
    private VBox temperature;

    @FXML
    private VBox humidity;

    @FXML
    private Button clientsButton;

    @FXML
    private Button goodsButton;

    @FXML
    private Button racksButton;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert useful_volume != null : "fx:id=\"useful_volume\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert temperature != null : "fx:id=\"temperature\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert humidity != null : "fx:id=\"humidity\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert clientsButton != null : "fx:id=\"clientsButton\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert goodsButton != null : "fx:id=\"goodsButton\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert racksButton != null : "fx:id=\"racksButton\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'PremisessPage.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'PremisessPage.fxml'.";

    }
}
