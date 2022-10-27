package Rack;

import java.util.Calendar;

public class Rack {
    private int id;
    private float length;
    private float width;
    private float height;
    private float max_total_load;
    private int number_of_storages;
    private int id_premises;
    private int id_client;

    public Rack(int id,
                float length, float width, float height, float max_total_load,
                int number_of_storages, int id_premises, int id_client) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.max_total_load = max_total_load;
        this.number_of_storages = number_of_storages;
        this.id_premises = id_premises;
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getMax_total_load() {
        return max_total_load;
    }

    public void setMax_total_load(float max_total_load) {
        this.max_total_load = max_total_load;
    }

    public int getNumber_of_storages() {
        return number_of_storages;
    }

    public void setNumber_of_storages(int number_of_storages) {
        this.number_of_storages = number_of_storages;
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
}
