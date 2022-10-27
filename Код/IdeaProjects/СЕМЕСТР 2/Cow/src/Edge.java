//Класс, реализующий ребро полиэдра.
public class Edge{
    //Начало ребра.
    private Vertex begin;

    //Конец ребра.
    private Vertex end;

    public Edge(Vertex begin, Vertex end){
        this.begin = begin;
        this.end = end;
    }

    //Получить начало ребра.
    public final Vertex getBegin(){
        return begin;
    }

    //Получить конец ребра.
    public final Vertex getEnd(){
        return end;
    }
}