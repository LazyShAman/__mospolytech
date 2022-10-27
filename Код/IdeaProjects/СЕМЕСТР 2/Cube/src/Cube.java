import java.awt.*;
import java.util.Observable;

public class Cube extends Observable {
    private Facet[] _facets;

    public Cube() {
        _facets = new Facet[6];

        //дальняя грань в плоскости XY
        _facets[0] = new Facet(new R3Vector(0, 0, 0),
                               new R3Vector(0, 1, 0),
                               new R3Vector(1, 1, 0),
                               new R3Vector(1, 0, 0),
                               Color.RED);

        //передняя грань
        _facets[1] = new Facet(new R3Vector(0, 1, 1),
                               new R3Vector(0, 0, 1),
                               new R3Vector(1, 0, 1),
                               new R3Vector(1, 1, 1),
                               Color.YELLOW);

        //верхняя грань
        _facets[2] = new Facet(new R3Vector(0, 1, 0),
                               new R3Vector(0, 1, 1),
                               new R3Vector(1, 1, 1),
                               new R3Vector(1, 1, 0),
                               Color.GREEN);

        //нижняя грань
        _facets[3] = new Facet(new R3Vector(0, 0, 0),
                               new R3Vector(1, 0, 0),
                               new R3Vector(1, 0, 1),
                               new R3Vector(0, 0, 1),
                               Color.CYAN);

        //левая боковая грань в плоскости YZ
        _facets[4] = new Facet(new R3Vector(0, 1, 0),
                               new R3Vector(0, 0, 0),
                               new R3Vector(0, 0, 1),
                               new R3Vector(0, 1, 1),
                               Color.BLUE);

        //правая боковая грань
        _facets[5] = new Facet(new R3Vector(1, 1, 0),
                               new R3Vector(1, 1, 1),
                               new R3Vector(1, 0, 1),
                               new R3Vector(1, 0, 0),
                               Color.MAGENTA);
    }

    public void scale(double k) {
        for (Facet facet : _facets) {
            facet.scale(k);
        }
    }

    public void translate(double dx, double dy, double dz) {
        for (Facet facet : _facets) {
            facet.translate(dx, dy, dz);
        }
    }

    public void rotate(double ux, double uy, double uz) {
        for (Facet facet : _facets) {
            facet.rotate(ux, uy, uz);
        }
    }

    public void ortdraw(Graphics2D g, boolean flag) {
        for (Facet facet : _facets) {
            facet.ortdraw(g, flag);
        }
    }

    public void perspdraw(Graphics2D g, double c) {
        for (Facet facet : _facets) {
            facet.perspdraw(g, c);
        }
    }
}
