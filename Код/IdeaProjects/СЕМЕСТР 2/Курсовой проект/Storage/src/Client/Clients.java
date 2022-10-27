package Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Clients extends Observable {
    private Connection connection;
    private List<Client> clients;

    public Clients(DBConnection connection) {
        this.connection = connection.getConnection();
        clients = new ArrayList<>();
    }

    public void select() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, legal_entity_name, bank_details FROM Clients";
            ResultSet result = statement.executeQuery(query);

            clients.clear();
            while (result.next()) {
                int id = result.getInt("id");
                String legal_entity_name = result.getString("legal_entity_name");
                String bank_details = result.getString("bank_details");

                // переход от реляционной модели к объектной
                clients.add(new Client(id, legal_entity_name, bank_details));

                System.out.print("Client.Client: ");
                System.out.print("id = " + id);
                System.out.print(", legal_entity_name = \"" + legal_entity_name + "\"");
                System.out.println(", bank_details = \"" + bank_details + "\".");
            }
            System.out.println("--------");

            //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers(obj);
    }

    public void delete(JTable table, DefaultTableModel model) {
        table = ClientsTable.getTable();
        model = ClientsTable.getModel();

        try {
            Statement statement = connection.createStatement();
            String query = "DELETE id, legal_entity_name, bank_details FROM Clients WHERE ";

            while (table.isRowSelected(table.getSelectedRow())) {
                int currentRow = table.getSelectedRow();
                int id = (int) table.getValueAt(currentRow, 1);
                table.remove(currentRow);
                model.removeRow(currentRow);
                query += "id = '" + id + "'";

                java.sql.PreparedStatement ps = connection.prepareStatement(query);

                ps.executeUpdate();
            }

            //connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.setChanged();
        this.notifyObservers(); //this.notifyObservers(obj);
    }

    public List<Client> getAll() {
        return clients;
    }
}