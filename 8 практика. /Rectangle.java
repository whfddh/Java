import java.awt.*;

public class Rectangle extends Shape{
    private int width;
    private int height;
    public Rectangle(int y, int x, Color color, int width, int height){
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void ris(Graphics graphics) {
        graphics.fillRect(x, y, width, height);
    }
}
