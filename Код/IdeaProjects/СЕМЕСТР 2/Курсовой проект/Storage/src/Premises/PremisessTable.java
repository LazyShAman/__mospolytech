package Premises;

import Premises.Premises;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PremisessTable extends JPanel {
    private Premisess premisess;
    private JScrollPane pane;
    private JTable table;
    private DefaultTableModel model;

    public PremisessTable(Premisess premisess){
        this.premisess = premisess;
        model = new DefaultTableModel(new String[]{"ID", "Name", "Useful volume",
                                                   "Humidity", "Temperature"}, 0);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        pane = new JScrollPane(table);
        this.add(pane);
    }

    public void setModel(Premisess premisess){
        model = new DefaultTableModel(new String[]{"ID", "Name", "Useful volume",
                                                   "Humidity", "Temperature"}, 0);
        List<Premises> p = premisess.getAll();
        for (Premises premises : p) {
            model.addRow(new String[]{String.valueOf(premises.getId()), premises.getName(),
                    String.valueOf(premises.getUseful_volume()),
                    String.valueOf(premises.getHumidity()), String.valueOf(premises.getTemperature())});
        }
        table.setModel(model);
    }
}