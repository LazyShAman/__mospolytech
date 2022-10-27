import java.awt.*;

public class Penguin extends Bird{

    private static int min_x = MyFrame.width_work;
    private static int max_x = MyFrame.width_work * -1;
    private static int min_y = MyFrame.height_work;
    private static int max_y = MyFrame.width_work * -1;
    private static int num = 0;
    private static int count = 0;

    public Penguin(){
        size = 20;
        color = new Color(0, 0, 0);
        num++;
        System.out.println("Я пингвин. Нас уже " + num + " шт.");
    }
    @Override
    public void fly(){
        System.out.println("Я не умею летать");
    }
    public void hello(Parrot p){
        System.out.println("Привет, " + p.getName() + "!");
    }
    public void hello(Penguin p){
        System.out.println("Привет, Пингвин");
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillOval(x, y, size, size);
        graphics.setColor(Color.WHITE);
        graphics.fillOval(x + size/4, y + size/4, size/2, size/2);
    }

    @Override
    public void borderline(Graphics graphics){
        graphics.setColor(Color.RED);
        count++;
        //------------------------------------ Не трогай убьет ------------------------------
        if(num > 1) {
            //System.out.println("x = " + x);
            //System.out.println("y = " + y);
            if(_p.getx() > max_x)
                max_x = _p.getx();
            if (min_x > _p.getx())
                min_x = _p.getx();
            if(_p.gety() > max_y)
                max_y = _p.gety();
            if(_p.gety() < min_y)
                min_y = _p.gety();

            if(count == num) {
                graphics.drawRect(min_x, min_y, max_x - min_x + size, max_y - min_y + size);
            }
            //else graphics.drawLine(x, y, x, y);
        }
        else
            graphics.drawRect(_p.getx(), _p.gety(), size, size);
    }
}
