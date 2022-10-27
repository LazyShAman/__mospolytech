package sample.Racks;

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
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sample.AreYouSureController;
import sample.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RacksController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Rack> Racks;

    @FXML
    private TableColumn<Rack, Integer> id;

    @FXML
    private TableColumn<Rack, Float> length;

    @FXML
    private TableColumn<Rack, Float> width;

    @FXML
    private TableColumn<Rack, Float> height;

    @FXML
    private TableColumn<Rack, Float> max_total_load;

    @FXML
    private TableColumn<Rack, Integer> number_of_storages;

    @FXML
    private TableColumn<Rack, Integer> id_premises;

    @FXML
    private TableColumn<Rack, Integer> id_client;

    @FXML
    private Button clientsButton;

    @FXML
    private Button goodsButton;

    @FXML
    private Button premisessButton;

    @FXML
    private Button find;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    ObservableList<Rack> racks;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();
        Racks.setEditable(true);
        Racks.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        clientsButton.setOnAction(event -> {
            clientsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Clients/ClientsPage.fxml"));

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
            loader.setLocation(getClass().getResource("/sample/Racks/RacksWindow.fxml"));

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

            Integer searchId = RacksWindowController.value1;
            Integer searchIdPremises = RacksWindowController.value7;
            Integer searchIdClient = RacksWindowController.value8;

            Racks.getItems().stream()
                    .filter(item -> {
                        if (searchId != null && item.getId() == searchId)
                            return true;
                        else if (searchIdClient != null && item.getIdClient() == searchIdClient)
                            return true;
                        else return searchIdPremises != null && item.getIdPremises() == searchIdPremises;
                    })
                    .findAny()
                    .ifPresent(item -> {
                        Racks.getSelectionModel().select(item);
                        Racks.scrollTo(item);
                    });
        });

        add.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Racks/RacksWindow.fxml"));

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

            Integer searchId = RacksWindowController.value1;
            Float searchLength = RacksWindowController.value2;
            Float searchWidth = RacksWindowController.value3;
            Float searchHeight = RacksWindowController.value4;
            Float searchMaxTotalLoad = RacksWindowController.value5;
            Integer searchNumberOfStorages = RacksWindowController.value6;
            Integer searchIdPremises = RacksWindowController.value7;
            Integer searchIdClient = RacksWindowController.value8;

            if (searchId != null && searchLength != null && searchWidth != null && searchHeight != null
                    && searchMaxTotalLoad != null && searchNumberOfStorages != null
                    && searchIdPremises != null && searchIdClient != null) {
                String sql = "INSERT INTO `Racks`(`id`, `length`, `width`, `height`, `max_total_load`, " +
                        "`number_of_storages`, `id_premises`, `id_client`) " +
                        "VALUES ('" + searchId + "','" + searchLength + "','" + searchWidth + "','"
                        + searchHeight + "','" + searchMaxTotalLoad + "','" + searchNumberOfStorages + "','"
                        + searchIdPremises + "','" + searchIdClient + "');";
                try {
                    connection.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                racks.add(new Rack(searchId, searchLength, searchWidth, searchHeight, searchMaxTotalLoad,
                        searchNumberOfStorages, searchIdPremises, searchIdClient));
                Racks.setItems(racks);
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
                ObservableList<Rack> selectedRows = Racks.getSelectionModel().getSelectedItems();
                // we don't want to iterate on same collection on with we remove items
                ArrayList<Rack> rows = new ArrayList<>(selectedRows);
                rows.forEach(row -> {
                    Racks.getItems().remove(row);
                    String sql = "DELETE FROM `Racks` WHERE `id`='" + row.getId() + "';";
                    try {
                        connection.execute(sql);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    racks.remove(row);
                });
            }
        });
    }

    void loadInfo() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Racks.getItems().size(); i++)
            Racks.getItems().clear();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        length.setCellValueFactory(new PropertyValueFactory<>("length"));
        length.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        length.setOnEditCommit((TableColumn.CellEditEvent<Rack, Float> event) -> {
            TablePosition<Rack, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setLength(newValue);

            String sql = "UPDATE `Racks` SET `length`='" + rack.getLength() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        width.setCellValueFactory(new PropertyValueFactory<>("width"));
        width.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        width.setOnEditCommit((TableColumn.CellEditEvent<Rack, Float> event) -> {
            TablePosition<Rack, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setWidth(newValue);

            String sql = "UPDATE `Racks` SET `width`='" + rack.getWidth() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        height.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        height.setOnEditCommit((TableColumn.CellEditEvent<Rack, Float> event) -> {
            TablePosition<Rack, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setHeight(newValue);

            String sql = "UPDATE `Racks` SET `height`='" + rack.getHeight() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        max_total_load.setCellValueFactory(new PropertyValueFactory<>("maxTotalLoad"));
        max_total_load.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        max_total_load.setOnEditCommit((TableColumn.CellEditEvent<Rack, Float> event) -> {
            TablePosition<Rack, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setMaxTotalLoad(newValue);

            String sql = "UPDATE `Racks` SET `max_total_load`='" + rack.getMaxTotalLoad() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        number_of_storages.setCellValueFactory(new PropertyValueFactory<>("numberOfStorages"));
        number_of_storages.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        number_of_storages.setOnEditCommit((TableColumn.CellEditEvent<Rack, Integer> event) -> {
            TablePosition<Rack, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setNumberOfStorages(newValue);

            String sql = "UPDATE `Racks` SET `number_of_storages`='" + rack.getNumberOfStorages() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id_premises.setCellValueFactory(new PropertyValueFactory<>("idPremises"));
        id_premises.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id_premises.setOnEditCommit((TableColumn.CellEditEvent<Rack, Integer> event) -> {
            TablePosition<Rack, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setIdPremises(newValue);

            String sql = "UPDATE `Racks` SET `id_premises`='" + rack.getIdPremises() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id_client.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        id_client.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id_client.setOnEditCommit((TableColumn.CellEditEvent<Rack, Integer> event) -> {
            TablePosition<Rack, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Rack rack = event.getTableView().getItems().get(row);

            rack.setIdClient(newValue);

            String sql = "UPDATE `Racks` SET `id_client`='" + rack.getIdClient() +
                    "' WHERE `id`='" + rack.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id.setSortable(true);

        racks = connection.getRacks();
        Racks.setItems(racks);
    }
}
