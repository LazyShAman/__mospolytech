class Stack{
    private static final int DEFSIZE = 16;
    private final char[] _array;
    private int _head;

    public Stack(int capacity) {
        _array = new char[capacity];
        _head = 0;
    }

    public Stack() {
        this(DEFSIZE);
    }

    // is stack empty?
    public boolean empty() {
        return _head == 0;
    }

    // to make stack empty
    public void clear() {
        _head = 0;
    }

    // to add new element on the top of the stack
    public void push(char val) throws Exception {
        _array[_head++] = val;
    }

    // to remove last element from the top of the stack
    public int pop() throws Exception {
        return _array[--_head];
    }

    // to get last element of the stack
    public int top() throws Exception {
        return _array[_head - 1];
    }

    // to get the size of the stack
    public int getSize() {
        return _head;
    }
}

