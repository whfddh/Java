public interface Queue2<T> {
    void enqueue(T element);
    T deque();
    T peek();
    T dequeue();

    boolean isEmpty();
    int size();
    void clear();

}
