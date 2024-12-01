// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Solution {
    public static String recursion(int n, int divisor) {
        if (n <= 1) {
            return "NO";
        }
        if (divisor * divisor > n){
            return "YES";
        }
        if (n % divisor == 0){
            return "NO";
        }
        return recursion(n, divisor + 1);
    }
    public static void main(String[] args){
        int n = 113;
        System.out.println("Введенное число: " + n);
        String result = recursion(n, 2);
        System.out.println(result);
    }
}
