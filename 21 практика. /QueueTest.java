public class QueueTest {
    public static void main(String[] args) {
        // Тестирование модульной реализации
        ArrayQueueModule.enqueue("1");
        ArrayQueueModule.enqueue("2");
        ArrayQueueModule.enqueue("3");

        System.out.println("Размер очереди: " + ArrayQueueModule.size()); // Ожидаемый результат: 2
        System.out.println("Первый элемент: " + ArrayQueueModule.element()); // Ожидаемый результат: A
        System.out.println("Удаленный элемент: " + ArrayQueueModule.dequeue()); // Ожидаемый результат: A
        System.out.println("Размер очереди после dequeue: " + ArrayQueueModule.size()); // Ожидаемый результат: 1
        System.out.println("Очередь пуста: " + ArrayQueueModule.isEmpty()); // Ожидаемый результат: false
        ArrayQueueModule.clear();
        System.out.println("Размер очереди после clear: " + ArrayQueueModule.size()); // Ожидаемый результат: 0
        System.out.println("Очередь пуста после clear: " + ArrayQueueModule.isEmpty()); // Ожидаемый результат: true

        // Тестирование реализации с явной передачей ссылки на экземпляр очереди (ADT)
        ArrayQueueADT queueADT = new ArrayQueueADT();
        ArrayQueueADT.enqueue(queueADT, "X");
        ArrayQueueADT.enqueue(queueADT, "Y");
        System.out.println("\nРазмер очереди: " + ArrayQueueADT.size(queueADT)); // Ожидаемый результат: 2
        System.out.println("Первый элемент: " + ArrayQueueADT.element(queueADT)); // Ожидаемый результат: X
        System.out.println("Удаленный элемент: " + ArrayQueueADT.dequeue(queueADT)); // Ожидаемый результат: X
        System.out.println("Размер очереди после dequeue: " + ArrayQueueADT.size(queueADT)); // Ожидаемый результат: 1
        System.out.println("Очередь пуста: " + ArrayQueueADT.isEmpty(queueADT)); // Ожидаемый результат: false
        ArrayQueueADT.clear(queueADT);
        System.out.println("Размер очереди после clear: " + ArrayQueueADT.size(queueADT)); // Ожидаемый результат: 0
        System.out.println("Очередь пуста после clear: " + ArrayQueueADT.isEmpty(queueADT)); // Ожидаемый результат: true

        // Тестирование реализации с неявной передачей ссылки на экземпляр очереди
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue("M");
        queue.enqueue("N");
        System.out.println("\nРазмер очереди: " + queue.size()); // Ожидаемый результат: 2
        System.out.println("Первый элемент: " + queue.element()); // Ожидаемый результат: M
        System.out.println("Удаленный элемент: " + queue.dequeue()); // Ожидаемый результат: M
        System.out.println("Размер очереди после dequeue: " + queue.size()); // Ожидаемый результат: 1
        System.out.println("Очередь пуста: " + queue.isEmpty()); // Ожидаемый результат: false
        queue.clear();
        System.out.println("Размер очереди после clear: " + queue.size()); // Ожидаемый результат: 0
        System.out.println("Очередь пуста после clear: " + queue.isEmpty()); // Ожидаемый результат: true
    }
}
