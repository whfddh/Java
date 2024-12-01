public class Student {
    private String name;
    private double averageGrade;

    public Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getAverageGrade(), student1.getAverageGrade());
    }

    public static void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].getAverageGrade();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getAverageGrade() >= pivot) {
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
    public static void print(Student[] students) {
        System.out.println("After sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
