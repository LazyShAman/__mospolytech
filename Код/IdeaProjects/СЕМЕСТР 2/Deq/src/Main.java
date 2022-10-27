public class Main {
    public static void main(String[] args) throws Exception {
        Deq deq1 = new Deq(5);
        deq1.pushFront(5);
        deq1.pushBack(3);
        deq1.pushBack(4);
        deq1.pushFront(1);
        deq1.pushFront(9);
        deq1.popFront();
        deq1.pushFront(72);

        System.out.println(deq1.getSize());

        for (int i = 0; i < deq1.getSize(); i++) {
            int val = deq1.popFront();
            deq1.pushBack(val);
            System.out.print(" " + val);
        }
        System.out.println();
        for (int i = 0; i < deq1.getSize(); i++) {
            int val = deq1.popBack();
            deq1.pushFront(val);
            System.out.print(" " + val);
        }
    }
}
