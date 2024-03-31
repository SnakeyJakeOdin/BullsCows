import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private int bulls;
    private int cows;
    private int turn = 1;
    private String secret;

    public Game() {
    }

    public int getBulls() {
        return this.bulls;
    }
    public int getCows() {
        return this.cows;
    }
    public int getTurn() {
        return this.turn;
    }
    public void setBulls(int bulls) {
        this.bulls = bulls;
    }
    public void setCows(int cows) {
        this.cows = cows;
    }
    public void incrementTurn() {
        turn++;
    }

    protected void generateCode() {
        int secretLength = promptSecretLength();
        int desiredNumberOfSymbols = promptDesiredNumberOfSymbols();
        this.secret = generateSecretNum(secretLength, desiredNumberOfSymbols);
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
}
