import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Drunkard3 {
    public static void main(String[] args){
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.next().split("");
        String[] second = scanner.next().split("");

        LinkedList<Integer> player1Deck = new LinkedList<>();
        LinkedList<Integer> player2Deck = new LinkedList<>();

        for (int i = 0; i <= 4; i++) {
            player1Deck.add(Integer.parseInt(first[i]));
            player2Deck.add(Integer.parseInt(second[i]));
        }

        while (moves < 106 && !player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            int card1 = player1Deck.remove();
            int card2 = player2Deck.remove();

            int effectivecard1 = (card1 == 9 && card2 == 0) ? -1 : card1;
            int effectivecard2 = (card2 == 9 && card1 == 0) ? -1 : card2;

            if (effectivecard1 > effectivecard2) {
                player1Deck.add(card1);
                player1Deck.add(card2);
            } else {
                player2Deck.add(card2);
                player2Deck.add(card1);
            }
            moves++;
        }

        if (player1Deck.isEmpty()) {
            System.out.println("second " + moves);
        } else if (player2Deck.isEmpty()) {
            System.out.println("first " + moves);
        } else {
            System.out.println("botva");
        }
    }
}
