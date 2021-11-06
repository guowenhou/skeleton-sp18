
public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private static final int CAPACITY = 8;
    private int first, last;


    public ArrayDeque() {
        this.items = (T[]) new Object[CAPACITY];
        first = last = size = 0;
    }

    private boolean isFull() {
        return (this.size == items.length);

    }

    private void resize(int n) {
        T[] mid = (T[]) new Object[n];
        for (int i = first, j = 0; i < items.length; i++, j++) {
            mid[j] = items[i];
        }
        for (int i = 0, j = items.length - first; i < last; i++, j++) {

            mid[j] = items[i];
        }

        items = mid;
        first = 0;
        last = size;
    }

    private int decrement(int n) {

        return (n - 1 + items.length) % items.length;
    }

    private int increment(int n) {

        return (n + 1) % items.length;
    }

    public void addFirst(T item) {

        if (isFull()) {
            resize(2 * items.length);
        }

        first = decrement(first);
        items[first] = item;
        this.size++;

    }

    public void addLast(T item) {

        if (isFull()) {
            resize(2 * items.length);
        }

        last = decrement(last);
        items[last] = item;
        this.size++;

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (first < last) {
            for (int i = first; i < last; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println();
        } else {

            for (int i = first; i < items.length; i++) {
                System.out.println(items[i] + " ");
            }
            for (int i = 0; i < last; i++) {
                System.out.println(items[i] + " ");
            }
            System.out.println();
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T res = items[first];
        first = increment(first);
        size--;
        if (items.length > 2 * CAPACITY && 4 * size < items.length) {
            resize((int) (items.length * 0.5));
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = items[last];
        last = decrement(last);
        size--;
        if (items.length > 2 * CAPACITY && 4 * size < items.length) {
            resize((int) (items.length * 0.5));
        }
        return res;
    }

    public T get(int index) {
        if (isEmpty() || index >= size || index < 0) {
            return null;
        }
        return items[(first + index - 1) % items.length];
    }

//    public ArrayDeque(ArrayDeque other) {
//        this.items = (T[]) new Object[other.items.length];
//        first = other.first;
//        last = other.last;
//        size = other.size();
//        System.arraycopy(other.items, 0, items, 0, other.items.length);
//
//    }
}


