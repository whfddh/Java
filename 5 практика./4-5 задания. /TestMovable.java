public class TestMovable {
    public static void main(String[] args){
    MovablePoint point = new MovablePoint(0, 0, 0, 0);
    System.out.println("Movable Point info: ");
    System.out.println(point);
    point.moveDown();
    System.out.println("After MoveDown: ");
    System.out.println(point);
    point.moveLeft();
    System.out.println("After moveLeft:");
    System.out.println(point);
    MovableCircle circle = new MovableCircle(5, 6, 7, 8, 9);
    System.out.println("MovableCircle:");
    System.out.println(circle);
    circle.moveDown();
    System.out.println("After moveDown:");
    System.out.println(circle);
    circle.moveRight();
    System.out.println("After moveRight:");
    System.out.println(circle);
    MovableRectangle rectangle = new MovableRectangle(0, 0, 5, 4, 1, 1);
    System.out.println("MovableRectangle:");
    System.out.println(rectangle);
    rectangle.moveUp();
    System.out.println("After moveUp:");
    System.out.println(rectangle);
    rectangle.moveLeft();
    System.out.println("After moveLeft:");
    System.out.println(rectangle);
    System.out.println("\nChecking same speed: " + rectangle.SameSpeed());
    }
}
