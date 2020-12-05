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
    @Override
    public void addFirst(T item) {
        if (items.length == size) {
            T[] a = (T[]) new Object[size * 2];
            a[0] = item;
            System.arraycopy(items, 0, a, 1, size);
            items = a;
        } else {
            T[] a = (T[]) new Object[size];
            a[0] = item;
            System.arraycopy(items, 0, a, 1, size);
            items = a;
        }
        size += 1;
    }

    // Adds an item of type T to the back of the deque.
    @Override
    public void addLast(T item) {
        if (items.length == size) {
            T[] a = (T[]) new Object[size * 2];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        items[size] = item;
        size += 1;
    }

    // Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of items in the deque.
    @Override
    public int size() {
        return size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        for (T item : items) {
            System.out.print(item + " ");
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if (items == null) {
            return null;
        }
        T item = items[0];
        T[] a = (T[]) new Object[size];
        System.arraycopy(items, 1, a, 0, size - 1);
        items = a;
        size--;
        return item;
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T item = items[size - 1];
        items[size - 1] = null;
        if ((double) size / items.length <= 0.25) {
            T[] a = (T[]) new Object[size];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        size--;
        return item;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[index - 1];
    }


}
