import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void test() {

        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder message = new StringBuilder();
        int size = 0;
        for (int i = 0; i < 5000; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sad.addFirst(i);
                ads.addFirst(i);
                size++;
                message.append("addFirst(" + i + ")\n");
                assertEquals(message.toString(), sad.get(0), ads.get(0));
            }
            if (numberBetweenZeroAndOne < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                size++;
                message.append("addLast(" + i + ")\n");
                assertEquals(message.toString(),
                        sad.get(size - 1), ads.get(size - 1));
            }
            if (numberBetweenZeroAndOne < 0.75) {
                if (sad.isEmpty()) {
                    message.append("isEmpty()\n");
                    assertTrue(message.toString(), sad.isEmpty());
                    continue;
                }
                Integer act = sad.removeFirst();
                Integer exp = ads.removeFirst();
                size--;
                message.append("removeFirst \n");
                assertEquals(message.toString(), act, exp);
            }
            else {
                if (sad.isEmpty()) {
                    message.append("isEmpty()\n");
                    assertTrue(message.toString(), sad.isEmpty());
                    continue;
                }
                Integer act = sad.removeLast();
                Integer exp = ads.removeLast();
                size--;
                message.append("removeLast \n");
                assertEquals(message.toString(), act, exp);
            }

        }
        System.out.println(message);


    }
}
