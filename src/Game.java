public class Game {
    private int bulls;
    private int cows;
    private int turn = 1;
    private final String secret;

    public Game() {
        this.secret = "PLACEHOLDER"; //TODO: create method
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

}
