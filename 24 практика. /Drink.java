// Класс для напитков
final class Drink extends MenuItem implements Alcoholable {
    private static final int DEFAULT_COST = 0;

    private final int cost;
    private final String name;
    private final String description;
    private final boolean isAlcoholic;
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(String name, String description) {
        this(DEFAULT_COST, name, description, false, 0, null);
    }

    public Drink(int cost, String name, String description, boolean isAlcoholic, double alcoholVol, DrinkTypeEnum type) {
        super(name, description, cost);
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid Drink parameters");
        }
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.isAlcoholic = isAlcoholic;
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return isAlcoholic;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", isAlcoholic=" + isAlcoholic +
                ", alcoholVol=" + alcoholVol +
                ", type=" + type +
                '}';
    }
}
