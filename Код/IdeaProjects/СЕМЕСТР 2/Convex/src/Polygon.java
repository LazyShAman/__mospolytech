//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends Deq implements Figure{
    private double s, p;
    private int counter;

    public Polygon(R2Point a, R2Point b, R2Point c){
        pushFront(b);

        if (b.light(a, c)){
            pushFront(a);
            pushBack(c);
        }
        else{
            pushFront(c);
            pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = length(); i>0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow(back(), front(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            R2Point last = popBack();
            pushBack(last);
            R2Point first = popFront();
            pushFront(first);

            counter = 0;
            quadrantI(last, t);
            quadrantI(t, first);
            quadrantI(last, first);
            if (counter == 3)
                ConvexTest.I -= 2;

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }

        return this;
    }

    public void quadrantI(R2Point A, R2Point B) {
        int xA = A.getX();
        int yA = A.getY();
        int xB = B.getX();
        int yB = B.getY();

        if (xA > 0 && yA > 0 && xB > 0 && yB > 0) {
            ConvexTest.I++;
            counter++;
        }
    }
}