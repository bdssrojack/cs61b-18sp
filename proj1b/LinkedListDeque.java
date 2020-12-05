/**rules:
 * add and remove options must not involve any looping or recursion.
 *      A single such operation must take “constant time”,
 *      i.e. execution time should not depend on the size of the deque.
 *
 * The amount of memory that your program uses at any given time must be
 *      proportional to the number of items.
 * @param <T>
 */

public class LinkedListDeque<T> implements Deque<T> {

    private ItemNode sentF;
    private ItemNode sentB;
    private int size;

    private class ItemNode {
        T item;
        ItemNode next;
        ItemNode prev;
        ItemNode(T i, ItemNode p, ItemNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    // Creates an empty deque.
    public LinkedListDeque() {
        sentF = new ItemNode(null, null, null);
        sentB = new ItemNode(null, null, null);
        sentF.next = sentB;
        sentB.prev = sentF;
        size = 0;
    }

    // Creates a deque with one element.
    public LinkedListDeque(T x) {
        sentF = new ItemNode(null, null, null);
        sentB = new ItemNode(null, null, null);
        sentF.next = new ItemNode(x, sentF, sentB);
        sentB.prev = sentF.next;
        size = 1;
    }

    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T item) {
        sentF.next = new ItemNode(item, sentF, sentF.next);
        sentF.next.next.prev = sentF.next;
        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T item) {
        sentB.prev = new ItemNode(item, sentB.prev, sentB);
        sentB.prev.prev.next = sentB.prev;
        size += 1;
    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

    // Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
        Prints the items in the deque from first to last,
        separated by a space.
    */
    @Override
    public void printDeque() {
        ItemNode p = sentF.next;
        while (p.next != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /*
        Removes and returns the item at the front of the deque.
        If no such item exists, returns null.
    */
    @Override
    public T removeFirst() {
        if (sentF.next.next == null) {
            return null;
        }
        T t = sentF.next.item;
        sentF.next = sentF.next.next;
        sentF.next.prev = sentF;
        size -= 1;
        return t;
    }

    /*
        Removes and returns the item at the back of the deque.
        If no such item exists, returns null.
    */
    @Override
    public T removeLast() {
        if (sentB.prev.prev == null) {
            return null;
        }
        T t = sentB.prev.item;
        sentB.prev = sentB.prev.prev;
        sentB.prev.next = sentB;
        size -= 1;
        return t;
    }

    /*
        Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        If no such item exists, returns null. Must not alter the deque!
    */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        if (index < size/2) {
            ItemNode p = sentF;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        } else {
           ItemNode p = sentB;
           for (int i = 0; i <= index; i++) {
               p = p.prev;
           }
           return p.item;
        }
    }

    // Same as get, but uses recursion.
/*    public T getRecursive(int index) {
        if (index == 0) {
            return item;
        }
        index --;
        return;

    }*/
}
