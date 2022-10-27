package sample.Premisess;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PremisessWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    public static Integer value1;

    @FXML
    private TextArea txtName;

    public static String value2;

    @FXML
    private TextField txtUsefulVolume;

    public static Float value3;

    @FXML
    private TextField txtHumidity;

    public static Float value4;

    @FXML
    private TextField txtTemperature;

    public static Float value5;

    @FXML
    private Button ok;

    @FXML
    void initialize() {
        txtId.clear();
        txtName.clear();
        txtUsefulVolume.clear();
        txtHumidity.clear();
        txtTemperature.clear();

        ok.setOnAction(this::handleOkAction);
    }

    @FXML
    public void handleOkAction(ActionEvent event) {
        if (!txtId.getText().equals(""))
            value1 = Integer.valueOf(txtId.getText());
        else
            value1 = null;

        value2 = String.valueOf(txtName.getText());

        if (!txtUsefulVolume.getText().equals(""))
            value3 = Float.valueOf(txtUsefulVolume.getText());
        else
            value3 = null;

        if (!txtHumidity.getText().equals(""))
            value4 = Float.valueOf(txtHumidity.getText());
        else
            value4 = null;

        if (!txtTemperature.getText().equals(""))
            value5 = Float.valueOf(txtTemperature.getText());
        else
            value5 = null;

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
}
