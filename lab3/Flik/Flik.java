import org.junit.Test;

/**
 * An Integer tester created by Flik Enterprises.
 */
public class Flik {
    public static boolean isSameNumber(int a, int b) {

        return a == b;
    }

    @Test
    public void testIsSameNumber() {

        for (int i = 127, j = 127; i < 500; i++, j++) {
            if (isSameNumber(i, j)) {
                System.out.println("i = " + i + " j = " + j);
            }

        }
    }

}
