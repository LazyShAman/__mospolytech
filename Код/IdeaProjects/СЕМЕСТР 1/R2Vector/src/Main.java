public class Main {
    public static void main(String[] args) {
        R2Vector v1 = new R2Vector(1, 0, 0);
        R2Vector v2 = new R2Vector(0, 1, 0);

        System.out.println(R2Vector.Scalar(v1, v2));
        System.out.println(v1.Scalar(v2));

        R2Vector v3 = v1.Vector(v2);
        v3.print();

        R2Vector v4 = R2Vector.Vector(v1, v2);
        v4.print();

        //System.out.println(v1 == v2);
        //System.out.println(v1.Equals(v2));
        //System.out.println(R2Vector.Equals(v1, v2));
        //v1.Scale(10);
        //v1.print();
        //(v1.Sum(v1)).print();
        //System.out.println(v1.Distance(v2));
        //System.out.println(R2Vector.Distance(v1, v2));

    }
}
