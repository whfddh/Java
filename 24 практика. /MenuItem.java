public class MenuItem {
    private String name;
    private String description;
    private int cost;

    public MenuItem(String name, String description, int cost) {
        if (name == null || description == null || name.isEmpty() || description.isEmpty() || cost < 0) {
            throw new IllegalArgumentException("Invalid MenuItem parameters");
        }
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}
