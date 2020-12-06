import org.junit.Test;
import static org.junit.Assert.*;

public class TestGetRecursive {
    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> list = new LinkedListDeque<>(1);
        list.addFirst(0);
        list.addLast(2);
        int i = list.getRecursive(1);
        assertEquals(1, i);
    }
}
