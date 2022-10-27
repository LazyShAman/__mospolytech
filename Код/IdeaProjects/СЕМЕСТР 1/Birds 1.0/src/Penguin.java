import java.awt.*;

public class Penguin extends Bird {
    private static int minX = MyFrame.activeWidth;
    private static int maxX = MyFrame.activeWidth * -1;
    private static int minY = MyFrame.activeHeight;
    private static int maxY = MyFrame.activeHeight * -1;
    private static int count = 0;
    private static int amount = 0;

    public Penguin() {
        size = 20;
        color = new Color(0, 0, 0);

        count++;
        System.out.println("I'm a penguin! There are already " + count + " of us");
    }

    @Override
    public void fly() {
        System.out.println("Я не умею летать!");
    }

    public void hello(Penguin p) {
        System.out.println();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(p.getX(), p.getY(), size, size);
        g.setColor(Color.WHITE);
        g.fillOval(p.getX() + size / 4, p.getY() + size / 4, size / 2, size / 2);
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