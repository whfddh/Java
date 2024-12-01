import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Drunkard2 {
    public static void main(String[] args){
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.next().split("");
        String[] second = scanner.next().split("");

        Queue<Integer> player1Dequeue = new ArrayDeque<>();
        Queue<Integer> player2Dequeue = new ArrayDeque<>();

        for (int i = 0; i <= 4; i++) {
            player1Dequeue.add(Integer.parseInt(first[i]));
            player2Dequeue.add(Integer.parseInt(second[i]));
        }

        while (moves < 106 && !player1Dequeue.isEmpty() && !player2Dequeue.isEmpty()) {
            int card1 = player1Dequeue.poll();
            int card2 = player2Dequeue.poll();

            int effectivecard1 = (card1 == 9 && card2 == 0) ? -1 : card1;
            int effectivecard2 = (card2 == 9 && card1 == 0) ? -1 : card2;

            if (effectivecard1 > effectivecard2) {
                player1Dequeue.add(card1);
                player1Dequeue.add(card2);
            } else {
                player2Dequeue.add(card2);
                player2Dequeue.add(card1);
            }
            moves++;
        }

        if (player1Dequeue.isEmpty()) {
            System.out.println("second " + moves);
        } else if (player2Dequeue.isEmpty()) {
            System.out.println("first " + moves);
        } else {
            System.out.println("botva");
        }
    }
}
