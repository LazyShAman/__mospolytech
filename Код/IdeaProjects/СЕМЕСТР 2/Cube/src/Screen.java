import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    private final Cube _cube;

    public int _width = 500;
    public int _height = 500;

    public Screen(Cube cube) {
        _cube = cube;
        this.setDoubleBuffered(true);
        this.setSize(_width, _height);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        g2d.translate(_width / 2, _height / 2);

        if (Main.buttontype == 2)
            _cube.ortdraw(g2d, true);
        if (Main.buttontype == 3)
            _cube.perspdraw(g2d, _height);
    }
}
