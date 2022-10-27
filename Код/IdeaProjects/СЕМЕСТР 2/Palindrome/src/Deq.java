public class Deq {
    private final int[] _array;
    private int _size, _head, _tail;

    public Deq(int capacity) {
        _array = new int[capacity];
        clear();
    }

    public boolean empty() {
        return _size == 0;
    }

    public void clear() {
        _size = _head = 0;
        _tail = _array.length - 1;
    }

    public void pushFront(int val) {
        _array[_head = backward(_head)] = val;
        _size++;
    }

    public void pushBack(int val) {
        _array[_tail = forward(_tail)] = val;
        _size++;
    }

    public int popFront() throws Exception {
        int val = front();
        _head = forward(_head);
        _size -= 1;

        return val;
    }

    public int popBack() throws Exception {
        int val = back();
        _tail = backward(_tail);
        _size -= 1;

        return val;
    }

    public int front() throws Exception {
        if (empty())
            throw new Exception();

        return _array[_head];
    }

    public int back() throws Exception {
        if (empty())
            throw new Exception();

        return _array[_tail];
    }

    private int forward(int index) {
        return ++index < _array.length ? index : 0;
    }

    private int backward(int index) {
        return --index > -1 ? index : _array.length - 1;
    }

    public int getSize() {
        return _size;
    }
}
