import java.util.Scanner;

public class Drunkard4 {
    private int[] player1;
    private int[] player2;
    private int moves;

    public Drunkard4(String input1, String input2) {
        player1 = new int[5];
        player2 = new int[5];
        for (int i = 0; i < 5; i++) {
            player1[i] = Integer.parseInt(input1.charAt(i) + "");
            player2[i] = Integer.parseInt(input2.charAt(i) + "");
        }
        moves = 0;
    }

    public void play() {
        while (moves < 106) {
            int card1 = player1[0];
            int card2 = player2[0];

            // Move the cards to the winner's deck
            if (card1 == 0 && card2 == 9) {
                player1[0] = card2;
                player2[0] = card1;
            } else if (card1 > card2) {
                for (int i = 1; i < 5; i++) {
                    player1[i - 1] = player1[i];
                    player2[i - 1] = player2[i];
                }
                player1[4] = card1;
                player1[3] = card2;
            } else {
                for (int i = 1; i < 5; i++) {
                    player1[i - 1] = player1[i];
                    player2[i - 1] = player2[i];
                }
                player2[4] = card2;
                player2[3] = card1;
            }

            moves++;

            // Check if a player has won
            if (player1[0] == 0 && player2[0] == 9) {
                System.out.println("second " + moves);
                return;
            } else if (player2[0] == 0 && player1[0] == 9) {
                System.out.println("first " + moves);
                return;
            }

            if (isEmpty(player1)) {
                System.out.println("second " + moves);
                return;
            } else if (isEmpty(player2)) {
                System.out.println("first " + moves);
                return;
            }
        }

        System.out.println("botva");
    }

    private boolean isEmpty(int[] deck) {
        for (int i : deck) {
            if (i != -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first player's cards (5 cards, e.g., 13579):");
        String input1 = scanner.next();
        System.out.println("Enter the second player's cards (5 cards, e.g., 24680):");
        String input2 = scanner.next();

        Drunkard4 game = new Drunkard4(input1, input2);
        game.play();
    }
}
