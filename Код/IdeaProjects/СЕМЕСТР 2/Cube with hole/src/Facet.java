// класс, реализующий грань полиэдра
public class Facet {
    // массив вершин полиэдра, принадлежащих грани
    private final Vertex[] vertexes;

    // центр грани
    private final R3Vector center;

    // вектор нормали к грани
    private final R3Vector normal;

    public Facet(Vertex[] vertexes) {
        this.vertexes = vertexes;

        normal = R3Vector.vectMul(R3Vector.minus(vertexes[1], vertexes[0]), R3Vector.minus(vertexes[2], vertexes[0]));

        center = new R3Vector(0., 0., 0.);
        for (int i = 0; i < vertexes.length; i++) {
            center.plus(vertexes[i]);
        }
        center.mul(1. / (double) vertexes.length);
    }

    // получить количество вершин
    public final int getVertexesQuantity() { return vertexes.length; }

    // получить вершину с номером i
    public final Vertex getVertex(int i) { return vertexes[i]; }

    // получить центр грани
    public final R3Vector getCenter() { return center; }

    // получить нормаль к грани
    public final R3Vector getNormal() { return normal; }

    // является ли грань "вертикальной"?
    public final boolean vertical(R3Vector pr) {
        //Аргумент pr - вектор проектирования.
        return R3Vector.scalMul(normal, pr) == 0.;
    }
}