public class LinkedListDeque<T> implements  Deque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }

        public void printNode() {
            System.out.print(item);
        }
    }

    private Node sentinel;
    private int size = 0;

    public LinkedListDeque() { // Deque constructor
        sentinel = new Node(null, null, null);

        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size += 1;
        Node oldFirst = sentinel.next;

        Node newFirst = new Node(item, oldFirst, sentinel);
        sentinel.next = newFirst;
        oldFirst.prev = newFirst;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        Node oldLast = sentinel.prev;

        Node newLast = new Node(item, sentinel, oldLast);
        oldLast.next = newLast;
        sentinel.prev = newLast;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            p.printNode();
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        T item = null;
        Node p;
        if (size != 0) {
            size -= 1;
            p = sentinel.next;
            p.next.prev = sentinel;
            sentinel.next = p.next;
            item = p.item;
        }
        return item;
    }

    @Override
    public T removeLast() {
        T item = null;
        Node p;
        if (size != 0) {
            size -= 1;
            p = sentinel.prev;
            p.prev.next = sentinel;
            sentinel.prev = p.prev;
            item = p.item;
        }
        return item;
    }

    @Override
    public T get(int index) {
        Node p;
        T item = null;
        if (size != 0 && size > index) {
            p = sentinel.next;
            for (int j = 0; j < index; j++) {
                p = p.next;
            }
            item = p.item;
        }
        return item;
    }

    public T getRecursive(int index) {
        Node p;
        p = getRecursiveNode(sentinel.next, index);
        return p.item;
    }

    private Node getRecursiveNode(Node startNode, int startIndex) {
        if (startIndex == 0) {
            return startNode;
        } else {
            return getRecursiveNode(startNode.next, startIndex - 1);
        }
    }

}
