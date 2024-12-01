public class razl {
    public static void recursion(int n, int divisor) {
        if (n < 2) {
            return;
        }
        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            recursion(n / divisor, divisor);
        } else {
            recursion(n, divisor + 1);
        }
    }
    public static void main(String[] args){
        int n = 3000;
        System.out.println("Введенное число: " + n);
        recursion(n, 2);
    }
}
