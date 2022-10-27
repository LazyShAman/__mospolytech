//Класс, реализующий грань полиэдра.
public class Facet{
    //Массив вершин полиэдра, принадлежащих грани.
    private Vertex[] vertexes;

    //Центр грани.
    private R3Vector center;

    //Вектор нормали к грани.
    private R3Vector normal;

    public Facet(Vertex[] vertexes){
        this.vertexes = vertexes;

        normal = R3Vector.vectMul(R3Vector.minus(vertexes[1], vertexes[0]), R3Vector.minus(vertexes[2], vertexes[0]));

        center = new R3Vector(0.,0.,0.);
        for(int i = 0; i < vertexes.length; i++){
            center.plus(vertexes[i]);
        }
        center.mul(1./(double)vertexes.length);
    }

    //Получить количество вершин.
    public final int getVertexesQuantity(){
        return vertexes.length;
    }

    //Получить вершину с номером i.
    public final Vertex getVertex(int i){
        return vertexes[i];
    }

    //Получить центр грани.
    public final R3Vector getCenter(){
        return center;
    }

    //Получить нормаль к грани.
    public final R3Vector getNormal(){
        return normal;
    }

    //Является ли грань "вертикальной"?
    public final boolean vertical(R3Vector pr){
        //Аргумент pr - вектор проектирования.
        return R3Vector.scalMul(normal, pr) == 0.;
    }
}
