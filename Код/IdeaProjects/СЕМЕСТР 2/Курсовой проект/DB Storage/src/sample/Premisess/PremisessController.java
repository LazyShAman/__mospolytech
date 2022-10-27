package sample.Premisess;

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
import sample.AreYouSureController;
import sample.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PremisessController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Premises> Premisess;

    @FXML
    private TableColumn<Premises, Integer> id;

    @FXML
    private TableColumn<Premises, String> name;

    @FXML
    private TableColumn<Premises, Float> useful_volume;

    @FXML
    private TableColumn<Premises, Float> humidity;

    @FXML
    private TableColumn<Premises, Float> temperature;

    @FXML
    private Button clientsButton;

    @FXML
    private Button goodsButton;

    @FXML
    private Button racksButton;

    @FXML
    private Button find;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    ObservableList<Premises> premisess;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();
        Premisess.setEditable(true);
        Premisess.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

        find.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("ATTENTION!");
            alert.setHeaderText(null);
            alert.setContentText("Enter in one or more highlighted fields. We will find a tuple by the first existing one!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Premisess/PremisessWindow.fxml"));

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

            Integer searchId = PremisessWindowController.value1;
            String searchName = PremisessWindowController.value2;

            Premisess.getItems().stream()
                    .filter(item -> {
                        if (searchId != null && item.getId() == searchId)
                            return true;
                        else return searchName != null && item.getName().equals(searchName);
                    })
                    .findAny()
                    .ifPresent(item -> {
                        Premisess.getSelectionModel().select(item);
                        Premisess.scrollTo(item);
                    });
        });

        add.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Premisess/PremisessWindow.fxml"));

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

            Integer searchId = PremisessWindowController.value1;
            String searchName = PremisessWindowController.value2;
            Float searchUsefulVolume = PremisessWindowController.value3;
            Float searchHumidity = PremisessWindowController.value4;
            Float searchTemperature = PremisessWindowController.value5;

            if (searchId != null && !searchName.equals("") && searchUsefulVolume != null &&
                    searchHumidity != null && searchTemperature != null) {
                String sql = "INSERT INTO `Premises`(`id`, `name`, `useful_volume`, `humidity`, `temperature`) " +
                        "VALUES ('" + searchId + "','" + searchName + "','"
                        + searchHumidity + "','" + searchTemperature + "');";
                try {
                    connection.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                premisess.add(new Premises(searchId, searchName, searchUsefulVolume,
                        searchHumidity, searchTemperature));
                Premisess.setItems(premisess);
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
                ObservableList<Premises> selectedRows = Premisess.getSelectionModel().getSelectedItems();
                // we don't want to iterate on same collection on with we remove items
                ArrayList<Premises> rows = new ArrayList<>(selectedRows);
                rows.forEach(row -> {
                    Premisess.getItems().remove(row);
                    String sql = "DELETE FROM `Premises` WHERE `id`='" + row.getId() + "';";
                    try {
                        connection.execute(sql);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    premisess.remove(row);
                });
            }
        });
    }

    void loadInfo() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Premisess.getItems().size(); i++)
            Premisess.getItems().clear();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit((TableColumn.CellEditEvent<Premises, String> event) -> {
            TablePosition<Premises, String> pos = event.getTablePosition();

            String newValue = event.getNewValue();

            int row = pos.getRow();
            Premises premises = event.getTableView().getItems().get(row);

            premises.setName(newValue);

            String sql = "UPDATE `Premises` SET `name`='" + premises.getName() +
                    "' WHERE `id`='" + premises.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        useful_volume.setCellValueFactory(new PropertyValueFactory<>("usefulVolume"));
        useful_volume.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        useful_volume.setOnEditCommit((TableColumn.CellEditEvent<Premises, Float> event) -> {
            TablePosition<Premises, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Premises premises = event.getTableView().getItems().get(row);

            premises.setUsefulVolume(newValue);

            String sql = "UPDATE `Premises` SET `useful_volume`='" + premises.getUsefulVolume() +
                    "' WHERE `id`='" + premises.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        humidity.setCellValueFactory(new PropertyValueFactory<>("humidity"));
        humidity.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        humidity.setOnEditCommit((TableColumn.CellEditEvent<Premises, Float> event) -> {
            TablePosition<Premises, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Premises premises = event.getTableView().getItems().get(row);

            premises.setHumidity(newValue);

            String sql = "UPDATE `Premises` SET `humidity`='" + premises.getHumidity() +
                    "' WHERE `id`='" + premises.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        temperature.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        temperature.setOnEditCommit((TableColumn.CellEditEvent<Premises, Float> event) -> {
            TablePosition<Premises, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Premises premises = event.getTableView().getItems().get(row);

            premises.setTemperature(newValue);

            String sql = "UPDATE `Premises` SET `temperature`='" + premises.getTemperature() +
                    "' WHERE `id`='" + premises.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id.setSortable(true);

        premisess = connection.getPremisess();
        Premisess.setItems(premisess);
    }
}
