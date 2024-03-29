import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = generateSecretNum(scanner.nextInt());
        if (num != -1) {
            System.out.printf("The random secret number is %d", num);
        }

    }

    public static long generateSecretNum(int len) {
        if (len > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d" +
                    " because there aren't enough unique digits.", len);
            return -1;
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
            return secretNum;
        }
    }
}