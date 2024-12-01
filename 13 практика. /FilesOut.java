import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilesOut {
    public static void main(String[] args){
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
