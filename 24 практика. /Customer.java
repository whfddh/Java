public class Customer{
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    private Customer MATURE_UNKNOWN_CUSTOMER;
    private Customer NOT_MATURE_UNKNOWN_CUSTOMER;

    public Customer(String firstName, String secondName, int age, Address address, Customer MATURE_UNKNOWN_CUSTOMER, Customer NOT_MATURE_UNKNOWN_CUSTOMER) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
        this.MATURE_UNKNOWN_CUSTOMER = MATURE_UNKNOWN_CUSTOMER;
        this.NOT_MATURE_UNKNOWN_CUSTOMER = NOT_MATURE_UNKNOWN_CUSTOMER;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

}
