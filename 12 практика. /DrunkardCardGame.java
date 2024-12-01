import java.util.Scanner;
import java.util.Stack;

public class DrunkardCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод карт для обоих игроков
        String[] player1Cards = scanner.next().split("");
        String[] player2Cards = scanner.next().split("");

        Stack<Integer> player1Stack = new Stack<>();
        Stack<Integer> player2Stack = new Stack<>();
        int moves = 0;

        // Заполняем стеки картами игроков
        for (int i = 4; i >= 0; i--) {
            player1Stack.push(Integer.parseInt(player1Cards[i]));
            player2Stack.push(Integer.parseInt(player2Cards[i]));
        }

        while (moves < 106 && !player1Stack.isEmpty() && !player2Stack.isEmpty()) {
            int card1 = player1Stack.pop();
            int card2 = player2Stack.pop();

            if (card1 > card2) {
                player1Stack.add(0, card2); // Карта игрока 2 внизу колоды игрока 1
                player1Stack.add(0, card1);
            } else {
                player2Stack.add(0, card1); // Карта игрока 1 внизу колоды игрока 2
                player2Stack.add(0, card2);
            }
            moves++;
        }

        if (player1Stack.isEmpty()) {
            System.out.println("second " + moves);
        } else if (player2Stack.isEmpty()) {
            System.out.println("first " + moves);
        } else {
            System.out.println("botva");
        }
    }
}
