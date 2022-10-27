import java.awt.*;

public class Sparrow extends Bird {
    private static int minX = MyFrame.activeWidth;
    private static int maxX = MyFrame.activeWidth * -1;
    private static int minY = MyFrame.activeHeight;
    private static int maxY = MyFrame.activeHeight * -1;
    private static int count = 0;
    private static int amount = 0;

    public Sparrow() {
        size = 10;
        color = new Color(95, 41, 5);

        count++;
        System.out.println("I'm a sparrow! There are " + count + " of us!");
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
