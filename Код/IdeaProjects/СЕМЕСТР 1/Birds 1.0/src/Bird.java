import java.awt.*;

public abstract class Bird {
    protected Point p;
    protected int size = 15;
    protected Color color = Color.BLACK;

    private static int count = 0;

    // ctor
    public Bird() {
        p = new Point((int) (Math.random() * (MyFrame.activeWidth)) - MyFrame.activeWidth / 2,
                (int) (Math.random() * (MyFrame.activeHeight)) - MyFrame.activeHeight / 2);

        count++;
        System.out.println("I'm a bird!");
    }

    public void fly() // пример метода экземпляра класса
    {
        System.out.println("I'm flying!");
    }

    public static void printNum() {
        System.out.println("count = " + count);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(p.getX(), p.getY(), size, size);
    }

    public void borderline(Graphics g) { ; }
}
