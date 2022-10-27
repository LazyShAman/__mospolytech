import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static final int width = 400;
    public static final int height = 400;
    public static final int margin = 20; //отступ в процентах

    public static final int activeWidth = width * (100 - margin) / 100;
    public static final int activeHeight = height * (100 - margin) / 100;

    private Group group;
    public MyFrame(Group group){
        this.group = group;
        this.setSize(width,height);
        this.setTitle("Qqq");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        // смещение оси координат в центр экрана
        g.translate(MyFrame.width / 2, MyFrame.height / 2);

        g.setColor(Color.YELLOW);
        g.drawRect(-activeWidth / 2, -activeHeight / 2, width - activeWidth / 4, height - activeHeight / 4);

        g.setColor(Color.PINK);
        g.drawLine(0, MyFrame.height / 2, 0, -MyFrame.height);
        g.drawLine(-MyFrame.width / 2, 0, MyFrame.width / 2, 0);

        group.draw(g);
    }
}