import java.util.Arrays;

public class InternetOrder {
    private static class Node {
        Item item;
        Node next;
        Node prev;

        public Node(Item item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node head;
    private int size;

    public InternetOrder() {
        this.head = new Node(null, null, null);
        this.head.next = this.head;
        this.head.prev = this.head;
        this.size = 0;
    }

    public InternetOrder(Item[] items) {
        this();
        Arrays.stream(items).forEach(this::addItem);
    }

    public boolean addItem(Item item) {
        Node newNode = new Node(item, head, head.prev);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
        return true;
    }

    public boolean removeItem(String itemName) {
        Node currentNode = head.prev;
        while (currentNode != head) {
            if (currentNode.item.getName().equals(itemName)) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size--;
                return true;
            }
            currentNode = currentNode.prev;
        }
        return false;
    }

    public int removeAll(String itemName) {
        int count = 0;
        Node currentNode = head.prev;
        while (currentNode != head) {
            if (currentNode.item.getName().equals(itemName)) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size--;
                count++;
            }
            currentNode = currentNode.prev;
        }
        return count;
    }

    public int getOrderSize() {
        return size;
    }

    public Item[] getOrderedItems() {
        Item[] orderedItems = new Item[size];
        Node currentNode = head.next;
        int index = 0;
        while (currentNode != head) {
            orderedItems[index++] = currentNode.item;
            currentNode = currentNode.next;
        }
        return orderedItems;
    }

    public double getTotalCost() {
        double totalCost = 0;
        Node currentNode = head.next;
        while (currentNode != head) {
            totalCost += currentNode.item.getCost();
            currentNode = currentNode.next;
        }
        return totalCost;
    }

    public int getItemQuantity(String itemName) {
        int quantity = 0;
        Node currentNode = head.next;
        while (currentNode != head) {
            if (currentNode.item.getName().equals(itemName)) {
                quantity++;
            }
            currentNode = currentNode.next;
        }
        return quantity;
    }

    public String[] getUniqueItemNames() {
        String[] uniqueItemNames = new String[size];
        Node currentNode = head.next;
        int index = 0;
        while (currentNode != head) {
            Node finalCurrentNode = currentNode;
            if (Arrays.stream(uniqueItemNames).noneMatch(name -> name != null && name.equals(finalCurrentNode.item.getName()))) {
                uniqueItemNames[index++] = currentNode.item.getName();
            }
            currentNode = currentNode.next;
        }
        return Arrays.copyOf(uniqueItemNames, index);
    }

    public Item[] getSortedItemsByPrice() {
        Item[] sortedItems = getOrderedItems();
        Arrays.sort(sortedItems, (item1, item2) -> Double.compare(item2.getCost(), item1.getCost()));
        return sortedItems;
    }
}


