public class Main {
    public static void main(String[] args) {

        Parrot p1 = new Parrot();
        /*p1.fly();
        p1.speak();
        p1.setName("Попугай");
        p1.speak();
        System.out.println(p1.getName());
        */
        Parrot p2 = new Parrot("Gosha");
        //p2.speak();
        //Bird p3 = new Parrot();

        //p3.fly();
        //Parrot p4 = p1;
        //p4.speak();
        Penguin p5 = new Penguin();
        /*Penguin k1 = new Penguin();
        k1.printNum();
        Bird.printNum();
        System.out.println(k1 instanceof Penguin);
        System.out.println(k1 instanceof Bird);
        System.out.println(k1 instanceof Object);

         */
        p5.hello(p1);
        /*
        p1.hello(p2);
        p1.hello(p1);
        p1.hello(p5);
        p5.hello(p1);

         */
        /*ArrayList<Bird> flock = new ArrayList<>();
        flock.add(p1);
        flock.add(p5);
        for(int i = 0; i < flock.size(); i++){
            flock.get(i).fly();
        }
         */
        Group g1 = new Group();
        Group g2 = new Group();
        g1.add(p1);
        g1.add(p2);
        g1.add(p5);
        //g1.add(p3);
        //g1.fly();
        g2.add(p5);
        g1.union(g2);
        g1.fly();
        g1.add(new Sparrow());
        MyFrame window = new MyFrame(g1);

    }
}
