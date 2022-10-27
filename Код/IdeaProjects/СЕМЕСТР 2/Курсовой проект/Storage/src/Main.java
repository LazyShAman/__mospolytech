import Good.Goods;
import Good.GoodsButton;
import Good.GoodsTable;
import Premises.Premisess;
import Premises.PremisessButton;
import Premises.PremisessTable;
import Rack.Racks;
import Rack.RacksButton;
import Rack.RacksTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        this.setTitle("Storage");
        this.setSize(700, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(55, 135, 154));

        Container basic_pane = this.getContentPane();
        basic_pane.setLayout(new BoxLayout(basic_pane, BoxLayout.Y_AXIS));

        Container button_pane = new Container();
        button_pane.setLayout(new BoxLayout(button_pane, BoxLayout.X_AXIS));

        Container action_pane = new Container();
        action_pane.setLayout(new BoxLayout(action_pane, BoxLayout.X_AXIS));

        DBConnection connection = new DBConnection();

        Goods goods = new Goods(connection); // Model
        GoodsTable goods_table = new GoodsTable(goods); // View
        GoodsButton goods_button = new GoodsButton(goods, goods_table); // Controller
        buttonMaker(goods_button);

        Racks racks = new Racks(connection);
        RacksTable racks_table = new RacksTable(racks);
        RacksButton racks_button = new RacksButton(racks, racks_table);
        buttonMaker(racks_button);

        Premisess premisess = new Premisess(connection);
        PremisessTable premisess_table = new PremisessTable(premisess);
        PremisessButton premisess_button = new PremisessButton(premisess, premisess_table);
        buttonMaker(premisess_button);

        Clients clients = new Clients(connection); // Model
        ClientsTable clients_table = new ClientsTable(clients); // View
        ClientsButton clients_button = new ClientsButton(clients, clients_table); // Controller
        buttonMaker(clients_button);

        DeleteButton delete = new DeleteButton((JTable) clients_table, (DefaultTableModel) clients);

        basic_pane.add(goods_table);
        basic_pane.add(racks_table);
        basic_pane.add(premisess_table);
        basic_pane.add(clients_table);

        button_pane.add(goods_button);

        button_pane.add(racks_button);

        button_pane.add(premisess_button);

        button_pane.add(clients_button);

        //action_pane.add(delete);

        button_pane.setSize(new Dimension(320, 50));
        basic_pane.add(button_pane);
        basic_pane.add(action_pane);

        goods.addObserver(goods_button);
        racks.addObserver(racks_button);
        premisess.addObserver(premisess_button);
        clients.addObserver(clients_button);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args){
        new Main();
    }

    public static void buttonMaker(JButton button) {
        button.setFont(new Font("Consolas", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(244, 122, 85));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        button.setBounds(10, 10, 60, 60);

    }
}