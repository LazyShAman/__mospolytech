package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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

import javax.swing.*;

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
        connection.getConnection();

        goodsButton.setOnAction(event -> {
            goodsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("GoodsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        racksButton.setOnAction(event -> {
            racksButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RacksPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        premisessButton.setOnAction(event -> {
            premisessButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PremisessPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
        });
    }

   /* void loadInfo() {
        try {
            // сначала очищаем от прошлых значений
            bank_details.getChildren().clear();

            // получаем все значения из базы данных
            ArrayList<String> bankDetails = connection.getBankDetails();
            for(int i = 0; i < bankDetails.size(); i++) // перебираем их через цикл
                // добавляем каждое значение столбца в объект VBox (bank_details)
                bank_details.getChildren().add(new Label(bankDetails.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*public void add() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
        String sql = "INSERT into Clients (id,legal_entity_name,bank_details) VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, txt_email.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
}
