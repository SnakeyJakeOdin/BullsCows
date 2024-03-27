import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Class setup
        Scanner scanner = new Scanner(System.in);
        SecretKeeper secretKeeper = new SecretKeeper("9305");
        int[] bullsAndCows = secretKeeper.getBullsAndCows(scanner.nextLine());

        // Variables to compare
        int bulls = bullsAndCows[0];
        int cows = bullsAndCows[1];

        // Logic
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cows(s).", bulls, cows);
        }
        else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s).", bulls);
        }
        else if (cows > 0) {
            System.out.printf("Grade: %d cow(s).", cows);
        }
        else {
            System.out.print("None.");
        }
        System.out.printf(" The secret code is %s.", "9305");
    }
}