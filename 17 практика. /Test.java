import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        String FIO = scanner.next();
        System.out.println("Введите ИНН: ");
        String INN = scanner.next();
        Online online = new Online(FIO, INN);
        try {
            Online.isINNValid(INN);
            System.out.println("ИНН валиден");}
        catch(Online.InvalidINNException e) {
            System.err.println("ИНН не валиден");
        }
    }
}
