import java.io.*;
import java.util.Scanner;

public class FileReplace{
    public static void main(String[] args){
        try(FileReader reader = new FileReader("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt")){
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try (FileWriter writer = new FileWriter("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt  ")){
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
        try(FileReader reader = new FileReader("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)\\123.txt")){
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
