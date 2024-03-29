import java.util.*;

public class Main {
    public static void main(String[] args) {
        int num = generateSecretNum(4);
        System.out.println(num);

    }

    public static int generateSecretNum(int len) {
        if (len > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", len);
            return -1;
        }
        else {
            // random, unique number generation
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 9; i >= 0; i--) {
                stack.push(i);
            }
            while (stack.peek() == 0) {
                Collections.shuffle(stack);
            }

            //TODO: Delete after testing
            System.out.println(stack);

            // unique generation --> secret number
            int secretNum = 0;
            for (int i = len - 1; i >= 0; i--) {
                secretNum += stack.pop() * (int)Math.pow(10, i);
            }
            return secretNum;
        }
    }
}