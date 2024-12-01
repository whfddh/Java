import java.util.Scanner;

public class Exception1 {
    public static void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer: ");
        String intString = scanner.next();


        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        //} catch (NumberFormatException e) {
           // System.err.println("Invalid input. Please enter a valid integer.");
        //} catch (ArithmeticException e) {
          //  System.err.println("Attempted division by zero");
        } catch (Exception e){
            System.err.println("General Exeption: " + e.getMessage());
        }finally {
            System.out.println("This code always runs in the 'finally' block.");
        }


    }
    public static void main(String[] args){
        exceptionDemo();
    }
}
