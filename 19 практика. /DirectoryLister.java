import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryLister {
    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        File directory = new File("C:\\Users\\malol\\OneDrive\\Рабочий стол\\Новая папка (2)");
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file.getName());
            }
        }
        for (int i = 0; i < 5 && i < fileList.size(); i++) {
            System.out.println(fileList.get(i));
        }
    }
}
