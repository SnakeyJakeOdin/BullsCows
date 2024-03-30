import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        String secretNum = generateSecretNum(scanner.nextInt());
        //TODO: Delete
        System.out.println(secretNum);

        System.out.println("Okay, let's start a game!");
        int bulls = 0;
        int cows = 0;
        int turn = 1;
        String guessNum;
        while (bulls < 4) {
            System.out.printf("Turn %d:%n", turn);
            guessNum = scanner.next();
            bulls = findBulls(guessNum, secretNum);

            System.out.printf("Grade: %d bull(s) and %d cow(s)%n", bulls, 0);
        }

    }

    public static String generateSecretNum(int len) {
        if (len > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", len);
            return null;
        }
        else {
            // random, unique number generation
            Stack<Integer> stack = new Stack<>();
            for (int i = 9; i >= 0; i--) {
                stack.push(i);
            }
            while (stack.peek() == 0) {
                Collections.shuffle(stack);
            }

            // unique generation --> secret number
            long secretNum = 0;
            for (int i = len - 1; i >= 0; i--) {
                secretNum += stack.pop() * (long)Math.pow(10, i);  // caused stack overflow 💀
            }
            return String.valueOf(secretNum);
        }
    }

    public static int findBulls(String guessNum, String secretNum) {
        int bulls = 0;
        for (int i = 0; i < guessNum.length(); i++) {
            if (guessNum.charAt(i) == secretNum.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }
}