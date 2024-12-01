import java.io.*;
import java.util.Scanner;

public class FilesApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try (FileWriter writer = new FileWriter("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt  ")){
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
