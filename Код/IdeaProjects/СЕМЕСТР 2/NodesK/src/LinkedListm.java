public class LinkedListm<T> {
    private Node<T> _first, _last; //Ссылки на первый и последний узлы.
    private int _size;

    private Node<T> _now; //указатель

    public LinkedListm() {
        _first = _last = null;
        _size = 0;
    }

    public void append(Node<T> node) {
        node.next = null;

        if (_first == null) //Первый элемент.
            _first = node;

        if (_last != null)
            _last.next = node;

        _last = node;
        _size++;
        _now = node;
    }

    public Node<T> get() {
        if (_now == null)
            throw new NullPointerException();
        Node<T> res = _now;
        if (_now == _last)
            _now = _first;
        else
            _now = _now.next;

        return res;
    }

    public void toFront() {
        _now = _first;
    }

    public Node<T> get(int index) {
        if (index >= _size)
            throw new IndexOutOfBoundsException();
        Node<T> node = _first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Получить номер элемента.
     *
     * @param node искомый элемент
     * @return номер
     */
    public int find(Node<T> node) {
        Node<T> temp = _first;
        int i = 0;
        while (i < _size) {
            if (temp.value == node.value)
                return i;
            else {
                i++;
                temp = temp.next;
            }
        }
        throw new NullPointerException();
    }

    public void insert(Node<T> node, int location) {
        if (location >= _size)
            throw new IndexOutOfBoundsException();
        Node<T> prev = null, next = null;

        if (location != 0)
            prev = get(location - 1);

        next = get(location);

        node.next = next;
        assert prev != null;
        prev.next = node;

        _size++;
        _now = node;
    }


    public void remove(int location) {
        if (location >= _size)
            throw new IndexOutOfBoundsException();
        Node<T> prev = null, next = null;

        if (location != _size - 1)
            next = get(location).next;
        if (location != 0) {
            prev = get(location - 1);
            prev.next = next;
        } else
            _first = next;

        _size--;
    }
}
