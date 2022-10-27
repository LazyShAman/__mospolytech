package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Client;

import java.sql.*;
import java.util.Date;

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

    // CLIENTS

    public ObservableList<Client> getClients() throws SQLException, ClassNotFoundException {
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
            System.out.println(id + " " + legal_entity_name + " " + bank_details);
        }

        return clients;
    }
}