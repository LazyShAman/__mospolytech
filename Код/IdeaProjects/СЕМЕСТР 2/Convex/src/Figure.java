//Интерфейс, задающий новый тип - фигуру.
interface Figure{
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void quadrantI(R2Point A, R2Point B);
}