public abstract class AbstractQueue<T> implements Queue2<T> {
    public int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
    public int size() {
        return size;
    }
}
