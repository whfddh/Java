// Контроллер (Controller)
class   EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }
    public void setView(EmployeeView view) {
        this.view = view;
    }

    public void updateView() {
        view.setSalaryResult(model.calculateSalary());
    }

    public void notifyModel() {
        model = new Employee(view.getName(), view.getHourlyRate(), view.getHoursWorked());
        updateView();
    }
}
