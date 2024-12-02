public class TripleGenericTest {
    public static void main(String[] args) {
        GenericBox<String, Integer, Boolean> triple = new GenericBox<>("Hello", true, 42);

        String firstValue = triple.getContent();
        Boolean secondValue = triple.getCon();
        Integer thirdValue = triple.getTent();

        System.out.println("First Value: " + firstValue);
        System.out.println("Second Value: " + secondValue);
        System.out.println("Third Value: " + thirdValue);
    }
}
