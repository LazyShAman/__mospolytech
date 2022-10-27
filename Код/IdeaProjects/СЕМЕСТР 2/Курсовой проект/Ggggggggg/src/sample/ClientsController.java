package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private final TableColumn<Client, Integer> id = new TableColumn<>("ID");

    @FXML
    private final TableColumn<Client, String> legal_entity_name = new TableColumn<>("Legal entity name");

    @FXML
    private final TableColumn<Client, String> bank_details = new TableColumn<>("Bank details");

    @FXML
    public static TableView<Client> Clients = new TableView<>();

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
    private Button add;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();

    }

    void loadInfo() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Clients.getItems().size(); i++)
            Clients.getItems().clear();


        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        legal_entity_name.setCellValueFactory(new PropertyValueFactory<>("legal_entity_name"));
        bank_details.setCellValueFactory(new PropertyValueFactory<>("bank_details"));

        legal_entity_name.setSortType(TableColumn.SortType.DESCENDING);
        legal_entity_name.setSortable(false);

        ObservableList<Client> clients = connection.getClients();
        Clients.setItems(clients);

        //Clients.getColumns().addAll(id, legal_entity_name, bank_details);
        //bank_details.setUserData(clients.get(0).getBankDetails());
    }
}
