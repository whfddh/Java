import java.awt.*;
import javax.swing.*;
import java.util.Random;
public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public abstract void ris(Graphics graphics);
}
