public class MVCPatternDemo{
    public static void main(String[] args){
        Student model = retriveCourseFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        System.out.println("Updated info:");
        controller.setStudentName("Sasha");
        controller.setStudentRollNo("101");
        controller.updateView();
    }

    public static Student retriveCourseFromDatabase(){
        Student student = new Student();
        student.setName("Max");
        student.setRollNo("102");
        System.out.println("Previous info: ");
        System.out.println(student.getName() + " " + student.getRollNo());
        return student;

    }
}
