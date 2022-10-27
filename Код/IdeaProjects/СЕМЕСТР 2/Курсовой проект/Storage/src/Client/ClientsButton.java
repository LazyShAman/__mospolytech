package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class ClientsButton extends JButton implements Observer {
    private Clients clients;
    private final ClientsTable clients_table;
    private String tableName = "Client.Client.Clients";

    public String getTableName() {
        return tableName;
    }

    public ClientsButton(Clients clients, ClientsTable clients_table) {
        this.setText(" Client.Client.Clients ");

        ClientsButtonListener listener = new ClientsButtonListener();
        this.addActionListener(listener);

        this.clients = clients;
        this.clients_table = clients_table;

        if (isSelected())
            doClick();
    }

    public void update(Observable o, Object arg) {
        clients = (Clients) o;
        clients_table.setModel(clients);
        clients_table.repaint();
    }

    private class ClientsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clients.select();
        }
    }
}