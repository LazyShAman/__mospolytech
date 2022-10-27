package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clientsButton;


    @FXML
    void initialize() {
        clientsButton.setOnAction(event -> {
            clientsButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/ClientsPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            StackPane root = new StackPane();
            root.setPadding(new Insets(25));
            root.getChildren().add(ClientsController.Clients);
            Stage stage = new Stage();
            stage.setTitle("TableView (o7planning.org)");

            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        });
    }
}

