public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == 1 || y - x == 1) {
            return true;
        }
        return false;
    }

/*    public boolean isPalindrome(String word) {
        int size = word.length();

        if (size == 0 || size == 1) {
            return true;
        }

        double halfSize = size / 2.0;
        int i = 0;

        while (size >= halfSize + 1) {
            if (!equalChars(word.charAt(i), word.charAt(size - 1))) {
                return false;
            }
            size--;
            i++;
        }

        return true;
    }*/
}
