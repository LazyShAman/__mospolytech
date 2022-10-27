package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox bank_details;

    @FXML
    private VBox legal_entity_name;

    @FXML
    private VBox id;

    @FXML
    private Button goodsButton;

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
        assert bank_details != null : "fx:id=\"bank_details\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert legal_entity_name != null : "fx:id=\"legal_entity_name\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert goodsButton != null : "fx:id=\"goodsButton\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert racksButton != null : "fx:id=\"racksButton\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert premisessButton != null : "fx:id=\"premisessButton\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'ClientsPage.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'ClientsPage.fxml'.";

    }
}
