import java.awt.*;

// класс "Нульугольник", реализующий интерфейс фигуры
class Void implements Figure {
    public double perimeter() {
        return 0.0;
    }

    public double area() {
        return 0.0;
    }

    public Figure add(R2Point p) {
        return new Point(p);
    }

    public void draw(Graphics g) { }

    public boolean unitCircle(R2Point A, R2Point B) { return false; }
}