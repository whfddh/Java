public class TestNameable {
    public static void main(String[] args){
        Nameable book = new Book("BB");
        Nameable planet = new Planet("Jupyter");
        Nameable car = new Car("Toyota");
        System.out.println("Марка машины: " + car.getName());
        System.out.println("Планета: " + planet.getName());
        System.out.println("Название книги: " + book.getName());
    }
}
