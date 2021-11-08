import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static OffByN offByN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {

        boolean flag = palindrome.isPalindrome("Aca");
        boolean ans = false;
        assertEquals(ans, flag);

        boolean flag2 = palindrome.isPalindrome("fsdg");
        boolean ans2 = false;
        assertEquals(ans2, flag2);

        boolean flag3 = palindrome.isPalindrome("noon");
        boolean ans3 = true;
        assertEquals(ans3, flag3);


    }

    @Test
    public void testIsPalindromeOffByOne() {

        boolean flag = palindrome.isPalindrome("Aca", offByOne);
        boolean ans = false;
        assertEquals(ans, flag);

        boolean flag2 = palindrome.isPalindrome("fsdg", offByOne);
        boolean ans2 = false;
        assertEquals(ans2, flag2);

        boolean flag3 = palindrome.isPalindrome("ab", offByOne);
        boolean ans3 = true;
        assertEquals(ans3, flag3);


    }

}
