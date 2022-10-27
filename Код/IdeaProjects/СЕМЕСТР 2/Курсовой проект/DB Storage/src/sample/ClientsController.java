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
    private Button add;

    DBConnection connection = null;

    @FXML
    void initialize() throws SQLException {
        connection = new DBConnection();
        loadInfo();

        goodsButton.setOnAction(event -> {
            goodsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/GoodsPage.fxml"));

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
        /*try {
            // сначала очищаем от прошлых значений
            id.getChildren().clear();

            // получаем все значения из базы данных
            ArrayList<String> Id = connection.getClientsId();
            for (int i = 0; i < Id.size(); i++) // перебираем их через цикл
                // добавляем каждое значение в объект VBox (id)
                id.getChildren().add(new Label(Id.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            legal_entity_name.getChildren().clear();

            ArrayList<String> legalEntityName = connection.getLegalEntityName();
            for (int i = 0; i < legalEntityName.size(); i++)
                legal_entity_name.getChildren().add(new Label(legalEntityName.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            bank_details.getChildren().clear();

            ArrayList<String> bankDetails = connection.getBankDetails();
            for (int i = 0; i < bankDetails.size(); i++)
                bank_details.getChildren().add(new Label(bankDetails.get(i)));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
