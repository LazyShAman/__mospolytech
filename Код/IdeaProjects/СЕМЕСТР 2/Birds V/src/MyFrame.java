import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private Group group;
    private static final int width = 400;
    private static final int height = 400;
    private static final int margin = 20; //Отступ в %

    public static final int width_work = width * (100 - margin)/100;
    public static final int height_work = height * (100 - margin)/100;

    public MyFrame(Group group){
        this.group = group;

        setSize(width, height);
        setTitle("птицы");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setVisible(true);

    }
    @Override
    public void paint(Graphics g){
        /*g.setColor(new Color(255,0,0));
        g.drawLine(0,0, 40, 40);
        g.drawOval(40, 40, 80, 80);
        g.setColor(Color.ORANGE);
        g.fillOval(120, 120, 80, 80);
         */
        g.translate(MyFrame.width / 2, MyFrame.height / 2);
        g.setColor(Color.BLACK);
        //g.drawLine(MyFrame.width/2, 0, MyFrame.width/2, MyFrame.height);
        //g.drawLine(0, MyFrame.height/2, MyFrame.width, MyFrame.height/2);

        g.drawLine(0, MyFrame.height/2, 0, -MyFrame.height);
        g.drawLine(-MyFrame.width/2, 0, MyFrame.width/2, 0);
        group.draw(g);
        g.drawLine(-MyFrame.width/2*(100-margin)/100,MyFrame.height/2*(100-margin)/100,
                MyFrame.width/2*(100-margin)/100,MyFrame.height/2*(100-margin)/100);
        g.drawLine(MyFrame.width/2*(100-margin)/100,-MyFrame.height/2*(100-margin)/100,
                MyFrame.width/2*(100-margin)/100,MyFrame.height/2*(100-margin)/100);
        g.drawLine(MyFrame.width/2*(100-margin)/100,-MyFrame.height/2*(100-margin)/100,
                -MyFrame.width/2*(100-margin)/100,-MyFrame.height/2*(100-margin)/100);
        g.drawLine(-MyFrame.width/2*(100-margin)/100,MyFrame.height/2*(100-margin)/100,
                -MyFrame.width/2*(100-margin)/100,-MyFrame.height/2*(100-margin)/100);
        //g.drawPolygon();

    }
}