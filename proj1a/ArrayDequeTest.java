import org.junit.Test;


public class ArrayDequeTest {

    @Test
    public void addTest() {

        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");
        arrayDeque.addFirst("1");
        arrayDeque.addLast("3");

        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeLast();

        String x = (String) arrayDeque.removeLast();
        String y = (String) arrayDeque.removeFirst();
        System.out.println(x);
        System.out.println(y);

    }

}


