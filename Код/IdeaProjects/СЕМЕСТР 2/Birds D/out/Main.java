public class Main {
    public static void main(String[] args)
    {
        /*//Bird b = new Bird();
        //b.fly();
        */
        Parrot p1 = new Parrot();/*
        Parrot p2 = new Parrot();
        //p1.fly();
        p1.speak();
        p1.name = "noKesha";
        p1.speak();
        p1.setName("Kek");
        p1.speak();
        System.out.println(p1.getName());
        */Parrot p2 = new Parrot("Gosha");/*
        p2.speak();
        Bird p3 = new Parrot();
        Parrot p4 = p1;
        p4.speak();
        p1.speak();
        p4.setName("Qqq");
        */
        Penguin p5 = new Penguin();
        //p5.fly();
        //Penguin k1 = new Penguin();
        /*k1.printNum();
        Bird.printNum();

        System.out.println(k1 instanceof Penguin);
        System.out.println(k1 instanceof Bird);
        System.out.println(k1 instanceof Object);

        Bird[] arr = {p2,p5,k1};
        for (int i=0;i< arr.length;i++)
        {
            arr[i].fly();
        }*/
        //p1.hello(p2);
        //p1.hello(p1);
        //p1.hello(p5);
        Group g1 = new Group();
        Group g2 = new Group();
        g1.add(p1);
        g1.add(p2);
        g1.add(p5);
        //g1.fly();
        g2.add(p5);
        //g2.add(k1);
        g1.union(g2);
        //g1.fly();
        g1.add(new Sparrow());
        g1.add(new Sparrow());g1.add(new Sparrow());g1.add(new Sparrow());g1.add(new Sparrow());g1.add(new Sparrow());
        //g1.union(g2);
        //g1.add(new Penguin());g1.add(new Penguin());g1.add(new Penguin());
        MyFrame frame = new MyFrame(g1);
    }
}
