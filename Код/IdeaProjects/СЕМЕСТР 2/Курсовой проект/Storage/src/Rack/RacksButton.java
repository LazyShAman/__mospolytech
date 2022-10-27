package Rack;

import Rack.Racks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class RacksButton extends JButton implements Observer {
    private Racks racks;
    private final RacksTable racks_table;
    private String tableName = "Rack.Racks";

    public String getTableName() {
        return tableName;
    }

    public RacksButton(Racks racks, RacksTable racks_table) {
        this.setText("  Rack.Racks  ");

        RacksButtonListener listener = new RacksButtonListener();
        this.addActionListener(listener);

        this.racks = racks;
        this.racks_table = racks_table;
    }

    public void update(Observable o, Object arg) {
        racks = (Racks) o;
        racks_table.setModel(racks);
        racks_table.repaint();
    }

    private class RacksButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            racks.select();
        }
    }
}