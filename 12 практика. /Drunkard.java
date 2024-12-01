import java.util.Scanner;
import java.util.Stack;

public class Drunkard {
    public static void main(String[] args){
        int moves = 0;
        Scanner scanner = new Scanner(System.in);

        String[] firstPlayer = scanner.next().split("");
        String[] secondPlayer = scanner.next().split("");

        Stack<Integer> player1Stack = new Stack<>();
        Stack<Integer> player2Stack = new Stack<>();

        for (int i = 4; i >= 0; i--){
            player1Stack.push(Integer.parseInt(firstPlayer[i]));
            player2Stack.push(Integer.parseInt(secondPlayer[i]));
        }
        while (moves < 106 && !player1Stack.isEmpty() && !player2Stack.isEmpty()){
            int card1 = player1Stack.pop();
            int card2 = player2Stack.pop();

            int effectivecard1 = (card1 == 9 && card2 == 0) ? -1: card1;
            int effectivecard2 = (card2 == 9 && card1 == 0) ? -1: card2;

            if (effectivecard1 > effectivecard2){
                player1Stack.add(0,card1);
                player1Stack.add(0,card2);
            }else{
                player2Stack.add(0,card2);
                player2Stack.add(0,card1);
            }
            moves++;
        }

        if (player1Stack.isEmpty()){
            System.out.println("second " + moves);
        } else if (player2Stack.isEmpty()){
            System.out.println("first " + moves);
        }
        else{
            System.out.println("botva");
        }

    }
}
