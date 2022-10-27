package Rack;

import Rack.Rack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Racks extends Observable {
    private Connection connection;
    private List<Rack> racks;

    public Racks(DBConnection connection) {
        this.connection = connection.getConnection();
        racks = new ArrayList<>();
    }

    public void select() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, length, width, height, max_total_load, " +
                           "number_of_storages, id_premises, id_client FROM Racks";
            ResultSet result = statement.executeQuery(query);

            racks.clear();
            while (result.next()) {
                int id = result.getInt("id");
                float length = result.getFloat("length");
                float width = result.getFloat("width");
                float height = result.getFloat("height");
                float max_total_load = result.getFloat("max_total_load");
                int number_of_storages = result.getInt("number_of_storages");
                int id_premises = result.getInt("id_premises");
                int id_client = result.getInt("id_client");

                // переход от реляционной модели к объектной
                racks.add(new Rack(id, length, width, height, max_total_load,
                                   number_of_storages, id_premises, id_client));

                System.out.print("Rack.Rack: ");
                System.out.print("id = " + id);
                System.out.print(", length = " + length);
                System.out.print(", width = " + width);
                System.out.print(", height = " + height);
                System.out.print(", max_total_load = " + max_total_load);
                System.out.print(", number_of_storages = " + number_of_storages);
                System.out.print(", id_premises = " + id_premises);
                System.out.println(", id_client = " + id_client + ".");
            }
            System.out.println("--------");

            //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers(obj);
    }

    public List<Rack> getAll() {
        return racks;
    }
}