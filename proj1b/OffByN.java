public class OffByN implements CharacterComparator{
    public int diff;

    public OffByN(int N) {
        this.diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == diff || y - x == diff) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        int size = word.length();

        if (size == 0 || size == 1) {
            return true;
        }

        double halfSize = size/2.0;
        int i = 0;

        while (size >= halfSize) {
            if (!equalChars(word.charAt(i), word.charAt(size-1))) {
                return false;
            }
            size--;
            i++;
        }

        return true;
    }
}
