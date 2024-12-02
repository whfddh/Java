public class Test2 {
    public static void main(String[] args) {
        Animal animal = new Animal("Grisha", 12);
        GenericBox2<String, Animal, Integer> box = new GenericBox2<>("Hello", 42, animal);

        String firstValue = box.getOne();
        Integer secondValue = box.getTwo();
        Animal thirdValue = box.getThree();

        System.out.println("First Value: " + firstValue);
        System.out.println("Second Value: " + secondValue);
        System.out.println("Third Value: " + thirdValue);
    }
}
