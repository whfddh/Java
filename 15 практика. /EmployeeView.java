import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Представление (View)
class EmployeeView extends JFrame {
    private JTextField nameField;
    private JTextField rateField;
    private JTextField hoursField;
    private JLabel resultLabel;
    private EmployeeController controller;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;

        setTitle("Employee Salary Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        nameField = new JTextField(10);
        rateField = new JTextField(10);
        hoursField = new JTextField(10);
        resultLabel = new JLabel("Salary: ");

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.notifyModel();
            }
        });

        panel.add(new JLabel("Name: "));
        panel.add(nameField);
        panel.add(new JLabel("Hourly Rate: "));
        panel.add(rateField);
        panel.add(new JLabel("Hours Worked: "));
        panel.add(hoursField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
    }

    public String getName() {
        return nameField.getText();
    }

    public double getHourlyRate() {
        return Double.parseDouble(rateField.getText());
    }

    public int getHoursWorked() {
        return Integer.parseInt(hoursField.getText());
    }

    public void setSalaryResult(double salary) {
        resultLabel.setText("Salary: $" + salary);
    }
}
