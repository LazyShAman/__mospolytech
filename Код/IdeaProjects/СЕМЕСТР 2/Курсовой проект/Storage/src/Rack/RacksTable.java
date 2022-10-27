package Rack;

import Rack.Rack;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RacksTable extends JPanel {
    private Racks racks;
    private JScrollPane pane;
    private JTable table;
    private DefaultTableModel model;

    public RacksTable(Racks racks){
        this.racks = racks;
        model = new DefaultTableModel(new String[]{"ID", "Length", "Width", "Height", "Max total load",
                                                   "Number of storages", "ID Premises.Premises", "ID Client.Client"}, 0);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        pane = new JScrollPane(table);
        this.add(pane);
    }

    public void setModel(Racks racks){
        model = new DefaultTableModel(new String[]{"ID", "Length", "Width", "Height", "Max total load",
                                                   "Number of storages", "ID Premises.Premises", "ID Client.Client"}, 0);
        List<Rack> p = racks.getAll();
        for (Rack rack : p) {
            model.addRow(new String[]{String.valueOf(rack.getId()),
                    String.valueOf(rack.getLength()), String.valueOf(rack.getWidth()),
                    String.valueOf(rack.getHeight()), String.valueOf(rack.getMax_total_load()),
                    String.valueOf(rack.getNumber_of_storages()),
                    String.valueOf(rack.getId_premises()), String.valueOf(rack.getId_client())});
        }
        table.setModel(model);
    }
}