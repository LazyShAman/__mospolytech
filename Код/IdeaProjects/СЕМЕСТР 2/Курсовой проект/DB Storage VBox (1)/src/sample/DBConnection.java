package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private final Connection connection;

    public DBConnection() throws SQLException {
        /*try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Storage",
                    "root", "12345678");
        } catch (Exception e) {
            System.out.println(e);
        }*/

        String host = "std-mysql.ist.mospolytech.ru";
        String port = "3306";
        String name = "std_1607_st";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;

        String login = "std_1607_st";
        String password = "12345678";
        connection = DriverManager.getConnection(url, login, password);
    }

    // CLIENTS

    public ArrayList<String> getClientsId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Clients";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> id = new ArrayList<>();
        while (res.next())
            id.add(res.getString("id"));

        return id;
    }

    public ArrayList<String> getLegalEntityName() throws SQLException, ClassNotFoundException {
        String sql = "SELECT legal_entity_name FROM Clients";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> legal_entity_name = new ArrayList<>();
        while (res.next())
            legal_entity_name.add(res.getString("legal_entity_name"));

        return legal_entity_name;
    }

    public ArrayList<String> getBankDetails() throws SQLException, ClassNotFoundException {
        String sql = "SELECT bank_details FROM Clients";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> bank_details = new ArrayList<>();
        while (res.next())
            bank_details.add(res.getString("bank_details"));

        return bank_details;
    }

    // GOODS

    public ArrayList<String> getGoodsId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> id = new ArrayList<>();
        while (res.next())
            id.add(res.getString("id"));

        return id;
    }

    public ArrayList<String> getGoodsIdRack() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id_rack FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> id_rack = new ArrayList<>();
        while (res.next())
            id_rack.add(res.getString("id_rack"));

        return id_rack;
    }

    public ArrayList<String> getRackSpace() throws SQLException, ClassNotFoundException {
        String sql = "SELECT rack_space FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> rack_space = new ArrayList<>();
        while (res.next())
            rack_space.add(res.getString("rack_space"));

        return rack_space;
    }

    public ArrayList<String> getGoodsIdClient() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id_client FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> id_client = new ArrayList<>();
        while (res.next())
            id_client.add(res.getString("id_client"));

        return id_client;
    }

    public ArrayList<String> getGoodsLength() throws SQLException, ClassNotFoundException {
        String sql = "SELECT length FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> length = new ArrayList<>();
        while (res.next())
            length.add(res.getString("length"));

        return length;
    }

    public ArrayList<String> getGoodsWidth() throws SQLException, ClassNotFoundException {
        String sql = "SELECT width FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> width = new ArrayList<>();
        while (res.next())
            width.add(res.getString("width"));

        return width;
    }

    public ArrayList<String> getGoodsHeight() throws SQLException, ClassNotFoundException {
        String sql = "SELECT height FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> height = new ArrayList<>();
        while (res.next())
            height.add(res.getString("height"));

        return height;
    }

    public ArrayList<String> getWeight() throws SQLException, ClassNotFoundException {
        String sql = "SELECT weight FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> weight = new ArrayList<>();
        while (res.next())
            weight.add(res.getString("weight"));

        return weight;
    }

    public ArrayList<String> getReceiptDate() throws SQLException, ClassNotFoundException {
        String sql = "SELECT receipt_date FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> receipt_date = new ArrayList<>();
        while (res.next())
            receipt_date.add(res.getString("receipt_date"));

        return receipt_date;
    }

    public ArrayList<String> getContractNumber() throws SQLException, ClassNotFoundException {
        String sql = "SELECT contract_number FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> contract_number = new ArrayList<>();
        while (res.next())
            contract_number.add(res.getString("contract_number"));

        return contract_number;
    }

    public ArrayList<String> getExpDateOfContract() throws SQLException, ClassNotFoundException {
        String sql = "SELECT exp_date_of_contract FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> exp_date_of_contract = new ArrayList<>();
        while (res.next())
            exp_date_of_contract.add(res.getString("exp_date_of_contract"));

        return exp_date_of_contract;
    }

    public ArrayList<String> getGoodsHumidity() throws SQLException, ClassNotFoundException {
        String sql = "SELECT humidity FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> humidity = new ArrayList<>();
        while (res.next())
            humidity.add(res.getString("humidity"));

        return humidity;
    }

    public ArrayList<String> getGoodsTemperature() throws SQLException, ClassNotFoundException {
        String sql = "SELECT temperature FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> temperature = new ArrayList<>();
        while (res.next())
            temperature.add(res.getString("temperature"));

        return temperature;
    }

    public ArrayList<String> getGoodsIdPremises() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id_premises FROM Goods";

        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> id_premises = new ArrayList<>();
        while (res.next())
            id_premises.add(res.getString("id_premises"));

        return id_premises;
    }
}