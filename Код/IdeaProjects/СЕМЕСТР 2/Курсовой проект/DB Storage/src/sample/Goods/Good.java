package sample.Goods;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Good {
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty id_rack;
    private final SimpleIntegerProperty rack_space;
    private final SimpleIntegerProperty id_client;
    private final SimpleFloatProperty length;
    private final SimpleFloatProperty width;
    private final SimpleFloatProperty height;
    private final SimpleFloatProperty weight;
    private final SimpleIntegerProperty contract_number;
    private final SimpleFloatProperty humidity;
    private final SimpleFloatProperty temperature;
    private final SimpleIntegerProperty id_premises;


    public Good(int id, int id_rack, int rack_space, int id_client,
                float length, float width, float height, float weight,
                int contract_number,
                float humidity, float temperature, int id_premises) {
        this.id = new SimpleIntegerProperty(id);
        this.id_rack = new SimpleIntegerProperty(id_rack);
        this.rack_space = new SimpleIntegerProperty(rack_space);
        this.id_client = new SimpleIntegerProperty(id_client);
        this.length = new SimpleFloatProperty(length);
        this.width = new SimpleFloatProperty(width);
        this.height = new SimpleFloatProperty(height);
        this.weight = new SimpleFloatProperty(weight);
        this.contract_number = new SimpleIntegerProperty(contract_number);
        this.humidity = new SimpleFloatProperty(humidity);
        this.temperature = new SimpleFloatProperty(temperature);
        this.id_premises = new SimpleIntegerProperty(id_premises);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public int getIdRack() {
        return id_rack.get();
    }

    public void setIdRack(int value) {
        id_rack.set(value);
    }

    public int getRackSpace() {
        return rack_space.get();
    }

    public void setRackSpace(int value) {
        rack_space.set(value);
    }

    public int getIdClient() {
        return id_client.get();
    }

    public void setIdClient(int value) {
        id_client.set(value);
    }

    public float getLength() {
        return length.get();
    }

    public void setLength(float value) {
        length.set(value);
    }

    public float getWidth() {
        return width.get();
    }

    public void setWidth(float value) {
        width.set(value);
    }

    public float getHeight() {
        return height.get();
    }

    public void setHeight(float value) {
        height.set(value);
    }

    public float getWeight() {
        return weight.get();
    }

    public void setWeight(float value) {
        weight.set(value);
    }

    public int getContractNumber() {
        return contract_number.get();
    }

    public void setContractNumber(int value) {
        contract_number.set(value);
    }

    public float getHumidity() {
        return humidity.get();
    }

    public void setHumidity(float value) {
        humidity.set(value);
    }

    public float getTemperature() {
        return temperature.get();
    }

    public void setTemperature(float value) {
        temperature.set(value);
    }

    public int getIdPremises() {
        return id_premises.get();
    }

    public void setIdPremises(int value) {
        id_premises.set(value);
    }
}