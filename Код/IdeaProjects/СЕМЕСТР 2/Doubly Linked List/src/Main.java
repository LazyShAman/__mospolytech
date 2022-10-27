public class Main {
    public static void main(String[] args) throws Exception {
        L2List list2 = new L2List();
        list2.insertFront(15);
        list2.insertFront(14);
        list2.insertFront(13);
        list2.insertFront(12);
        list2.insertFront(11);

        list2.toFront();
        for (int i = 0; i < 5; i++) {
            list2.forward();
            System.out.print(list2.before() + " ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            list2.backward();
            System.out.print(list2.after() + " ");
        }
    }
}
