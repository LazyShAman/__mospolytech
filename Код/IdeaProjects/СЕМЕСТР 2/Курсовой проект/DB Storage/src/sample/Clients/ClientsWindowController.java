package sample.Clients;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientsWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    public static Integer value1;

    @FXML
    private TextArea txtLegalEntityName;

    public static String value2;

    @FXML
    private TextArea txtBankDetails;

    public static String value3;

    @FXML
    private Button ok;

    @FXML
    void initialize() {
        txtId.clear();
        txtLegalEntityName.clear();
        txtBankDetails.clear();

        ok.setOnAction(this::handleOkAction);
    }

    @FXML
    public void handleOkAction(ActionEvent event) {
        if (!txtId.getText().equals(""))
            value1 = Integer.valueOf(txtId.getText());
        else
            value1 = null;
        value2 = String.valueOf(txtLegalEntityName.getText());
        value3 = String.valueOf(txtBankDetails.getText());
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
