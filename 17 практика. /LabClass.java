import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LabClass {
    private List<Student> students;

    public LabClass(List<Student> students){
        this.students = students;
    }

    public void sortStudents(){
        Collections.sort(students, (s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
    }
    public Student findByName(String name) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Студент с именем " + name + " не найден");
    }
}
