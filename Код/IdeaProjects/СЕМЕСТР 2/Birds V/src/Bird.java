import java.awt.*;

public abstract class Bird {
    private static int num = 0;
    protected int x;
    protected int y;
    protected int size;
    protected Color color;
    protected Point _p;

    public Bird(){

        _p = new Point((int)(Math.random()*(MyFrame.width_work)) - MyFrame.width_work/2,
                (int)(Math.random()*(MyFrame.height_work)) - MyFrame.height_work/2);

        num++;
        //x = (int) (Math.random() * (MyFrame.width_work)) - MyFrame.width_work/2;
        //y = (int) (Math.random() * (MyFrame.height_work)) - MyFrame.height_work/2;

        System.out.println("Я птица. Нас уже " + num + " шт.");
    }

    public void fly(){
        System.out.println("Я лечу");
    }

    public static void printNum(){
        System.out.println("num = " + num);
    }

    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillOval(_p.getx(), _p.gety(), size, size);
    }
    public void borderline(Graphics graphics){

    }
    //public void hello(){}
}