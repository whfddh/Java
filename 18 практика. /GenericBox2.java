import java.io.Serializable;

public class GenericBox2<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T one;
    private K two;
    private V three;

    public GenericBox2(T one, K two, V three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public V getThree() {
        return three;
    }

    public T getOne() {
        return one;
    }

    public K getTwo() {
        return two;
    }

    public void printClassNames() {
        System.out.println("First Class: " + one.getClass().getName());
        System.out.println("Second Class: " + two.getClass().getName());
        System.out.println("Third Class: " + three.getClass().getName());
    }
}
