import java.util.Scanner;

// класс, реализующий радиус-вектор в трехмерном пространстве
public class R3Vector {
    // координаты вектора
    private double x, y, z;

    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public R3Vector() throws Exception {
        // исключительная ситуация, возникающая при ошибках
        // ввода координат с клавиатуры

        Scanner in = new Scanner(System.in);

        System.out.print("x-координата вектора проектирования -> ");
        x = in.nextInt();
        System.out.print("\n");

        System.out.print("y-координата вектора проектирования -> ");
        y = in.nextInt();
        System.out.print("\n");

        System.out.print("z-координата вектора проектирования -> ");
        z = in.nextInt();
        System.out.print("\n");
    }

    // получить x-координату вектора
    public final double getX() { return x; }

    // получить y-координату вектора
    public final double getY() { return y; }

    // получить z-координату вектора
    public final double getZ() { return z; }


    // нормировать ненулевой вектор
    public final R3Vector normalize() {
        // длина радиус-вектора
        double norm = Math.sqrt(x * x + y * y + z * z);
        // единичные векторы
        x /= norm;
        y /= norm;
        z /= norm;
        return this;
    }

    // найти сумму двух векторов
    public static R3Vector plus(R3Vector a, R3Vector b) {
        return new R3Vector(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    // добавить заданный вектор
    public final R3Vector plus(R3Vector b) {
        x += b.x;
        y += b.y;
        z += b.z;
        return this;
    }

    // найти разность двух векторов
    public static R3Vector minus(R3Vector a, R3Vector b) {
        return new R3Vector(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    // вычесть заданный вектор
    public final R3Vector minus(R3Vector b) {
        x -= b.x;
        y -= b.y;
        z -= b.z;
        return this;
    }

    // найти произведение вектора на число
    public static R3Vector mul(double k, R3Vector a) {
        return new R3Vector(k * a.x, k * a.y, k * a.z);
    }

    // умножить вектор на заданное число
    public final R3Vector mul(double k) {
        x *= k;
        y *= k;
        z *= k;
        return this;
    }

    // найти скалярное произвдение векторов
    public static double scalMul(R3Vector a, R3Vector b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    // найти векторное произведение векторов
    public static R3Vector vectMul(R3Vector a, R3Vector b) {
        return new R3Vector(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }
}