import java.util.*;

public class Secret {
    private final int[] secret;

    public Secret() {
        this.secret = generateRandomSecret();
        System.out.println(Arrays.toString(secret));
    }
    public Secret(String secretNumber) {
        this.secret = stringToArray(secretNumber);
    }

    public int[] getSecret() {
        return this.secret;
    }

    private int[] generateRandomSecret() {
        // Create array of unique random numbers
        Stack<Integer> nums = new Stack<>();
        for (int i = 9; i >= 0; i--) {
            nums.add(i);
        }

        // Make sure array does not start with a 0
        while (nums.peek() == 0) {
            Collections.shuffle(nums);
        }

        // Generate secret code
        int[] secretCode = new int[4];
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = nums.pop();
        }

        return secretCode;
    }

    public int[] getBullsAndCows(String guesserNumber) {
        // Create array of user input
        int[] guess = stringToArray(guesserNumber);

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

    private int[] stringToArray(String s) {
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - 48;
        }
        return arr;
    }
}