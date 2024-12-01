public class MVCEmployeeSalaryCalculator {
    public static void main(String[] args) {
        Employee model = new Employee("John Doe", 20.0, 40);
        EmployeeController controller = new EmployeeController(model, null);
        EmployeeView view = new EmployeeView(controller);
        controller.setView(view);
        view.setVisible(true);
    }
}
