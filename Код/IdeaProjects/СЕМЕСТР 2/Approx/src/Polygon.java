import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

// класс "Многоугольник", реализующий интерфейс фигуры
class Polygon implements Figure {
    public static boolean flag;
    public static boolean oN = false, I = false,
                          oP = false, II = false,
                          No = false, III = false,
                          Po = false, IV = false;
    private double s, p;
    private final Deque<R2Point> poly = new LinkedList<>();

    public Polygon(R2Point a, R2Point b, R2Point c) {
        poly.addFirst(b);

        if (b.light(a, c)) {
            poly.addFirst(a);
            poly.addLast(c);
        } else {
            poly.addFirst(c);
            poly.addLast(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter() {
        return p;
    }

    public double area() {
        return s;
    }

    // значения первых двух точек полигона мы узнаём за пределами цикла,
    // а затем в цикле берём новую точку, отрисовываем ребро,
    // присваиваем первой точке значение второй и так далее
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);

        R2Point A = poly.pollFirst();
        R2Point B = poly.pollFirst();

        assert A != null;
        int xA = A.getX();
        int yA = A.getY();
        assert B != null;
        int xB = B.getX();
        int yB = B.getY();

        g.drawLine(xA, yA, xB, yB);
        poly.addLast(A);
        poly.addLast(B);
        A = B;

        for (int i = poly.size(); i > 0; i--) {
            B = poly.pollFirst();
            xA = xB;
            yA = yB;
            assert B != null;
            xB = B.getX();
            yB = B.getY();

            g.drawLine(xA, yA, xB, yB);
            poly.addLast(A);
            A = B;
        }
    }

    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t) {
        int i;
        // ищем освещенные ребра, просматривая их одно за другим
        for (i = poly.size(); i > 0 && !t.light(poly.getLast(), poly.getFirst()); i--)
            poly.addLast(poly.pollFirst());

        // УТВЕРЖДЕНИЕ:
        // либо ребро [poly.getLast(), poly.getFirst()] освещено из t,
        // либо освещенных ребер нет совсем
        if (i > 0) {
            R2Point x;
            grow(poly.getLast(), poly.getFirst(), t);

            // удаляем все освещенные ребра из начала дека
            for (x = poly.pollFirst(); t.light(x, poly.getFirst()); x = poly.pollFirst())
                grow(x, poly.getFirst(), t);
            poly.addFirst(x);

            // удаляем все освещенные ребра из конца дека
            for (x = poly.pollLast(); t.light(poly.getLast(), x); x = poly.pollLast())
                grow(poly.getLast(), x, t);
            poly.addLast(x);

            // анализируем на принадлежность окружности оболочке
            flag = unitCircle(poly.getLast(), t) && unitCircle(poly.getFirst(), t) && unitCircle(t, poly.getFirst());

            // завершаем обработку добавляемой точки
            p += R2Point.dist(poly.getLast(), t) + R2Point.dist(t, poly.getFirst());
            poly.addFirst(t);
        }

        return this;
    }

    public boolean unitCircle(R2Point A, R2Point B) {
        R2Point O = new R2Point(0, 0);

        int xA = A.getX();
        int yA = A.getY();
        int xB = B.getX();
        int yB = B.getY();

        if (xA < 0) {
            if (yA < 0) III = true;
            if (yA == 0) No = true;
            if (yA > 0)  II = true;
        }

        if (xA == 0) {
            if (yA < 0)  oN = true;
            if (yA > 0)  oP = true;
        }

        if (xA > 0) {
            if (yA < 0)  IV = true;
            if (yA == 0) Po = true;
            if (yA > 0)   I = true;
        }

        double c = R2Point.dist(A, B);
        double a = R2Point.dist(O, A);
        double b = R2Point.dist(O, B);
        double p = (a + b + c) / 2;
        double h = 2 * Math.sqrt(p * (p - a) * (p - b) * (p - c)) / c;

        return !(h < 1);
    }
}
