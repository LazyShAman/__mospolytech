import java.awt.*;

public class Cube {
    public Facet[] _facets;

    public Cube(){
        _facets = new Facet[6];

        // дальняя грань, в плоскость XY
        _facets[0] = new Facet(new R3Vector(0,0,0),
                new R3Vector(0,1,0),
                new R3Vector(1,1,0),
                new R3Vector(1,0,0),
                Color.RED); // new Color (255, 0 ,0 )

        //передняя грань, в плоскость XY(верхняя грань)
        _facets[1] = new Facet(new R3Vector(0,1,1),
                new R3Vector(0,0,1),
                new R3Vector(1,0,1),
                new R3Vector(1,1,1),
                Color.BLUE);

        _facets[2] = new Facet(new R3Vector(0,1,0),
                new R3Vector(0,1,1),
                new R3Vector(1,1,1),
                new R3Vector(1,1,0),
                Color.BLACK);

        _facets[3] = new Facet(new R3Vector(0,0,0),
                new R3Vector(1,0,0),
                new R3Vector(1,0,1),
                new R3Vector(0,0,1),
                Color.YELLOW);

        _facets[4] = new Facet(new R3Vector(0,1,0),
                new R3Vector(0,0,0),
                new R3Vector(0,0,1),
                new R3Vector(0,1,1),
                Color.GREEN);

        _facets[5] = new Facet(new R3Vector(1,1,0),
                new R3Vector(1,1,1),
                new R3Vector(1,0,1),
                new R3Vector(1,0,0),
                Color.WHITE);
    }

    public void scale(double k){
        for(int i = 0; i < _facets.length; i++){
            _facets[i].scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for(int i = 0; i < _facets.length; i++){
            _facets[i].translate(dx, dy, dz);
        }
    }

    public void rotate(double ux, double uy, double uz){
        for(int i = 0; i < _facets.length; i++){
            _facets[i].rotate(ux, uy, uz);
        }
    }

    public void ortdraw(Graphics2D g, int t){
        for(int i = 0; i < _facets.length; i++){
            _facets[i].ortdraw(g, t);
        }
    }

    public void perspdraw(Graphics2D g, double c){
        for(int i = 0; i < _facets.length; i++){
            _facets[i].perspdraw(g, c);
        }
    }
}
