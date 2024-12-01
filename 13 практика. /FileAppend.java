import java.io.*;
import java.util.Scanner;

public class FileAppend {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            FileWriter fileWriter = new FileWriter("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt", true);
            fileWriter.write('\n' + text);
            fileWriter.close();
            try(FileReader reader = new FileReader("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt")){
                int c;
                while((c = reader.read()) != -1){
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
