import java.awt.*;

public class Parrot extends Bird {
    private static int num = 0;
    private String name = "Kesha";
    private static int count = 0;
    private static int min_x = MyFrame.width_work;
    private static int max_x = MyFrame.width_work * -1;
    private static int min_y = MyFrame.height_work;
    private static int max_y = MyFrame.width_work * -1;
    public Parrot(){
        //x = (int) (Math.random()*MyFrame.width);
        //y = (int) (Math.random()*MyFrame.height);
        size = 10;
        color = new Color(255, 0, 0);
        num++;
        System.out.println("Я попугай. Нас уже " + num + " шт.");
    }
    public Parrot(String name){
        size = 10;
        color = new Color(255, 0, 0);
        num++;
        this.name = name;
        System.out.println("Я попугай. Нас уже " + num + " шт.");
    }
    public void speak(){
        System.out.println("Меня зовут " + name);
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void hello(Parrot p){
        System.out.println("Привет, " + p.name + "!");
    }
    public void hello(Penguin p){
        System.out.println("Привет, Пингвин");
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillOval(x, y, size, size);
    }
    @Override
    public void borderline(Graphics graphics){
        graphics.setColor(Color.BLUE);
        count++;
        //for(int i = 0; i < num; i++)
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
            /*System.out.println("maxx = " + maxx);
            System.out.println("minx = " + minx);
            System.out.println("maxy = " + maxy);
            System.out.println("miny = " + miny);

             */
            if(count == num) {

                graphics.drawRect(min_x, min_y, max_x - min_x + size, max_y - min_y + size);
            }
            //else graphics.drawLine(x, y, x, y);

        }
        else
            graphics.drawRect(_p.getx(), _p.gety(), size, size);
    }
}
