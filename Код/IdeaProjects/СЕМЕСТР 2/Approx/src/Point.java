import java.awt.*;

// класс "Одноугольник", реализующий интерфейс фигуры
class Point implements Figure {
    private final R2Point p;

    public Point(R2Point p) {
        this.p = p;
    }

    public double perimeter() {
        return 0.0;
    }

    public double area() {
        return 0.0;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(p.getX(), p.getY(), 5, 5);
    }

    public Figure add(R2Point q) {
        if (!R2Point.equal(p, q))
            return new Segment(p, q);
        else
            return this;
    }

    public boolean unitCircle(R2Point A, R2Point B) { return false; }
}