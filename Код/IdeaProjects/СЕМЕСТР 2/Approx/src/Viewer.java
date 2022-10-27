import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    public static final int width = 400;
    public static final int height = 400;
    public static final int margin = 20; // отступ в процентах

    public static final int activeWidth = width * (100 - margin) / 100;
    public static final int activeHeight = height * (100 - margin) / 100;

    private final Convex con;

    public Viewer(Convex con) {
        this.con = con;
        this.setSize(width, height);
        this.setTitle("WINDOWs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // смещение оси координат в центр экрана
        g.translate(Viewer.width / 2, Viewer.height / 2);

        g.setColor(Color.PINK);
        g.drawLine(0, Viewer.height / 2, 0, -Viewer.height);
        g.drawLine(-Viewer.width / 2, 0, Viewer.width / 2, 0);


        con.draw(g);
    }
}
