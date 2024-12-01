import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<SortingStudentsByGPA.Student> {

    public static class Student {
        private int iDNumber;
        private double points;

        public Student(int iDNumber, double points) {
            this.iDNumber = iDNumber;
            this.points = points;
        }

        public int getiDNumber() {
            return iDNumber;
        }

        public double getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "iDNumber=" + iDNumber +
                    ", points=" + points +
                    '}';
        }
    }

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getPoints(), student1.getPoints());
    }

    public static void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].getPoints();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getPoints() >= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Student[] students = {new Student(1, 45), new Student(5, 55), new Student(8, 90), new Student(4, 29)};
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        quickSort(students, 0, students.length - 1);

        System.out.println("After sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
