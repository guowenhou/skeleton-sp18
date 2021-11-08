public class LinkedListDeque<T> implements Deque<T>{

    private Node sentinel;
    private int size;

    public class Node {

        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }


    public LinkedListDeque() {
        T a = (T) new Integer(13);
        sentinel = new Node(null, a, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node midNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = midNode;
        //在创建midNode的时候next就指向sentinel.next了所以不用在赋值，更新sentinel.next即可
        //midNode.prev.next= midNode;
        sentinel.next = midNode;
        size++;
    }

    public void addLast(T item) {
        Node midNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = midNode;
        sentinel.prev = midNode;
        size++;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node mid = sentinel.next;
        while (mid != sentinel) {

            System.out.print(mid.item + " ");
            mid = mid.next;
        }
        System.out.println();

    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }

        Node result = sentinel.next;
        result.next.prev = sentinel;
        sentinel.next = result.next;
        size--;

        return result.item;


    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node result = sentinel.prev;
        result.prev.next = sentinel;
        sentinel.prev = result.prev;
        size--;

        return result.item;
    }

    public T get(int index) {
        Node result = sentinel.next;
//        int i = 0;
//        while (result != sentinel && i < index) {
//            result = result.next;
//            i++;
//        }
//        if (i == index) {
//            return null;
//        } else {
//            return result.item;
//        }
//        //other answer 1
//        while(result != sentinel){
//            if(index==0){
//                return result.item;
//            }
//            result=result.next;
//            index--;
//        }
//        return null;
        //other answer 2
        if (size < index) {
            return null;
        }
        while (index > 0) {
            result = result.next;
            index--;

        }
        return result.item;
    }

//    public LinkedListDeque(LinkedListDeque other) {
//
//        T a = (T) new Integer(13);
//        sentinel = new Node(null, a, null);
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//        size = 0;
//
//        Node res = other.sentinel;
//        for (int i = 0; i < other.size(); i++) {
//
//            addLast((T) (other.get(i)));
//        }
//    }

    //Same as get, but uses recursion.
    public T getRecursive(int index) {

        if (size < index) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);

    }

    private T getRecursiveHelper(int index, Node res) {
        if (index == 0) {
            return res.item;
        }
        return getRecursiveHelper(index - 1, res.next);
    }
}


