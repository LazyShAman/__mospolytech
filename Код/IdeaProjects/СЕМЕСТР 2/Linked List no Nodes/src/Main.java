public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList();

        for (int i = 0; i < 5; i++) {
            ll.append(new Node(i + 1));
        }

        Node n9 = new Node<>(9);
        Node n72 = new Node<>(72);

        ll.remove(3);
        //ll.insert(n9, 1);
        //ll.insert(n72, 3);
        //System.out.println(ll.find(n72) + "\n");

        int i = 0;
        while (ll.node(i) != null) {
            System.out.println(ll.node(i));
            i++;
        }
        System.out.println("\n\n");
    }
}
