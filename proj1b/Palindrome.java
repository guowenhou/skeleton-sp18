public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque arr = new ArrayDeque();
        int length = word.length();
        for (int i = 0; i < length; i++) {
            arr.addLast(word.charAt(i));
        }

        return arr;
    }

    public boolean isPalindrome(String word) {

        if (word.length() <= 1) {
            return true;
        }
        int length = word.length();
        for (int i = 0; i < (length / 2); i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        if (word.length() <= 1) {
            return true;
        }
        int length = word.length();
        for (int i = 0; i < (length / 2); i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(length - i - 1))) {
                return false;
            }
        }
        return true;
    }


}
