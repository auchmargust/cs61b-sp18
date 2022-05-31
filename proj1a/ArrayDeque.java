public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity, int srcPos, int destPos, int L) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, srcPos, a, destPos, L);
        items = a;
    }

    public ArrayDeque(Item x) {
        items = (Item[]) new Object[8];
        items[0] = x;
        size = 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        return items[index];
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("The array is Empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public void addFirst(Item i) {
        if (size >= items.length) {
            //new list = first empty, starting from position[1] with #sizes of items
            resize(size * 2, 0, 1, size);
        } else {
            resize(items.length, 0, 1, size);
        }
        items[0] = i;
        size++;
    }

    public void addLast(Item i) {
        if (size >= items.length) {
            //new list = last empty, starting from position[0] with #sizes of items
            resize(size * 2, 0, 0, size);
        }
        if (size == 0) {
            items[0] = i;
        } else {
            items[size] = i;
        }
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Item temp = items[0];
            //resize array  if length>16 and usage factor <25%
            if (items.length > 16 && size < (items.length / 4)) {
                resize((int) (0.5 * (items.length) + 1), 1, 0, size - 1);
            } else {
                resize(items.length, 1, 0, size - 1);
            }
            size = size - 1;
            return temp;
        }
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item temp = items[size];
            if (items.length > 16 && size < (items.length / 4)) {
                resize((int) (0.5 * (items.length) + 1), 1, 0, size - 1);
            } else {
                resize(items.length, 0, 0, size - 1);
            }
            size = size - 1;
            return temp;
        }
    }


}
