/**
 * @author Е.А. Роганов
 * Класс ShadowDrawer, обеспечивающий изображение проекции
 * полиэдра с удалением невидимых линий
 */
public class ShadowDrawer extends SimpleDrawer {

    /**
     * Флаг, определяющий целостность ребра.
     */
    public boolean flag = true;

    /**
     * Начало изображаемого ребра.
     */
    protected R3Vector begin;

    /**
     * Конец изображаемого ребра.
     */
    protected R3Vector end;

    /**
     * Максимальный размер списка.
     */
    private static final int MAXSIZE = 128;

    /**
     * Односвязный список видимых отрезков ребра.
     */
    private final L1ListSegments list;

    /**
     * Достаточно малая константа, предназначенная для
     * решения проблемы неточного представления действительных
     * чисел на ЭВМ.
     */
    private static final double EPSILON = 1.e-12;

    /**
     * Одномерная координата начала обрабатываемого ребра.
     */
    private static final double t0 = 0.;

    /**
     * Одномерная координата конца обрабатываемого ребра.
     */
    private static final double t1 = 1.;

    /**
     * Вычислить пространственные координаты точки ребра,
     * заданной одномерной координатой.
     *
     * @param t Одномерная координата точки на ребре.
     * @return Трехмерная координата этой точки ребра.
     */
    private R3Vector R3(double t) {
        return R3Vector.plus(R3Vector.mul((1. - t), begin), R3Vector.mul(t, end));
    }

    /**
     * Вычислить одномерный отрезок тени от грани.
     *
     * @param f Грань полиэдра.
     * @return Отрезок тени от этой грани на ребре.
     */
    private Segment shadow(Facet f) {
        if (f.vertical(pr)) return new Segment(t1, t0);

        int n = f.getVertexesQuantity();

        Vertex a = f.getVertex(n - 1);
        Vertex b = f.getVertex(0);
        Segment result = hCross(f, a);

        if (result.degenerate()) return result;

        result.intersection(vCross(a, b, f.getCenter()));

        if (result.degenerate()) return result;

        for (int i = 1; i < n; i++) {
            a = b;
            b = f.getVertex(i);

            result.intersection(vCross(a, b, f.getCenter()));

            if (result.degenerate()) return result;
        }

        return result;
    }

    /**
     * Вычислить пересечение с "горизонтальным" полупространством.
     *
     * @param f Грань полиэдра.
     * @param a Точка (вектор) на грани.
     * @return Отрезок пересечения ребра с "горизонтальным" полупростраством.
     */
    private Segment hCross(Facet f, R3Vector a) {
        R3Vector n = f.getNormal();

        if (R3Vector.scalMul(n, pr) < 0.0) n.mul(-1);

        return crossWith(a, n);
    }

    /**
     * Вычислить пересечение с "вертикальным" полупространством.
     *
     * @param a Точка (вектор) на грани.
     * @param b Точка (вектор) на грани.
     * @param c Точка (вектор) на грани.
     * @return Отрезок пересечения ребра с "вертикальным" полупространством.
     */
    private Segment vCross(R3Vector a, R3Vector b, R3Vector c) {
        R3Vector n = R3Vector.vectMul(R3Vector.minus(b, a), pr);

        if (R3Vector.scalMul(n, R3Vector.minus(a, c)) < 0.0) n.mul(-1);

        return crossWith(a, n);
    }

    /**
     * Вычислить пересечение отрезка с заданным полупространством.
     *
     * @param a Точка (вектор) на грани.
     * @param n Вектор внешней нормали к полупространству.
     * @return Отрезок пересечения ребра с полупространством.
     */
    private Segment crossWith(R3Vector a, R3Vector n) {
        double f0 = R3Vector.scalMul(n, R3Vector.minus(begin, a));
        double f1 = R3Vector.scalMul(n, R3Vector.minus(end, a));

        if (Math.abs(f0) < EPSILON) f0 = 0.;
        if (Math.abs(f1) < EPSILON) f1 = 0.;
        if (f0 >= 0. && f1 >= 0.) return new Segment(t1, t0);
        if (f0 < 0. && f1 < 0.) return new Segment(t0, t1);

        double t = -f0 / (f1 - f0);

        if (f0 < 0.) return new Segment(t0, t);

        return new Segment(t, t1);
    }

    /**
     * Учесть тень от одной грани.
     *
     * @param f Грань, тень от которой должна быть учтена.
     */
    protected final void addShadow(Facet f) {
        try {
            Segment s = shadow(f);

            if (!(s.getBegin() == s.getEnd()))
                flag = false;

            if (!s.degenerate()) {
                list.toFront();

                while (!list.end()) {
                    Segment next = list.erase();
                    Segment left = next.leftSub(s);

                    if (!left.degenerate()) {
                        list.insert(left);
                        list.forward();

                        Segment right = next.rightSub(s);

                        if (!right.degenerate()) {
                            list.insert(right);
                            list.forward();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Слишком много видимых отрезков ребра.");
            System.exit(0);
        }
    }

    /**
     * Учесть тень от всех граней.
     */
    protected void addShadow() {
        for (int j = 0; j < p.getFacetsQuantity(); j++)
            addShadow(p.getFacet(j));
    }

    /**
     * Конструктор класса.
     *
     * @param p     Полиэдр.
     * @param pr    Вектор проектирования.
     * @param angle Угол поворота в плоскости проекции.
     */
    public ShadowDrawer(Polyedr p, R3Vector pr, double angle) {
        super(p, pr, angle);

        list = new L1ListSegments(MAXSIZE);
    }

    /**
     * Изобразить видимую часть ребра полиэдра.
     *
     * @param s Обрабатываемое ребро полиэдра.
     */
    public final void drawEdge(Edge s) {
        begin = s.getBegin();
        end = s.getEnd();

        list.clear();

        try {
            list.insert(new Segment(t0, t1));
        } catch (Exception e) { }

        flag = true;

        addShadow();

        if (!flag) {
            // поскольку одно ребро принадлежит сразу двум граням
            p.findAndDelete(begin, end);
            p.findAndDelete(begin, end);
        }

        try {
            for (list.toFront(); !list.end(); list.forward()) {
                Segment u = list.after();
                R3Vector begin = R3(u.getBegin());
                R3Vector end = R3(u.getEnd());
                draw(xnProection(begin), ynProection(begin), xnProection(end), ynProection(end));
            }
        } catch (Exception e) { }

        System.out.print(".");
    }
}