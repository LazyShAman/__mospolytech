//Класс "Двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure{
    private R2Point p, q;

    public Segment(R2Point p, R2Point q){
        this.p = p;
        this.q = q;
        quadrantI(p, q);
    }

    public double perimeter(){
        return 2.0 * R2Point.dist(p, q);
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point r){
        if(R2Point.isTriangle(p, q, r)) {
            quadrantI(p, r);
            quadrantI(r, q);
            return new Polygon(p, q, r);
        }


        if(q.inside(p, r))
            q = r;

        if(p.inside(r, q))
            p = r;

        return this;
    }

    public void quadrantI(R2Point A, R2Point B) {
        int xA = A.getX();
        int yA = A.getY();
        int xB = B.getX();
        int yB = B.getY();

        if (xA > 0 && yA > 0 && xB > 0 && yB > 0) ConvexTest.I++;
    }
}
