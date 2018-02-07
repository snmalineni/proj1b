public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        // item at nextFirst+1 is the current first item
        int currentFirst = (nextFirst + 1) % items.length;

        if ((currentFirst + size) <= items.length) {
            System.arraycopy(items, currentFirst, a, 0, size);
        } else {
            int initSize = items.length - currentFirst;
            int restSize = size - initSize;

            System.arraycopy(items, currentFirst, a, 0, initSize);
            System.arraycopy(items, 0, a, initSize, restSize);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public ArrayDeque() { // Constructor
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1; // first starts at the end of the array
        nextLast = 0;                 // last starts from beginning of the array
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst + items.length - 1) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        // item at nextFirst+1 is the current first item
        int currentFirst = (nextFirst + 1) % items.length;

        if ((currentFirst + size) <= items.length) {
            for (int i = currentFirst; i < currentFirst + size; i++) {
                System.out.print(items[i]);
            }
        } else {
            int initSize = items.length - currentFirst;
            int restSize = size - initSize;

            for (int i = currentFirst; i < currentFirst + initSize; i++) {
                System.out.print(items[i]);
            }
            for (int i = 0; i < restSize; i++) {
                System.out.print(items[i]);
            }
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            // early return null
            return null;
        }

        T x = getFirst();
        items[(nextFirst + 1) % items.length] = null;

        size -= 1;
        nextFirst = (nextFirst + 1) % items.length;

        if ((items.length >= 16) && (size * 4 < items.length)) {
            // R = size / items.length <= 25%, and items.length is 16 or more
            resize(items.length / 2);
        }

        return x;
    }

    public T removeLast() {
        if (isEmpty()) {
            // early return null
            return null;
        }

        T x = getLast();
        items[(nextLast + items.length - 1) % items.length] = null;

        size -= 1;
        nextLast = (nextLast + items.length - 1) % items.length;

        if ((items.length >= 16) && (size * 4 < items.length)) {
            resize(items.length / 2);
        }

        return x;
    }

    public T get(int index) {
        // item at nextFirst+1 is the current first item
        return items[(nextFirst + 1 + index) % items.length];
    }

    public T getLast() {
        // item at nextLast-1 is the current last item
        return items[(nextLast + items.length - 1) % items.length];
    }

    public T getFirst() {
        // item at nextFirst+1 is the current first item
        return items[(nextFirst + 1) % items.length];
    }
}
