package sample.Premisess;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Premises {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleFloatProperty useful_volume;
    private final SimpleFloatProperty humidity;
    private final SimpleFloatProperty temperature;

    public Premises(int id, String name, float useful_volume,
                    float humidity, float temperature) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.useful_volume = new SimpleFloatProperty(useful_volume);
        this.humidity = new SimpleFloatProperty(humidity);
        this.temperature = new SimpleFloatProperty(temperature);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public float getUsefulVolume() {
        return useful_volume.get();
    }

    public void setUsefulVolume(float value) {
        useful_volume.set(value);
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
}
