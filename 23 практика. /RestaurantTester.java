import java.util.Arrays;

public class RestaurantTester {

    public static void main(String[] args) {
        testOrderManager();
        testInternetOrder();
    }

    private static void testOrderManager() {
        OrderManager orderManager = new OrderManager();

        Dish dish1 = new Dish("Pizza", "Delicious pizza");
        Dish dish2 = new Dish("Burger", "Tasty burger");
        Drink drink1 = new Drink("Coke", "Refreshing cola");

        Order order1 = new Order();
        order1.addDish(dish1);
        order1.addDish(dish2);

        Order order2 = new Order();

        orderManager.addOrder(order1, 1);
        orderManager.addOrder(order2, 2);

        System.out.println("Order 1 Table Number: " + orderManager.getOrderTableNumber(order1));
        System.out.println("Order 2 Table Number: " + orderManager.getOrderTableNumber(order2));

        System.out.println("Free Table Numbers: " + orderManager.freeTableNumbers());
        System.out.println("Orders Cost Summary: " + orderManager.ordersCostSummary());

        orderManager.removeOrder(1);
        System.out.println("Free Table Numbers after removing Order 1: " + orderManager.freeTableNumbers());
        System.out.println("Orders Cost Summary after removing Order 1: " + orderManager.ordersCostSummary());

        System.out.println("Dish Quantity for Coke: " + orderManager.dishQuantity("Coke"));
    }

    private static void testInternetOrder() {
        Dish dish1 = new Dish("Pizza", "Delicious pizza");
        Dish dish2 = new Dish("Burger", "Tasty burger");
        Drink drink1 = new Drink("Coke", "Refreshing cola");

        InternetOrder internetOrder = new InternetOrder(new Item[]{dish1, dish2, drink1});

        System.out.println("Initial Order Size: " + internetOrder.getOrderSize());

        internetOrder.addItem(new Dish("Pasta", "Yummy pasta"));
        System.out.println("Order Size after adding Pasta: " + internetOrder.getOrderSize());

        internetOrder.addItem(new Drink("Soda", "Sweet soda"));
        System.out.println("Order Size after adding Soda: " + internetOrder.getOrderSize());

        internetOrder.removeItem("Burger");
        System.out.println("Order Size after removing Burger: " + internetOrder.getOrderSize());

        internetOrder.removeAll("Pizza");
        System.out.println("Order Size after removing all Pizza: " + internetOrder.getOrderSize());

        System.out.println("Dish Quantity for Coke: " + internetOrder.getItemQuantity("Coke"));

        String[] uniqueItemNames = internetOrder.getUniqueItemNames();
        System.out.println("Unique Item Names: " + Arrays.toString(uniqueItemNames));

        Item[] sortedItemsByPrice = internetOrder.getSortedItemsByPrice();
        System.out.println("Sorted Items by Price: " + Arrays.toString(sortedItemsByPrice));
    }
}
