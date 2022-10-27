package sample.Clients;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import sample.AreYouSureController;
import sample.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Client, Integer> id;

    @FXML
    private TableColumn<Client, String> legal_entity_name;

    @FXML
    private TableColumn<Client, String> bank_details;

    @FXML
    private TableView<Client> Clients;

    @FXML
    private Button goodsButton;

    @FXML
    private Button racksButton;

    @FXML
    private Button premisessButton;

    @FXML
    private Button find;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    ObservableList<Client> clients;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();
        Clients.setEditable(true);
        Clients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        goodsButton.setOnAction(event -> {
            goodsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Goods/GoodsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("DB Storage");
            stage.show();
        });

        racksButton.setOnAction(event -> {
            racksButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Racks/RacksPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("DB Storage");
            stage.show();
        });

        premisessButton.setOnAction(event -> {
            premisessButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Premisess/PremisessPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("DB Storage");
            stage.show();
        });

        find.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("ATTENTION!");
            alert.setHeaderText(null);
            alert.setContentText("Enter in one or more highlighted fields. We will find a tuple by the first existing one!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Clients/ClientsWindow.fxml"));

            try {
                loader.load();
            } catch (IOException io) {
                io.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Enter the data");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node) e.getSource()).getScene().getWindow());
            stage.showAndWait();

            Integer searchId = ClientsWindowController.value1;
            String searchLegalEntityName = ClientsWindowController.value2;
            String searchBankDetails = ClientsWindowController.value3;
            Clients.getItems().stream()
                    .filter(item -> {
                        if (searchId != null && item.getId() == searchId)
                            return true;
                        else if (!searchLegalEntityName.equals("") && item.getLegalEntityName().equals(searchLegalEntityName))
                            return true;
                        else return !searchBankDetails.equals("") && item.getBankDetails().equals(searchBankDetails);
                    })
                    .findAny()
                    .ifPresent(item -> {
                        Clients.getSelectionModel().select(item);
                        Clients.scrollTo(item);
                    });
        });

        add.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Clients/ClientsWindow.fxml"));

            try {
                loader.load();
            } catch (IOException io) {
                io.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Enter the data");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node) e.getSource()).getScene().getWindow());
            stage.showAndWait();

            Integer searchId = ClientsWindowController.value1;
            String searchLegalEntityName = ClientsWindowController.value2;
            String searchBankDetails = ClientsWindowController.value3;

            if (searchId != null && !searchLegalEntityName.equals("") && !searchBankDetails.equals("")) {
                String sql = "INSERT INTO `Clients`(`id`, `legal_entity_name`, `bank_details`) " +
                        "VALUES ('" + searchId + "','" + searchLegalEntityName + "','" + searchBankDetails + "');";
                try {
                    connection.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                clients.add(new Client(searchId, searchLegalEntityName, searchBankDetails));
                Clients.setItems(clients);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("WARNING!");
                alert.setHeaderText(null);
                alert.setContentText("Insufficient data!");

                alert.showAndWait();
            }

        });

        delete.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/AreYouSure.fxml"));

            try {
                loader.load();
            } catch (IOException io) {
                io.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node) e.getSource()).getScene().getWindow());
            stage.showAndWait();


            if (AreYouSureController.flag) {
                ObservableList<Client> selectedRows = Clients.getSelectionModel().getSelectedItems();
                // we don't want to iterate on same collection on with we remove items
                ArrayList<Client> rows = new ArrayList<>(selectedRows);
                rows.forEach(row -> {
                    Clients.getItems().remove(row);
                    String sql = "DELETE FROM `Clients` WHERE `id`='" + row.getId() + "';";
                    try {
                        connection.execute(sql);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    clients.remove(row);
                });
            }
        });
    }

    void loadInfo() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Clients.getItems().size(); i++)
            Clients.getItems().clear();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id.setEditable(true);
        id.setOnEditCommit((TableColumn.CellEditEvent<Client, Integer> event) -> {
            TablePosition<Client, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Client client = event.getTableView().getItems().get(row);

            client.setId(newValue);
        });

        legal_entity_name.setCellValueFactory(new PropertyValueFactory<>("legalEntityName"));
        legal_entity_name.setCellFactory(TextFieldTableCell.forTableColumn());
        legal_entity_name.setMaxWidth(250);
        legal_entity_name.setOnEditCommit((TableColumn.CellEditEvent<Client, String> event) -> {
            TablePosition<Client, String> pos = event.getTablePosition();

            String newValue = event.getNewValue();

            int row = pos.getRow();
            Client client = event.getTableView().getItems().get(row);

            client.setLegalEntityName(newValue);
            String sql = "UPDATE `Clients` SET `legal_entity_name`='" + client.getLegalEntityName() +
                    "' WHERE `id`='" + client.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        bank_details.setCellValueFactory(new PropertyValueFactory<>("bankDetails"));
        bank_details.setCellFactory(TextFieldTableCell.forTableColumn());
        bank_details.setMaxWidth(500);
        bank_details.setOnEditCommit((TableColumn.CellEditEvent<Client, String> event) -> {
            TablePosition<Client, String> pos = event.getTablePosition();

            String newValue = event.getNewValue();

            int row = pos.getRow();
            Client client = event.getTableView().getItems().get(row);

            client.setBankDetails(newValue);
            String sql = "UPDATE `Clients` SET `bank_details`='" + client.getBankDetails() +
                    "' WHERE `id`='" + client.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        legal_entity_name.setSortable(true);

        clients = connection.getClients();
        Clients.setItems(clients);
    }
}
