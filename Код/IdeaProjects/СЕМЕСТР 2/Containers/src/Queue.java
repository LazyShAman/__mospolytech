class Queue {
    private final int[] _array;
    private int _size, _head, _tail;

    public Queue(int capacity) {
        _array = new int[capacity];
        clear();
    }

    // is queue empty?
    public boolean empty() {
        return _size == 0;
    }

    // to make queue empty
    public void clear() {
        _size = _head = 0;
        _tail = _array.length - 1;
    }

    // to return next index
    private int forward(int index) {
        return ++index < _array.length ? index : 0;
    }

    // to add new element to the tail of the queue
    public void push(int val) throws Exception {
        if (++_size >= _array.length)
            throw new Exception();

        _array[_tail = forward(_tail)] = val;
    }

    // to remove first element from the head of the queue
    public int pop() throws Exception {
        int val = front();
        _head = forward(_head);
        _size -= 1;

        return val;
    }

    // to get a head of the queue (without deleting it)
    public int front() throws Exception {
        if (empty())
            throw new Exception();

        return _array[_head];
    }

    public int getSize() {
        return _size;
    }
}

