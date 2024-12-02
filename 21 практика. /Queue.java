import java.util.LinkedList;

public class Queue<T>{
    private LinkedList<T> list = new LinkedList<>();
    public void enque(T item){
        list.addLast(item);
    }
    public T element(){
        if (list.isEmpty()){
            throw new IllegalArgumentException("Очередь пуста");
        }

        return list.getFirst();
    }

    public T dequeue(T item){
        if (list.isEmpty()){
            throw new IllegalArgumentException("Очередь пуста");

        }
        return list.removeFirst();
    }

    public int size(){
        return list.size();
    }

    private boolean isEmpty(){
        return list.isEmpty();
    }
    public void clear(){
        list.clear();
    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        queue.enque("1");
        queue.enque("4");
        queue.enque("4");
        queue.enque("4");
        queue.enque("4");
        queue.enque("4");
        System.out.println(queue.list);
        queue.element();
        System.out.println(queue.list);
        String removed =  queue.dequeue("");
        System.out.println("Удаленный элемент: " + removed); // Ожидаемый результат: A
        System.out.println("Размер очереди после dequeue: " + queue.size()); // Ожидаемый результат: 1
        System.out.println(queue.list);
        queue.size();
        System.out.println(queue.list);
        queue.clear();
        System.out.println("Очередь пуста " +queue.isEmpty());
    }
}
