import java.awt.*;

public class Circle extends Shape {
    private int radius;
    public Circle(Color color, int x, int y, int radius){
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void ris(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x - radius, y - radius, 2 * radius, 3 * radius);
    }
}
