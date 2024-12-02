public class ArrayQueueADT {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    // Инвариант: elements - массив элементов очереди, size - текущий размер очереди,
    // front - индекс первого элемента, rear - индекс следующего после последнего элемента.

    // Добавить элемент в очередь
    public static void enqueue(ArrayQueueADT queue, Object element) {
        ensureCapacity(queue);
        queue.elements[queue.rear] = element;
        queue.rear = (queue.rear + 1) % queue.elements.length;
        queue.size++;
    }

    // Получить первый элемент в очереди
    public static Object element(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Очередь пуста");
        }
        return queue.elements[queue.front];
    }

    // Удалить и вернуть первый элемент в очереди
    public static Object dequeue(ArrayQueueADT queue) {
        if (isEmpty(queue)) {
            throw new IllegalStateException("Очередь пуста");
        }
        Object removed = queue.elements[queue.front];
        queue.elements[queue.front] = null;
        queue.front = (queue.front + 1) % queue.elements.length;
        queue.size--;
        return removed;
    }

    // Получить текущий размер очереди
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Проверить, является ли очередь пустой
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Очистить все элементы из очереди
    public static void clear(ArrayQueueADT queue) {
        queue.elements = new Object[DEFAULT_CAPACITY];
        queue.size = 0;
        queue.front = 0;
        queue.rear = 0;
    }

    // Вспомогательная функция для увеличения емкости массива при необходимости
    private static void ensureCapacity(ArrayQueueADT queue) {
        if (queue.size == queue.elements.length) {
            int newCapacity = queue.elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(queue.elements, queue.front, newElements, 0, queue.elements.length - queue.front);
            System.arraycopy(queue.elements, 0, newElements, queue.elements.length - queue.front, queue.rear);
            queue.elements = newElements;
            queue.front = 0;
            queue.rear = queue.size;
        }
    }
}
