import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            System.out.println("Enter key: ");
            String key = myScanner.next();

            try {
                printDetails(key);
                success = true;
            } catch (Exception e) {
                System.err.println("Exception caught: " + e.getMessage());
                System.err.println("Please try again.");
            }
        }
    }
    public void printDetails(String key) throws Exception {
        try { String message = getDetails(key);
            System.out.println( message );
        }catch ( Exception e){
            throw e;
        }
    }
    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );

        }
        else if(key.equals( "0")){
            throw new Exception("Key cannot be 0");
        }
        return "data for " + key; }

    public static void main(String[] args) throws Exception {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getKey();
    }
}
