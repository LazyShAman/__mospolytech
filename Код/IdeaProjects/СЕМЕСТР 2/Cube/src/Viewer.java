import javax.swing.*;
import java.awt.*;

// представление состояния модели
public class Viewer extends JFrame {
    private final Cube _c;

    private final int _width = 450;
    private final int _height = 300;

    public Viewer(Cube c) {
        _c = c;
        //this.setDoubleBuffered(true); // для JPanel
        this.setSize(_width, _height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        g2d.translate(_width / 2, _height / 2);
        _c.ortdraw(g2d, true);
        //_c.perspdraw(g2d);
    }
}
