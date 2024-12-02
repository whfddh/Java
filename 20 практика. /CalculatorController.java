import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CalculatorController extends JFrame {
    private JTextField inputField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CalculatorController() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("RPN Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new GridLayout(2, 1));

        inputField = new JTextField();
        resultLabel = new JLabel("Result: ");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));

        calculateButton = new JButton("Calculate");
        JButton spaceButton = new JButton("Space");

        int centerX = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(centerX, centerY);

        // Создаем кнопки с цифрами от 0 до 9
        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            digitButtons[i] = new JButton(Integer.toString(i));
            digitButtons[i].addActionListener(new DigitButtonListener());
        }

        String[] operators = { "+", "-", "*", "/" };
        JButton[] operatorButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].addActionListener(new OperatorButtonListener());
        }

        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(operatorButtons[0]);
        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(operatorButtons[1]);
        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(operatorButtons[2]);
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(spaceButton);
        buttonPanel.add(operatorButtons[3]);

        add(inputField);
        add(buttonPanel);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] tokens = input.split("");
                CalculatorModel calculator = new CalculatorModel();
                try {
                    double result = calculator.RPN(tokens);
                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            }
        });

        spaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText(inputField.getText() + " ");
            }
        });
    }

    private class DigitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String digit = ((JButton) e.getSource()).getText();
            inputField.setText(inputField.getText() + digit);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operator = ((JButton) e.getSource()).getText();
            inputField.setText(inputField.getText() + " " + operator);
        }
    }

    public static void main(String[] args) {
        CalculatorController view = new CalculatorController();
        view.setVisible(true);
    }
}
