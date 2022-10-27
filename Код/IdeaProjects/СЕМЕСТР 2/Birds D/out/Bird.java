import java.awt.*;

public abstract class Bird {
    protected Point p;
    protected int size = 15;
    protected  Color color = Color.BLACK;
    private static int num = 0;
    public Bird()//Конструктор
    {
        //x = (int)(Math.random() * (MyFrame.width_work)) - MyFrame.width_work/2;
        //y = (int)(Math.random() * (MyFrame.height_work)) - MyFrame.height_work/2;
        p = new Point((int)(Math.random() * (MyFrame.width_work)) - MyFrame.width_work/2,
                (int)(Math.random() * (MyFrame.height_work)) - MyFrame.height_work/2);
        num++;
        System.out.println("Я птица!");
    }
    public void fly()//Пример метода экземпляра класса
    {
        System.out.println("Я лечу!");
    }
    public void speak()
    {
        ;
    }
    public static void printNum(){
        System.out.println("num = " + num);
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(p.get_x(),p.get_y(),size,size);
    }
    public void cage(Graphics g){

    }
}
