package Good;

import Good.Goods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class GoodsButton extends JButton implements Observer {
    private Goods goods;
    private final GoodsTable goods_table;
    private String tableName = "Good.Goods";

    public String getTableName() {
        return tableName;
    }

    public GoodsButton(Goods goods, GoodsTable goods_table) {
        this.setText("  Good.Goods  ");

        GoodsButtonListener listener = new GoodsButtonListener();
        this.addActionListener(listener);

        this.goods = goods;
        this.goods_table = goods_table;
    }

    public void update(Observable o, Object arg) {
        goods = (Goods) o;
        goods_table.setModel(goods);
        goods_table.repaint();
    }

    private class GoodsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            goods.select();
        }
    }
}