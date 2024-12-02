import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders;
    private int freeTableNumbers;

    // Constructor
    public OrderManager() {
        this.orders = new HashMap<>();
        this.freeTableNumbers = 10; // Assuming 10 tables are available initially
    }

    // Methods
    public void addOrder(Order order, int tableNumber) {
        if (freeTableNumbers > 0 && !orders.containsKey(tableNumber)) {
            orders.put(tableNumber, order);
            freeTableNumbers--;
        }
    }

    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public int getOrderTableNumber(Order order) {
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            if (entry.getValue().equals(order)) {
                return entry.getKey();
            }
        }
        return -1; // Return -1 if order not found
    }

    public void removeOrder(int tableNumber) {
        if (orders.containsKey(tableNumber)) {
            orders.remove(tableNumber);
            freeTableNumbers++;
        }
    }

    public int freeTableNumbers() {
        return freeTableNumbers;
    }

    public double ordersCostSummary() {
        double totalCost = 0;
        for (Order order : orders.values()) {
            totalCost += order.costTotal();
        }
        return totalCost;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Order order : orders.values()) {
            count += order.dishQuantity(dishName);
        }
        return count;
    }
}

