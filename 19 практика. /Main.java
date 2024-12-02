import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.next().split("");
        List<String> list = new ArrayList<>();
        for (String i : str){
            list.add(i);
        }
        System.out.println(list);
    }
}
