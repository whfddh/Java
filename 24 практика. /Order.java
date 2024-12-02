import java.util.ArrayList;
import java.util.List;
public interface Order {
    boolean add(MenuItem item);
    String[] ItemsNames();
    int itemsQuantity();
    int itemQuantity(String itemName);
    int itemQuantity(MenuItem itemName);
    MenuItem getItems();
    boolean remove(String itemName);
    boolean remove(MenuItem itemName);

    int removeAll(String itemName);
    int removeAll(MenuItem itemName);
    int costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
    MenuItem[] SortedItemsByCostDesc();

}
