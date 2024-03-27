import java.util.*;

public class SecretKeeper {
    private final int[] secretNum;

    public SecretKeeper() {
        this.secretNum = generateNum();
    }
    public SecretKeeper(String secret) {
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = secret.charAt(i) - 48;
        }
        this.secretNum = arr;
    }

    public int[] getSecretNum() {
        return this.secretNum;
    }

    private int[] generateNum() {
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

    public int[] checkBullsAndCows(String userGuess) {
        // Create array of user input
        int[] guessNum = new int[4];
        for (int i = 0; i < guessNum.length; i++) {
            guessNum[i] = userGuess.charAt(i) - 48;
        }
        System.out.println(Arrays.toString(guessNum));

        // Compare
        int numCows = 0;
        int numBulls = 0;
        for (int i = 0; i < secretNum.length; i++) {
            for (int j = 0; j < guessNum.length; j++) {
                // Cow check
                if (secretNum[i] == guessNum[j]) {
                    numCows++;
                }
            }
            // Bull check
            if (secretNum[i] == guessNum[i]) {
                numCows--;
                numBulls++;
            }
        }

        return new int[]{numBulls, numCows};
    }
}