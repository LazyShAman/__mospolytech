// тест для выпуклой оболочки
class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        Viewer window = new Viewer(convex);

        while (true) {
            window.repaint();
            convex.add(new R2Point());

            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());

            Polygon.flag = Polygon.flag & (
                           (Polygon.I & Polygon.II & (Polygon.III || Polygon.IV || Polygon.oN)) ||
                           (Polygon.II & Polygon.III & (Polygon.I || Polygon.IV || Polygon.Po)) ||
                           (Polygon.III & Polygon.IV & (Polygon.I || Polygon.II || Polygon.oP)) ||
                           (Polygon.IV & Polygon.I & (Polygon.II || Polygon.III || Polygon.No)) ||
                           (Polygon.oP & Polygon.Po & Polygon.III) ||
                           (Polygon.Po & Polygon.oN & Polygon.II) ||
                           (Polygon.oN & Polygon.No & Polygon.I) ||
                           (Polygon.No & Polygon.oP & Polygon.IV) ||
                           (Polygon.I & Polygon.III) ||
                           (Polygon.II & Polygon.IV));

            if (Polygon.flag) {
                System.out.println("The unit circle is inside the convex hull");
            } else
                System.out.println("The unit circle is not inside the convex hull");
        }
    }
}
