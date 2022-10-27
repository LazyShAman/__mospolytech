package sample.Racks;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Rack {
    private final SimpleIntegerProperty id;
    private final SimpleFloatProperty length;
    private final SimpleFloatProperty width;
    private final SimpleFloatProperty height;
    private final SimpleFloatProperty max_total_load;
    private final SimpleIntegerProperty number_of_storages;
    private final SimpleIntegerProperty id_premises;
    private final SimpleIntegerProperty id_client;

    public Rack(int id,
                float length, float width, float height, float max_total_load,
                int number_of_storages, int id_premises, int id_client) {
        this.id = new SimpleIntegerProperty(id);
        this.length = new SimpleFloatProperty(length);
        this.width = new SimpleFloatProperty(width);
        this.height = new SimpleFloatProperty(height);
        this.max_total_load = new SimpleFloatProperty(max_total_load);
        this.number_of_storages = new SimpleIntegerProperty(number_of_storages);
        this.id_premises = new SimpleIntegerProperty(id_premises);
        this.id_client = new SimpleIntegerProperty(id_client);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
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

    public float getMaxTotalLoad() {
        return max_total_load.get();
    }

    public void setMaxTotalLoad(float value) {
        max_total_load.set(value);
    }

    public int getNumberOfStorages() {
        return number_of_storages.get();
    }

    public void setNumberOfStorages(int value) {
        number_of_storages.set(value);
    }

    public int getIdPremises() {
        return id_premises.get();
    }

    public void setIdPremises(int value) {
        id_premises.set(value);
    }

    public int getIdClient() {
        return id_client.get();
    }

    public void setIdClient(int value) {
        id_client.set(value);
    }

}
