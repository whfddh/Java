import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Drunkard1 {
    public static void main(String[] args) {
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.next().split("");
        String[] second = scanner.next().split("");

        Queue<Integer> player1Queue = new LinkedList<>();
        Queue<Integer> player2Queue = new LinkedList<>();

        for (int i = 0; i <= 4; i++) {
            player1Queue.add(Integer.parseInt(first[i]));
            player2Queue.add(Integer.parseInt(second[i]));
        }

        while (moves < 106 && !player1Queue.isEmpty() && !player2Queue.isEmpty()) {
            int card1 = player1Queue.poll();
            int card2 = player2Queue.poll();

            int effectivecard1 = (card1 == 9 && card2 == 0) ? -1 : card1;
            int effectivecard2 = (card2 == 9 && card1 == 0) ? -1 : card2;

            if (effectivecard1 > effectivecard2) {
                player1Queue.add(card1);
                player1Queue.add(card2);
            } else {
                player2Queue.add(card2);
                player2Queue.add(card1);
            }
            moves++;
        }

        if (player1Queue.isEmpty()) {
            System.out.println("second " + moves);
        } else if (player2Queue.isEmpty()) {
            System.out.println("first " + moves);
        } else {
            System.out.println("botva");
        }
    }
}
