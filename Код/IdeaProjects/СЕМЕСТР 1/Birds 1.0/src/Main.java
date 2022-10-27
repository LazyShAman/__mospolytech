public class Main {
    public static void main(String[] args)
    {
        Parrot p1 = new Parrot();
        Parrot p2 = new Parrot("Pugo");

        Penguin pn1 = new Penguin();

        Group g1 = new Group();
        Group g2 = new Group();

        g1.add(p1);
        g1.add(p2);
        g1.add(pn1);
        for (int i = 0; i < 5; i++)
            g1.add(new Sparrow());

        g2.add(pn1);

        g1.union(g2);

        MyFrame frame = new MyFrame(g1);
    }
}
