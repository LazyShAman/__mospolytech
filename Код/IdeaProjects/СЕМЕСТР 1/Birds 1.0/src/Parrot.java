import java.awt.*;

public class Parrot extends Bird {
    private static int minX = MyFrame.activeWidth;
    private static int maxX = MyFrame.activeWidth * -1;
    private static int minY = MyFrame.activeHeight;
    private static int maxY = MyFrame.activeHeight * -1;

    private static int count = 0;
    private static int amount = 0;

    // переменная экземпляра класса
    private String name = "Ke$ha";

    // конструктор
    public Parrot() {
        size = 20;
        color = new Color(215, 18, 0);

        count++;
        System.out.println("I'm a parrot! There are already " + count + " of us");
    }

    public Parrot(String name) {
        size = 20;
        color = new Color(215, 18, 0);

        count++;
        // ссылка на текущий объект
        this.name = name;
        System.out.println("I'm a parrot! There are already " + count + " of us");
        System.out.println("My name is " + name);
    }

    public void speak() {
        System.out.println("My name is " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void hello(Parrot p) {
        System.out.println("Hello, " + p.name + "!");
        //System.out.println("Hello, " + p.getName() + "!");
    }

    public static void hello(Penguin p) {
        System.out.println("Hello, penguin!");
        //System.out.println("Hello, " + p.getName() + "!");
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(p.getX(), p.getY(), size, size);
    }

    @Override
    public void borderline(Graphics g) {
        amount++;

        if (p.getX() > maxX) maxX = p.getX();
        if (p.getY() > maxY) maxY = p.getY();
        if (p.getX() < minX) minX = p.getX();
        if (p.getY() < minY) minY = p.getY();

        if (amount == count)
            g.drawRect(minX, minY, maxX - minX + this.size, maxY - minY + this.size);
    }
}
