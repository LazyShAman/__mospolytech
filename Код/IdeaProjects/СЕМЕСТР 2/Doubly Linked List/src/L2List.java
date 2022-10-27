public class L2List {
    private final static int DEFSIZE = 16;
    private final int[] _array; // array of elements
    private final int[] _next; // array of links
    private final int[] _prev; // array of links in reverse
    private final int _nilList; // "Nil" of list
    private final int _nilFree; // "Nil" of free space
    private int _before; // index of element before the cursor
    private int _after; // index of element after the cursor

    public L2List(int capacity) {
        _array = new int[capacity];
        _next = new int[capacity + 2];
        _prev = new int[capacity + 2];

        _nilList = capacity;
        _nilFree = capacity + 1;

        link(_nilList, _nilList);
        link(_nilFree, 0);
        for (int i = 0; i < capacity - 1; i++)
            link(i, i + 1);
        link(capacity - 1, _nilFree);

        _before = _after = _nilList;
    }

    public L2List() {
        this(DEFSIZE);
    }

    // to connect 2 elements, declared by indexes
    private void link(int first, int second) {
        _next[first] = second;
        _prev[second] = first;
    }

    // to seize place
    private int mallocIndex() {
        int index = _next[_nilFree];
        link(_nilFree, _next[index]);

        return index;
    }

    // to empty place
    private void freeIndex(int index) {
        link(index, _next[_nilFree]);
        link(_nilFree, index);

        //link(index, _prev[_nilFree]);
    }

    // is list empty?
    public boolean empty() {
        return _next[_nilList] == _nilList;
    }

    // to make list empty
    public void clear() {
        try {
            toFront();
            while (true)
                eraseBack();
        } catch (Exception e) {
        }
    }

    // to move the cursor to the head of the list
    public void toFront() {
        _before = _nilList;
        _after = _next[_nilList];
    }

    // to move the cursor to the tail of the list
    public void toBack() {
        _after = _nilList;
        _before = _prev[_nilList];
    }

    // is the cursor at the head of the list?
    public boolean begin() {
        return _before == _nilList;
    }

    // is the cursor at the tail of the list?
    public boolean end() {
        return _after == _nilList;
    }

    // to move the cursor forward
    public void forward() throws Exception {
        if (_after == _nilList)
            throw new Exception();

        _before = _after;
        _after = _next[_after];
    }

    // to move the cursor backward
    public void backward() throws Exception {
        if (_before == _nilList)
            throw new Exception();

        _after = _before;
        _before = _prev[_before];
    }

    // to get the element after the cursor
    public int after() throws Exception {
        return _array[_after];
    }

    // to get the element before the cursor
    public int before() throws Exception {
        return _array[_before];
    }

    // to add an element after the cursor
    public void insertBack(int val) {
        int index = mallocIndex();

        link(_before, index);
        link(index, _after);
        _after = index;
        _array[index] = val;
    }

    // to add an element before the cursor
    public void insertFront(int val) {
        int index = mallocIndex();

        link(_after, index);
        link(index, _before);
        _before = index;
        _array[index] = val;
    }

    // to delete the element after the cursor
    public int eraseBack() throws Exception {
        int val = _array[_after];
        int index = _after;

        _after = _next[index];
        link(_before, _after);
        freeIndex(index);

        return val;
    }

    // to delete the element before the cursor
    public int eraseFront() throws Exception {
        int val = _array[_before];
        int index = _before;

        _before = _prev[index];
        link(_after, _before);
        freeIndex(index);

        return val;
    }
}
