package Client;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClientsTable extends JPanel {
    private Clients clients;
    private JScrollPane pane;
    private static JTable table;
    private static DefaultTableModel model;

    public static JTable getTable() {
        return table;
    }
    public static DefaultTableModel getModel() {
        return model;
    }

    public ClientsTable(Clients clients){
        this.clients = clients;
        model = new DefaultTableModel(new String[]{"ID", "Legal entity name", "Bank details"}, 0);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        pane = new JScrollPane(table);
        this.add(pane);
    }

    public void setModel(Clients clients){
        model = new DefaultTableModel(new String[]{"ID", "Legal entity name", "Bank details"}, 0);
        List<Client> p = clients.getAll();
        for (Client client : p) {
            model.addRow(new String[]{String.valueOf(client.getId()),
                    client.getLegal_entity_name(), client.getBank_details()});
        }
        table.setModel(model);
    }
}