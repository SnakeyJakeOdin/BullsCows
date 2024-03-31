import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate secret code
        System.out.println("Please, enter the secret code's length:");
        int codeLen = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbolsLen = scanner.nextInt();
        final String secretNum = generateSecretNum(codeLen, possibleSymbolsLen);

        // Game loop
        System.out.println("Okay, let's start a game!");
        int bulls;
        int cows;
        int turn = 1;
        String guessNum;
        do {
            System.out.printf("Turn %d:%n", turn);
            guessNum = scanner.next();
            bulls = findBulls(guessNum, secretNum);
            cows = findCows(guessNum, secretNum);

            System.out.printf("Grade: %d bulls and %d cows%n", bulls, cows);
            turn++;
        } while (bulls < secretNum.length());

        // End game
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static String generateSecretNum(int len, int numSymbols) {
        if (len > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", len);
            return null;
        }
        else {
            // random, unique number generation
            char[] possibleVal = new char[]{'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            ArrayList<Character> secretCode = new ArrayList<>();

            // fill ArrayList with possible values
            for (int i = 0; i < numSymbols; i++) {
                secretCode.add(possibleVal[i]);
            }
            Collections.shuffle(secretCode);

            // create a string from ArrayList
            String secret = "";
            for (int i = 0; i < len; i++) secret += secretCode.get(i);

            // print to console
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < len; i++) {
                System.out.print("*");
            }
            System.out.printf(" (0-9, a-%c).%n", possibleVal[numSymbols]);

            return secret;
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

    public static int findCows(String guessNum, String secretNum) {
        int cows = 0;
        for (int i = 0; i < guessNum.length(); i++) {
            for (int j = 0; j < guessNum.length(); j++) {
                if (guessNum.charAt(j) == secretNum.charAt(i)) {
                    cows++;
                }
            }
        }
        return cows - findBulls(guessNum, secretNum);
    }
}