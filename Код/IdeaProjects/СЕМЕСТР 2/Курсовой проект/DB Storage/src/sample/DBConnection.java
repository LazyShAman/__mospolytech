package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Clients.Client;
import sample.Goods.Good;
import sample.Premisess.Premises;
import sample.Racks.Rack;

import java.sql.*;

public class DBConnection {
    private final Connection connection;

    public DBConnection() throws SQLException {
        String host = "std-mysql.ist.mospolytech.ru";
        String port = "3306";
        String name = "std_1607_st";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;

        String login = "std_1607_st";
        String password = "12345678";
        connection = DriverManager.getConnection(url, login, password);
    }

    public void execute(String sql) throws SQLException {
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.execute();
    }

    // CLIENTS

    public ObservableList<Client> getClients() throws SQLException {
        String sql = "SELECT * FROM Clients";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ObservableList<Client> clients = FXCollections.observableArrayList();

        while (res.next()) {
            int id = res.getInt("id");
            String legal_entity_name = res.getString("legal_entity_name");
            String bank_details = res.getString("bank_details");

            // переход от реляционной модели к объектной
            clients.add(new Client(id, legal_entity_name, bank_details));
        }

        return clients;
    }

    // GOODS

    public ObservableList<Good> getGoods() throws SQLException {
        String sql = "SELECT * FROM Goods";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ObservableList<Good> goods = FXCollections.observableArrayList();

        while (res.next()) {
            int id = res.getInt("id");
            int id_rack = res.getInt("id_rack");
            int rack_space = res.getInt("rack_space");
            int id_premises = res.getInt("id_premises");
            int id_client = res.getInt("id_client");
            float length = res.getFloat("length");
            float width = res.getFloat("width");
            float height = res.getFloat("height");
            float weight = res.getFloat("weight");
            int contract_number = res.getInt("contract_number");
            float humidity = res.getFloat("humidity");
            float temperature = res.getFloat("temperature");

            goods.add(new Good(id, id_rack, rack_space, id_client,
                    length, width, height, weight, contract_number,
                    humidity, temperature, id_premises));
        }

        return goods;
    }

    // RACKS

    public ObservableList<Rack> getRacks() throws SQLException {
        String sql = "SELECT * FROM Racks";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ObservableList<Rack> racks = FXCollections.observableArrayList();

        while (res.next()) {
            int id = res.getInt("id");
            float length = res.getFloat("length");
            float width = res.getFloat("width");
            float height = res.getFloat("height");
            float max_total_load = res.getFloat("max_total_load");
            int number_of_storages = res.getInt("number_of_storages");
            int id_premises = res.getInt("id_premises");
            int id_client = res.getInt("id_client");

            racks.add(new Rack(id, length, width, height, max_total_load,
                    number_of_storages, id_premises, id_client));
        }

        return racks;
    }

    // PREMISESS

    public ObservableList<Premises> getPremisess() throws SQLException {
        String sql = "SELECT * FROM Premises";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ObservableList<Premises> premisess = FXCollections.observableArrayList();

        while (res.next()) {
            int id = res.getInt("id");
            String name = res.getString("name");
            float useful_volume = res.getFloat("useful_volume");
            float humidity = res.getFloat("humidity");
            float temperature = res.getFloat("temperature");

            premisess.add(new Premises(id, name, useful_volume, humidity, temperature));
        }

        return premisess;
    }
}