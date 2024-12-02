import java.util.Arrays;

public class RestaurantTester {
    public static void main(String[] args) {
        testOrderManager();
        testInternetOrder();
        testRestaurantOrder();
    }

    private static void testOrderManager() {
        OrderManager orderManager = new OrderManager(5);

        // Create a sample order
        InternetOrder internetOrder = new InternetOrder();
        Dish dish = new Dish("Spaghetti", "Delicious pasta");
        Drink drink = new Drink(5, "Cola", "Refreshing cola", false, 0, DrinkTypeEnum.SODA);
        internetOrder.add(dish);
        internetOrder.add(drink);

        // Test adding orders to the order manager
        orderManager.add(internetOrder, 1); // Add order to table 1

        // Try adding the same order to the same table, should throw an exception
        try {
            orderManager.add(internetOrder, 1);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Try adding the same order to a different table, should not throw an exception
        orderManager.add(internetOrder, 3);

        // Check and display free tables
        int[] freeTables = orderManager.freeTableNumbers();
        if (freeTables.length == 0) {
            System.out.println("All tables are occupied.");
        } else {
            System.out.println("Free tables: " + Arrays.toString(freeTables));
        }

        // Display orders
        for (int i = 0; i < 5; i++) {
            Order order = orderManager.getOrder(i);
            if (order != null) {
                System.out.println("Order for Table " + i + ": " + order.getItems().toString());
            }
        }

        // Test removing orders from the order manager
        orderManager.removeOrder(1);
        orderManager.removeOrder(2);
    }

    private static void testRestaurantOrder() {
        // Test creating a RestaurantOrder
        RestaurantOrder restaurantOrder = new RestaurantOrder();
        Dish drink = new Dish("Pizza", "Refreshing cola");
        // Test adding dishes to the order
        Dish spaghetti = new Dish("Spaghetti", "Delicious pasta");
        Dish pizza = new Dish("Pizza", "Cheesy goodness");
        restaurantOrder.addDish(spaghetti);
        restaurantOrder.addDish(pizza);
        restaurantOrder.addDish(drink);

        // Test removing a dish by name
        restaurantOrder.removeDish("Spaghetti");

        // Test removing all dishes with a certain name
        restaurantOrder.addDish(spaghetti);
        restaurantOrder.addDish(spaghetti);
        int removedCount = restaurantOrder.removeAllDishes("Spaghetti");

        // Test sorting dishes by cost
        Dish[] sortedDishes = restaurantOrder.sortedDishesByCostDesc();

        // Print results
        System.out.println("Removed count: " + removedCount);
        System.out.println("Sorted dishes: " + Arrays.toString(sortedDishes));

        // Test getting the total cost
        double totalCost = restaurantOrder.costTotal();
        System.out.println("RestaurantOrder Total cost: " + totalCost);

        // Test getting dish quantity by name
        int pizzaQuantity = restaurantOrder.dishQuantity("Pizza");
        System.out.println("Pizza quantity: " + pizzaQuantity);

        // Test getting unique dish names
        String[] uniqueDishNames = restaurantOrder.dishesNames();
        System.out.println("Unique dish names: " + Arrays.toString(uniqueDishNames));

        // Test getting the order size
        int orderSize = restaurantOrder.dishQuantity();
        System.out.println("Order size: " + orderSize);

        // Test getting all dishes
        Dish[] allDishes = restaurantOrder.getDishes();
        System.out.println("All dishes: " + Arrays.toString(allDishes));
    }


    private static void testInternetOrder() {
        // Test creating an InternetOrder
        InternetOrder internetOrder = new InternetOrder();

        // Test adding items to the order
        Dish dish = new Dish("Pizza", "Cheesy goodness");
        Drink drink = new Drink(7, "Wine", "Red wine", true, 12, DrinkTypeEnum.WINE);
        internetOrder.add(dish);
        internetOrder.add(dish);
        internetOrder.add(drink);

        // Test removing an item by name
        internetOrder.removeItem("Pizza");

        // Test removing all items with a certain name
        internetOrder.add(dish);
        internetOrder.add(dish);
        int removedCount = internetOrder.removeAll("Pizza");

        // Test sorting items by cost
        MenuItem[] sortedItems = internetOrder.SortedItemsByCostDesc();

        // Print results
        System.out.println("Removed count: " + removedCount);
        System.out.println("Sorted items: " + Arrays.toString(sortedItems));

        // Test getting the total cost
        double totalCost = internetOrder.getTotalCost();
        System.out.println("InternetOrder Total cost: " + totalCost);

        // Test getting item quantity by name
        int pizzaQuantity = internetOrder.getItemQuantity("Pizza");
        System.out.println("Pizza quantity: " + pizzaQuantity);

        // Test getting unique item names
        String[] uniqueItemNames = internetOrder.getUniqueItemNames();
        System.out.println("Unique item names: " + Arrays.toString(uniqueItemNames));

        // Test getting the order size
        int orderSize = internetOrder.getOrderSize();
        System.out.println("Order size: " + orderSize);
    }
}
