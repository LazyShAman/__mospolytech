import java.awt.*;

// класс "Выпуклая оболочка"
class Convex {
    private Figure fig;

    public Convex() {
        fig = new Void();
    }

    public void add(R2Point p) {
        fig = fig.add(p);
    }

    public double area() {
        return fig.area();
    }

    public double perimeter() {
        return fig.perimeter();
    }

    public void draw(Graphics g) {
        fig.draw(g);
    }

    public boolean unitCircle(R2Point A, R2Point B) {
        return fig.unitCircle(A, B);
    }
}