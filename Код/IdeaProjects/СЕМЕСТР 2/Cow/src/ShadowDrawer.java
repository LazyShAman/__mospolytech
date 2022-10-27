import javax.sound.sampled.Line;
import java.awt.geom.Line2D;
import java.util.*;

/**
 * @author Е.А. Роганов
 * Класс ShadowDrawer, обеспечивающий изображение проекции
 * полиэдра с удалением невидимых линий
 */
public class ShadowDrawer extends SimpleDrawer{
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
    private L1ListSegments list;

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
     * @param t Одномерная координата точки на ребре.
     * @return Трехмерная координата этой точки ребра.
     */
    private R3Vector R3(double t){
        return R3Vector.plus(R3Vector.mul((1.-t), begin), R3Vector.mul(t, end));
    }

    /**
     * Вычислить одномерный отрезок тени от грани.
     * @param f Грань полиэдра.
     * @return Отрезок тени от этой грани на ребре.
     */
    private Segment shadow(Facet f){
        if(f.vertical(pr)) return new Segment(t1, t0);

        int n = f.getVertexesQuantity();

        Vertex a = f.getVertex(n - 1);
        Vertex b = f.getVertex(0);
        Segment result = hCross(f, a);

        if(result.degenerate()) return result;

        result.intersection(vCross(a, b, f.getCenter()));

        if(result.degenerate()) return result;

        for(int i = 1; i < n; i++){
            a = b;
            b = f.getVertex(i);

            result.intersection(vCross(a, b, f.getCenter()));

            if (result.degenerate()) return result;
        }

        return result;
    }

    /**
     * Вычислить пересечение с "горизонтальным" полупространством.
     * @param f Грань полиэдра.
     * @param a Точка (вектор) на грани.
     * @return Отрезок пересечения ребра с "горизонтальным" полупростраством.
     */
    private Segment hCross(Facet f, R3Vector a){
        R3Vector n = f.getNormal();

        if (R3Vector.scalMul(n, pr) < 0.0) n.mul(-1);

        return crossWith(a, n);
    }

    /**
     * Вычислить пересечение с "вертикальным" полупространством.
     * @param a Точка (вектор) на грани.
     * @param b Точка (вектор) на грани.
     * @param c Точка (вектор) на грани.
     * @return Отрезок пересечения ребра с "вертикальным" полупространством.
     */
    private Segment vCross(R3Vector a, R3Vector b, R3Vector c){
        R3Vector n = R3Vector.vectMul(R3Vector.minus(b, a), pr);

        if (R3Vector.scalMul(n, R3Vector.minus(a, c)) < 0.0) n.mul(-1);

        return crossWith(a, n);
    }

    /**
     * Вычислить пересечение отрезка с заданным полупространством.
     * @param a Точка (вектор) на грани.
     * @param n Вектор внешней нормали к полупространству.
     * @return Отрезок пересечения ребра с полупространством.
     */
    private Segment crossWith(R3Vector a, R3Vector n){
        double f0 = R3Vector.scalMul(n, R3Vector.minus(begin, a));
        double f1 = R3Vector.scalMul(n, R3Vector.minus(end, a));

        if(Math.abs(f0) < EPSILON) f0 = 0.;
        if(Math.abs(f1) < EPSILON) f1 = 0.;
        if(f0 >= 0. && f1 >= 0.) return new Segment(t1, t0);
        if(f0 < 0.&& f1 < 0. ) return new Segment(t0, t1);

        double t =  - f0/(f1- f0);

        if(f0 < 0.) return new Segment(t0, t);

        return new Segment(t, t1);
    }

