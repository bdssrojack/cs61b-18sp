

public class Palindrome {

    public  Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<Character>();
        char[] chars = word.toCharArray();
        for (char c : chars) {
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> deque = (LinkedListDeque) wordToDeque(word);

        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int size = word.length();

        if (size == 0 || size == 1) {
            return true;
        }

        double halfSize = size / 2.0;
        int i = 0;

        while (size >= halfSize) {
            if (!cc.equalChars(word.charAt(i), word.charAt(size - 1))) {
                return false;
            }
            size--;
            i++;
        }
        return true;
    }
}
