import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private int bulls;
    private int cows;
    private int turn;
    private String secret;

    public Game() {
        this.bulls = 0;
        this.cows = 0;
        this.turn = 1;
    }
    public void incrementTurn() {
        turn++;
    }
    protected void generateCode() {
        int secretLength = promptSecretLength();
        int desiredNumberOfSymbols = promptDesiredNumberOfSymbols();
        this.secret = generateSecretNum(secretLength, desiredNumberOfSymbols);
    }
    protected void showSecret() {
        System.out.println("Secret code: " + secret);
    }
    protected void play() {
        System.out.println("Okay, let's start a game!");

        String guessNum;
        while (bulls < secret.length()) {
            System.out.printf("Turn %d:%n", turn);

            guessNum = scanner.next();
            findBulls(guessNum);
            findCows(guessNum);

            System.out.printf("Grade: %d bulls and %d cows%n", bulls, cows);
            incrementTurn();
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
    private String generateSecretNum(int secretLength, int desiredNumberOfSymbols) {
        if (secretLength > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", secretLength);
            return null;
        }
        else {
            // list of all 36 possibilities ranging from 0-9 and a-z
            char[] allPossibleValues = new char[]{'0','1','2','3','4','5','6','7','8','9',
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

            // fill a list that will contain only the desired number of possible symbols
            ArrayList<Character> secretArray = new ArrayList<>();
            for (int i = 0; i < desiredNumberOfSymbols; i++) {
                secretArray.add(allPossibleValues[i]);
            }
            Collections.shuffle(secretArray);

            // use StringBuilder (it is better when using for loops supposedly)
            StringBuilder secret = new StringBuilder();
            for (int i = 0; i < secretLength; i++) secret.append(secretArray.get(i));

            // print to console
            System.out.print("The secret is prepared: ");
            for (int i = 0; i < secretLength; i++) {
                System.out.print("*");
            }
            System.out.printf(" (0-9, a-%c).%n", allPossibleValues[desiredNumberOfSymbols - 1]);

            return String.valueOf(secret);
        }

    }
    private int promptSecretLength() {
        System.out.println("Please, enter the secret code's length:");
        return scanner.nextInt();
    }
    private int promptDesiredNumberOfSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        return scanner.nextInt();
    }
    private void findBulls(String guessNum) {
        bulls = 0;
        for (int i = 0; i < guessNum.length(); i++) {
            if (guessNum.charAt(i) == secret.charAt(i)) {
                bulls++;
            }
        }
    }
    private void findCows(String guessNum) {
        cows = 0;
        for (int i = 0; i < guessNum.length(); i++) {
            for (int j = 0; j < guessNum.length(); j++) {
                if (guessNum.charAt(j) == secret.charAt(i)) {
                    cows++;
                }
            }
        }
        cows -= bulls;
    }
}
