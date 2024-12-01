public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }
    public void setStudentName(String name){
        model.setName(name);
    }
    public String getStudentName(){
        return model.getName();
    }
    public String getStudentRollNo(){
        return model.getRollNo();
    }
    public void setStudentRollNo(String RollNo){
        model.setRollNo(RollNo);
    }
    public void updateView(){
        view.printStudentDetails(model.getName(), model.getRollNo());
    }


}
