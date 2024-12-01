public class Main {
    public static void main(String[] args) {
        // Пример использования классов и интерфейсов
        IWaitList<Integer> waitList1;
        waitList1 = new BoundedWaitList<>(2);
        waitList1.add(1);
        waitList1.add(2);
        waitList1.add(3);

        IWaitList<Integer> waitList2 = new UnfairWaitList<>();
        waitList2.add(1);
        waitList2.add(2);
        waitList2.add(3);
        waitList2.remove(2);
        waitList2.moveToBack(1);

        System.out.println("BoundedWaitList: " + waitList1.toString());
        System.out.println("UnfairWaitList: " + waitList2.toString());

    }
}
