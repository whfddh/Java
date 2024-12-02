public class ArrayQueue {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    // Инвариант: elements - массив элементов очереди, size - текущий размер очереди,
    // front - индекс первого элемента, rear - индекс следующего после последнего элемента.

    // Добавить элемент в очередь
    public void enqueue(Object element) {
        ensureCapacity();
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;
    }

    // Получить первый элемент в очереди
    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        return elements[front];
    }

    // Удалить и вернуть первый элемент в очереди
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Очередь пуста");
        }
        Object removed = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return removed;
    }

    // Получить текущий размер очереди
    public int size() {
        return size;
    }

    // Проверить, является ли очередь пустой
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистить все элементы из очереди
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Вспомогательная функция для увеличения емкости массива при необходимости
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, front, newElements, 0, elements.length - front);
            System.arraycopy(elements, 0, newElements, elements.length - front, rear);
            elements = newElements;
            front = 0;
            rear = size;
        }
    }
}
