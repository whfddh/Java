public class QueueTester {
    public static void main(String[] args) {
        // Тестирование LinkedQueue
        System.out.println("Тестирование LinkedQueue:");
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        System.out.println("Размер очереди: " + linkedQueue.size()); // Ожидаемый результат: 3
        System.out.println("Первый элемент: " + linkedQueue.peek()); // Ожидаемый результат: A
        System.out.println("Удаленный элемент: " + linkedQueue.dequeue()); // Ожидаемый результат: A
        System.out.println("Размер очереди после dequeue: " + linkedQueue.size()); // Ожидаемый результат: 2
        System.out.println("Очередь пуста: " + linkedQueue.isEmpty()); // Ожидаемый результат: false
        linkedQueue.clear();
        System.out.println("Размер очереди после clear: " + linkedQueue.size()); // Ожидаемый результат: 0
        System.out.println("Очередь пуста после clear: " + linkedQueue.isEmpty()); // Ожидаемый результат: true

        // Тестирование общего функционала из AbstractQueue
        System.out.println("\nТестирование AbstractQueue:");
        AbstractQueue<String> abstractQueue = new LinkedQueue<>();

        abstractQueue.enqueue("X");
        abstractQueue.enqueue("Y");
        abstractQueue.enqueue("Z");

        System.out.println("Размер очереди: " + abstractQueue.size()); // Ожидаемый результат: 3
        System.out.println("Первый элемент: " + abstractQueue.peek()); // Ожидаемый результат: X
        System.out.println("Удаленный элемент: " + abstractQueue.dequeue()); // Ожидаемый результат: X
        System.out.println("Размер очереди после dequeue: " + abstractQueue.size()); // Ожидаемый результат: 2
        System.out.println("Очередь пуста: " + abstractQueue.isEmpty()); // Ожидаемый результат: false
        abstractQueue.clear();
        System.out.println("Размер очереди после clear: " + abstractQueue.size()); // Ожидаемый результат: 0
        System.out.println("Очередь пуста после clear: " + abstractQueue.isEmpty()); // Ожидаемый результат: true
    }
}
