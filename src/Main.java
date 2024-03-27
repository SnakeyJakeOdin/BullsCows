import java.util.*;

public class Main {
    public static void main(String[] args) {
        SecretKeeper secretKeeper = new SecretKeeper("9305");
        System.out.println(Arrays.toString(secretKeeper.getSecret()));
        System.out.println(Arrays.toString(secretKeeper.getBullsAndCows("9350")));;
    }
}