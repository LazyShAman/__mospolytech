// класс, реализующий односвязный список отрезков

public class L1ListSegments {
    // массив отрезков
    private final Segment[] array;

    // массив ссылок
    private final int[] next;

    // нил списка
    private final int nilList;

    // нил свободного места
    private final int nilFree;

    // элемент до указателя
    private int before;

    // элемент за указателем
    private int after;

    public L1ListSegments(int size) {
        array = new Segment[size]; // аргумент size - максимальный размер списка
        next = new int[size + 2];

        nilList = size;
        nilFree = size + 1;

        link(nilList, nilList);
        link(nilFree, 0);

        for (int i = 0; i < size - 1; i++)
            link(i, i + 1);

        link(size - 1, nilFree);

        before = after = nilList;
    }

    // связать два элемента
    private void link(int first, int second) {
        next[first] = second;
    }

    // захватить место
    private int mallocIndex() {
        int index = next[nilFree];
        link(nilFree, next[index]);
        return index; //Индекс занимаемого места.
    }

    // освободить место
    private void freeIndex(int index) {
        link(index, next[nilFree]);
        link(nilFree, index);
    }

    // пуст ли список?
    public final boolean empty() {
        return next[nilList] == nilList;
    }

    // сделать список пустым
    public final void clear() {
        try {
            toFront();
            while (true)
                erase();
        } catch (Exception e) {
        }
    }

    // передвинуть указатель в начало списка
    public final void toFront() {
        before = nilList;
        after = next[nilList];
    }

    // указатель в конце списка?
    public final boolean end() {
        return after == nilList;
    }

    // передвинуть указатель вперед
    public final void forward() throws Exception {
        // исключительная ситуация возникает при попытке
        // передвинуть вперед указатель, находящийся в конце списка

        if (after == nilList) throw new Exception();

        before = after;
        after = next[after];
    }

    // получить элемент за указателем
    public final Segment after() throws Exception {
        // исключительная ситуация возникает при попытке
        // получить элемент за указателем, находящимся в конце списка

        return array[after];
    }

    // добавить элемент (отрезок, сегмент) за указателем
    public final void insert(Segment val) throws Exception {
        //Исключетельная ситуация возникает при попытке
        //добавить элемент в заполненный до конца список.

        int index = mallocIndex();

        link(before, index);
        link(index, after);
        after = index;

        array[index] = val;
    }

    // удалить элемент за указателем
    public final Segment erase() throws Exception {
        // исключительная ситуация возникает при попытке
        // удалить элемент из пустого списка

        Segment val = array[after];

        int index = after;
        after = next[index];
        link(before, after);

        freeIndex(index);

        return val;
    }
}