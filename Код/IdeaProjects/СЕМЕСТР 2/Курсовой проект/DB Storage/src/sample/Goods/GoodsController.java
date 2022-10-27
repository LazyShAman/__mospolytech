package sample.Goods;

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

public class GoodsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Good> Goods;

    @FXML
    private TableColumn<Good, Integer> id;

    @FXML
    private TableColumn<Good, Integer> id_client;

    @FXML
    private TableColumn<Good, Integer> rack_space;

    @FXML
    private TableColumn<Good, Integer> id_rack;

    @FXML
    private TableColumn<Good, Float> length;

    @FXML
    private TableColumn<Good, Float> width;

    @FXML
    private TableColumn<Good, Float> height;

    @FXML
    private TableColumn<Good, Float> weight;

    @FXML
    private TableColumn<Good, Integer> contract_number;

    @FXML
    private TableColumn<Good, Float> humidity;

    @FXML
    private TableColumn<Good, Float> temperature;

    @FXML
    private TableColumn<Good, Integer> id_premises;

    @FXML
    private Button clientsButton;

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

    ObservableList<Good> goods;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();
        Goods.setEditable(true);
        Goods.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
            loader.setLocation(getClass().getResource("/sample/Goods/GoodsWindow.fxml"));

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

            Integer searchId = GoodsWindowController.value1;
            Integer searchIdClient = GoodsWindowController.value2;
            Integer searchRackSpace = GoodsWindowController.value3;
            Integer searchIdRack = GoodsWindowController.value4;
            Integer searchContractNumber = GoodsWindowController.value9;
            Integer searchIdPremises = GoodsWindowController.value12;
            Goods.getItems().stream()
                    .filter(item -> {
                        if (searchId != null && item.getId() == searchId)
                            return true;
                        else if (searchRackSpace != null && item.getRackSpace() == searchRackSpace)
                            return true;
                        else if (searchIdRack != null && item.getIdRack() == searchIdRack)
                            return true;
                        else if (searchContractNumber != null && item.getContractNumber() == searchContractNumber)
                            return true;
                        else if (searchIdClient != null && item.getIdClient() == searchIdClient)
                            return true;
                        else return searchIdPremises != null && item.getIdPremises() == searchIdPremises;
                    })
                    .findAny()
                    .ifPresent(item -> {
                        Goods.getSelectionModel().select(item);
                        Goods.scrollTo(item);
                    });
        });

        add.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Goods/GoodsWindow.fxml"));

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

            Integer searchId = GoodsWindowController.value1;
            Integer searchIdClient = GoodsWindowController.value2;
            Integer searchRackSpace = GoodsWindowController.value3;
            Integer searchIdRack = GoodsWindowController.value4;
            Float searchLength = GoodsWindowController.value5;
            Float searchWidth = GoodsWindowController.value6;
            Float searchHeight = GoodsWindowController.value7;
            Float searchWeight = GoodsWindowController.value8;
            Integer searchContractNumber = GoodsWindowController.value9;
            Float searchHumidity = GoodsWindowController.value10;
            Float searchTemperature = GoodsWindowController.value11;
            Integer searchIdPremises = GoodsWindowController.value12;

            if (searchId != null && searchIdClient != null && searchRackSpace != null &&
                    searchIdRack != null && searchLength != null && searchWidth != null &&
                    searchHeight != null && searchWeight != null && searchContractNumber != null &&
                    searchHumidity != null && searchTemperature != null && searchIdPremises != null) {
                String sql = "INSERT INTO `Goods`(`id`, `id_rack`, `rack_space`, `id_client`, " +
                        "`length`, `width`, `height`, `weight`, `contract_number`, " +
                        "`humidity`, `temperature`, `id_premises`) " +
                        "VALUES ('" + searchId + "','" + searchIdClient + "','" + searchRackSpace + "','"
                        + searchIdRack + "','" + searchLength + "','" + searchWidth + "','"
                        + searchHeight + "','" + searchWeight + "','" + searchContractNumber + "','"
                        + searchHumidity + "','" + searchTemperature + "','" + searchIdPremises + "');";
                try {
                    connection.execute(sql);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                goods.add(new Good(searchId, searchIdClient, searchRackSpace, searchIdRack,
                        searchLength, searchWidth, searchHeight, searchWeight, searchContractNumber,
                        searchHumidity, searchTemperature, searchIdPremises));
                Goods.setItems(goods);
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
                ObservableList<Good> selectedRows = Goods.getSelectionModel().getSelectedItems();
                // we don't want to iterate on same collection on with we remove items
                ArrayList<Good> rows = new ArrayList<>(selectedRows);
                rows.forEach(row -> {
                    Goods.getItems().remove(row);
                    String sql = "DELETE FROM `Goods` WHERE `id`='" + row.getId() + "';";
                    try {
                        connection.execute(sql);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    goods.remove(row);
                });
            }
        });
    }

    void loadInfo() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < Goods.getItems().size(); i++)
            Goods.getItems().clear();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        id_client.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        id_client.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id_client.setOnEditCommit((TableColumn.CellEditEvent<Good, Integer> event) -> {
            TablePosition<Good, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setIdClient(newValue);

            String sql = "UPDATE `Goods` SET `id_client`='" + good.getIdClient() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        rack_space.setCellValueFactory(new PropertyValueFactory<>("rackSpace"));
        rack_space.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        rack_space.setOnEditCommit((TableColumn.CellEditEvent<Good, Integer> event) -> {
            TablePosition<Good, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setRackSpace(newValue);

            String sql = "UPDATE `Goods` SET `rack_space`='" + good.getRackSpace() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id_rack.setCellValueFactory(new PropertyValueFactory<>("idRack"));
        id_rack.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id_rack.setOnEditCommit((TableColumn.CellEditEvent<Good, Integer> event) -> {
            TablePosition<Good, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setIdRack(newValue);

            String sql = "UPDATE `Goods` SET `id_rack`='" + good.getIdRack() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        length.setCellValueFactory(new PropertyValueFactory<>("length"));
        length.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        length.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setLength(newValue);

            String sql = "UPDATE `Goods` SET `length`='" + good.getLength() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        width.setCellValueFactory(new PropertyValueFactory<>("width"));
        width.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        width.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setWidth(newValue);

            String sql = "UPDATE `Goods` SET `width`='" + good.getWidth() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        height.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        height.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setHeight(newValue);

            String sql = "UPDATE `Goods` SET `height`='" + good.getHeight() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        weight.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        weight.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setWeight(newValue);

            String sql = "UPDATE `Goods` SET `weight`='" + good.getWeight() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        contract_number.setCellValueFactory(new PropertyValueFactory<>("contractNumber"));
        contract_number.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        contract_number.setOnEditCommit((TableColumn.CellEditEvent<Good, Integer> event) -> {
            TablePosition<Good, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setContractNumber(newValue);

            String sql = "UPDATE `Goods` SET `contract_number`='" + good.getContractNumber() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        humidity.setCellValueFactory(new PropertyValueFactory<>("humidity"));
        humidity.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        humidity.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setHumidity(newValue);

            String sql = "UPDATE `Goods` SET `humidity`='" + good.getHumidity() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        temperature.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        temperature.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        temperature.setOnEditCommit((TableColumn.CellEditEvent<Good, Float> event) -> {
            TablePosition<Good, Float> pos = event.getTablePosition();

            Float newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setTemperature(newValue);

            String sql = "UPDATE `Goods` SET `temperature`='" + good.getTemperature() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id_premises.setCellValueFactory(new PropertyValueFactory<>("idPremises"));
        id_premises.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id_premises.setOnEditCommit((TableColumn.CellEditEvent<Good, Integer> event) -> {
            TablePosition<Good, Integer> pos = event.getTablePosition();

            Integer newValue = event.getNewValue();

            int row = pos.getRow();
            Good good = event.getTableView().getItems().get(row);

            good.setIdPremises(newValue);

            String sql = "UPDATE `Goods` SET `id_premises`='" + good.getIdPremises() +
                    "' WHERE `id`='" + good.getId() + "';";
            try {
                connection.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        id.setSortable(true);

        goods = connection.getGoods();
        Goods.setItems(goods);
    }
}