    /**
     * Учесть тень от одной грани.
     * @param f Грань, тень от которой должна быть учтена.
     */
    protected final void addShadow(Facet f){
        try{
            Segment s = shadow(f);

            if(!s.degenerate()){
                list.toFront();

                while(!list.end()){
                    Segment next = list.erase();
                    Segment left = next.leftSub(s);

                    if(!left.degenerate()){
                        list.insert(left);
                        list.forward();

                        Segment right = next.rightSub(s);

                        if(!right.degenerate()){
                            list.insert(right);
                            list.forward();
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Слишком много видимых отрезков ребра.");
            System.exit(0);
        }
    }

    /**
     * Учесть тень от всех граней.
     */
    protected void addShadow(){
        for(int j = 0; j < p.getFacetsQuantity(); j++)
            addShadow(p.getFacet(j));
    }

    /**
     * Конструктор класса.
     * @param p Полиэдр.
     * @param pr Вектор проектирования.
     * @param angle Угол поворота в плоскости проекции.
     */
    public ShadowDrawer(Polyedr p, R3Vector pr, double angle){
        super(p, pr, angle);

        list = new L1ListSegments(MAXSIZE);
    }

    /**
     * Изобразить видимую часть ребра полиэдра.
     * @param s Обрабатываемое ребро полиэдра.
     */
    public final void drawEdge(Edge s){
        begin = s.getBegin();
        end = s.getEnd();

        list.clear();

        try{
            list.insert(new Segment(t0, t1));
        }
        catch(Exception e){;}

        addShadow();

        try{
            for(list.toFront(); !list.end(); list.forward()){
                Segment u = list.after();
                R3Vector begin = R3(u.getBegin());
                R3Vector end= R3(u.getEnd());
                draw(xnProection(begin), ynProection(begin), xnProection(end), ynProection(end));
            }
        }
        catch(Exception e){;}

        System.out.print(".");
    }

    double DELTA = 0.0001;
    private boolean arePointsEquals(double x1, double y1, double x2, double y2) {
        if(Math.abs(x1-x2) < DELTA && Math.abs(y1-y2) < DELTA)
            return true;
        return false;
    }

    public final void contour(){
        ArrayList<double[]> proection = new ArrayList<>();
        for(int i = 0; i < p.getEdgesQuantity(); i++) {
            Edge s = p.getEdge(i);

            begin = s.getBegin();
            end = s.getEnd();

            list.clear();

            try{
                list.insert(new Segment(t0, t1));
            }
            catch(Exception e){;}

            addShadow();

            try{
                for(list.toFront(); !list.end(); list.forward()){
                    Segment u = list.after();
                    R3Vector begin = R3(u.getBegin());
                    R3Vector end= R3(u.getEnd());
                    proection.add(new double[]{xnProection(begin), ynProection(begin), xnProection(end), ynProection(end)});
                }
            }
            catch(Exception e){;}
        }

       /* ArrayList<double[]> tmp = new ArrayList<>();
        for(double[] c : proection) {
            for(double[] s : proection) {
                if(c != s &&
                        !arePointsEquals(c[0], c[1], s[0], s[1]) && !arePointsEquals(c[2], c[3], s[2], s[3]) &&
                        !arePointsEquals(c[2], c[3], s[0], s[1]) && !arePointsEquals(c[2], c[3], s[0], s[1]) &&
                        Line2D.linesIntersect(c[0], c[1],c[2],c[3], s[0], s[1],s[2], s[3])) {
                    double[] i = findIntersection(c[0], c[1],c[2],c[3], s[0], s[1],s[2], s[3]);
                    if(!arePointsEquals(c[0], c[1], i[0], i[1])) {
                        tmp.add(new double[]{c[0], c[1], i[0], i[1]});
                    }
                    if(!arePointsEquals(c[2], c[3], i[0], i[1])) {
                        tmp.add(new double[]{c[2], c[3], i[0], i[1]});
                    }
                    if(!arePointsEquals(s[0], s[1], i[0], i[1])) {
                        tmp.add(new double[]{s[0], s[1], i[0], i[1]});
                    }
                    if(!arePointsEquals(s[2], s[3], i[0], i[1])) {
                        tmp.add(new double[]{s[2], s[3], i[0], i[1]});
                    }
                }
            }
        }*/
        //proection.addAll(tmp);

        ArrayList<double[]> contour = new ArrayList<>();
        for(double[] c : proection) {
            if(isPoitnOnEdge(c[0], c[1], proection) && isPoitnOnEdge(c[2], c[3], proection)) {
                boolean isExist = false;
                for(double[] s : contour) {
                    if(arePointsEquals(c[0], c[1], s[2], s[3]) && arePointsEquals(c[2], c[3], s[0], s[1]))
                        isExist = true;
                    if(arePointsEquals(c[0], c[1],s[0], s[1]) && arePointsEquals(c[2], c[3], s[2], s[3]))
                        isExist = true;
                }
                if(!isExist)
                    contour.add(c);
            }
        }

        double perim = 0;
        for(double[] c : contour) {
            perim += Math.sqrt(Math.pow(c[0]-c[2], 2) + Math.pow(c[1] - c[3], 2));
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            draw(c[0], c[1], c[2], c[3]);
        }



        System.out.print("PERIMETER=" + perim);
    }

    public static double[] findIntersection(double x1, double y1, double x2, double y2,
                                             double x3, double y3, double x4, double y4) {
        double a1 = y1 - y2;
        double b1 = x2 - x1;
        double c1 = a1 * x2 + b1 * y2;

        double a2 = y3 - y4;
        double b2 = x4 - x3;
        double c2 = a2 * x4 + b2 * y4;

        double delta = a1 * b2 - a2 * b1;
        return new double[]{(b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta};
    }

    private boolean isPoitnOnEdge(double x, double y, ArrayList<double[]> segmnts) {
        boolean isMinX = true, isMaxX = true;
        for(double[] s : segmnts) {
            if(Line2D.linesIntersect(-10000, y, 10000, y, s[0], s[1], s[2], s[3])) {
                double[] i = findIntersection(-10000, y, 10000, y, s[0], s[1], s[2], s[3]);

                if(/*(Double.isNaN(i[0]) && (x > s[0] || x > s[2])) || */x > i[0] && Math.abs(x - i[0]) > DELTA)
                    isMinX = false;
                if(/*(Double.isNaN(i[0]) && (x < s[1] || x < s[3])) ||*/ x < i[0] && Math.abs(x - i[0]) > DELTA)
                    isMaxX = false;
            }
        }

        boolean isMinY = true, isMaxY = true;
        for(double[] s : segmnts) {
            if(Line2D.linesIntersect(  x,-10000,x, 10000, s[0], s[1], s[2], s[3])) {
                double[] i = findIntersection( x,-10000,x, 10000, s[0], s[1], s[2], s[3]);

                if(/*(Double.isNaN(i[0]) && (y > s[1] || y > s[3])) || */y > i[1] && Math.abs(y - i[1]) > DELTA)
                    isMinY = false;
                if(/*(Double.isNaN(i[0]) && (y < s[1] || y < s[3])) || */y < i[1] && Math.abs(y - i[1]) > DELTA)
                    isMaxY = false;
            }
        }
        if(isMinX || isMaxX || isMinY || isMaxY)
            return true;
        return false;
    }
}