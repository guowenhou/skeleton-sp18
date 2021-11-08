import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.

    // Uncomment this class once you've created
    // your CharacterComparator interface and OffByOne class.
    @Test
    public void testEqualChars() {
        boolean res = offByOne.equalChars('x', 'y');
        boolean ans = true;
        assertEquals(ans, res);

        boolean res2 = offByOne.equalChars('a', 'a');
        boolean ans2 = false;
        assertEquals(ans2, res2);


    }


}
