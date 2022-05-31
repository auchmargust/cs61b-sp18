public class ArrayDeque<T> {
    private T[] Ts;
    private int size;
    
    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        Ts = (T[]) new Object[8];
        size = 0;
    }
    
    private void resize(int capacity, int srcPos, int destPos, int L) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(Ts, srcPos, a, destPos, L);
        Ts = a;
    }
    
    public ArrayDeque(T x) {
        Ts = (T[]) new Object[8];
        Ts[0] = x;
        size = 1;
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        for (int i = 0; i < Ts.length; i++) {
            if (Ts[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public int size() {
        return size;
    }
    
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        } else {
            return Ts[index];
        }
    }
    
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("The array is Empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println(Ts[i]);
            }
        }
    }
    
    public void addFirst(T i) {
        if (size >= Ts.length) {
            resize(size * 2, 0, 1, size);
        } else {
            resize(Ts.length, 0, 1, size);
        }
        Ts[0] = i;
        size++;
    }
    
    public void addLast(T i) {
        if (size >= Ts.length) {
            resize(size * 2, 0, 0, size);
        }
        if (size == 0) {
            Ts[0] = i;
        } else {
            Ts[size] = i;
        }
        size++;
    }
    
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T temp = Ts[0];
            if (Ts.length > 16 && size < (Ts.length / 4)) {
                resize((int) (0.5 * (Ts.length) + 1),
                        1, 0, size - 1);
            } else {
                resize(Ts.length, 1, 0, size - 1);
            }
            size = size - 1;
            return temp;
        }
    }
    
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T temp = Ts[size - 1];
            if (Ts.length > 16 && size < (Ts.length / 4)) {
                resize((int) (0.5 * (Ts.length) + 1),
                        1, 0, size - 1);
            } else {
                resize(Ts.length, 0, 0, size - 1);
            }
            size = size - 1;
            return temp;
        }
    }
}
