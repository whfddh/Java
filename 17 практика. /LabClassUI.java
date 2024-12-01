import java.util.Scanner;

public class LabClassUI{
    private LabClass labClass;

    public LabClassUI(LabClass labClass) {
        this.labClass = labClass;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Меню:");
            System.out.println("1. Сортировка студентов");
            System.out.println("2. Поиск студента по ФИО");
            System.out.println("3. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    labClass.sortStudents();
                    System.out.println("Студенты отсортированы по среднему баллу.");
                    break;
                case 2:
                    System.out.print("Введите ФИО студента: ");
                    scanner.nextLine(); // Очистка буфера
                    String name = scanner.nextLine();
                    try {
                        if (name.isEmpty()) {
                            throw new EmptyStringException("ФИО не может быть пустым.");
                        }
                        Student foundStudent = labClass.findByName(name);
                        System.out.println("Студент найден: " + foundStudent.getName() + ", Средний балл: " + foundStudent.getAverageGrade());
                    } catch (StudentNotFoundException e) {
                        System.err.println(e.getMessage());
                    } catch (EmptyStringException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}
