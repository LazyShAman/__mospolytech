public class MyClassTest {
    private final int attr;

    public MyClassTest(int attr) {
        this.attr = attr;
    }

    public int getAttr() {
        return attr;
    }

    public int div(int a) {
        return this.attr / a;
    }

    public static int min(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }
}
