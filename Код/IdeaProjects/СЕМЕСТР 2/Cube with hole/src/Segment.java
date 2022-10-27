// класс, реализующий одномерный отрезок
public class Segment {
    // координаты начала и конца отрезка
    private double begin, end;

    public Segment(double begin, double end) {
        this.begin = begin;
        this.end = end;
    }

    // вырожден ли отрезок?
    public final boolean degenerate() { return begin >= end; }

    // найти левый отрезок разности с отрезком s
    public final Segment leftSub(Segment s) {
        return new Segment(begin, Math.min(end, s.begin));
    }

    // найти правый отрезок разности с отрезком s
    public final Segment rightSub(Segment s) {
        return new Segment(Math.max(begin, s.end), end);
    }

    // найти пересечение с отрезком s
    public final Segment intersection(Segment s) {
        begin = Math.max(begin, s.begin);
        end = Math.min(end, s.end);
        return this;
    }

    // получить начало отрезка
    public final double getBegin() { return begin; }

    // получить конец отрезка
    public final double getEnd() { return end; }
}