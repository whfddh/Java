// Order class
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int size;
    private List<Dish> dishes;

    // Constructor
    public Order() {
        this.size = 0;
        this.dishes = new ArrayList<>();
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
            }
        }
        if (toRemove != null) {
            size--;
            return dishes.remove(toRemove);
        }
        return false;
    }

    public int removeAll(String dishName) {
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
}
