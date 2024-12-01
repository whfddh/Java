public class TestMovable {
    public static void main(String[] args) {
        Movable m = new MovablePoint(0, 0, 1, 4);
        System.out.println("Point:\n");
        System.out.println(m);
        m.moveUp();
        m.moveRight();
        System.out.println("Up+Right -> " + m);

        System.out.println("\nRectangle:\n");
        m = new MovableRectangle(0, 0, 4, 4, 2,4);
        System.out.println(m);
        m.moveRight();
        m.moveDown();
        System.out.println("Right+Down -> " + m);

        System.out.println("\nChanging speed for rectangle:");
        MovableRectangle r = (MovableRectangle) m;
        try{
            r.moveDown();
        }catch (IllegalStateException e){
            System.out.println(e);
        }
    }
}
