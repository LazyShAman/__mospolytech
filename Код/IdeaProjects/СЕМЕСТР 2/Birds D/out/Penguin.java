import java.awt.*;

public class Penguin extends Bird{
    private static int min_x = MyFrame.width_work;
    private static int max_x = MyFrame.width_work * -1;
    private static int min_y = MyFrame.height_work;
    private static int max_y = MyFrame.width_work * -1;
    private static int num = 0;
    private static int call = 0;
    public Penguin()
    {
        size = 20;
        color = new Color(0,0,0);
        num++;
        System.out.println("Я пингвин! Нас уже "+ num + "шт.");
    }
    @Override
    public void fly()
    {
        System.out.println("Я не умею летать!");
    }

    public void hello(Penguin p)
    {
        System.out.println("");
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(p.get_x(),p.get_y(),size,size);
        //color = new Color(255,255,255);
        g.setColor(Color.WHITE);
        /*size = size/2;
        x += size/2;
        y += size/2;
        g.setColor(color);*/
        g.fillOval(p.get_x() + size/4,p.get_y() + size/4,size/2,size/2);
    }
    @Override
    public void cage(Graphics g){
        g.setColor(Color.BLUE);
        call++;
        if (num > 1) {
            if (p.get_x() > max_x) {
                max_x = p.get_x();
            }
            if (p.get_x() < min_x) {
                min_x = p.get_x();
            }
            if (p.get_y() > max_y) {
                max_y = p.get_y();
            }
            if (p.get_y() < min_y) {
                min_y = p.get_y();
            }
            if(this.call == this.num){
                g.drawRect(this.min_x, this.min_y, this.max_x - this.min_x + this.size, this.max_y - this.min_y + this.size);
            }
        } else {
            g.drawRect(p.get_x(), p.get_y(), this.size, this.size);
        }

    }
}