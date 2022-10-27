package Good;

import Good.Good;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Goods extends Observable {
    private Connection connection;
    private List<Good> goods;

    public Goods(DBConnection connection) {
        this.connection = connection.getConnection();
        goods = new ArrayList<>();
    }

    public void select() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, id_rack, rack_space, id_premises, id_client," +
                           "length, width, height, weight, receipt_date, contract_number, exp_date_of_contract, " +
                           "humidity, temperature FROM Goods";
            ResultSet result = statement.executeQuery(query);

            goods.clear();
            while (result.next()) {
                int id = result.getInt("id");
                int id_rack = result.getInt("id_rack");
                int rack_space = result.getInt("rack_space");
                int id_premises = result.getInt("id_premises");
                int id_client = result.getInt("id_client");
                float length = result.getFloat("length");
                float width = result.getFloat("width");
                float height = result.getFloat("height");
                float weight = result.getFloat("weight");
                Date receipt_date = result.getDate("receipt_date");
                int contract_number = result.getInt("contract_number");
                Date exp_date_of_contract = result.getDate("exp_date_of_contract");
                float humidity = result.getFloat("humidity");
                float temperature = result.getFloat("temperature");

                // переход от реляционной модели к объектной
                goods.add(new Good(id, id_rack, rack_space, id_premises, id_client,
                                   length, width, height, weight,
                                   receipt_date, contract_number, exp_date_of_contract,
                                   humidity, temperature));

                System.out.print("Good.Good: ");
                System.out.print("id = " + id);
                System.out.print(", id_rack = " + id_rack);
                System.out.print(", rack_space = " + rack_space);
                System.out.print(", id_premises = " + id_premises);
                System.out.print(", id_client = " + id_client);
                System.out.print(", length = " + length);
                System.out.print(", width = " + width);
                System.out.print(", height = " + height);
                System.out.print(", weight = " + weight);
                System.out.print(", receipt_date = \"" + receipt_date + "\"");
                System.out.print(", contract_number = " + contract_number);
                System.out.print(", exp_date_of_contract = \"" + exp_date_of_contract + "\"");
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

    public List<Good> getAll() {
        return goods;
    }
}