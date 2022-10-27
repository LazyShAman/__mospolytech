package Premises;

import Premises.Premises;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Premisess extends Observable {
    private Connection connection;
    private List<Premises> premisess;

    public Premisess(DBConnection connection) {
        this.connection = connection.getConnection();
        premisess = new ArrayList<>();
    }

    public void select() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, name, useful_volume, humidity, temperature FROM Premises";
            ResultSet result = statement.executeQuery(query);

            premisess.clear();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                float useful_volume = result.getFloat("useful_volume");
                float humidity = result.getFloat("humidity");
                float temperature = result.getFloat("temperature");

                // переход от реляционной модели к объектной
                premisess.add(new Premises(id, name, useful_volume,
                                       humidity, temperature));

                System.out.print("Premises.Premises: ");
                System.out.print("id = " + id);
                System.out.print(", name = \"" + name + "\"");
                System.out.print(", useful_volume = " + useful_volume);
                System.out.print(", humidity = " + humidity);
                System.out.println(", temperature = " + temperature + ".");
            }
            System.out.println("--------");

            //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers(obj);
    }

    public List<Premises> getAll() {
        return premisess;
    }
}