import java.awt.*;

public class Parrot extends Bird{
    private String name = "Kesha";//Пример переменной экземпляра класса
    private static int num = 0;
    private static int call = 0;
    private static int min_x = MyFrame.width_work;
    private static int max_x = MyFrame.width_work * -1;
    private static int min_y = MyFrame.height_work;
    private static int max_y = MyFrame.width_work * -1;
    public Parrot()
    {
        size = 10;
        color = new Color(0,255,0);
        num++;
        System.out.println("Я попугай! Нас уже "+ num + "шт.");
    }
    public Parrot(String name)
    {
        size = 10;
        color = new Color(0,255,0);
        num++;
        this.name = name;
        System.out.println("Я попугай");
    }
    public void speak()
    {
        System.out.println("Меня зовут " + name + "!");
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void hello(Penguin p)
    {
        //System.out.println("Привет, "+ p.getName()+"!");
        System.out.println("Привет, Пингвин");
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(p.get_x(),p.get_y(),size,size);
    }
    @Override
    public void cage(Graphics g) {
        g.setColor(Color.ORANGE);
        call++;
        if (num > 1) {
            if (p.get_x() > max_x){
                max_x = p.get_x();
            }
            if (p.get_x() < min_x){
                min_x = p.get_x();
            }
            if (p.get_y() > max_y){
                max_y = p.get_y();
            }
            if (p.get_y() < min_y){
                min_y = p.get_y();
            }
            if (call == num){
                g.drawRect(min_x, min_y, max_x - min_x + size, max_y - min_y + size);
            }
        }
        else {
            g.drawRect(p.get_x(), p.get_y(), size, size);
        }
    }
}
