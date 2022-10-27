import java.awt.*;

// интерфейс, задающий новый тип - фигуру
interface Figure {
    double perimeter();

    double area();

    Figure add(R2Point p);

    void draw(Graphics g);

    boolean unitCircle(R2Point A, R2Point B);
}
