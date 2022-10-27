import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] _vertex;
    private Color _color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4, Color color){
        _vertex = new R3Vector[4];
        _vertex[0] = v1;
        _vertex[1] = v2;
        _vertex[2] = v3;
        _vertex[3] = v4;

        _color = color;
    }

    public void scale(double k){
        for(int i = 0; i < _vertex.length; i++){
            _vertex[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < _vertex.length; i++){
            _vertex[i].translate(dx, dy, dz);
        }
    }

    public  void rotate(double ux, double uy, double uz){
        for(int i = 0; i < +_vertex.length; i++){
            _vertex[i].rotate(ux, uy, uz);
        }
    }

    public void ortdraw(Graphics2D g, int t){
//        if(t == 1){
//            Path2D p = new Path2D.Double();
//
//            p.moveTo(_vertex[0].getX(), -_vertex[0].getY());
//            p.lineTo(_vertex[1].getX(), -_vertex[1].getY());
//            p.lineTo(_vertex[2].getX(), -_vertex[2].getY());
//            p.lineTo(_vertex[3].getX(), -_vertex[3].getY());
//            p.lineTo(_vertex[0].getX(), -_vertex[0].getY());
//            p.closePath();
//            g.setColor(_color);
//            //g.fill(p);
//            g.setColor(Color.BLACK);
//            g.draw(p);
//        }
        if(t == 2) {
            if(Main.buttonTransparent.isSelected()) {
                Path2D p = new Path2D.Double();

                p.moveTo(_vertex[0].getX(), -_vertex[0].getY());
                p.lineTo(_vertex[1].getX(), -_vertex[1].getY());
                p.lineTo(_vertex[2].getX(), -_vertex[2].getY());
                p.lineTo(_vertex[3].getX(), -_vertex[3].getY());
                p.lineTo(_vertex[0].getX(), -_vertex[0].getY());
                p.closePath();
                g.setColor(_color);
                g.setColor(Color.BLACK);
                g.draw(p);
            }
            if(!Main.buttonTransparent.isSelected()) {
                if (R3Vector.vect(R3Vector.toR3Vector(_vertex[0], _vertex[1]), R3Vector.toR3Vector(_vertex[1], _vertex[2])).getZ() > 0) {

                    Path2D p = new Path2D.Double();

                    p.moveTo(_vertex[0].getX(), -_vertex[0].getY());
                    p.lineTo(_vertex[1].getX(), -_vertex[1].getY());
                    p.lineTo(_vertex[2].getX(), -_vertex[2].getY());
                    p.lineTo(_vertex[3].getX(), -_vertex[3].getY());
                    p.lineTo(_vertex[0].getX(), -_vertex[0].getY());
                    p.closePath();
                    g.setColor(_color);
                    g.fill(p);
                    g.setColor(Color.BLACK);
                    g.draw(p);
                }
            }
        }
    }

    public void perspdraw(Graphics2D g, double c){
        double t0 = (c/(c - _vertex[0].getZ()));
        double t1 = (c/(c - _vertex[1].getZ()));
        double t2 = (c/(c - _vertex[2].getZ()));
        double t3 = (c/(c - _vertex[3].getZ()));

        R3Vector v0 = new R3Vector(_vertex[0].getX() * t0, _vertex[0].getY() * t0, _vertex[0].getZ());
        R3Vector v1 = new R3Vector(_vertex[1].getX() * t1, _vertex[1].getY() * t1, _vertex[1].getZ());
        R3Vector v2 = new R3Vector(_vertex[2].getX() * t2, _vertex[2].getY() * t2, _vertex[2].getZ());
        R3Vector v3 = new R3Vector(_vertex[3].getX() * t3, _vertex[3].getY() * t3, _vertex[3].getZ());

        if(Main.buttonTransparent.isSelected()) {
            //if(R3Vector.vect(R3Vector.toR3Vector(v0, v1), R3Vector.toR3Vector(v1, v2)).getZ() > 0){
            Path2D p = new Path2D.Double();
            p.moveTo(v0.getX(), -v0.getY());
            p.lineTo(v1.getX(), -v1.getY());
            p.lineTo(v2.getX(), -v2.getY());
            p.lineTo(v3.getX(), -v3.getY());
            p.lineTo(v0.getX(), -v0.getY());
            p.closePath();

            g.setColor(_color);
            //g.fill(p);
            g.setColor(Color.BLACK);
            g.draw(p);
            //}
        }
        if(!Main.buttonTransparent.isSelected()) {
            if(R3Vector.vect(R3Vector.toR3Vector(v0, v1), R3Vector.toR3Vector(v1, v2)).getZ() > 0){
                Path2D p = new Path2D.Double();
                p.moveTo(v0.getX(), -v0.getY());
                p.lineTo(v1.getX(), -v1.getY());
                p.lineTo(v2.getX(), -v2.getY());
                p.lineTo(v3.getX(), -v3.getY());
                p.lineTo(v0.getX(), -v0.getY());
                p.closePath();

                g.setColor(_color);
                g.fill(p);
                g.setColor(Color.BLACK);
                g.draw(p);
            }
        }
    }
}
