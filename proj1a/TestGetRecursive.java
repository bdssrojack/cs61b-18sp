import org.junit.Test;
import static org.junit.Assert.*;

public class TestGetRecursive {
    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            list.removeLast();
        }
        assertNull(list.getRecursive(0));
    }
}