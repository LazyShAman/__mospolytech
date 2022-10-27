package Good;

import Good.Good;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GoodsTable extends JPanel {
    private Goods goods;
    private JScrollPane pane;
    private JTable table;
    private DefaultTableModel model;

    public GoodsTable(Goods goods){
        this.goods = goods;
        model = new DefaultTableModel(new String[]{"ID", "ID Rack.Rack", "Rack.Rack space", "ID Premises.Premises", "ID Client.Client",
                                                   "Length", "Width", "Height", "Weight",
                                                   "Receipt date", "Contract number", "Exp. date of contract",
                                                   "Humidity", "Temperature"}, 0);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 100));
        pane = new JScrollPane(table);
        this.add(pane);
    }

    public void setModel(Goods goods){
        model = new DefaultTableModel(new String[]{"ID", "ID Rack.Rack", "Rack.Rack space", "ID Premises.Premises", "ID Client.Client",
                                                   "Length", "Width", "Height", "Weight",
                                                   "Receipt date", "Contract number", "Exp. date of contract",
                                                   "Humidity", "Temperature"}, 0);
        List<Good> p = goods.getAll();
        for (Good good : p) {
            model.addRow(new String[]{String.valueOf(good.getId()),
                    String.valueOf(good.getId_rack()), String.valueOf(good.getRack_space()),
                    String.valueOf(good.getId_premises()), String.valueOf(good.getId_client()),
                    String.valueOf(good.getLength()), String.valueOf(good.getWidth()),
                    String.valueOf(good.getHeight()), String.valueOf(good.getWeight()),
                    String.valueOf(good.getReceipt_date()), String.valueOf(good.getContract_number()),
                    String.valueOf(good.getExp_date_of_contract()),
                    String.valueOf(good.getHumidity()), String.valueOf(good.getTemperature())});
        }
        table.setModel(model);
    }
}