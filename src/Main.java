import java.util.*;

public class Main {
    public static void main(String[] args) {
        SecretKeeper secretKeeper = new SecretKeeper("9305");
        System.out.println(Arrays.toString(secretKeeper.getSecretNum()));
        System.out.println(Arrays.toString(secretKeeper.checkBullsAndCows("1267")));;
    }
}