public class LinkedQueue <T> extends AbstractQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Добавляет элемент в конец очереди
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public T deque() {
        return null;
    }

    // Удаляет и возвращает элемент из начала очереди
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        T removed = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return removed;
    }

    // Возвращает элемент из начала очереди без его удаления
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }
}
