// класс, обеспечивающий изображение проекции полиэдра
public class SimpleDrawer extends SwingDrawer {
    // полиэдр
    protected Polyedr p;

    // единичный вектор проектирования
    protected R3Vector pr;

    // единичный x-вектор плоскости проектирования
    private R3Vector x;

    // единичный y-вектор плоскости проектирования
    private R3Vector y;

    // минимальная x-координата проекции полиэдра
    private double xmin;

    // минимальная y-координата проекции пролиэдра
    private double ymin;

    // размер проекции полиэдра
    private double size;

    public int counter() { return p.getEdgesQuantity()/2; }

    public SimpleDrawer(Polyedr p, R3Vector pr, double angle) {
        // аргумент angle - угол поворота в плоскости проекции

        this.p = p;
        this.pr = pr.normalize();

        double a = pr.getX();
        double b = pr.getY();
        double c = pr.getZ();

        if (a != 0. || b != 0.) {
            x = new R3Vector(-b, a, 0.);
        } else {
            x = new R3Vector(0., c, -b);
        }

        y = R3Vector.vectMul(x, pr);

        x.normalize();
        y.normalize();

        R3Vector nx = R3Vector.plus(R3Vector.mul(Math.cos(angle), x), R3Vector.mul(-Math.sin(angle), y));
        R3Vector ny = R3Vector.plus(R3Vector.mul(Math.sin(angle), x), R3Vector.mul(Math.cos(angle), y));

        // новые значения с учётом поворота
        x = nx;
        y = ny;

        // поиск максимальных и минимальных значений x и y на экране
        xmin = ymin = Double.MAX_VALUE;
        double xmax, ymax;
        xmax = ymax = Double.MIN_VALUE;
        for (int i = 0; i < p.getVertexesQuantity(); i++) {
            double xi = xProection(p.getVertex(i));
            double yi = yProection(p.getVertex(i));

            if (xi < xmin) xmin = xi;
            if (yi < ymin) ymin = yi;
            if (xi > xmax) xmax = xi;
            if (yi > ymax) ymax = yi;
        }

        size = ymax - ymin;
        if (xmax - xmin > size)
            size = xmax - xmin;
    }

    // вычислить x-координату проекции точки
    private double xProection(R3Vector v) {
        return R3Vector.scalMul(v, x);
    }

    // вычислить y-координату проекции точки
    private double yProection(R3Vector v) {
        return R3Vector.scalMul(v, y);
    }

    // вычислить нормализованную x-координату проекции точки
    protected double xnProection(R3Vector v) {
        return (xProection(v) - xmin) / size;
    }

    // вычислить нормализованную y-координату проекции точки
    protected double ynProection(R3Vector v) {
        return (yProection(v) - ymin) / size;
    }

    // изобразить проекцию полиэдра
    public final void draw() {
        for (int i = 0; i < p.getEdgesQuantity(); i++)
            drawEdge(p.getEdge(i));

        System.out.print("\n");
    }

    // изобразить ребро полиэдра
    public void drawEdge(Edge s) {
        Vertex begin = s.getBegin();
        Vertex end = s.getEnd();

        draw(xnProection(begin), ynProection(begin), xnProection(end), ynProection(end));
        System.out.print(".");
    }

    public static void maxArea() {
        double Smax = 0.;
        for (double area : Polyedr.areas)
            if (area > Smax) Smax = area;

        /*for (int i = 0; i < p.getFacetsQuantity(); i++) {
            if (Polyedr.areas[i] == Smax) {
                int n = Polyedr.facets[i].getVertexesQuantity();
                for (int k = 0; k < n-1; k++) {
                    draw(xnProection(Polyedr.vertexes[k]), ynProection(Polyedr.vertexes[k]),
                         xnProection(Polyedr.vertexes[k+1]), ynProection(Polyedr.vertexes[k+1]));
                }
            }
        }*/

        System.out.println("Max area is " + Smax);
    }
}