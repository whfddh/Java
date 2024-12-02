import java.util.Arrays;

public class InternetOrder implements Order{
    static class Node {
        MenuItem item;
        Node next;
        Node prev;

        public Node(MenuItem item, Node next, Node prev) {
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

    public InternetOrder(MenuItem[] items) {
        this();
        Arrays.stream(items).forEach(this::add);
    }

    public boolean add(MenuItem item) {
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

    @Override
    public int removeAll(MenuItem itemName) {
        return 0;
    }

    @Override
    public int costTotal() {
        return 0;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public void setCustomer(Customer customer) {

    }

    @Override
    public MenuItem[] SortedItemsByCostDesc() {
        MenuItem[] sortedItems = getOrderedItems();
        Arrays.sort(sortedItems, (item1, item2) -> Double.compare(item2.getCost(), item1.getCost()));

        // Convert Item[] to MenuItem[]
        MenuItem[] sortedMenuItems = new MenuItem[sortedItems.length];
        for (int i = 0; i < sortedItems.length; i++) {
            sortedMenuItems[i] = (MenuItem) sortedItems[i];
        }

        return sortedMenuItems;
    }

    public int getOrderSize() {
        return size;
    }

    public MenuItem[] getOrderedItems() {
        MenuItem[] orderedItems = new MenuItem[size];
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

    public MenuItem[] getSortedItemsByPrice() {
        MenuItem[] sortedItems = getOrderedItems();
        Arrays.sort(sortedItems, (item1, item2) -> Double.compare(item2.getCost(), item1.getCost()));
        return sortedItems;
    }
    @Override
    public String[] ItemsNames() {
        return getUniqueItemNames();
    }
    @Override
    public int itemsQuantity() {
        return getOrderSize();
    }

    @Override
    public int itemQuantity(String itemName) {
        return getItemQuantity(itemName);
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        return 0;
    }

    @Override
    public MenuItem getItems() {
        return head.next.item;
    }

    @Override
    public boolean remove(String itemName) {
        return false;
    }

    @Override
    public boolean remove(MenuItem itemName) {
        return false;
    }
}


