public class LinkedListDeque<Item> {
    private class Node<Item> {
        private Item value;
        private Node prev;
        private Node next;

        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("URF_UNREAD_FIELD")
        private Node(Item i) {
            value = i;
            prev = null;
            next = null;
        }
    }

    private Node first;
    private Node end;
    private int size;

    public LinkedListDeque() {
        first = new Node(0);
        end = new Node(0);

        first.next = end;
        end.prev = first;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        int counter = 0;
        while (counter != index) {
            first = first.next;
            counter++;
        }
        return (Item) first.value;
    }

    private Item getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return (Item) p.value;
        } else {
            return (Item) getRecursiveHelper(index - 1, p.next);
        }
    }

    public Item getRecursive(int index) {
        if (size == 0) {
            return null;
        } else if (index < 0 || index > size) {
            return null;
        }
        return getRecursiveHelper(index, first);
    }

    public void printDeque() {
        if (first == null) {
            System.out.println("Empty List.");
        } else {
            while (first != null) {
                System.out.println(first.value);
                first = first.next;
            }
        }
    }

    public void addFirst(Item i) {
        Node toAdd = new Node(i);
        Node temp = first.next;
        toAdd.next = temp;
        toAdd.prev = first;
        first.next = toAdd;
        temp.prev = toAdd;
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item x = (Item) first.next.value;
        Node temp = first.next.next;
        first.next.next = null;
        first.next.prev = null;

        first.next = temp;
        temp.prev = first;
        size--;
        return x;
    }

    public void addLast(Item i) {
        Node toAdd = new Node(i);
        Node temp = end.prev;
        toAdd.prev = temp;
        toAdd.next = end;
        end.prev = toAdd;
        temp.next = toAdd;
        size++;

    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Item x = (Item) end.prev.value;
        Node temp = end.prev.prev;

        end.prev.next = null;
        end.prev.prev = null;

        end.prev = temp;
        temp.next = end;
        size--;
        return x;
    }


}
