public class Main {

    public static void main(String[] args) {

        LinkedListm<Integer> ll = new LinkedListm();

        for (int i = 0; i < 5; i++) {
            ll.append(new Node<>(i));
        }

        ll.toFront();

        for (int i = 0; i < 5; i++) {
            System.out.println(ll.get());
        }
        System.out.println("\n\n");

        ll.remove(2);

        ll.toFront();
        for (int i = 0; i < 4; i++) {
            System.out.println(ll.get());
        }

        ////////////////////////////////
        System.out.println("\n\n");
        ll.insert(new Node<>(5), 3);

        ll.toFront();
        for (int i = 0; i < 5; i++) {
            System.out.println(ll.get());
        }


        /*
        System.out.println(ll.get());
        System.out.println(ll.get());
        System.out.println(ll.get());
        System.out.println(ll.get());
        System.out.println(ll.get());
        System.out.println(ll.get());

        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        */
        //LinkedList<Integer> lll = new LinkedList<>();

        //lll.add(2);


    }
}
