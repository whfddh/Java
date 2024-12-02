public class TestBall {
    public static void main(String[] args){
        Ball ball = new Ball();
        ball.setXY(12.0, 11.0);
        System.out.println(ball.getX());
        System.out.println(ball.getY());
        ball.setY(10.0);
        System.out.println(ball.getX());
        System.out.println(ball.getY());
        ball.move(2, 1);
        System.out.println(ball);
    }
}
