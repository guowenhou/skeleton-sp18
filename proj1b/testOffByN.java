import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testOffByN {


    static OffByN offByN = new OffByN(5);

    @Test
    public  void testEqualChars(){

        boolean res = offByN.equalChars('x', 'y');
        boolean ans = false;
        assertEquals(ans, res);

        boolean res2 = offByN.equalChars('a', 'f');
        boolean ans2 = true;
        assertEquals(ans2, res2);

    }
}
