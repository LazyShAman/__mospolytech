import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;

public class DeleteButton extends JButton implements Observer {
    private DefaultTableModel model;
    private JTable table = new JTable(model);

    public DeleteButton(JTable table, DefaultTableModel model) {
        this.setText(" Client.Client.Clients ");

        DeleteButton.DeleteButtonListener listener = new DeleteButton.DeleteButtonListener();
        this.addActionListener(listener);

        this.model = model;
        //this.clients_table = clients_table;
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //table.delete();
        }
    }
}

