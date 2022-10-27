package Premises;

import Premises.Premisess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class PremisessButton extends JButton implements Observer {
    private Premisess premisess;
    private final PremisessTable premisess_table;
    private String tableName = "Premises";

    public String getTableName() {
        return tableName;
    }

    public PremisessButton(Premisess premisess, PremisessTable premisess_table) {
        this.setText("Premises.Premisess");

        PremisessButtonListener listener = new PremisessButtonListener();
        this.addActionListener(listener);

        this.premisess = premisess;
        this.premisess_table = premisess_table;
    }

    public void update(Observable o, Object arg) {
        premisess = (Premisess) o;
        premisess_table.setModel(premisess);
        premisess_table.repaint();
    }

    private class PremisessButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            premisess.select();
        }
    }
}