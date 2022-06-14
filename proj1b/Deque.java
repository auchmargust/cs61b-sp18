public interface Deque<T> {
	int size();
	
	T get(int index);
	
	void printDeque();
	
	void addFirst(T i);
	
	T removeFirst();
	
	void addLast(T i);
	
	T removeLast();
	
	boolean isEmpty();
}
