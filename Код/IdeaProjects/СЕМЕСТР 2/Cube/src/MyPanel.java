import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private final Cube _cube;

    public MyPanel(Cube cube) {
        this._cube = cube;
    }

    @Override
    public void paintComponent(Graphics g) {
        g = g;
        super.paintComponent(g);
    }
}