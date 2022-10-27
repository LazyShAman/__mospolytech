package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private VBox length;

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
    private Button add;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        connection = new DBConnection();
        loadInfo();

        clientsButton.setOnAction(event -> {
            clientsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/ClientsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        racksButton.setOnAction(event -> {
            racksButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/RacksPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        premisessButton.setOnAction(event -> {
            premisessButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/PremisessPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    void loadInfo() {
        try {
            // сначала очищаем от прошлых значений
            id.getChildren().clear();

            // получаем все значения из базы данных
            ArrayList<String> Id = connection.getGoodsId();
            for (int i = 0; i < Id.size(); i++) // перебираем их через цикл
                // добавляем каждое значение в объект VBox (id)
                id.getChildren().add(new Label(Id.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            id_rack.getChildren().clear();

            ArrayList<String> idRack = connection.getGoodsIdRack();
            for (int i = 0; i < idRack.size(); i++)
                id_rack.getChildren().add(new Label(idRack.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            rack_space.getChildren().clear();

            ArrayList<String> rackSpace = connection.getRackSpace();
            for (int i = 0; i < rackSpace.size(); i++)
                rack_space.getChildren().add(new Label(rackSpace.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            id_client.getChildren().clear();

            ArrayList<String> idClient = connection.getGoodsIdClient();
            for (int i = 0; i < idClient.size(); i++)
                id_client.getChildren().add(new Label(idClient.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            length.getChildren().clear();

            ArrayList<String> Length = connection.getGoodsLength();
            for (int i = 0; i < Length.size(); i++)
                length.getChildren().add(new Label(Length.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            width.getChildren().clear();

            ArrayList<String> Width = connection.getGoodsWidth();
            for (int i = 0; i < Width.size(); i++)
                width.getChildren().add(new Label(Width.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            height.getChildren().clear();

            ArrayList<String> Height = connection.getGoodsHeight();
            for (int i = 0; i < Height.size(); i++)
                height.getChildren().add(new Label(Height.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            weight.getChildren().clear();

            ArrayList<String> Weight = connection.getWeight();
            for (int i = 0; i < Weight.size(); i++)
                weight.getChildren().add(new Label(Weight.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            receipt_date.getChildren().clear();

            ArrayList<String> receiptDate = connection.getReceiptDate();
            for (int i = 0; i < receiptDate.size(); i++)
                receipt_date.getChildren().add(new Label(receiptDate.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            contract_number.getChildren().clear();

            ArrayList<String> contractNumber = connection.getContractNumber();
            for (int i = 0; i < contractNumber.size(); i++)
                contract_number.getChildren().add(new Label(contractNumber.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            exp_date_of_contract.getChildren().clear();

            ArrayList<String> expDateOfContract = connection.getExpDateOfContract();
            for (int i = 0; i < expDateOfContract.size(); i++)
                exp_date_of_contract.getChildren().add(new Label(expDateOfContract.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            humidity.getChildren().clear();

            ArrayList<String> Humidity = connection.getGoodsHumidity();
            for (int i = 0; i < Humidity.size(); i++)
                humidity.getChildren().add(new Label(Humidity.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            temperature.getChildren().clear();

            ArrayList<String> Temperature = connection.getGoodsTemperature();
            for (int i = 0; i < Temperature.size(); i++)
                temperature.getChildren().add(new Label(Temperature.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            id_premises.getChildren().clear();

            ArrayList<String> idPremises = connection.getGoodsIdPremises();
            for (int i = 0; i < idPremises.size(); i++)
                id_premises.getChildren().add(new Label(idPremises.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
