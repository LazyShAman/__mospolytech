import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{
    public Cube _c;

    public int _width = 480;
    public int _height = 450;
    private double c;

    public Screen(Cube cube){
        _c = cube;
        this.setDoubleBuffered(true); // для JPanel
        this.setSize(_width, _height);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        g2d.translate(_width/2, _height/2);
        if (Main.function == 2){
            _c.ortdraw(g2d, 2);
        }
        if(Main.function == 3){
            _c.perspdraw(g2d, _height);
        }
    }

}
