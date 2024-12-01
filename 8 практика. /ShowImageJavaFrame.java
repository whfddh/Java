import javax.swing.*;

public class ShowImageJavaFrame extends JFrame
{
    public ShowImageJavaFrame(String title)
    {
        super(title);
    }

    public static void main(String[] args)
    {
        JFrame frame = new ShowImageJavaFrame("Показываем картинку");
        var icon = new ImageIcon("C:\\Users\\malol\\IdeaProjects\\untitled\\pr2\\pr8\\src\\images\\frame3.png");
        var panel = new JPanel();
        panel.add(new JLabel(icon));
        frame.add(panel);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
