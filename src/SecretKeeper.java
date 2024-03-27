import java.util.*;

public class SecretKeeper {
    private final int[] num;

    public SecretKeeper() {
        this.num = generateNum();
    }

    public int[] getNum() {
        return this.num;
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
}