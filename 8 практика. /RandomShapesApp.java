import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapesApp extends JPanel {
    private List<Shape> shapes;

    public RandomShapesApp() {
        shapes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            int width = random.nextInt(100);
            int height = random.nextInt(100);

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color color = new Color(red, green, blue);

            if (random.nextBoolean()) {
                shapes.add(new Circle(color, x, y, width));
            } else {
                shapes.add(new Rectangle(y, x, color, width, height));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.ris(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setSize(700, 700);
        frame.add(new RandomShapesApp());
        frame.setVisible(true);
    }
}
