import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static final int width = 400;
    public static final int height = 400;
    public static final int margin = 20; //отступ в процентах

    public static final int width_work = width * (100 - margin)/100;
    public static final int height_work = height * (100 - margin)/100;

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
        /*g.setColor(new Color(255,0,0));
        g.drawLine(0,0,40,40);
        g.drawOval(40,40,80,80);
        g.setColor(Color.ORANGE);
        g.fillOval(120,120,80,80);*/

        g.setColor(Color.BLACK);


        //g.drawLine(MyFrame.width/2,0,MyFrame.width/2,MyFrame.height);
        //g.drawLine(0,MyFrame.height/2,MyFrame.width,MyFrame.height/2);
        g.translate(MyFrame.width/2,MyFrame.height/2);

        g.drawLine(MyFrame.width_work/2,MyFrame.height_work/2,MyFrame.width_work/2,-MyFrame.height_work/2);
        g.drawLine(MyFrame.width_work/2,MyFrame.height_work/2,-MyFrame.width_work/2,MyFrame.height_work/2);
        g.drawLine(-MyFrame.width_work/2,-MyFrame.height_work/2,-MyFrame.width_work/2,MyFrame.height_work/2);
        g.drawLine(-MyFrame.width_work/2,-MyFrame.height_work/2,MyFrame.width_work/2,-MyFrame.height_work/2);


        g.drawLine(0,MyFrame.height/2,0,-MyFrame.height/2);
        g.drawLine(-MyFrame.width/2,0,MyFrame.width/2,0);
        group.draw(g);

    }
}