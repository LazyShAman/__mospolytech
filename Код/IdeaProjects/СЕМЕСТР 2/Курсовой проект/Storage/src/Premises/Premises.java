package Premises;

import java.util.Calendar;

public class Premises {
    private int id;
    private String name;
    private float useful_volume;
    private float humidity;
    private float temperature;

    public Premises(int id, String name, float useful_volume,
                    float humidity, float temperature) {
        this.id = id;
        this.name = name;
        this.useful_volume = useful_volume;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUseful_volume() {
        return useful_volume;
    }

    public void setUseful_volume(float useful_volume) {
        this.useful_volume = useful_volume;
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
