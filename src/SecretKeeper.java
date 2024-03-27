import java.util.*;

public class SecretKeeper {
    private final int[] secret;

    public SecretKeeper() {
        this.secret = generateRandomSecret();
    }
    public SecretKeeper(String secretNumber) {
        // Convert user String into an array
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = secretNumber.charAt(i) - 48;
        }
        this.secret = arr;
    }

    public int[] getSecret() {
        return this.secret;
    }

    private int[] generateRandomSecret() {
        // Create array of unique random numbers
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i <= 9; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        // Generate secret code
        int[] secretCode = new int[4];
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = nums.pop();
        }

        return secretCode;
    }

    public int[] getBullsAndCows(String guesserNumber) {
        // Create array of user input
        int[] guess = new int[4];
        for (int i = 0; i < guess.length; i++) {
            guess[i] = guesserNumber.charAt(i) - 48;
        }

        // Compare
        int numCows = 0;
        int numBulls = 0;
        for (int i = 0; i < secret.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                // Cow check
                if (secret[i] == guess[j]) {
                    numCows++;
                }
            }
            // Bull check
            if (secret[i] == guess[i]) {
                numCows--;
                numBulls++;
            }
        }

        return new int[]{numBulls, numCows};
    }
}