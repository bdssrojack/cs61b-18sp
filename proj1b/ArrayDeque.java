/*
    Rules:
    add and remove must take constant time, except during resizing operations.
    get and size must take constant time.
    The starting size of your array should be 8.
 */

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;

    // Creates an empty array deque.
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        T[] a = (T[]) new Object[size + 1];
        a[0] = item;
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        if (items.length == size) {
            T[] a = (T[]) new Object[size + 1];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        items[size] = item;
        size += 1;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of items in the deque.
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        for (T item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T item = items[0];
        T[] a = (T[]) new Object[size - 1];
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size--;
        return item;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T item = items[size - 1];
        T[] a = (T[]) new Object[size - 1];
        System.arraycopy(items, 0, a, 0, size - 1);
        items = a;
        size--;
        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[index];
    }


}
