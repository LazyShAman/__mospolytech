import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private Counter counter;
    private String str;

    public MyPanel(Counter counter) {
        this.counter = counter;
        str = "0";

        this.setBackground(Color.YELLOW);
    }

    public void setStr(int counter) {
        this.str = "" + counter;
    }

    @Override
    public void paintComponent(Graphics g){
        g = (Graphics2D) g;
        super.paintComponent(g);
        g.drawString(str,20,20);
    }
}
