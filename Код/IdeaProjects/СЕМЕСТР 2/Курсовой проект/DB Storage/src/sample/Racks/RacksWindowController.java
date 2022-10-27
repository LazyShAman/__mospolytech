package sample.Racks;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RacksWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    public static Integer value1;

    @FXML
    private TextField txtLength;

    public static Float value2;

    @FXML
    private TextField txtWidth;

    public static Float value3;

    @FXML
    private TextField txtHeight;

    public static Float value4;

    @FXML
    private TextField txtMaxTotalLoad;

    public static Float value5;

    @FXML
    private TextField txtNumberOfStorages;

    public static Integer value6;

    @FXML
    private TextField txtIdPremises;

    public static Integer value7;

    @FXML
    private TextField txtIdClient;

    public static Integer value8;

    @FXML
    private Button ok;

    @FXML
    void initialize() {
        txtId.clear();
        txtLength.clear();
        txtWidth.clear();
        txtHeight.clear();
        txtMaxTotalLoad.clear();
        txtNumberOfStorages.clear();
        txtIdPremises.clear();
        txtIdClient.clear();

        ok.setOnAction(this::handleOkAction);
    }

    @FXML
    public void handleOkAction(ActionEvent event) {
        if (!txtId.getText().equals(""))
            value1 = Integer.valueOf(txtId.getText());
        else
            value1 = null;

        if (!txtLength.getText().equals(""))
            value2 = Float.valueOf(txtLength.getText());
        else
            value2 = null;

        if (!txtWidth.getText().equals(""))
            value3 = Float.valueOf(txtWidth.getText());
        else
            value3 = null;

        if (!txtHeight.getText().equals(""))
            value4 = Float.valueOf(txtHeight.getText());
        else
            value4 = null;

        if (!txtMaxTotalLoad.getText().equals(""))
            value5 = Float.valueOf(txtMaxTotalLoad.getText());
        else
            value5 = null;

        if (!txtNumberOfStorages.getText().equals(""))
            value6 = Integer.valueOf(txtNumberOfStorages.getText());
        else
            value6 = null;

        if (!txtIdPremises.getText().equals(""))
            value7 = Integer.valueOf(txtIdPremises.getText());
        else
            value7 = null;

        if (!txtIdClient.getText().equals(""))
            value8 = Integer.valueOf(txtIdClient.getText());
        else
            value8 = null;

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
}
