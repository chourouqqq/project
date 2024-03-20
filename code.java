
import java.util.Random;

public class LudoGame {
    private static final int BOARD_SIZE = 72;
    private static final int NUM_PLAYERS = 4;

    private int[] playerPositions;
    private int currentPlayer;

    public LudoGame() {
        playerPositions = new int[NUM_PLAYERS];
        currentPlayer = 0;
    }

    // Lance le dé 
    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Déplace le joueur en fonction de la valeur du dé
    private void movePlayer(int steps) {
        playerPositions[currentPlayer] = (playerPositions[currentPlayer] + steps) % BOARD_SIZE;
    }

    // Affiche la position des joueurs sur le plateau
    private void displayBoard() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println("Joueur " + (i + 1) + " : Position " + playerPositions[i]);
        }
    }

    // Vérifie si un joueur a gagné en atteignant la fin du plateau
    private boolean hasPlayerWon() {
        for (int position : playerPositions) {
            if (position >= BOARD_SIZE - 1) {
                return true;
            }
        }
        return false;
    }

    // Passe au joueur suivant
    private void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % NUM_PLAYERS;
    }

    // Trouve le joueur gagnant
    private int findWinner() {
        int maxPosition = -1;
        int winningPlayer = -1;

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (playerPositions[i] > maxPosition) {
                maxPosition = playerPositions[i];
                winningPlayer = i + 1;
            }
        }

        return winningPlayer;
    }

    public static void main(String[] args) {
        LudoGame ludoGame = new LudoGame();

        // Joue jusqu'à ce qu'un joueur gagne
        while (!ludoGame.hasPlayerWon()) {
            System.out.println("Joueur " + (ludoGame.currentPlayer + 1) + " joue.");

            int diceValue = ludoGame.rollDice();
            System.out.println("Dé lancé : " + diceValue);

            ludoGame.movePlayer(diceValue);
            ludoGame.displayBoard();

            ludoGame.nextPlayer();
            System.out.println();
        }

        // Affiche le joueur gagnant
        int winner = ludoGame.findWinner();
        System.out.println("Joueur " + winner + " a gagné!");
    }
}
