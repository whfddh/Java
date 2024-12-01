import java.util.ArrayList;
import java.util.List;

public class LabClassDriver {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 4.5));
        students.add(new Student("Петров", 3.9));
        students.add(new Student("Сидоров", 4.2));

        LabClass labClass = new LabClass(students);

        LabClassUI labClassUI = new LabClassUI(labClass);

        labClassUI.displayMenu();
    }
}
