package sample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class Clients extends Observable {
    //private DBConnection connection;
    private final ArrayList<Client> clients;
    private Client client;

    public Clients() throws SQLException {
        //this.connection = new DBConnection();
        clients = new ArrayList<>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client getClient(int i) {
        return clients.get(i);
    }

    public void setClient(Client value) {
        this.client = value;
        getClients().add(client);
    }

    public int size() {
        return clients.size();
    }
}