package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AreYouSureController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    public static boolean flag;

    @FXML
    void initialize() {
        ok.setOnAction(e -> {
            flag = true;
            ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
        });
        cancel.setOnAction(e -> {
            flag = false;
            ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
        });
    }
}
