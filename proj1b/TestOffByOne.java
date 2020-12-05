import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        boolean b1 = offByOne.equalChars('x', 'y');
        boolean b2 = offByOne.equalChars('x', 'x');
        assertTrue(b1);
        assertFalse(b2);
    }

}
