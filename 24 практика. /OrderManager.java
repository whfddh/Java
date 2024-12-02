import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderManager {
    private HashMap<String, Order> addressOrderMap;
    private Order[] orders;

    // Constructor
    public OrderManager(int numberOfTables) {
        this.orders = new Order[numberOfTables];
        this.addressOrderMap = new HashMap<>();
    }

    // Add an order to a specific table
    public void add(Order order, int tableNumber) {
        if (tableNumber < 0 || tableNumber >= orders.length) {
            throw new IllegalArgumentException("Invalid table number");
        }
        if (orders[tableNumber] != null) {
            throw new OrderAlreadyAddedException("Order already exists for table " + tableNumber);
        }

        orders[tableNumber] = order;
    }

    // Add a menu item to a specific table's order
    public void add(MenuItem item, int tableNumber) {
        if (tableNumber < 0 || tableNumber >= orders.length) {
            throw new IllegalArgumentException("Invalid table number");
        }

        if (orders[tableNumber] == null) {
            throw new IllegalStateException("No order exists for the specified table");
        }

        orders[tableNumber].add(item);
    }

    // Get the first free table number (return -1 if no free table is found)
    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i;
            }
        }
        return -1; // No free table found
    }

    // Get an array of free table numbers
    public int[] freeTableNumbers() {
        List<Integer> freeTables = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                freeTables.add(i);
            }
        }
        return freeTables.stream().mapToInt(Integer::intValue).toArray();
    }

    // Get the order for a specific table
    public Order getOrder(String address) {
        return addressOrderMap.get(address);
    }
    public Order getOrder(int tableNumber) {
        if (tableNumber < 0 || tableNumber >= orders.length) {
            throw new IllegalArgumentException("Invalid table number");
        }
        return orders[tableNumber];
    }

    // Remove the order for a specific table
    public void removeOrder(int tableNumber) {
        if (tableNumber < 0 || tableNumber >= orders.length) {
            throw new IllegalArgumentException("Invalid table number");
        }
        orders[tableNumber] = null;
    }

    // Remove the specified order from the manager and return the table number
    public int removeOrder(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == order) {
                orders[i] = null;
                return i;
            }
        }
        return -1; // Order not found
    }

    // Remove all occurrences of the specified order from the manager and return the count
    public int removeAllOrders(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == order) {
                orders[i] = null;
                count++;
            }
        }
        return count;
    }
}
