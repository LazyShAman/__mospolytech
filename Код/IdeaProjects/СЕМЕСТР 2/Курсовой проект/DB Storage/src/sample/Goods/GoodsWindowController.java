package sample.Goods;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GoodsWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    public static Integer value1;

    @FXML
    private TextField txtIdClient;

    public static Integer value2;

    @FXML
    private TextField txtRackSpace;

    public static Integer value3;

    @FXML
    private TextField txtIdRack;

    public static Integer value4;

    @FXML
    private TextField txtLength;

    public static Float value5;

    @FXML
    private TextField txtWidth;

    public static Float value6;

    @FXML
    private TextField txtHeight;

    public static Float value7;

    @FXML
    private TextField txtWeight;

    public static Float value8;

    @FXML
    private TextField txtContractNumber;

    public static Integer value9;

    @FXML
    private TextField txtHumidity;

    public static Float value10;

    @FXML
    private TextField txtTemperature;

    public static Float value11;

    @FXML
    private TextField txtIdPremises;

    public static Integer value12;

    @FXML
    private Button ok;

    @FXML
    void initialize() {
        txtId.clear();
        txtIdClient.clear();
        txtRackSpace.clear();
        txtIdRack.clear();
        txtLength.clear();
        txtWidth.clear();
        txtHeight.clear();
        txtWeight.clear();
        txtContractNumber.clear();
        txtHumidity.clear();
        txtTemperature.clear();
        txtIdPremises.clear();

        ok.setOnAction(this::handleOkAction);
    }

    @FXML
    public void handleOkAction(ActionEvent event) {
        if (!txtId.getText().equals(""))
            value1 = Integer.valueOf(txtId.getText());
        else
            value1 = null;

        if (!txtIdClient.getText().equals(""))
            value2 = Integer.valueOf(txtIdClient.getText());
        else
            value2 = null;

        if (!txtRackSpace.getText().equals(""))
            value3 = Integer.valueOf(txtRackSpace.getText());
        else
            value3 = null;

        if (!txtIdRack.getText().equals(""))
            value4 = Integer.valueOf(txtIdRack.getText());
        else
            value4 = null;

        if (!txtLength.getText().equals(""))
            value5 = Float.valueOf(txtLength.getText());
        else
            value5 = null;

        if (!txtWidth.getText().equals(""))
            value6 = Float.valueOf(txtWidth.getText());
        else
            value6 = null;

        if (!txtHeight.getText().equals(""))
            value7 = Float.valueOf(txtHeight.getText());
        else
            value7 = null;

        if (!txtWeight.getText().equals(""))
            value8 = Float.valueOf(txtWeight.getText());
        else
            value8 = null;

        if (!txtContractNumber.getText().equals(""))
            value9 = Integer.valueOf(txtContractNumber.getText());
        else
            value9 = null;

        if (!txtHumidity.getText().equals(""))
            value10 = Float.valueOf(txtHumidity.getText());
        else
            value10 = null;

        if (!txtTemperature.getText().equals(""))
            value11 = Float.valueOf(txtTemperature.getText());
        else
            value11 = null;

        if (!txtIdPremises.getText().equals(""))
            value12 = Integer.valueOf(txtIdPremises.getText());
        else
            value12 = null;

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
}

