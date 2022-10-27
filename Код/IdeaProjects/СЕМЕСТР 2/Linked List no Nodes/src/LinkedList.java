public class LinkedList<T> {
    private Node<T> _first, _last; //Ссылки на первый и последний узлы.
    private int _size;

    public LinkedList() {
        _first = _last = null;
        _size = 0;
    }



    public void append(Node<T> node) {
        node.next = null;

        if (_first == null)
            _first = node;

        if (_last != null)
            _last.next = node;

        _last = node;
        _size++;
    }

    // TASK *** получение индекса элемента
    public int find(Node node) {
        int index;
        for (index = 0; index <= _size; index++) {
            if (node == node(index))
                break;
        }
        return index;
    }

    // TASK *** вставка элемента
    public void insert(Node node, int location) {
        Node<T> prev = null, next;
        if (location <= _size) {
            if (location != 0) {
                prev = node(location-1);
            }

            next = node(location);
            node.next = next;
            if (prev != null)
                prev.next = node;
            _size++;
        }
    }

    // TASK *** удаление элемента
    public void remove(int location) {
        Node<T> prev, next = null;
        if (location < _size) {
            if (location < _size - 1)
                next = node(location).next;

            if (location > 0) {
                prev = node(location - 1);
                prev.next = next;
            } else
                _first = next;

            _size--;
        }
    }

    // получение элемента по индексу
    public Node<T> node(int location) {
        Node<T> node = _first;
        for (int i = 0; i < location; i++)
            node = node.next;
        return node;
    }
}