// класс, реализующий ребро полиэдра
public class Edge {
    // начало ребра
    private final Vertex begin;

    // конец ребра
    private final Vertex end;

    public Edge(Vertex begin, Vertex end) {
        this.begin = begin;
        this.end = end;
    }

    // получить начало ребра
    public final Vertex getBegin() { return begin; }

    // получить конец ребра
    public final Vertex getEnd() { return end; }
}