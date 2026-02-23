import java.util.Random;

public class RaceTo20Game extends Game {

    private static final int TARGET_SCORE = 20;

    private int numberOfPlayers;
    private int[] scores;
    private boolean gameOver;
    private int winner;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers < 2) {
            throw new IllegalArgumentException("At least 2 players required.");
        }

        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];
        this.gameOver = false;
        this.winner = -1;
        this.random = new Random();

        System.out.println("=== Race to 20 Game Started ===");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("First to reach 20 wins!\n");
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;

        System.out.println("Player " + (player + 1) +
                " rolled " + roll +
                " | Total Score: " + scores[player]);

        if (scores[player] >= TARGET_SCORE) {
            gameOver = true;
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\n=== Game Over ===");
        System.out.println("Winner: Player " + (winner + 1));

        System.out.println("\nFinal Scores:");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " + scores[i]);
        }
    }
}