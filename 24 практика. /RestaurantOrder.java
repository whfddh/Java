import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Интерфейс для позиций заказа
class RestaurantOrder {
    private int size;
    private Node head;
    private List<Dish> dishes;

    // Constructor
    public RestaurantOrder() {
        this.size = 0;
        this.dishes = new ArrayList<>();
        this.head = new Node(null, null, null);
        this.head.next = this.head;
        this.head.prev = this.head;
    }

    // Methods
    public boolean addDish(Dish dish) {
        size++;
        return dishes.add(dish);
    }

    public boolean removeDish(String dishName) {
        Dish toRemove = null;
        for (Dish dish : dishes) {
            if (dish.getName().equals(dishName)) {
                toRemove = dish;
                break;
            }
        }
        if (toRemove != null) {
            size--;
            return dishes.remove(toRemove);
        }
        return false;
    }

    private static class Node {
        MenuItem item;
        Node next;
        Node prev;

        public Node(MenuItem item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public int removeAllDishes(String dishName) {
        int count = 0;
        for (Dish dish : new ArrayList<>(dishes)) {
            if (dish.getName().equals(dishName)) {
                dishes.remove(dish);
                count++;
                size--;
            }
        }
        return count;
    }

    public int dishQuantity() {
        return size;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Dish dish : dishes) {
            if (dish.getName().equals(dishName)) {
                count++;
            }
        }
        return count;
    }

    public Dish[] getDishes() {
        return dishes.toArray(new Dish[0]);
    }

    public double costTotal() {
        double totalCost = 0;
        for (Dish dish : dishes) {
            totalCost += dish.getCost();
        }
        return totalCost;
    }

    public String[] dishesNames() {
        List<String> names = new ArrayList<>();
        for (Dish dish : dishes) {
            names.add(dish.getName());
        }
        return names.toArray(new String[0]);
    }

    public Dish[] sortedDishesByCostDesc() {
        Dish[] sortedDishes = dishes.toArray(new Dish[0]);
        // Sorting in descending order
        for (int i = 0; i < sortedDishes.length - 1; i++) {
            for (int j = 0; j < sortedDishes.length - i - 1; j++) {
                if (sortedDishes[j].getCost() < sortedDishes[j + 1].getCost()) {
                    Dish temp = sortedDishes[j];
                    sortedDishes[j] = sortedDishes[j + 1];
                    sortedDishes[j + 1] = temp;
                }
            }
        }
        return sortedDishes;
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
}
