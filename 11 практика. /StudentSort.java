public class StudentSort {

    public static void insertionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getiDNumber() > key.getiDNumber()) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }



    public static void main(String[] args){

        Student[] students = {new Student(1), new Student(5), new Student(8), new Student(4)};
        System.out.println("Before sorting:");
        printStudents(students);

        insertionSort(students);

        System.out.println("After sorting:");
        printStudents(students);
    }
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
