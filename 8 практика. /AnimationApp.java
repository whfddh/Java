import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationApp extends JFrame {
    private ImageIcon[] frames;
    private int currentFrame = 0;
    private Timer timer;

    public AnimationApp(String title) {
        super(title);

        frames = new ImageIcon[4];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new ImageIcon("C:\\Users\\malol\\IdeaProjects\\untitled\\pr2\\pr8\\src\\images\\frame" + i + ".png");
        }

        int delay = 400;
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame = (currentFrame + 1) % frames.length;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ImageIcon currentImage = frames[currentFrame];
        Image image = currentImage.getImage();
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimationApp app = new AnimationApp("Пример анимации");
            app.setSize(800, 600);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setVisible(true);
        });
    }
}
