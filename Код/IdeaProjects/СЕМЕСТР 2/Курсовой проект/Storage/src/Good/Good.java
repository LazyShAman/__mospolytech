package Good;

import java.util.Calendar;
import java.util.Date;

public class Good {
    private int id;
    private int id_rack;
    private int rack_space;
    private int id_premises;
    private int id_client;
    private float length;
    private float width;
    private float height;
    private float weight;
    private Date receipt_date;
    private int contract_number;
    private Date exp_date_of_contract;
    private float humidity;
    private float temperature;

    public Good(int id, int id_rack, int rack_space, int id_premises, int id_client,
                float length, float width, float height, float weight,
                Date receipt_date, int contract_number, Date exp_date_of_contract,
                float humidity, float temperature) {
        this.id = id;
        this.id_rack = id_rack;
        this.rack_space = rack_space;
        this.id_premises = id_premises;
        this.id_client = id_client;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.receipt_date = receipt_date;
        this.contract_number = contract_number;
        this.exp_date_of_contract = exp_date_of_contract;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rack() {
        return id_rack;
    }

    public void setId_rack(int id_rack) {
        this.id_rack = id_rack;
    }

    public int getRack_space() {
        return rack_space;
    }

    public void setRack_space(int rack_space) {
        this.rack_space = rack_space;
    }

    public int getId_premises() {
        return id_premises;
    }

    public void setId_premises(int id_premises) {
        this.id_premises = id_premises;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(Date receipt_date) {
        //receipt_date.set(year, month, day);
        this.receipt_date = receipt_date;
    }

    public int getContract_number() {
        return contract_number;
    }

    public void setContract_number(int contract_number) {
        this.contract_number = contract_number;
    }

    public Date getExp_date_of_contract() {
        return exp_date_of_contract;
    }

    public void setExp_date_of_contract(Date exp_date_of_contract) {
        this.exp_date_of_contract = exp_date_of_contract;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}