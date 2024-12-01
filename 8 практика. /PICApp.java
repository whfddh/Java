import javax.swing.*;
import java.awt.*;

public class PICApp extends JFrame {
    Image image = new ImageIcon("src/1cv8st_o0DlRLn6di.png").getImage();

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        gr.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pic");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
